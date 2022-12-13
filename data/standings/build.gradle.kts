import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
}

android {
    namespace = "com.baz.infofootball.data.standings"
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    val coreKtxVersion = rootProject.extra.get("coreKtxVersion")
    val daggerHiltVersion = rootProject.extra.get("daggerHiltVersion")
    val retrofitVersion = rootProject.extra.get("retrofitVersion")

    implementation(project(mapOf("path" to ":core:network")))
    implementation(project(mapOf("path" to ":core:ui")))

    implementation("androidx.core:core-ktx:${coreKtxVersion}")
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("com.google.android.material:material:1.7.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.4")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.0")

    //dagger-hilt
    implementation("com.google.dagger:hilt-android:${daggerHiltVersion}")
    kapt("com.google.dagger:hilt-compiler:${daggerHiltVersion}")

    //retrofit
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")
}

kapt {
    correctErrorTypes = true
}