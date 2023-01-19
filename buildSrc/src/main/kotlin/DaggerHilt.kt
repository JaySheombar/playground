object DaggerHilt {
    // HiltAndroid: https://developer.android.com/jetpack/androidx/releases/hilt
    const val version = "2.42"
    const val hiltAndroid = "com.google.dagger:hilt-android:$version"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:$version"

    // HiltNavigationCompose: https://androidx.tech/artifacts/hilt/hilt-navigation-compose/
    private const val hiltNavigationComposeVersion = "1.0.0"
    const val composeHiltNavigation = "androidx.hilt:hilt-navigation-compose:$hiltNavigationComposeVersion"
}