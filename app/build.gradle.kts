plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
}

android {
    namespace = "ru.fd.ohayosekai"
    compileSdk = 35

    defaultConfig {
        applicationId = "ru.fd.ohayosekai"
        minSdk = 25
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.room.gradle.plugin)
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.activity)

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.7")
//    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    kapt("androidx.room:room-compiler:2.7.1")
//    kapt(libs.androidx.room.compiler)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}