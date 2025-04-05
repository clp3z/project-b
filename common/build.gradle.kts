plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.clp3z.projectb.common"
}

dependencies {

    // Modules
    implementation(project(":entity"))

    // Arrow
    implementation(libs.arrow.core)
}
