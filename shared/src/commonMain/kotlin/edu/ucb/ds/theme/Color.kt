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
