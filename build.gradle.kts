// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
  repositories {
    google()
    jcenter()
    maven {
      url = uri("https://jitpack.io")
    }
    maven {
      url = uri("https://plugins.gradle.org/m2/")
    }
  }
  dependencies {
    classpath("com.github.dcendents:android-maven-gradle-plugin:1.5")
    classpath("com.jfrog.bintray.gradle:gradle-bintray-plugin:1.7.3")
    classpath("com.google.gms:google-services:4.3.5")
    classpath("com.android.tools.build:gradle:4.2.1")
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Libraries.Versions.kotlin}")
    // MARK : klint
    classpath("org.jlleitschuh.gradle:ktlint-gradle:10.0.0")
    classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.3.5")
    // NOTE: Do not place your application dependencies here; they belong
    // in the individual module build.gradle.kts files
  }
}

allprojects {

  repositories {
    google()
    jcenter()
    maven { setUrl("https://jitpack.io") }
    mavenCentral()
  }
  apply(plugin = "org.jlleitschuh.gradle.ktlint")
  apply(plugin = "org.jlleitschuh.gradle.ktlint-idea")
}

tasks.register("clean", Delete::class) {
  delete(rootProject.buildDir)
}
