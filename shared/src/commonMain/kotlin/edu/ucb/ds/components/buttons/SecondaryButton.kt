package edu.ucb.ds.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import edu.ucb.ds.theme.MyProjectTheme

@Composable
fun SecondaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = MyProjectTheme.colors.secondary
        ),
        border = BorderStroke(1.dp, MyProjectTheme.colors.secondary),
        contentPadding = PaddingValues(
            horizontal = MyProjectTheme.spacing.large,
            vertical = MyProjectTheme.spacing.medium
        )
    ) {
        Text(text = text, style = MyProjectTheme.typography.label)
    }
}
