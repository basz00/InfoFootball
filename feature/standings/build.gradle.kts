plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
}

val composeVersion = rootProject.extra.get("composeVersion") as String


android {
    namespace = "com.baz.infofootball.feature.standings"
    compileSdk = 32

    defaultConfig {
        minSdk = 21
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

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = composeVersion
    }
}

dependencies {
    val coreKtxVersion = rootProject.extra.get("coreKtxVersion")
    val composeNavigationVersion = rootProject.extra.get("composeNavigationVersion")
    val composeViewModelVersion = rootProject.extra.get("composeViewModelVersion")
    val activityComposeVersion = rootProject.extra.get("activityComposeVersion")
    val composeMaterial3Version = rootProject.extra.get("composeMaterial3Version")
    val daggerHiltVersion = rootProject.extra.get("daggerHiltVersion")

    implementation(project(mapOf("path" to ":core:ui")))
    implementation(project(mapOf("path" to ":core:network")))
    implementation(project(mapOf("path" to ":data:standings")))

    implementation("androidx.core:core-ktx:${coreKtxVersion}")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.4")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.0")
    androidTestImplementation("androidx.annotation:annotation:1.3.0")

    //compose
    implementation("androidx.activity:activity-compose:${activityComposeVersion}")
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    implementation("androidx.compose.material3:material3:${composeMaterial3Version}")
    implementation("androidx.navigation:navigation-compose:${composeNavigationVersion}")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:${composeViewModelVersion}")

    //dagger-hilt
    implementation("com.google.dagger:hilt-android:${daggerHiltVersion}")
    kapt("com.google.dagger:hilt-compiler:${daggerHiltVersion}")
}

kapt {
    correctErrorTypes = true
}