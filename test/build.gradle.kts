plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.clp3z.projectb.test"
}

dependencies {

    // Modules
    implementation(project(":entity"))

    // Serialization
    implementation(libs.kotlinx.serialization.json)

    // Test
    implementation(libs.bundles.kotlinx.coroutines)
    implementation(libs.bundles.local.tests)
}
