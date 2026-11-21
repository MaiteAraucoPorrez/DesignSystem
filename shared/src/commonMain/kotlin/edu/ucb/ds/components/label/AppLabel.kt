package edu.ucb.ds.components.label

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import edu.ucb.ds.theme.MyProjectTheme

/** Título de sección. [textAlign] permite centrar o justificar el texto (por defecto, el del sistema). */
@Composable
fun AppHeading(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MyProjectTheme.colors.onBackground,
    textAlign: TextAlign? = null
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        textAlign = textAlign,
        style = MyProjectTheme.typography.heading
    )
}

/** Texto de párrafo. [textAlign] permite centrar o justificar el texto (por defecto, el del sistema). */
@Composable
fun AppBody(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MyProjectTheme.colors.onBackground,
    textAlign: TextAlign? = null
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        textAlign = textAlign,
        style = MyProjectTheme.typography.body
    )
}

/** Texto corto de apoyo (etiquetas, fechas). [textAlign] permite centrar o justificar el texto. */
@Composable
fun AppLabel(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MyProjectTheme.colors.onBackground,
    textAlign: TextAlign? = null
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        textAlign = textAlign,
        style = MyProjectTheme.typography.label
    )
}
