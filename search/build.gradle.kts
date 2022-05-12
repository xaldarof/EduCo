plugins {
    id("com.android.library")
}

apply(from = "../commons.gradle")

dependencies {
    implementation(project(uz.unical.buildSrc.Configurations.Modules.core))
    implementation(project(uz.unical.buildSrc.Configurations.Modules.navigation))
    implementation("com.beloo.widget:ChipsLayoutManager:0.3.7@aar")
    implementation("com.xiaofeng.android:flowlayoutmanager:1.2.3.2")
}