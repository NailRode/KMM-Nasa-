import com.codingfeline.buildkonfig.compiler.FieldSpec
import java.util.Properties

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("com.google.devtools.ksp")
    id("com.rickclephas.kmp.nativecoroutines").version(Versions.kmpNativeCoroutines)
    id("com.codingfeline.buildkonfig").version(Versions.buildKonfig)
    kotlin("plugin.serialization").version(Versions.Serialization.plugin)
}

kotlin {
    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Dependencies.napier)
                implementation(Dependencies.Koin.common)
                implementation(Dependencies.JetBrains.datetime)
                implementation(Dependencies.JetBrains.serializationJson)
                implementation(Dependencies.Ktor.common)
                implementation(Dependencies.Ktor.serialization)
                implementation(Dependencies.Ktor.contentNegotiation)
                implementation(Dependencies.Ktor.logging)
                implementation(Dependencies.Coroutines.common)
                implementation(Dependencies.kmmViewModel)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(Dependencies.Koin.test)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(Dependencies.androidViewModel)
                implementation(Dependencies.Ktor.android)
            }
        }
        val androidUnitTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                implementation(Dependencies.Ktor.ios)
            }
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

kotlin.sourceSets.all {
    languageSettings.optIn("kotlin.experimental.ExperimentalObjCName")
}

android {
    namespace = "de.nailrode.kmm.nasa"
    compileSdk = Versions.compileSdk
    defaultConfig {
        minSdk = Versions.minSdk
    }
}

buildkonfig {
    packageName = "de.nailrode.kmm.nasa"

    val localProperties = Properties()
    localProperties.load(file("${project.rootDir}/local.properties").inputStream())
    defaultConfigs {
        buildConfigField(FieldSpec.Type.STRING, "NASA_API_KEY", localProperties.getProperty("nasa_api_key"))
    }
}
