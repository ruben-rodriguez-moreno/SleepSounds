# SleepSounds Android App

A beautiful Android application built with Kotlin and Jetpack Compose that provides relaxing sounds to help users sleep better.

## Features

- 🎵 **Variety of Sounds**: Rain, ocean waves, forest ambience, white noise, and more
- ▶️ **Easy Playback**: Simple play/pause buttons for each sound
- 🌙 **Sleep-Focused Design**: Calming color scheme optimized for nighttime use
- 📱 **Modern UI**: Built with Jetpack Compose and Material Design 3

## Screenshots

*Screenshots will be added once the app is running*

## Technical Details

- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Architecture**: MVVM (ready for expansion)
- **Target SDK**: 34
- **Minimum SDK**: 24
- **Build Tool**: Gradle with Kotlin DSL

## Getting Started

### Prerequisites

- Android Studio Hedgehog (2023.1.1) or later
- JDK 8 or higher
- Android SDK with API level 34

### Building the Project

1. Clone the repository
2. Open the project in Android Studio
3. Sync the project with Gradle files
4. Run the app on an emulator or physical device

### Development Setup

```bash
# Build the project
./gradlew build

# Install on connected device
./gradlew installDebug

# Run tests
./gradlew test
```

## Project Structure

```
app/
├── src/main/
│   ├── java/com/sleepsounds/app/
│   │   ├── MainActivity.kt
│   │   ├── SleepSoundsApp.kt
│   │   └── ui/theme/
│   ├── res/
│   └── AndroidManifest.xml
└── build.gradle.kts
```

## Future Enhancements

- [ ] Actual audio playback implementation
- [ ] Timer functionality for sleep sessions
- [ ] Custom sound mixing
- [ ] Offline audio files
- [ ] Sleep tracking integration
- [ ] Widget support

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Test thoroughly
5. Submit a pull request

## License

This project is licensed under the MIT License - see the LICENSE file for details.
