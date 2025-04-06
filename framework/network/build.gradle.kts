plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.google.dagger.hilt)
    alias(libs.plugins.google.devtools.ksp)
    alias(libs.plugins.jetbrains.kotlin.serialization)
}

android {
    namespace = "com.clp3z.projectb.framework.network"
}

dependencies {

    // Modules
    implementation(project(":entity"))
    implementation(project(":common"))
    testImplementation(project(":test"))

    // Hilt
    implementation(libs.google.dagger.hilt.android)
    ksp(libs.google.dagger.hilt.compiler)

    // Coroutines
    implementation(libs.bundles.kotlinx.coroutines)

    // Serialization
    implementation(libs.kotlinx.serialization.json)

    // Arrow
    implementation(libs.arrow.core)

    // Retrofit
    implementation(libs.bundles.squareup.retrofit)

    // Test
    testImplementation(libs.bundles.local.tests)
}
