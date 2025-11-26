plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "ht.nguyenhuutrong.lamthem_materialdesign3_fe_moneytrack"
    compileSdk = 36

    defaultConfig {
        applicationId = "ht.nguyenhuutrong.lamthem_materialdesign3_fe_moneytrack"
        minSdk = 24
        targetSdk = 36
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
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation("com.github.mikephil.charting:mpandroidchart:v3.1.0")
}