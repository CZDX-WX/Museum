plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.czdxwx.museum"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.czdxwx.museum"
        minSdk = 29
        targetSdk = 34
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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)

    //本地数据库
    implementation(libs.room.common)
    implementation(libs.room.runtime)
    // Retrofit：网络请求框架
    implementation(libs.retrofit.v290)
    implementation(libs.converter.gson.v210)
    implementation(libs.gson)

    //注解开发
    implementation(libs.lombok)
    implementation(libs.logging.interceptor)
    implementation(libs.annotation)
    implementation(libs.constraintlayout)
    implementation(libs.lifecycle.livedata.ktx)
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.activity)
    implementation(libs.legacy.support.v4)
    implementation(libs.navigation.fragment)
    testImplementation(libs.junit)

    annotationProcessor(libs.lombok)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    annotationProcessor(libs.room.compiler)
}