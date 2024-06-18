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

![app_image](image.png |width=50|height=50) ![app_with_contacts](image-1.png |width=50|height=50)

- User can add their contacts :
  [insert](insert.webm)

- User can update the existing contact
  [update](update.webm)

- User can delete any contact
  [delete](delete.webm)

[app](app.webm)

- The contacts will remain stored even if the app is stopped , because the data is stored using a ROOM database
