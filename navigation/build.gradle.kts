plugins {
    id("com.android.library")
}

apply(from = "../commons.gradle")

dependencies {
    implementation(project(uz.unical.buildSrc.Configurations.Modules.core))
}