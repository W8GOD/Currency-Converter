plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
}

object PluginsVersions {
    const val gradle_android_version = "7.0.3"
    const val kotlin_version = "1.5.31"
    const val navigation_version = "2.3.5"
    const val hilt_version = "2.40"
}

dependencies {
    implementation("com.android.tools.build:gradle:${PluginsVersions.gradle_android_version}")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${PluginsVersions.kotlin_version}")
    implementation("androidx.navigation:navigation-safe-args-gradle-plugin:${PluginsVersions.navigation_version}")
    implementation("com.google.dagger:hilt-android-gradle-plugin:${PluginsVersions.hilt_version}")
}