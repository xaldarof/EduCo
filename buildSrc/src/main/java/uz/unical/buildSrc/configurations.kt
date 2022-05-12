package uz.unical.buildSrc

object Configurations {
    object App {
        var applicationId = "uz.unical.online_education"
        const val compileSdk = 32
        const val minSdk = 23
        const val targetSdk = 32
        const val versionCode = 1
        const val versionName = "1.0"
    }

    object Build {
        const val jvmTarget = "1.8"
        const val kotlinCompilerExtensionVersion = "1.1.0"
        const val excludes = "/META-INF/{AL2.0,LGPL2.1}"
        const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    object Modules {
        const val app = ":app"
        const val core = ":core"
        const val datastore = ":datastore"
        const val domain = ":domain"
        const val network = ":network"
        const val navigation = ":navigation"
        const val cache = ":cache"
        const val database = ":database"
        const val common = ":common"
        const val ereader = ":ereader"

        object ScreenModules {
            const val home = ":home"
            const val profile = ":profile"
            const val search = ":search"
            const val saved = ":saved"
        }
    }
}
