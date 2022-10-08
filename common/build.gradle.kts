import dependencies.Dependencies

plugins {
    id("commons.android-library")
}

dependencies {
    api(Dependencies.APP_COMPAT)
    api(Dependencies.CORE_KTX)
    api(Dependencies.TIMBER)
    kapt(Dependencies.HILT_ANDROID_COMPILER)
}