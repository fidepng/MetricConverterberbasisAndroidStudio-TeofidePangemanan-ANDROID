plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.example.aplikasimetricconverter"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.aplikasimetricconverter"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0"
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.compose.ui:ui:1.4.0")
    implementation("androidx.compose.material:material:1.4.0")
    implementation("androidx.compose.ui:ui-tooling-preview:1.4.0")
    implementation("androidx.activity:activity-compose:1.6.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.8.0")
    implementation("androidx.compose.material3:material3:1.0.0")

    // JUnit for local unit tests
    testImplementation("junit:junit:4.13.2")

    // AndroidX Test - JUnit for instrumented tests
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.test:rules:1.5.0")
    androidTestImplementation("androidx.test:runner:1.5.2")

    // AndroidX Compose Testing
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.4.0")
}



