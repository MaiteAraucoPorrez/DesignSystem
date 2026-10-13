package edu.ucb.ds.components.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import edu.ucb.ds.theme.MyProjectTheme

@Composable
fun AppCard(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit
) {
    val spacing = MyProjectTheme.spacing
    val colors = CardDefaults.cardColors(
        containerColor = MyProjectTheme.colors.surface,
        contentColor = MyProjectTheme.colors.onSurface
    )
    val shape = RoundedCornerShape(spacing.large)

    if (onClick != null) {
        Card(onClick = onClick, modifier = modifier.fillMaxWidth(), colors = colors, shape = shape) {
            Column(
                modifier = Modifier.padding(spacing.large),
                verticalArrangement = Arrangement.spacedBy(spacing.small),
                content = content
            )
        }
    } else {
        Card(modifier = modifier.fillMaxWidth(), colors = colors, shape = shape) {
            Column(
                modifier = Modifier.padding(spacing.large),
                verticalArrangement = Arrangement.spacedBy(spacing.small),
                content = content
            )
        }
    }
}
