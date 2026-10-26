package edu.ucb.ds.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

internal val LocalDsColors = staticCompositionLocalOf { LightDsColors }
internal val LocalDsTypography = staticCompositionLocalOf { DefaultDsTypography }
internal val LocalDsSpacing = staticCompositionLocalOf { DefaultDsSpacing }

/**
 * Forma de acceso a los tokens:
 *
 *     MyProjectTheme.colors.primary
 *     MyProjectTheme.typography.heading
 *     MyProjectTheme.spacing.large
 */
object MyProjectTheme {
    val colors: DsColors
        @Composable
        @ReadOnlyComposable
        get() = LocalDsColors.current

    val typography: DsTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalDsTypography.current

    val spacing: DsSpacing
        @Composable
        @ReadOnlyComposable
        get() = LocalDsSpacing.current
}

/**
 * Envuelve tu pantalla con este tema:  MyProjectTheme { ...tu UI... }
 *
 * darkTheme sigue al sistema por defecto. highContrast cambia a las paletas de alto contraste
 * (claro u oscuro según darkTheme).
 */
@Composable
fun MyProjectTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    highContrast: Boolean = false,
    colors: DsColors = dsColorsFor(darkTheme, highContrast),
    typography: DsTypography = DefaultDsTypography,
    spacing: DsSpacing = DefaultDsSpacing,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalDsColors provides colors,
        LocalDsTypography provides typography,
        LocalDsSpacing provides spacing
    ) {
        // Material3 por dentro usa los mismos colores, así los componentes base no se ven distintos.
        MaterialTheme(
            colorScheme = colors.toMaterialColorScheme(darkTheme),
            content = content
        )
    }
}

/** Elige la paleta según modo oscuro y alto contraste. */
fun dsColorsFor(darkTheme: Boolean, highContrast: Boolean): DsColors = when {
    highContrast && darkTheme -> HighContrastDarkDsColors
    highContrast -> HighContrastLightDsColors
    darkTheme -> DarkDsColors
    else -> LightDsColors
}

private fun DsColors.toMaterialColorScheme(darkTheme: Boolean): ColorScheme =
    if (darkTheme) {
        darkColorScheme(
            primary = primary,
            onPrimary = onPrimary,
            secondary = secondary,
            onSecondary = onSecondary,
            background = background,
            onBackground = onBackground,
            surface = surface,
            onSurface = onSurface,
            error = error,
            onError = onError
        )
    } else {
        lightColorScheme(
            primary = primary,
            onPrimary = onPrimary,
            secondary = secondary,
            onSecondary = onSecondary,
            background = background,
            onBackground = onBackground,
            surface = surface,
            onSurface = onSurface,
            error = error,
            onError = onError
        )
    }
