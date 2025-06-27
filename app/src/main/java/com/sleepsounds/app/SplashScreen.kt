package com.sleepsounds.app

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Nightlight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onSplashFinished: () -> Unit
) {
    // Animaciones
    val scale = remember { Animatable(0f) }
    val alpha = remember { Animatable(0f) }
    val textAlpha = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        // Animación del icono apareciendo
        scale.animateTo(
            targetValue = 1.2f,
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioLowBouncy,
                stiffness = Spring.StiffnessLow
            )
        )

        // Animación del fade in del icono
        alpha.animateTo(
            targetValue = 1f,
            animationSpec = tween(800, easing = EaseInOut)
        )

        // Pequeña pausa y luego mostrar el texto
        delay(500)
        textAlpha.animateTo(
            targetValue = 1f,
            animationSpec = tween(600, easing = EaseInOut)
        )

        // Esperar un poco más y luego escalar ligeramente hacia abajo
        delay(800)
        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(400, easing = EaseInOut)
        )

        // Esperar un momento final
        delay(1000)

        // Finalizar splash
        onSplashFinished()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1A1B3A)), // Mismo azul oscuro del icono
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Icono de la luna con animación
            Icon(
                imageVector = Icons.Filled.Nightlight,
                contentDescription = "SleepSounds",
                modifier = Modifier
                    .size(120.dp)
                    .scale(scale.value)
                    .alpha(alpha.value),
                tint = Color(0xFF8B7EC8) // Mismo morado del icono
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Texto de la app con animación
            Text(
                text = "SleepSounds",
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Light
                ),
                color = Color(0xFF8B7EC8),
                modifier = Modifier.alpha(textAlpha.value)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Relajante • Tranquilo • Sereno",
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFF8B7EC8).copy(alpha = 0.7f),
                modifier = Modifier.alpha(textAlpha.value)
            )
        }
    }
}
