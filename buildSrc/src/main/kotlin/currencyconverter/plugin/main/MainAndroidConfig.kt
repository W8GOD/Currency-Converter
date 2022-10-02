package currencyconverter.plugin.main

import app.DefaultBuildConfig
import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

internal fun Project.configureMainAndroid() = this.extensions.getByType<BaseExtension>().run {

    compileSdkVersion(DefaultBuildConfig.compileSdkVersion)

    defaultConfig {
        minSdk = DefaultBuildConfig.minSdkVersion
        targetSdk = DefaultBuildConfig.targetSdkVersion
        applicationId = DefaultBuildConfig.applicationId
        versionCode = DefaultBuildConfig.versionCode
        versionName = DefaultBuildConfig.versionName

        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true

        buildTypes {
            getByName("debug") {
                splits.abi.isEnable = false
                splits.density.isEnable = false
                aaptOptions.cruncherEnabled = false
                isTestCoverageEnabled = true
            }
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }

        testOptions {
            unitTests.isReturnDefaultValues = true
        }

        packagingOptions {
            resources.excludes.add("libs/arm64-v8a/libHDACEngine.so")
            resources.excludes.add("lib/mips/librsjni.so")
            resources.excludes.add("lib/mips/libRSSupport.so")
            resources.excludes.add("META-INF/LICENSE.txt")
            resources.excludes.add("META-INF/LICENSE")
            resources.excludes.add("META-INF/ASL2.0")
            resources.excludes.add("META-INF/NOTICE")
            resources.excludes.add("META-INF/NOTICE.txt")
            resources.excludes.add("META-INF/services/javax.annotation.processing.Processor")
            resources.excludes.add("META-INF/rxjava.properties")
            resources.excludes.add("META-INF/*.kotlin_module")
        }

        useLibrary("android.test.runner")
        useLibrary("android.test.base")
        useLibrary("android.test.mock")
    }
}
