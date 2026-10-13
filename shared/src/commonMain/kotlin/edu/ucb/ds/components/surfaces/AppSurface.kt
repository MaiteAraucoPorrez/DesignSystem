package edu.ucb.ds.components.surfaces

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import edu.ucb.ds.theme.MyProjectTheme

/** Fondo de pantalla del Design System (usa los colores Background / onBackground). */
@Composable
fun AppSurface(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Surface(
        modifier = modifier,
        color = MyProjectTheme.colors.background,
        contentColor = MyProjectTheme.colors.onBackground,
        content = content
    )
}
