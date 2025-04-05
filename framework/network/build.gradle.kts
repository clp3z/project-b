plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.google.dagger.hilt)
    alias(libs.plugins.jetbrains.kotlin.kapt)
    alias(libs.plugins.jetbrains.kotlin.serialization)
}

android {
    namespace = "com.clp3z.projectb.framework.network"
}

/*
android {
    namespace = "com.clp3z.projectb.framework.network"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}
*/

dependencies {

    // Modules
    implementation(project(":entity"))

    // Hilt
    implementation(libs.google.dagger.hilt.android)
    kapt(libs.google.dagger.hilt.compiler)

    // Coroutines
    implementation(libs.bundles.kotlinx.coroutines)

    // Serialization
    implementation(libs.kotlinx.serialization.json)

    // Arrow
    implementation(libs.arrow.core)

    // Retrofit
    implementation(libs.bundles.squareup.retrofit)
}

kapt {
    correctErrorTypes = true
}
