plugins {
    id(Build.application)
    id(Build.kotlin)
    kotlin(Build.kapt)
    id(Build.hilt)
}

android {
    namespace = "com.jaysh.playground"
    compileSdk = ProjectConfig.compileSdk

    defaultConfig {
        applicationId = ProjectConfig.applicationId
        minSdk = ProjectConfig.minSdk
        targetSdk = ProjectConfig.targetSdk
        versionCode = ProjectConfig.versionCode
        versionName = ProjectConfig.versionName

        testInstrumentationRunner = ProjectConfig.testInstrumentationRunner
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isDebuggable = false
            isShrinkResources = true
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = freeCompilerArgs + "-Xcontext-receivers"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Compose.composeCompilerVersion
    }

    packagingOptions {
        exclude("META-INF/AL2.0")
        exclude("META-INF/LGPL2.1")
    }
}

tasks.getByPath("preBuild").dependsOn("ktlintFormat")

dependencies {
    implementation(project(Modules.core))

    implementation(project(Modules.bakeryFirst))

    implementation(AndroidX.coreKtx)
    implementation(AndroidX.lifecycleRuntime)

    implementation(AndroidX.lifecycleRuntimeCompose)
    implementation(AndroidX.lifecycleViewModel)
    implementation(AndroidX.lifecycleSavedState)

    implementation(platform(Compose.composeBom))
    implementation(Compose.composeUi)
    implementation(Compose.composeActivity)
    implementation(Compose.composeTooling)
    implementation(Compose.composePreview)
    implementation(Compose.composeMaterial)
    implementation(Compose.composeViewModel)
    implementation(Compose.navigation)

    implementation(DaggerHilt.hiltAndroid)
    implementation(DaggerHilt.composeHiltNavigation)
    kapt(DaggerHilt.hiltCompiler)

    // HttpClient
    implementation(Ktor.core)
    implementation(Ktor.okHttp)
    implementation(Ktor.contentNegotiation)
    implementation(Ktor.serialization)
    implementation(Ktor.logging)
    implementation(Ktor.auth)

    // Arrow
    implementation(platform(Arrow.bom))
    implementation(Arrow.core)
    implementation(Arrow.fxCoroutines)
    implementation(Arrow.fxStm)

    implementation(Logcat.core)
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}