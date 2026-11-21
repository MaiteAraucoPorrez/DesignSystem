package edu.ucb.ds.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import edu.ucb.ds.resources.Res
import edu.ucb.ds.resources.fira_sans_bold
import edu.ucb.ds.resources.fira_sans_medium
import edu.ucb.ds.resources.fira_sans_regular
import edu.ucb.ds.resources.fira_sans_semibold
import org.jetbrains.compose.resources.Font

/** Token de tipografía: Heading, Body, Label. */
@Immutable
data class DsTypography(
    val heading: TextStyle,
    val body: TextStyle,
    val label: TextStyle
)

/** Tipografía base (fuente del sistema). Se usa mientras no haya un tema que provea Fira Sans. */
val DefaultDsTypography = DsTypography(
    heading = TextStyle(
        fontSize = 24.sp,
        lineHeight = 32.sp,
        fontWeight = FontWeight.Bold
    ),
    body = TextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight.Normal
    ),
    label = TextStyle(
        fontSize = 14.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight.Medium
    )
)

/** Fira Sans (licencia OFL) en cuatro pesos; los archivos están en composeResources/font. */
@Composable
fun rememberDsFontFamily(): FontFamily {
    val regular = Font(Res.font.fira_sans_regular, FontWeight.Normal)
    val medium = Font(Res.font.fira_sans_medium, FontWeight.Medium)
    val semiBold = Font(Res.font.fira_sans_semibold, FontWeight.SemiBold)
    val bold = Font(Res.font.fira_sans_bold, FontWeight.Bold)
    return remember(regular, medium, semiBold, bold) { FontFamily(regular, medium, semiBold, bold) }
}

/** Tipografía del Design System con Fira Sans: títulos en seminegrita para un trazo más limpio. */
@Composable
fun rememberDsTypography(): DsTypography {
    val family = rememberDsFontFamily()
    return remember(family) {
        DsTypography(
            heading = DefaultDsTypography.heading.copy(fontFamily = family, fontWeight = FontWeight.SemiBold),
            body = DefaultDsTypography.body.copy(fontFamily = family),
            label = DefaultDsTypography.label.copy(fontFamily = family)
        )
    }
}

/** Typography de Material 3 con la misma familia, para que los componentes base coincidan con los del DS. */
internal fun DsTypography.toMaterialTypography(): Typography {
    val family = body.fontFamily ?: return Typography()
    val base = Typography()
    return Typography(
        displayLarge = base.displayLarge.copy(fontFamily = family),
        displayMedium = base.displayMedium.copy(fontFamily = family),
        displaySmall = base.displaySmall.copy(fontFamily = family),
        headlineLarge = base.headlineLarge.copy(fontFamily = family),
        headlineMedium = base.headlineMedium.copy(fontFamily = family),
        headlineSmall = base.headlineSmall.copy(fontFamily = family),
        titleLarge = base.titleLarge.copy(fontFamily = family),
        titleMedium = base.titleMedium.copy(fontFamily = family),
        titleSmall = base.titleSmall.copy(fontFamily = family),
        bodyLarge = base.bodyLarge.copy(fontFamily = family),
        bodyMedium = base.bodyMedium.copy(fontFamily = family),
        bodySmall = base.bodySmall.copy(fontFamily = family),
        labelLarge = base.labelLarge.copy(fontFamily = family),
        labelMedium = base.labelMedium.copy(fontFamily = family),
        labelSmall = base.labelSmall.copy(fontFamily = family)
    )
}
