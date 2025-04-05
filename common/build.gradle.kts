plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.google.dagger.hilt)
    alias(libs.plugins.jetbrains.kotlin.kapt)
}

android {
    namespace = "com.clp3z.projectb.common"
}

dependencies {

    // Modules
    implementation(project(":entity"))

    // Hilt
    implementation(libs.google.dagger.hilt.android)
    kapt(libs.google.dagger.hilt.compiler)

    // Arrow
    implementation(libs.arrow.core)
}

kapt {
    correctErrorTypes = true
}
