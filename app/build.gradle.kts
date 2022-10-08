import dependencies.Dependencies
import extensions.*

plugins {
    id(BuildPlugins.ANDROID_APPLICATION)
    id(BuildPlugins.KOTLIN_ANDROID)
    id(BuildPlugins.KOTLIN_ANDROID_EXTENSIONS)
    id(BuildPlugins.KOTLIN_KAPT)
    id(BuildPlugins.NAVIGATION)
    id(BuildPlugins.HILT)
}

android {
    compileSdk = BuildDefaultConfig.COMPILE_SDK_VERSION
    defaultConfig {
        applicationId = BuildDefaultConfig.APPLICATION_ID
        minSdk = BuildDefaultConfig.MIN_SDK_VERSION
        targetSdk = BuildDefaultConfig.TARGET_SDK_VERSION

        versionCode = BuildDefaultConfig.VERSION_CODE
        versionName = BuildDefaultConfig.VERSION_NAME

        testInstrumentationRunner = "com.android.sample.app.AppTestRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    composeOptions {
        kotlinCompilerExtensionVersion  = BuildDependenciesVersions.COMPOSE_COMPILER_VERSION
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(project(BuildModules.CORE))
    implementation(Dependencies.HILT)
    implementation(Dependencies.COMPOSE_UI)
    implementation(Dependencies.COMPOSE_MATERIAL)
    implementation(Dependencies.COMPOSE_PREVIEW)
    implementation(Dependencies.COMPOSE_MATERIAL_ICONS)
    implementation(Dependencies.COMPOSE_UI_TOOLING)
    implementation(Dependencies.COMPOSE_ACTIVITY)
    implementation(Dependencies.TIMBER)

    kapt(Dependencies.HILT_ANDROID_COMPILER)

    addTestsDependencies()
    addAndroidTestsDependencies()
}