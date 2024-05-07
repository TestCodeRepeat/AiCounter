# AiCounter

![kotlin-version](https://img.shields.io/badge/kotlin-1.9.20-blue)

A Kotlin Multiplatform architecture example for introducing shared functionality into
existing Android & iOS projects.

The shared module is exported as an XCFramework for existing native iOS github
project, and integrated with an existing Android project as a standard gradle module.

Shared functionality combines basic Todo and Counter  using a lightweight Redux architecture. 

## Project Structure

This project consists of three main modules:

- **Android Application Module:** This is a pre-existing Android application that has been modified to use shared code
  from the KMP module. Most companies would likely start with large existing native mobile project kept in separate
  repositories.
- **Shared Module:** This module contains the common code that is shared between the Android and iOS applications. It is
  exported to Android as a Gradle module and to iOS as an XCFramework.
    - :shared module with common code
        - exported to Android as gradle module
        - exported to iOS as XCFramework
        - Shared Presentation Layer w/ Unit Testing of state
- **iOS Application:** This is a pre-existing iOS application that has been modified to use shared code from the KMP
  module. The iOS application is located in a separate repository here: [iosApp](https://github.com/TestCodeRepeat/iosApp)


### Lightweight Redux architecture (shared presentation layer)
- State, Store, Action & Side Effects
- dispatch Actions directly from iOS views
- very similar to Swift Composable Architecture [Swift Composable Architecture](https://github.com/pointfreeco/swift-composable-architecture)
- Presentation layer is shared by both iOS & Android apps and lives in **:shared** module
- manage application state in a single place


### Related documentation

* [Integration Kotlin Multiplatform Into Existing Project](https://www.jetbrains.com/help/kotlin-multiplatform-dev/multiplatform-integrate-in-existing-app.html#make-your-cross-platform-application-work-on-ios)

### Building

Use Android Studio/IntelliJ to build/run Android client.
Requires Xcode 14 or later for iOS client.

* Uses toml file for gradle build configurations.







