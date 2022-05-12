package uz.unical.buildSrc

object Libs {

    object Compressor {
        const val compressor = "id.zelory:compressor:3.0.1"
    }

    object Lottie {
        const val lottie = "com.airbnb.android:lottie:3.4.0"
    }

    object Glide {
        private const val version = "4.12.0"
        const val glide = "com.github.bumptech.glide:glide:$version"
        const val kapt = "com.github.bumptech.glide:compiler:$version"
    }

    object Service {
        const val serviceLifecycle = "androidx.lifecycle:lifecycle-service:2.4.1"
    }

    object View {
        const val flowLayoutManager = "com.xiaofeng.android:flowlayoutmanager:1.2.3.2"


        const val otpView = "com.github.aabhasr1:OtpView:v1.1.2"
    }

    object Paging {
        private const val version = "3.1.0"
        const val paging = "androidx.paging:paging-runtime-ktx:$version"
    }

    object Navigation {
        private const val version = "2.3.5"
        const val navigation_fragment = "androidx.navigation:navigation-fragment-ktx:$version"
        const val navigation_ui = "androidx.navigation:navigation-ui-ktx:$version"
        const val navigation_dynamic =
            "androidx.navigation:navigation-dynamic-features-fragment:$version"
        const val safe_args = "androidx.navigation:navigation-safe-args-gradle-plugin:$version"
        const val common = "androidx.navigation:navigation-common-ktx:$version"
    }

    object Utils {
        const val avoid_conflict =
            "com.google.guava:listenablefuture:9999.0-empty-to-avoid-conflict-with-guava"
    }

    object AndroidX {

        object Core {
            private const val version = "1.7.0"
            const val core = "androidx.core:core-ktx:$version"
        }

        object Compose {
            private const val version = "1.1.0"
            const val composeUi = "androidx.compose.ui:ui:$version"
            const val composeMaterial = "androidx.compose.material3:material3:1.0.0-alpha06"
            const val composeUiTooling = "androidx.compose.ui:ui-tooling-preview:$version"

            object ConstraintLayout {
                private const val version = "1.0.0"
                const val constraint = "androidx.constraintlayout:constraintlayout-compose:$version"
            }
        }

        object Lifecycle {
            private const val version = "2.4.1"
            const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
        }

        object Activity {
            private const val version = "1.4.0"
            const val activity = "androidx.activity:activity-compose:$version"
        }

        object AppCompat {
            private const val version = "1.2.0"
            const val appcompat = "androidx.appcompat:appcompat:$version"
        }

    }

    object Material {
        private const val version = "1.5.0"
        const val material = "com.google.android.material:material:$version"
        const val androidx_material = "androidx.compose.material:material:1.0.0-rc01"
        const val alphaMaterial = "com.google.android.material:material:1.2.0-alpha03"

    }


    object Kotlin {
        private const val version = "1.6.10"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
        const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:$version"
        const val reflect = "org.jetbrains.kotlin:kotlin-reflect:$version"

        const val serializationPlugin = "org.jetbrains.kotlin:kotlin-serialization:$version"
        const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2"

    }

    object Gradle {
        private const val version = "7.1.1"
        const val gradle = "com.android.tools.build:gradle:$version"
    }

    object Accompanist {
        object SystemUiController {
            private const val version = "0.24.2-alpha"
            const val systemUiController =
                "com.google.accompanist:accompanist-systemuicontroller:$version"
        }

        object Insets {
            private const val version = "0.24.3-alpha"
            const val insets = "com.google.accompanist:accompanist-insets:$version"
        }

        object Pager {
            private const val version = "0.24.3-alpha"
            const val pager = "com.google.accompanist:accompanist-pager:$version"
        }
    }

    object Coil {
        private const val version = "1.4.0"
        const val coil = "io.coil-kt:coil:$version"
    }

    object Multidex {
        private const val version = "2.0.1"
        const val multidex = "androidx.multidex:multidex:$version"
    }

    object Hilt {
        private const val version = "2.38.1"
        private const val composeNavigationVersion = "1.0.0"
        const val gradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$version"

        const val hilt = "com.google.dagger:hilt-android:$version"
        const val hiltKapt = "com.google.dagger:hilt-android-compiler:$version"
        const val hiltComposeNavigation =
            "androidx.hilt:hilt-navigation-compose:$composeNavigationVersion"
    }

    object DataStore {
        private const val version = "1.0.0"
        const val datastore =
            "androidx.datastore:datastore-preferences:$version"
    }

    object Retrofit {
        private const val version = "2.9.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val retrofit_moshi = "com.squareup.retrofit2:converter-moshi:$version"
        const val retrofit_kotlinx_serialisation =
            "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0"
    }

    object Moshi {
        private const val version = "1.13.0"
        const val moshi = "com.squareup.moshi:moshi-kotlin:$version"
        const val kapt = "com.squareup.moshi:moshi-kotlin-codegen:$version"
    }

    object Room {
        private const val version = "2.4.2"
        const val room = "androidx.room:room-runtime:$version"
        const val roomKtx = "androidx.room:room-ktx:$version"
        const val roomKapt = "androidx.room:room-compiler:$version"
    }

    object Okhttp {
        private const val version = "4.9.3"
        const val okhttp = "com.squareup.okhttp3:okhttp:$version"
    }

    object Chucker {
        private const val version = "3.5.2"
        const val chucker_debug = "com.github.chuckerteam.chucker:library:$version"
        const val chucker_release = "com.github.chuckerteam.chucker:library-no-op:$version"
    }

    object Navigaion {
        private const val version = "2.4.1"
        const val navigation = "androidx.navigation:navigation-compose:$version"
    }

    object MetaShimmer {
        private const val version = "0.5.0"
        const val shimmer = "com.facebook.shimmer:shimmer:$version"
    }

    object Decipher {
        private const val version = "1.0.0"
        const val decipher = "uz.unical.android:decipher:$version"
    }

    object AndroidYoutube {
        private const val version = "11.0.1"
        const val androidYoutubePlayer =
            "com.pierfrancescosoffritti.androidyoutubeplayer:core:$version"
    }


    object Test {

        object JUnit {
            private const val version = "4.13.2"
            const val junit = "junit:junit:$version"
        }

        object Espresso {
            private const val version = "3.4.0"
            const val espresso = "androidx.test.espresso:espresso-core:$version"
        }

        object ComposeUiTest {
            private const val version = "1.1.0"
            const val test = "androidx.compose.ui:ui-test-junit4:$version"
        }

        object AndroidJUnit {
            private const val version = "1.1.3"
            const val test = "androidx.test.ext:junit:$version"
        }

        object ComposeDebugTooling {
            private const val version = "1.1.0"
            const val tooling = "androidx.compose.ui:ui-tooling:$version"
        }

    }
}