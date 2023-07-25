# Weather Updates App

The Weather Updates App is a simple Android application that fetches weather updates from the OpenWeather API and displays the temperature on a card. The app incorporates offline storage using Room, adopts Jetpack Compose for the UI, and is developed using Kotlin. It follows the principles of Clean Architecture and utilizes Hilt for dependency injection.

## Features

- Fetch weather updates from the OpenWeather API.
- Display the temperature on a card in a visually appealing way using Jetpack Compose.
- Store weather data locally for offline access using Room.
- Follow Clean Architecture principles for maintainability and separation of concerns.
- Utilize Hilt for dependency injection to simplify object creation and management.

## Architecture

The app is structured based on Clean Architecture principles, which consist of the following layers:

1. **Presentation Layer**: Responsible for UI presentation and user interactions. It uses Jetpack Compose to create a modern and declarative UI. The UI components are designed to display the weather temperature fetched from the data layer.

2. **Domain Layer**: Contains the core business logic and use cases of the application. It defines the interfaces for interacting with the data layer.

3. **Data Layer**: Handles data retrieval and storage. It communicates with external data sources like the OpenWeather API and the local database using Room.

4. **Dependency Injection**: Hilt is used to manage and provide dependencies throughout the application. It simplifies the process of injecting dependencies into classes, making the code more maintainable and testable.

## Getting Started

1. Clone the project

2. Open the project in Android Studio.

3. Build and run the app on an Android emulator or a physical device.

## Dependencies

The app uses the following dependencies:

- Jetpack Compose: For building the modern UI.
- Retrofit: For network communication with the OpenWeather API.
- Room: For offline storage of weather data.
- Hilt: For dependency injection.
- Kotlin Coroutines: For asynchronous programming.
- Moshi: For JSON serialization and deserialization.
- kotlin flows: For reactive programming and data observation.

## License

The Weather Updates App is open-source and licensed under the MIT License. You are free to use, modify, and distribute the code as per the terms of the MIT License.

