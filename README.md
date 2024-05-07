# AiCounter 

![kotlin-version](https://img.shields.io/badge/kotlin-1.9.20-blue)



A Kotlin Multiplatform starter project for a simple counter + todo app.  

To be shared as an XCFramework with existing native iOS github project.

Includes:

- Android Application Module (e.g. a pre-existing Android application)
- :shared module with common code 
  - exported to Android as gradle module
  - exported to iOS as XCFramework
  - Shared Presentation Layer w/ Unit Testing of state 
- Lightweight Redux architecture
  - State, Store, Action & Side Effects
  - dispatch Actions directly from iOS views 


### Related posts

* [Integration Kotlin Multiplatform Into Existing Project](https://www.jetbrains.com/help/kotlin-multiplatform-dev/multiplatform-integrate-in-existing-app.html#make-your-cross-platform-application-work-on-ios)

### Building

Use Android Studio/IntelliJ to build/run Android client.
Requires Xcode 14 or later for iOS client.



