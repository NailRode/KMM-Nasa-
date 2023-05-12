plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "de.nailrode.kmm.nasa.android"
    compileSdk = Versions.compileSdk
    defaultConfig {
        applicationId = "de.nailrode.kmm.nasa.android"
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompilerVersion
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":shared"))

    with(Dependencies) {
        implementation(napier)
        implementation(material)
    }

    with(Dependencies.Compose) {
        implementation(compiler)
        implementation(runtime)
        implementation(runtimeLivedata)
        implementation(ui)
        implementation(tooling)
        implementation(foundation)
        implementation(foundationLayout)
        implementation(material)
        implementation(materialIcons)
        implementation(activity)
    }
}
