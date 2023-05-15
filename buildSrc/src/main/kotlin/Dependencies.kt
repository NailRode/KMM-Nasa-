const val androidPlugin = "android"
const val androidApp = "com.android.application"
const val androidLib = "com.android.library"
const val multiplatform = "multiplatform"
const val composePlugin = "org.jetbrains.compose"

object Versions {
    const val minSdk = 24
    const val targetSdk = 33
    const val compileSdk = 33

    object Koin {
        const val core = "3.4.0"
        const val android = "3.4.0"
        const val androidCompose = "3.4.4"
    }

    const val kotlinGradlePlugin = "1.8.21"
    const val androidGradlePlugin = "8.0.1"
    const val kspPlugin = "1.8.21-1.0.11"
    const val composeCompilerVersion = "1.4.7"
    const val composeVersion = "1.5.0-alpha04"
    const val coroutines = "1.7.1"
    const val kmpNativeCoroutines = "1.0.0-ALPHA-9"
    const val jUnit = "4.13.2"
    const val materialDesign = "1.4.0"
    const val kotlinxDateTime = "0.4.0"
    const val activityCompose = "1.7.0"
    const val viewModel = "2.6.1"
    const val napier = "2.6.1"
    const val junit5 = "1.5.10"
    const val buildKonfig = "0.13.3"
    const val ktor = "2.3.0"
    const val kmmViewModel = "1.0.0-ALPHA-9"

    object Serialization {
        const val plugin = "1.8.10"
        const val json = "1.5.1"
    }

    const val frameworkName = "shared"
}

object Dependencies {
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinGradlePlugin}"

    const val junit = "junit:junit:${Versions.jUnit}"
    const val material = "com.google.android.material:material:${Versions.materialDesign}"
    const val napier = "io.github.aakira:napier:${Versions.napier}"
    const val androidViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewModel}"
    const val kmmViewModel = "com.rickclephas.kmm:kmm-viewmodel-core:${Versions.kmmViewModel}"

    object Koin {
        const val common = "io.insert-koin:koin-core:${Versions.Koin.core}"
        const val android = "io.insert-koin:koin-android:${Versions.Koin.android}"
        const val androidCompose = "io.insert-koin:koin-androidx-compose:${Versions.Koin.androidCompose}"
        const val test = "io.insert-koin:koin-test:${Versions.Koin.core}"
    }

    object Ktor {
        const val common = "io.ktor:ktor-client-core:${Versions.ktor}"
        const val serialization = "io.ktor:ktor-serialization-kotlinx-json:${Versions.ktor}"
        const val contentNegotiation = "io.ktor:ktor-client-content-negotiation:${Versions.ktor}"
        const val android = "io.ktor:ktor-client-okhttp:${Versions.ktor}"
        const val ios = "io.ktor:ktor-client-darwin:${Versions.ktor}"
        const val logging = "io.ktor:ktor-client-logging:${Versions.ktor}"
    }

    object Compose {
        const val ui = "androidx.compose.ui:ui:${Versions.composeVersion}"
        const val uiUtil = "androidx.compose.ui:ui-util:${Versions.composeVersion}"
        const val tooling = "androidx.compose.ui:ui-tooling:${Versions.composeVersion}"
        const val foundation = "androidx.compose.foundation:foundation:${Versions.composeVersion}"
        const val material = "androidx.compose.material:material:${Versions.composeVersion}"
        const val materialIcons = "androidx.compose.material:material-icons-extended:${Versions.composeVersion}"
        const val runtime = "androidx.compose.runtime:runtime:${Versions.composeVersion}"
        const val compiler = "androidx.compose.compiler:compiler:${Versions.composeCompilerVersion}"
        const val runtimeLivedata = "androidx.compose.runtime:runtime-livedata:${Versions.composeVersion}"
        const val foundationLayout = "androidx.compose.foundation:foundation-layout:${Versions.composeVersion}"
        const val activity = "androidx.activity:activity-compose:${Versions.activityCompose}"
    }

    object Coroutines {
        const val common = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    }

    object JetBrains {
        const val datetime = "org.jetbrains.kotlinx:kotlinx-datetime:${Versions.kotlinxDateTime}"
        const val serializationJson = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.Serialization.json}"
    }
}
