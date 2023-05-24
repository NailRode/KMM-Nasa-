object Versions {
    const val minSdk = 24
    const val targetSdk = 33
    const val compileSdk = 33

    const val kmpNativeCoroutines = "1.0.0-ALPHA-9"
    const val jUnit = "4.13.2"
    const val materialDesign = "1.4.0"
    const val kotlinxDateTime = "0.4.0"
    const val activityCompose = "1.7.0"
    const val viewModel = "2.6.1"
    const val napier = "2.6.1"
    const val junit5 = "1.5.10"
    const val buildKonfig = "0.13.3"
    const val kmmViewModel = "1.0.0-ALPHA-9"
    const val imageLoader = "1.4.2"
    const val essenty = "1.1.0"

    object Serialization {
        const val json = "1.5.1"
    }

    const val frameworkName = "shared"
}

object Dependencies {
    const val junit = "junit:junit:${Versions.jUnit}"
    const val material = "com.google.android.material:material:${Versions.materialDesign}"
    const val napier = "io.github.aakira:napier:${Versions.napier}"
    const val androidViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewModel}"
    const val kmmViewModel = "com.rickclephas.kmm:kmm-viewmodel-core:${Versions.kmmViewModel}"
    const val imageLoader = "io.github.qdsfdhvh:image-loader:${Versions.imageLoader}"
    const val essenty = "com.arkivanov.essenty:lifecycle:${Versions.essenty}"

    object Decompose {
        private const val VERSION = "1.0.0-compose-experimental"
        const val decompose = "com.arkivanov.decompose:decompose:$VERSION"
        const val jetbrainsComposeExtensions = "com.arkivanov.decompose:extensions-compose-jetbrains:$VERSION"
    }

    object Koin {
        private const val VERSION = "3.4.0"
        private const val ANDROID_VERSION = "3.4.0"
        private const val COMPOSE_VERSION = "3.4.4"

        const val common = "io.insert-koin:koin-core:$VERSION"
        const val android = "io.insert-koin:koin-android:$ANDROID_VERSION"
        const val androidCompose = "io.insert-koin:koin-androidx-compose:$COMPOSE_VERSION"
        const val test = "io.insert-koin:koin-test:$VERSION"
    }

    object Ktor {
        private const val VERSION = "2.3.0"

        const val common = "io.ktor:ktor-client-core:$VERSION"
        const val serialization = "io.ktor:ktor-serialization-kotlinx-json:$VERSION"
        const val contentNegotiation = "io.ktor:ktor-client-content-negotiation:$VERSION"
        const val android = "io.ktor:ktor-client-okhttp:$VERSION"
        const val ios = "io.ktor:ktor-client-darwin:$VERSION"
        const val logging = "io.ktor:ktor-client-logging:$VERSION"
    }

    object Coroutines {
        private const val VERSION = "1.7.1"

        const val common = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$VERSION"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$VERSION"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$VERSION"
    }

    object JetBrains {
        const val datetime = "org.jetbrains.kotlinx:kotlinx-datetime:${Versions.kotlinxDateTime}"
        const val serializationJson = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.Serialization.json}"
    }
}
