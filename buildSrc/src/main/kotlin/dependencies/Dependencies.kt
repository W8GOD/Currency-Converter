package dependencies

import BuildDependenciesVersions

object Dependencies {
    // Common
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${BuildDependenciesVersions.KOTLIN_VERSION}"
    const val CORE_KTX = "androidx.core:core-ktx:${BuildDependenciesVersions.CORE_KTX_VERSION}"
    const val APP_COMPAT = "androidx.appcompat:appcompat:${BuildDependenciesVersions.APPCOMPAT_VERSION}"
    const val MATERIAL_DESIGN = "com.google.android.material:material:${BuildDependenciesVersions.MATERIAL_DESIGN_VERSION}"

    // ViewModel and LiveData
    const val LIFECYCLE_EXTENSIONS = "androidx.lifecycle:lifecycle-extensions:${BuildDependenciesVersions.LIFECYCLE_EXTENSIONS_VERSION}"
    const val LIFECYCLE_VIEW_MODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:${BuildDependenciesVersions.LIFECYCLE_VERSION}"
    const val LIFECYCLE_VIEW_MODEL_COMPOSE = "androidx.lifecycle:lifecycle-viewmodel-compose:${BuildDependenciesVersions.LIFECYCLE_VERSION}"
    const val LIFECYCLE_KTX = "androidx.lifecycle:lifecycle-runtime-ktx:${BuildDependenciesVersions.LIFECYCLE_VERSION}"

    // Moshi
    const val MOSHI = "com.squareup.moshi:moshi:${BuildDependenciesVersions.MOSHI_VERSION}"
    const val MOSHI_KTX = "com.squareup.moshi:moshi-kotlin:${BuildDependenciesVersions.MOSHI_VERSION}"

    // OKHttp
    const val OKHTTP = "com.squareup.okhttp3:okhttp:${BuildDependenciesVersions.OKHTTP_VERSION}"
    const val OKHTTP_LOGGING = "com.squareup.okhttp3:logging-interceptor:${BuildDependenciesVersions.OKHTTP_VERSION}"

    // Retrofit
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${BuildDependenciesVersions.RETROFIT_VERSION}"
    const val RETROFIT_CONVERTER = "com.squareup.retrofit2:converter-moshi:${BuildDependenciesVersions.RETROFIT_VERSION}"

    // Kotlinx Coroutines
    const val KOTLIN_COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${BuildDependenciesVersions.KOTLINX_COROUTINES_VERSION}"

    // Hilt
    const val HILT = "com.google.dagger:hilt-android:${BuildDependenciesVersions.HILT_VERSION}"
    const val HILT_ANDROID_COMPILER = "com.google.dagger:hilt-android-compiler:${BuildDependenciesVersions.HILT_VERSION}"

    // Coil
    const val COIL = "com.google.accompanist:accompanist-coil:${BuildDependenciesVersions.COIL_VERSION}"
    const val COIL_COMPOSE = "io.coil-kt:coil-compose:${BuildDependenciesVersions.COIL_COMPOSE_VERSION}"
    const val COIL_SVG = "io.coil-kt:coil-svg:${BuildDependenciesVersions.COIL_COMPOSE_VERSION}"

    // Room Database
    const val ROOM = "androidx.room:room-runtime:${BuildDependenciesVersions.ROOM_VERSION}"
    const val ROOM_KTX = "androidx.room:room-ktx:${BuildDependenciesVersions.ROOM_VERSION}"
    const val ROOM_COMPILER = "androidx.room:room-compiler:${BuildDependenciesVersions.ROOM_VERSION}"

    // Compose
    const val COMPOSE_UI = "androidx.compose.ui:ui:${BuildDependenciesVersions.COMPOSE_UI_VERSION}"
    const val COMPOSE_MATERIAL = "androidx.compose.material:material:${BuildDependenciesVersions.COMPOSE_UI_VERSION}"
    const val COMPOSE_PREVIEW = "androidx.compose.ui:ui-tooling-preview:${BuildDependenciesVersions.COMPOSE_UI_VERSION}"
    const val COMPOSE_MATERIAL_ICONS = "androidx.compose.material:material-icons-extended:${BuildDependenciesVersions.COMPOSE_UI_VERSION}"
    const val COMPOSE_UI_TOOLING = "androidx.compose.ui:ui-tooling:${BuildDependenciesVersions.COMPOSE_UI_VERSION}"
    const val COMPOSE_ACTIVITY = "androidx.activity:activity-compose:${BuildDependenciesVersions.COMPOSE_ACTIVITY_VERSION}"

    // Navigation
    const val NAVIGATION_FRAGMENT = "androidx.navigation:navigation-fragment-ktx:${BuildDependenciesVersions.NAVIGATION_VERSION}"
    const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:${BuildDependenciesVersions.NAVIGATION_VERSION}"
    const val NAVIGATION_FEATURES = "androidx.navigation:navigation-dynamic-features-fragment:${BuildDependenciesVersions.NAVIGATION_VERSION}"

    // Swipe Refresh
    const val SWIPE_REFRESH = "com.google.accompanist:accompanist-swiperefresh:${BuildDependenciesVersions.SWIPE_REFRESH_VERSION}"

    // Timber
    const val TIMBER = "com.jakewharton.timber:timber:${BuildDependenciesVersions.TIMBER_VERSION}"

    // Tests
    const val JUNIT = "junit:junit:${BuildDependenciesVersions.JUNIT_VERSION}"
    const val MOCKITO = "org.mockito:mockito-core:${BuildDependenciesVersions.MOCKITO_VERSION}"
    const val EXT = "androidx.test.ext:junit:${BuildDependenciesVersions.EXT_VERSION}"
    const val CORE = "androidx.test:core:${BuildDependenciesVersions.TEST_VERSION}"
    const val RUNNER = "androidx.test:runner:${BuildDependenciesVersions.TEST_VERSION}"
    const val RULES = "androidx.test:rules:${BuildDependenciesVersions.TEST_VERSION}"
    const val ARCH_CORE = "androidx.arch.core:core-testing:${BuildDependenciesVersions.ARCH_CORE_VERSION}"

    // Tests-Android
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${BuildDependenciesVersions.ESPRESSO_VERSION}"
    const val ESPRESSO_CONTRIB = "androidx.test.espresso:espresso-contrib:${BuildDependenciesVersions.ESPRESSO_VERSION}"
}