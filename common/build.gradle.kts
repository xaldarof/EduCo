plugins {
    id("com.android.library")
}

apply(from = "../commons.gradle")

dependencies {
    implementation(project(uz.unical.buildSrc.Configurations.Modules.core))
    implementation(project(uz.unical.buildSrc.Configurations.Modules.navigation))
    implementation(project(uz.unical.buildSrc.Configurations.Modules.domain))
    implementation(project(uz.unical.buildSrc.Configurations.Modules.cache))
}