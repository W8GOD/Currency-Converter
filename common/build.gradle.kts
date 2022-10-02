import app.Dependencies

plugins {
    id("com.android.library")
    kotlin("android.extensions")
    kotlin("android")
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

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

androidExtensions {
    isExperimental = true
}

dependencies {
    implementation(Dependencies.coreKtx)
    implementation(Dependencies.lifecycleExtensions)
    implementation(Dependencies.lifecycleViewModel)
    implementation(Dependencies.lifecycleViewModelCompose)
    implementation(Dependencies.lifecycleKtx)

    implementation(Dependencies.junit)
    implementation(Dependencies.testRunner)
}