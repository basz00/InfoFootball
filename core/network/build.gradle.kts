plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

android {
    namespace = "com.baz.infofootball.network"
    compileSdk = 33

    defaultConfig {
        minSdk = 21
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        buildConfigField("String", "KEY", "\"048bdb38d2b90138198eb9c7ac79c629\"")
        buildConfigField("String", "API_HEADER", "\"x-apisports-key\"")
        buildConfigField("String", "BASE_URL", "\"https://v3.football.api-sports.io\"")
        buildConfigField("String", "BASE_URL_SSL", "\"v3.football.api-sports.io\"")
        buildConfigField(
            "String",
            "SSL_PIN_1",
            "\"sha256/CFmLhuxykPKM5io8Bab0j41EW1iG65JHmtsOcf73fzU=\""
        )
        buildConfigField(
            "String",
            "SSL_PIN_2",
            "\"sha256/jQJTbIh0grw0/1TkHSumWb+Fs0Ggogr621gT3PvPKG0=\""
        )
        buildConfigField(
            "String",
            "SSL_PIN_3",
            "\"sha256/C5+lpZ7tcVwmwQIMcRtPbsQtWLABXhQzejna0wHFr8M=\""
        )
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
    val retrofitVersion = rootProject.extra.get("retrofitVersion")
    val loggingInterceptorVersion = rootProject.extra.get("loggingInterceptorVersion")
    val daggerHiltVersion = rootProject.extra.get("daggerHiltVersion")

    implementation("androidx.core:core-ktx:1.7.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.4")

    //retrofit
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    implementation("com.squareup.okhttp3:logging-interceptor:$loggingInterceptorVersion")

    //dagger-hilt
    implementation("com.google.dagger:hilt-android:${daggerHiltVersion}")
    kapt("com.google.dagger:hilt-compiler:${daggerHiltVersion}")
}

kapt {
    correctErrorTypes = true
}