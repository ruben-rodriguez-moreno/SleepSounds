# 🌙 SleepSounds

Una aplicación Android elegante y relajante que proporciona sonidos ambientales para ayudarte a dormir mejor.

## 📱 Capturas de Pantalla

- **Pantalla de Splash**: Animación suave con el icono de la luna
- **Pantalla Principal**: Lista de sonidos relajantes con controles intuitivos
- **Reproductor Global**: Control centralizado de reproducción con temporizador

## ✨ Características

### 🎵 Reproducción de Audio
- **8 sonidos relajantes** incluidos:
  - Lluvia suave
  - Océano tranquilo
  - Bosque nocturno
  - Viento suave
  - Fuego de chimenea
  - Río sereno
  - Ruido blanco
  - Tormenta lejana

### 🎮 Controles de Reproducción
- **Play/Pause** individual para cada sonido
- **Control global** cuando hay un sonido reproduciéndose
- **Botón Stop** para detener completamente la reproducción
- **Indicadores visuales** del estado de reproducción

### ⏰ Temporizador de Sueño
- **Sleep Timer** configurable: 10, 20, 30, 45 o 60 minutos
- **Indicador visual** del tiempo restante
- **Parada automática** cuando el temporizador expira
- **Cancelación manual** del temporizador

### 🔔 Notificaciones
- **Controles en la barra de notificaciones**
- **Reproducción en segundo plano**
- **Gestión automática de permisos**

### 🎨 Diseño y UX
- **Pantalla de splash animada** con la luna como protagonista
- **Material Design 3** con tema nocturno
- **Colores relajantes**: azul oscuro y púrpura suave
- **Iconografía consistente** con tema de luna y sueño
- **Animaciones suaves** y transiciones fluidas

## 🛠️ Tecnologías Utilizadas

### Desarrollo
- **Kotlin** - Lenguaje de programación principal
- **Jetpack Compose** - Framework de UI moderna
- **Material Design 3** - Sistema de diseño
- **StateFlow** - Gestión de estado reactiva

### Audio
- **MediaPlayer** - Reproducción de audio nativa
- **Notification** - Controles en segundo plano
- **Timer** - Funcionalidad de temporizador de sueño

### Arquitectura
- **MVVM Pattern** - Separación de responsabilidades
- **Repository Pattern** - Gestión de datos
- **Compose State Management** - Estado reactivo de UI

## 📋 Requisitos del Sistema

- **Android 7.0** (API 24) o superior
- **Kotlin 1.9+**
- **Compose BOM 2024.02.00**
- **Target SDK 34**

## 🚀 Instalación y Configuración

### Prerrequisitos
```bash
Android Studio Hedgehog | 2023.1.1 o superior
JDK 17 o superior
Android SDK 34
```

### Clonar el Repositorio
```bash
git clone https://github.com/tu-usuario/sleepsounds.git
cd sleepsounds
```

### Configurar el Proyecto
1. Abrir el proyecto en Android Studio
2. Sincronizar las dependencias de Gradle
3. Compilar y ejecutar en dispositivo/emulador

## 📂 Estructura del Proyecto

```
app/src/main/java/com/sleepsounds/app/
├── SleepSoundsApp.kt          # Componente principal de la app
├── SplashScreen.kt            # Pantalla de splash animada
├── MainActivity.kt            # Actividad principal
├── audio/
│   └── AudioManager.kt        # Gestión de reproducción de audio
├── data/
│   ├── Sound.kt              # Modelo de datos de sonidos
│   └── SoundRepository.kt    # Repositorio de sonidos
└── ui/theme/
    ├── Color.kt              # Colores del tema
    ├── Theme.kt              # Configuración del tema
    └── Type.kt               # Tipografía
```

## 🎨 Paleta de Colores

- **Fondo Principal**: `#1A1B3A` (Azul oscuro nocturno)
- **Acento Primario**: `#8B7EC8` (Púrpura suave)
- **Texto Principal**: `#F5F5F7` (Blanco suave)
- **Superficie**: Variaciones de azul y púrpura

## 🔊 Archivos de Audio

Los sonidos están ubicados en `app/src/main/res/raw/`:
- `rain.mp3` - Lluvia suave (10 min)
- `ocean.mp3` - Océano tranquilo (15 min)
- `forest.mp3` - Bosque nocturno (12 min)
- `wind.mp3` - Viento suave (8 min)
- `fireplace.mp3` - Fuego de chimenea (20 min)
- `river.mp3` - Río sereno (14 min)
- `whitenoise.mp3` - Ruido blanco (Continuo)
- `thunder.mp3` - Tormenta lejana (18 min)

## 🔧 Funcionalidades Técnicas

### Gestión de Estado
- **StateFlow** para estado reactivo
- **Compose State** para UI reactiva
- **Remember** para estado local de componentes

### Gestión de Audio
- **MediaPlayer** con loop automático
- **Control de volumen** y fundido
- **Gestión de recursos** automática

### Notificaciones
- **MediaStyle Notification** para controles
- **Gestión automática de permisos** (Android 13+)
- **Acciones**: Play, Pause, Stop

## 🐛 Depuración y Desarrollo

### Logs Importantes
```kotlin
AudioManager - Gestión de reproducción
SplashScreen - Animaciones de entrada
SoundRepository - Carga de datos
```

### Testing
- Verificar permisos de notificación
- Probar temporizador en diferentes intervalos
- Validar reproducción en segundo plano

## 📝 Roadmap Futuro

- [ ] **Más sonidos**: Ampliar la biblioteca de audio
- [ ] **Ecualizador**: Ajustes de frecuencia personalizados
- [ ] **Perfiles de sueño**: Configuraciones guardadas
- [ ] **Estadísticas**: Tracking de uso y hábitos de sueño
- [ ] **Modo oscuro/claro**: Temas adaptativos

## 👨‍💻 Desarrollo

Este proyecto utiliza las mejores prácticas de desarrollo Android moderno:

- **Clean Architecture** con separación clara de capas
- **Jetpack Compose** para UI declarativa
- **Material Design 3** para consistencia visual
- **Gestión de estado reactiva** con StateFlow
- **Manejo de recursos** eficiente y memoria optimizada

## 📄 Licencia

Este proyecto está bajo la Licencia MIT. Ver el archivo `LICENSE` para más detalles.

## 🤝 Contribuciones

Las contribuciones son bienvenidas. Para contribuir:

1. Fork el proyecto
2. Crea una rama para tu feature (`git checkout -b feature/nueva-funcionalidad`)
3. Commit tus cambios (`git commit -m 'Añadir nueva funcionalidad'`)
4. Push a la rama (`git push origin feature/nueva-funcionalidad`)
5. Abre un Pull Request

---

**Desarrollado con ❤️ para ayudarte a dormir mejor** 🌙✨
