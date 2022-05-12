
plugins {
    id("com.android.application")
}

apply(from = "../commons.gradle")

android {
    defaultConfig {
        testApplicationId = uz.unical.buildSrc.Configurations.App.applicationId
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {

    implementation(uz.unical.buildSrc.Libs.Navigaion.navigation)
    implementation(uz.unical.buildSrc.Libs.Hilt.hiltComposeNavigation)
    implementation(uz.unical.buildSrc.Libs.Accompanist.Pager.pager)

    implementation(project(uz.unical.buildSrc.Configurations.Modules.core))
    implementation(project(uz.unical.buildSrc.Configurations.Modules.domain))
    implementation(project(uz.unical.buildSrc.Configurations.Modules.network))
    implementation(project(uz.unical.buildSrc.Configurations.Modules.navigation))
    implementation(project(uz.unical.buildSrc.Configurations.Modules.cache))
    implementation(project(uz.unical.buildSrc.Configurations.Modules.common))

    implementation(project(uz.unical.buildSrc.Configurations.Modules.ScreenModules.home))
    implementation(project(uz.unical.buildSrc.Configurations.Modules.ScreenModules.profile))
    implementation(project(uz.unical.buildSrc.Configurations.Modules.ScreenModules.search))
    implementation(project(uz.unical.buildSrc.Configurations.Modules.ScreenModules.saved))

}