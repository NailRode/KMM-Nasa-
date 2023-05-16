import com.codingfeline.buildkonfig.compiler.FieldSpec
import java.util.Properties

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    kotlin("plugin.serialization")
    id("com.android.library")
    id("org.jetbrains.compose")
    id("com.google.devtools.ksp")
    id("com.rickclephas.kmp.nativecoroutines").version(Versions.kmpNativeCoroutines)
    id("com.codingfeline.buildkonfig").version(Versions.buildKonfig)
}

kotlin {
    android()

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        version = "1.0.0"
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
            isStatic = true
        }
        extraSpecAttributes["resources"] = "['src/commonMain/resources/**', 'src/iosMain/resources/**']"
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Dependencies.napier)
                implementation(Dependencies.Koin.common)
                implementation(Dependencies.JetBrains.datetime)
                implementation(Dependencies.JetBrains.serializationJson)
                implementation(Dependencies.Coroutines.common)
                implementation(Dependencies.kmmViewModel)

                with(Dependencies.Ktor) {
                    implementation(common)
                    implementation(serialization)
                    implementation(contentNegotiation)
                    implementation(logging)
                }

                with(compose) {
                    implementation(runtime)
                    implementation(foundation)
                    implementation(material)
                    @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                    implementation(components.resources)
                }
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
                api("androidx.activity:activity-compose:1.6.1")
                api("androidx.appcompat:appcompat:1.6.1")
                api("androidx.core:core-ktx:1.9.0")
                implementation(Dependencies.Koin.android)
                implementation(Dependencies.Koin.androidCompose)
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

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlin {
        jvmToolchain(11)
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
