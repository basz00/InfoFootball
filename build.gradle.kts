buildscript {
    extra.set("composeVersion", "1.1.1")
    extra.set("coreKtxVersion", "1.9.0")
    extra.set("lifecycleRuntimeKtxVersion", "2.5.1")
    extra.set("activityComposeVersion", "1.6.1")
    extra.set("composeMaterial3Version", "1.1.0-alpha03")
    extra.set("jUnitVersion", "4.13.2")
    extra.set("androidJUnitVersion", "1.1.4")
    extra.set("espressoVersion", "3.5.0")
    extra.set("daggerHiltVersion", "2.44.2")
}

plugins {
    id("com.android.application") version "7.3.0" apply false
    id("com.android.library") version "7.3.0" apply false
    id("com.google.dagger.hilt.android") version "2.44.2" apply false

    kotlin("android") version "1.7.10" apply false
}