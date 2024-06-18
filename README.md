# Contact Manager App

It is an andorid application built in kotlin for the users to store contacts , consisting of fields like name and email id. It stores the contacts on the ui itself and the user can create a new contact , modify an existing contact and delete a contact.

# Technology used

- Android Studio
- Kotlin
- ROOM database

# Install the Project

```git
git clone https://github.com/Sachdevabhavya/ContactManagerApp.git
```

# dependencies required

Add the following dependencies to run the app in the following file given :

- build.gradle.kts(module)

```kt
    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")
    kapt("androidx.room:room-compiler:2.6.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")
    val lifecycle_version = "2.6.2"
    //View Model
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")

    //Live Data
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
```

# plugins required

Add the following plugins to run the app in their respective file given :

- build.gradle.kts(module)

```kt
id("kotlin-kapt")
```

- build.gradle.kts(project)

```kt
kotlin("kapt") version "1.9.22"
```

# Features

<p align="center">
  <img src="image.png" width="250" height="250" style="display: inline-block; margin: 0 10px;">
  <img src="image-1.png" width="250" height="250" style="display: inline-block; margin: 0 10px;">
</p>


- User can add their contacts :
  <video width="320" height="240" controls>
  <source src="insert.webm" type="video/mp4">
</video>


- User can update the existing contact
  <video width="320" height="240" controls>
  <source src="update.webm" type="video/mp4">
</video>

- User can delete any contact
  <video width="320" height="240" controls>
  <source src="delete.webm" type="video/mp4">
</video>

<video width="320" height="240" controls>
  <source src="app.webm" type="video/mp4">
</video>

- The contacts will remain stored even if the app is stopped , because the data is stored using a ROOM database
