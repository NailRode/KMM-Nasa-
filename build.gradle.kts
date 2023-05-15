plugins {
    // trick: for the same plugin versions in all sub-modules
    id("com.android.application").version(Versions.androidGradlePlugin).apply(false)
    id("com.android.library").version(Versions.androidGradlePlugin).apply(false)
    id("com.google.devtools.ksp").version(Versions.kspPlugin).apply(false)
    kotlin("android").version(Versions.kotlinGradlePlugin).apply(false)
    kotlin("multiplatform").version(Versions.kotlinGradlePlugin).apply(false)
    kotlin("plugin.serialization").version(Versions.Serialization.plugin)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
