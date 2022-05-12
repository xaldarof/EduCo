plugins {
    id("com.android.application") version "7.1.2" apply false
    id("com.android.library") version "7.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.6.10" apply false
}

buildscript {
    dependencies {
        classpath(uz.unical.buildSrc.Libs.Gradle.gradle)
        classpath(uz.unical.buildSrc.Libs.Kotlin.gradlePlugin)
        classpath(uz.unical.buildSrc.Libs.Hilt.gradlePlugin)
        classpath(uz.unical.buildSrc.Libs.Navigation.safe_args)
        classpath(uz.unical.buildSrc.Libs.Kotlin.serializationPlugin)
    }
}

task<Delete>("clean") {
    delete(rootProject.buildDir)
}
