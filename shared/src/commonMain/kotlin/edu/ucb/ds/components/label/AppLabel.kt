package edu.ucb.ds.components.label

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import edu.ucb.ds.theme.MyProjectTheme

@Composable
fun AppHeading(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MyProjectTheme.colors.onBackground
) {
    Text(text = text, modifier = modifier, color = color, style = MyProjectTheme.typography.heading)
}

@Composable
fun AppBody(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MyProjectTheme.colors.onBackground
) {
    Text(text = text, modifier = modifier, color = color, style = MyProjectTheme.typography.body)
}

@Composable
fun AppLabel(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MyProjectTheme.colors.onBackground
) {
    Text(text = text, modifier = modifier, color = color, style = MyProjectTheme.typography.label)
}
