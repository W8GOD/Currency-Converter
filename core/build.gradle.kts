import dependencies.Dependencies

plugins {
    id("commons.android-library")
}

android {
    defaultConfig {
        buildConfigField("String", "BASE_API_URL", "\"https://openexchangerates.org/\"")
        buildConfigField("String", "APP_ID", "\"Token 7f53c92e5a9f49fdb9e70802ce8a03d2\"")
        buildConfigField("String", "DATABASE_NAME", "\"app-db\"")
        buildConfigField("int", "DATABASE_VERSION", "1")
        buildConfigField("boolean", "DATABASE_EXPORT_SCHEMA", "false")
    }
}

dependencies {
    api(project(BuildModules.COMMON))
    api(Dependencies.RETROFIT)
    api(Dependencies.MOSHI)

    implementation(Dependencies.RETROFIT_CONVERTER)
    implementation(Dependencies.ROOM)
    implementation(Dependencies.ROOM_KTX)
    implementation(Dependencies.OKHTTP_LOGGING)
    implementation(Dependencies.MOSHI_KTX)
    implementation(Dependencies.KOTLIN_COROUTINES)

    kapt(Dependencies.HILT_ANDROID_COMPILER)
    kapt(Dependencies.ROOM_COMPILER)
}