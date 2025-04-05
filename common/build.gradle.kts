plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

dependencies {

    // Modules
    implementation(project(":entity"))

    // Arrow
    implementation(libs.arrow.core)
}
