import java.util.Properties
import java.io.FileInputStream

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("dev.flutter.flutter-gradle-plugin")
}

// 🔑 Загружаем API ключ из local.properties
val localPropertiesFile = rootProject.file("local.properties")
val localProperties = Properties()

if (localPropertiesFile.exists()) {
    localProperties.load(FileInputStream(localPropertiesFile))
}

val yandexMapkitApiKey: String = localProperties.getProperty("yandex.mapkit.api.key") ?: "YOUR_API_KEY_HERE"

android {
    namespace = "com.example.flutter_application_2"
    compileSdk = flutter.compileSdkVersion
    ndkVersion = "27.0.12077973"

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    defaultConfig {
        applicationId = "com.example.flutter_application_2"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        manifestPlaceholders["YANDEX_MAPKIT_API_KEY"] = yandexMapkitApiKey
    }

    buildTypes {
        release {
            // Используем debug подпись для простоты
            signingConfig = signingConfigs.getByName("debug")
        }
    }
}

flutter {
    source = "../.."
}

dependencies {
    implementation("com.yandex.android:maps.mobile:4.6.1-full")
}