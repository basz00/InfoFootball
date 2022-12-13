plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

val composeVersion = rootProject.extra.get("composeVersion") as String

android {
    namespace = "com.baz.infofootball.core.ui"
    compileSdk = 33

    defaultConfig {
        minSdk = 21
        targetSdk = 33

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = composeVersion
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    val composeNavigationVersion = rootProject.extra.get("composeNavigationVersion")
    val composeViewModelVersion = rootProject.extra.get("composeViewModelVersion")
    val activityComposeVersion = rootProject.extra.get("activityComposeVersion")
    val composeMaterial3Version = rootProject.extra.get("composeMaterial3Version")

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("com.google.android.material:material:1.7.0")

    //compose
    implementation("androidx.activity:activity-compose:${activityComposeVersion}")
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    implementation("androidx.compose.material3:material3:${composeMaterial3Version}")
    implementation("androidx.navigation:navigation-compose:${composeNavigationVersion}")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:${composeViewModelVersion}")
}