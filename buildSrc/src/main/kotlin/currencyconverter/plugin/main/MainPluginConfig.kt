package currencyconverter.plugin.main

import org.gradle.api.Project

internal fun Project.configureMainPlugins() {
    plugins.apply("com.android.application")
    plugins.apply("kotlin-android-extensions")
    plugins.apply("kotlin-android")
    plugins.apply("kotlin-kapt")
    plugins.apply("com.google.dagger.hilt.android")
}