package com.fineteklabs.spacetutorial.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.FontFamily
import org.jetbrains.compose.resources.Font
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import spacetutorial.composeapp.generated.resources.Res
import spacetutorial.composeapp.generated.resources.figtree_regular
import spacetutorial.composeapp.generated.resources.quicksand_regular

val bodyFontFamily: FontFamily
    @Composable get() = FontFamily(
        Font(
            Res.font.figtree_regular,
            FontWeight.Normal,
        )
    )

val displayFontFamily: FontFamily
    @Composable get() = FontFamily(
        Font(
            Res.font.quicksand_regular,
            FontWeight.Normal,
        )
    )

// Default Material 3 typography values
val baseline = Typography()

val AppTypography: Typography
    @Composable
    get() = Typography(
        displayLarge = baseline.displayLarge.copy(fontFamily = displayFontFamily),
        displayMedium = baseline.displayMedium.copy(fontFamily = displayFontFamily),
        displaySmall = baseline.displaySmall.copy(fontFamily = displayFontFamily),
        headlineLarge = baseline.headlineLarge.copy(fontFamily = displayFontFamily),
        headlineMedium = baseline.headlineMedium.copy(fontFamily = displayFontFamily),
        headlineSmall = baseline.headlineSmall.copy(fontFamily = displayFontFamily),
        titleLarge = baseline.titleLarge.copy(fontFamily = displayFontFamily),
        titleMedium = baseline.titleMedium.copy(fontFamily = displayFontFamily),
        titleSmall = baseline.titleSmall.copy(fontFamily = displayFontFamily),
        bodyLarge = baseline.bodyLarge.copy(fontFamily = bodyFontFamily),
        bodyMedium = baseline.bodyMedium.copy(fontFamily = bodyFontFamily),
        bodySmall = baseline.bodySmall.copy(fontFamily = bodyFontFamily),
        labelLarge = baseline.labelLarge.copy(fontFamily = bodyFontFamily),
        labelMedium = baseline.labelMedium.copy(fontFamily = bodyFontFamily),
        labelSmall = baseline.labelSmall.copy(fontFamily = bodyFontFamily),
    )

