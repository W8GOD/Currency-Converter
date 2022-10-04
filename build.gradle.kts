buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${BuildDependenciesVersions.GRADLE_ANDROID_VERSION}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${BuildDependenciesVersions.KOTLIN_VERSION}")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:${BuildDependenciesVersions.NAVIGATION_VERSION}")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${BuildDependenciesVersions.HILT_VERSION}")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}