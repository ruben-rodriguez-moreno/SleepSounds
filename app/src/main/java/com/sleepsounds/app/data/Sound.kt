package com.sleepsounds.app.data

import androidx.annotation.RawRes
import com.sleepsounds.app.R

data class Sound(
    val id: Int,
    val name: String,
    val description: String,
    val duration: String,
    @RawRes val audioResourceId: Int? = null
)

object SoundRepository {
    fun getSounds(): List<Sound> {
        return listOf(
            Sound(
                id = 1,
                name = "Rain",
                description = "Gentle rainfall sounds",
                duration = "30 min",
                audioResourceId = R.raw.rain_sound
            ),
            Sound(
                id = 2,
                name = "Ocean Waves",
                description = "Calming ocean waves",
                duration = "45 min",
                audioResourceId = R.raw.ocean_waves
            ),
            Sound(
                id = 3,
                name = "Forest",
                description = "Peaceful forest ambience",
                duration = "60 min",
                audioResourceId = R.raw.forest_ambience
            ),
            Sound(
                id = 4,
                name = "White Noise",
                description = "Consistent white noise",
                duration = "Continuous",
                audioResourceId = R.raw.white_noise
            ),
            Sound(
                id = 5,
                name = "Thunderstorm",
                description = "Distant thunder with rain",
                duration = "25 min",
                audioResourceId = R.raw.thunderstorm
            ),
            Sound(
                id = 6,
                name = "Night Crickets",
                description = "Gentle cricket sounds",
                duration = "40 min",
                audioResourceId = R.raw.night_crickets
            )
        )
    }
}
