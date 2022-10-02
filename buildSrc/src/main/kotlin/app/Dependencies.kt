package app

object Dependencies {
    // Common
    const val coreKtx = "androidx.core:core-ktx:${DependenciesVersions.core_ktx_version}"
    const val appcompat = "androidx.appcompat:appcompat:${DependenciesVersions.appcompat_version}"
    const val materialDesign = "com.google.android.material:material:${DependenciesVersions.material_design_version}"

    // ViewModel and LiveData
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${DependenciesVersions.lifecycle_version}"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${DependenciesVersions.lifecycle_version}"
    const val lifecycleViewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:${DependenciesVersions.lifecycle_version}"
    const val lifecycleKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${DependenciesVersions.lifecycle_version}"

    // Gson
    const val gson = "com.google.code.gson:gson:${DependenciesVersions.gson_version}"

    // OKHttp
    const val okhttp = "com.squareup.okhttp3:okhttp:${DependenciesVersions.okhttp_version}"
    const val okhttpLogging = "com.squareup.okhttp3:logging-interceptor:${DependenciesVersions.okhttp_version}"

    // Retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${DependenciesVersions.retrofit_version}"
    const val retrofitConverter = "com.squareup.retrofit2:converter-gson:${DependenciesVersions.retrofit_version}"
    const val retrofitAdapter = "com.squareup.retrofit2:adapter-rxjava2:${DependenciesVersions.retrofit_version}"

    // Kotlinx Coroutines
    const val kotlinxCoroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${DependenciesVersions.kotlinx_coroutines_version}"

    // Coil
    const val coil = "com.google.accompanist:accompanist-coil:${DependenciesVersions.coil_version}"
    const val coilCompose = "io.coil-kt:coil-compose:${DependenciesVersions.coil_compose_version}"
    const val coilSvg = "io.coil-kt:coil-svg:${DependenciesVersions.coil_compose_version}"

    // Room Database
    const val room = "androidx.room:room-runtime:${DependenciesVersions.room_version}"
    const val roomKtx = "androidx.room:room-ktx:${DependenciesVersions.room_version}"
    const val roomCompiler = "androidx.room:room-compiler:${DependenciesVersions.room_version}"

    // Compose
    const val composeUI = "androidx.compose.ui:ui:${DependenciesVersions.compose_ui_version}"
    const val composeMaterial = "androidx.compose.material:material:${DependenciesVersions.compose_ui_version}"
    const val composePreview = "androidx.compose.ui:ui-tooling-preview:${DependenciesVersions.compose_ui_version}"
    const val composeUITooling = "androidx.compose.ui:ui-tooling:${DependenciesVersions.compose_ui_version}"
    const val composeActivity = "androidx.activity:activity-compose:${DependenciesVersions.compose_activity_version}"

    // Swipe Refresh
    const val swipeRefresh = "com.google.accompanist:accompanist-swiperefresh:${DependenciesVersions.swipe_refresh_version}"

    // Test
    const val junit = "junit:junit:${DependenciesVersions.junit_version}"
    const val junitExt = "androidx.test.ext:junit:${DependenciesVersions.junit_ext_version}"
    const val espresso = "androidx.test.espresso:espresso-core:${DependenciesVersions.espresso_version}"
}