package edu.ucb.ds.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

/** Token de colores del Design System: Primary, Secondary, Background, Error (+ sus "on" y surface). */
@Immutable
data class DsColors(
    val primary: Color,
    val onPrimary: Color,
    val secondary: Color,
    val onSecondary: Color,
    val background: Color,
    val onBackground: Color,
    val surface: Color,
    val onSurface: Color,
    val error: Color,
    val onError: Color
)

val LightDsColors = DsColors(
    primary = Color(0xFF1565C0),
    onPrimary = Color(0xFFFFFFFF),
    secondary = Color(0xFF00897B),
    onSecondary = Color(0xFFFFFFFF),
    background = Color(0xFFFAFAFA),
    onBackground = Color(0xFF1B1B1F),
    surface = Color(0xFFFFFFFF),
    onSurface = Color(0xFF1B1B1F),
    error = Color(0xFFB3261E),
    onError = Color(0xFFFFFFFF)
)

val DarkDsColors = DsColors(
    primary = Color(0xFF90CAF9),
    onPrimary = Color(0xFF0D2B4E),
    secondary = Color(0xFF80CBC4),
    onSecondary = Color(0xFF00332E),
    background = Color(0xFF121316),
    onBackground = Color(0xFFE3E2E6),
    surface = Color(0xFF1E1F24),
    onSurface = Color(0xFFE3E2E6),
    error = Color(0xFFF2B8B5),
    onError = Color(0xFF601410)
)

/** Alto contraste: texto negro puro sobre blanco y colores de marca más oscuros (contraste AAA). */
val HighContrastLightDsColors = DsColors(
    primary = Color(0xFF002A6B),
    onPrimary = Color(0xFFFFFFFF),
    secondary = Color(0xFF00413A),
    onSecondary = Color(0xFFFFFFFF),
    background = Color(0xFFFFFFFF),
    onBackground = Color(0xFF000000),
    surface = Color(0xFFFFFFFF),
    onSurface = Color(0xFF000000),
    error = Color(0xFF7A0000),
    onError = Color(0xFFFFFFFF)
)

/** Alto contraste oscuro: texto blanco puro sobre negro y colores de marca muy claros. */
val HighContrastDarkDsColors = DsColors(
    primary = Color(0xFFD6E9FF),
    onPrimary = Color(0xFF000000),
    secondary = Color(0xFFC8FFF6),
    onSecondary = Color(0xFF000000),
    background = Color(0xFF000000),
    onBackground = Color(0xFFFFFFFF),
    surface = Color(0xFF000000),
    onSurface = Color(0xFFFFFFFF),
    error = Color(0xFFFFDAD6),
    onError = Color(0xFF000000)
)
