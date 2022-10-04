package currencyconverter.plugin.main

import app.Dependencies
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureMainDependency() = dependencies {
    add("implementation", fileTree("libs") { include("*.jar") })

    add("implementation", Dependencies.coreKtx)
    add("implementation", Dependencies.appcompat)
    add("implementation", Dependencies.materialDesign)
    add("implementation", Dependencies.composeUI)
    add("implementation", Dependencies.composeMaterial)
    add("implementation", Dependencies.composePreview)
    add("implementation", Dependencies.lifecycleKtx)
    add("implementation", Dependencies.lifecycleViewModelCompose)
    add("implementation", Dependencies.composeActivity)
    add("implementation", Dependencies.kotlinxCoroutines)
    add("implementation", Dependencies.gson)
    add("implementation", Dependencies.swipeRefresh)
    add("implementation", Dependencies.coil)
    add("implementation", Dependencies.coilCompose)
    add("implementation", Dependencies.coilSvg)
    add("implementation", Dependencies.coilSvg)

    add("implementation", Dependencies.hilt)
    add("kapt", Dependencies.hiltAndroidCompiler)

    add("testImplementation", Dependencies.junit)
    add("androidTestImplementation", Dependencies.testRunner)
    add("androidTestImplementation", Dependencies.espresso)
    add("debugImplementation", Dependencies.composeUITooling)

}