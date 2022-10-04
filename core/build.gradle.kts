import app.Dependencies

plugins {
    id("com.android.library")
    id("com.google.dagger.hilt.android")
    kotlin("android.extensions")
    kotlin("android")
    kotlin("kapt")
}

repositories {
    google()
    mavenCentral()
}

android {
    compileSdk = app.DefaultBuildConfig.compileSdkVersion
    buildToolsVersion = app.DefaultBuildConfig.compileSdkVersion.toString()

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    sourceSets["main"].apply {
        java.srcDir("src/main/kotlin")
    }

    defaultConfig {
        javaCompileOptions {
            annotationProcessorOptions {
                arguments["room.incremental"] = "true"
                arguments["room.schemaLocation"] = "$projectDir/schemas"
            }
        }
    }

    buildTypes.forEach {
        try {
            it.buildConfigField("String", "BASE_API_URL", "\"https://openexchangerates.org/\"")
            it.buildConfigField("String", "APP_ID", "\"Token 7f53c92e5a9f49fdb9e70802ce8a03d2\"")
        } catch (ignored: Exception) {
            throw GradleException(ignored.message ?: "")
        }
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

androidExtensions {
    isExperimental = true
}

kapt {
    correctErrorTypes = true
}

dependencies {
    implementation(Dependencies.room)
    implementation(Dependencies.roomKtx)
    implementation(Dependencies.lifecycleExtensions)
    implementation(Dependencies.coreKtx)
    implementation(Dependencies.retrofit)
    implementation(Dependencies.retrofitConverter)
    implementation(Dependencies.retrofitAdapter)
    implementation(Dependencies.okhttp)
    implementation(Dependencies.okhttpLogging)
    implementation(Dependencies.kotlinxCoroutines)

    implementation(Dependencies.hilt)
    kapt(Dependencies.hiltAndroidCompiler)
    kapt(Dependencies.roomCompiler)

    implementation(Dependencies.junit)
    implementation(Dependencies.testRunner)

}