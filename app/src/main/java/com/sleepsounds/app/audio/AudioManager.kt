package com.sleepsounds.app.audio

import android.Manifest
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.content.pm.PackageManager
import android.os.Build
import android.os.CountDownTimer
import android.os.IBinder
import androidx.annotation.RawRes
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.sleepsounds.app.service.MediaPlayerService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AudioManager(private val context: Context) {
    private var mediaPlayerService: MediaPlayerService? = null
    private var serviceBound = false
    private var sleepTimer: CountDownTimer? = null

    private val _currentlyPlayingId = MutableStateFlow(-1)
    val currentlyPlayingId: StateFlow<Int> = _currentlyPlayingId.asStateFlow()

    private val _isPlaying = MutableStateFlow(false)
    val isPlaying: StateFlow<Boolean> = _isPlaying.asStateFlow()

    private val _currentSoundName = MutableStateFlow("")
    val currentSoundName: StateFlow<String> = _currentSoundName.asStateFlow()

    private val _timerMinutesRemaining = MutableStateFlow(0)
    val timerMinutesRemaining: StateFlow<Int> = _timerMinutesRemaining.asStateFlow()

    private val _isTimerActive = MutableStateFlow(false)
    val isTimerActive: StateFlow<Boolean> = _isTimerActive.asStateFlow()

    private val _showNotificationPermissionDialog = MutableStateFlow(false)
    val showNotificationPermissionDialog: StateFlow<Boolean> =
        _showNotificationPermissionDialog.asStateFlow()

    private val serviceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val binder = service as MediaPlayerService.MediaPlayerBinder
            mediaPlayerService = binder.getService()
            serviceBound = true

            // Sincronizar estados
            mediaPlayerService?.let { service ->
                _isPlaying.value = service.isPlaying.value
                _currentSoundName.value = service.currentSoundName.value
            }
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            serviceBound = false
            mediaPlayerService = null
        }
    }

    init {
        // Conectar al servicio
        val intent = Intent(context, MediaPlayerService::class.java)
        context.bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun playSound(@RawRes audioResource: Int?, soundId: Int, soundName: String = "") {
        try {
            if (audioResource == null) {
                // Simular reproducción para sonidos sin archivo
                _currentlyPlayingId.value = soundId
                _currentSoundName.value = soundName
                _isPlaying.value = true
                return
            }

            if (serviceBound && mediaPlayerService != null) {
                mediaPlayerService?.playSound(audioResource, soundName)
                _currentlyPlayingId.value = soundId
                _currentSoundName.value = soundName
                _isPlaying.value = true
            } else {
                // Si el servicio no está conectado, iniciarlo
                val intent = Intent(context, MediaPlayerService::class.java)
                context.startForegroundService(intent)
                context.bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            stopSound()
        }
    }

    fun pauseSound() {
        if (serviceBound && mediaPlayerService != null) {
            mediaPlayerService?.pauseSound()
            _isPlaying.value = false
        }
    }

    fun resumeSound() {
        if (serviceBound && mediaPlayerService != null) {
            mediaPlayerService?.resumeSound()
            _isPlaying.value = true
        }
    }

    fun stopSound() {
        if (serviceBound && mediaPlayerService != null) {
            mediaPlayerService?.stopPlayback()
        }
        _currentlyPlayingId.value = -1
        _currentSoundName.value = ""
        _isPlaying.value = false
        cancelTimer()
    }

    fun togglePlayPause(soundId: Int, @RawRes audioResource: Int?, soundName: String = "") {
        when {
            _currentlyPlayingId.value == soundId && _isPlaying.value -> pauseSound()
            _currentlyPlayingId.value == soundId && !_isPlaying.value -> resumeSound()
            else -> playSound(audioResource, soundId, soundName)
        }
    }

    fun setTimer(minutes: Int) {
        cancelTimer()

        if (minutes > 0) {
            _timerMinutesRemaining.value = minutes
            _isTimerActive.value = true

            sleepTimer = object : CountDownTimer(minutes * 60 * 1000L, 60 * 1000L) {
                override fun onTick(millisUntilFinished: Long) {
                    val minutesLeft = (millisUntilFinished / 1000 / 60).toInt() + 1
                    _timerMinutesRemaining.value = minutesLeft
                }

                override fun onFinish() {
                    stopSound()
                    cancelTimer()
                }
            }.start()
        }
    }

    fun cancelTimer() {
        sleepTimer?.cancel()
        sleepTimer = null
        _timerMinutesRemaining.value = 0
        _isTimerActive.value = false
    }

    fun release() {
        stopSound()
        cancelTimer()
        if (serviceBound) {
            context.unbindService(serviceConnection)
            serviceBound = false
        }
    }

    fun checkNotificationPermission(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
        } else {
            true // No se necesita permiso en versiones anteriores
        }
    }

    fun requestNotificationPermission() {
        if (!checkNotificationPermission()) {
            _showNotificationPermissionDialog.value = true
        }
    }

    fun dismissNotificationPermissionDialog() {
        _showNotificationPermissionDialog.value = false
    }
}
