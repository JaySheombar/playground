object Compose {
    const val composeCompilerVersion = "1.3.2"

    // https://developer.android.com/jetpack/androidx/releases/compose#versions
    private const val composeBomVersion = "2022.11.00"
    const val composeBom = "androidx.compose:compose-bom:$composeBomVersion"

    const val composeTooling = "androidx.compose.ui:ui-tooling"
    const val composePreview = "androidx.compose.ui:ui-tooling-preview"

    const val composeUi = "androidx.compose.ui:ui"
    const val composeMaterial = "androidx.compose.material3:material3"

    // https://developer.android.com/jetpack/compose/setup#bom-version-mapping
    private const val composeActivityVersion = "1.6.1"
    const val composeActivity = "androidx.activity:activity-compose:$composeActivityVersion"

    // https://developer.android.com/jetpack/compose/setup#bom-version-mapping
    private const val composeViewModelVersion = "2.5.1"
    const val composeViewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:$composeViewModelVersion"

    // Navigation: https://developer.android.com/jetpack/androidx/releases/navigation
    private const val navigationVersion = "2.6.0-alpha04"
    const val navigation = "androidx.navigation:navigation-compose:$navigationVersion"
}