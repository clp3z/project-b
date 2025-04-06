plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.google.dagger.hilt)
    alias(libs.plugins.google.devtools.ksp)
}

android {
    namespace = "com.clp3z.projectb.framework.persistence"
}

dependencies {

    // Modules
    implementation(project(":entity"))

    // Hilt
    implementation(libs.google.dagger.hilt.android)
    ksp(libs.google.dagger.hilt.compiler)

    // Room
    implementation(libs.bundles.androidx.room)
    ksp(libs.androidx.room.compiler)

    // Arrow
    implementation(libs.arrow.core)
}
