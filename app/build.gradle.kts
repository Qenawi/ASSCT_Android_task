plugins {
  id("com.android.application")
  kotlin("android")
  kotlin("android.extensions")
  kotlin("kapt")
  // MARK : klint
  id("org.jlleitschuh.gradle.ktlint")
  id("org.jlleitschuh.gradle.ktlint-idea")
}

 android {
  signingConfigs {
    create("app_sigin") {
      storeFile =
        file("/home/cashless/Desktop/android/android_personal-digital-assistant/PDAKEY.jks")
      storePassword = "123456"
      keyPassword = "123456"
      keyAlias = "key0"
    }
  }
  compileSdkVersion(30)
  defaultConfig {
    minSdkVersion(Libraries.Apps.minSdk)
    targetSdkVersion(Libraries.Apps.targetSdk)
    versionCode = Libraries.Apps.versionCode
    versionName = Libraries.Apps.versionName
    multiDexEnabled = true
    setProperty("archivesBaseName", "$applicationId-v$versionName($versionCode)")
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    signingConfig = signingConfigs.getByName("app_sigin")
  }
  dataBinding {
    isEnabled = true
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
  kotlinOptions {
    jvmTarget = JavaVersion.VERSION_1_8.toString()
  }
  lintOptions {
    isCheckReleaseBuilds = false
  }
}

dependencies {
  implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
  implementation(Libraries.Libs.kotlin)
  implementation(Libraries.Libs.appcompat)
  implementation(Libraries.constraintlayout)
  implementation(Libraries.Dagger.dagger)
  implementation(Libraries.Dagger.androidSupport)
  implementation(Libraries.Coroutines.android)
  implementation(Libraries.Coroutines.core)
  implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
  // MARK : - Core App Libs
  kapt(Libraries.Dagger.compiler)
  kapt(Libraries.Dagger.androidProcessor)
  implementation(Libraries.Fragment.fragment)
  implementation(Libraries.Lifecycle.extensions)
  implementation(Libraries.Glide.library)
  kapt(Libraries.Glide.compiler)
  implementation(Libraries.TestLibs.junit)
  implementation(Libraries.Timber)
  implementation(Libraries.Retrofit.retrofit)
  implementation(Libraries.Retrofit.gsonConverter)
  implementation(Libraries.UI.materialComponent)
  implementation(Libraries.Kotlin.reflect)
  implementation(Libraries.Kotlin.workManger)
  compileOnly(Libraries.AssistedInject.annotationDagger2)
  kapt(Libraries.AssistedInject.processorDagger2)
  implementation(Libraries.Google.playServiceLocation)
  // MARK : - Dynamic App Libs
  // MARK : - Image View
  implementation("de.hdodenhof:circleimageview:3.1.0")
  implementation("com.github.jkwiecien:EasyImage:3.0.4")
  implementation("com.squareup.okhttp3:logging-interceptor:4.6.0")
  // MARK : permission Requesting
  implementation("com.karumi:dexter:6.2.2")
  implementation("androidx.coordinatorlayout:coordinatorlayout:1.1.0")
  // MARK : KTX Android View Model
  implementation("androidx.activity:activity-ktx:1.3.0-alpha04")
  implementation(Libraries.coreKtx)
  implementation(Libraries.Fragment.fragmentKtx)
  implementation(Libraries.Lifecycle.viewmodelKtx)
  // ktlint
  compileOnly("org.jetbrains.kotlin:kotlin-stdlib")
  compileOnly("org.jetbrains.kotlin:kotlin-reflect")
  compileOnly("org.jetbrains.kotlin:kotlin-script-runtime")
  compileOnly("com.pinterest.ktlint:ktlint-core:0.41.0")


}

// MARK: - replace all  libs in future
ktlint {
  verbose.set(true)
  outputToConsole.set(true)
  coloredOutput.set(true)
  disabledRules.set(arrayListOf("no-wildcard-imports"))
  reporters {
    reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE)
    reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.JSON)
  }
}