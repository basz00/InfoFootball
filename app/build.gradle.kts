plugins {
    id("com.android.application")
    id("com.google.dagger.hilt.android")
    kotlin("android")
    kotlin("kapt")
}

android {
    namespace = "com.baz.infofootball"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.baz.infofootball"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.1"
    }
    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {
    val composeVersion = rootProject.extra.get("composeVersion")
    val coreKtxVersion = rootProject.extra.get("coreKtxVersion")
    val lifecycleRuntimeKtxVersion = rootProject.extra.get("lifecycleRuntimeKtxVersion")
    val activityComposeVersion = rootProject.extra.get("activityComposeVersion")
    val composeMaterial3Version = rootProject.extra.get("composeMaterial3Version")
    val jUnitVersion = rootProject.extra.get("jUnitVersion")
    val androidJUnitVersion = rootProject.extra.get("androidJUnitVersion")
    val espressoVersion = rootProject.extra.get("espressoVersion")
    val daggerHiltVersion = rootProject.extra.get("daggerHiltVersion")

    implementation("androidx.core:core-ktx:${coreKtxVersion}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${lifecycleRuntimeKtxVersion}")
    implementation("androidx.activity:activity-compose:${activityComposeVersion}")
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    implementation("androidx.compose.material3:material3:${composeMaterial3Version}")
    testImplementation("junit:junit:${jUnitVersion}")
    androidTestImplementation("androidx.test.ext:junit:${androidJUnitVersion}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${espressoVersion}")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")
    debugImplementation("androidx.compose.ui:ui-tooling:$composeVersion")
    debugImplementation("androidx.compose.ui:ui-test-manifest:$composeVersion")

    //dagger-hilt
    implementation("com.google.dagger:hilt-android:${daggerHiltVersion}")
    kapt("com.google.dagger:hilt-compiler:${daggerHiltVersion}")
}

kapt {
    correctErrorTypes = true
}