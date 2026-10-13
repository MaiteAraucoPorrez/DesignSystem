package edu.ucb.ds.components.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import edu.ucb.ds.components.cards.AppCard
import edu.ucb.ds.components.label.AppBody
import edu.ucb.ds.components.label.AppLabel
import edu.ucb.ds.theme.MyProjectTheme

/** Lista vertical con el espaciado del Design System. */
@Composable
fun <T> AppList(
    items: List<T>,
    modifier: Modifier = Modifier,
    key: ((T) -> Any)? = null,
    itemContent: @Composable (T) -> Unit
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(vertical = MyProjectTheme.spacing.medium),
        verticalArrangement = Arrangement.spacedBy(MyProjectTheme.spacing.medium)
    ) {
        items(items, key = key) { item -> itemContent(item) }
    }
}

/** Elemento de lista listo para usar: título, subtítulo opcional e ícono opcional. */
@Composable
fun AppListItem(
    title: String,
    modifier: Modifier = Modifier,
    subtitle: String? = null,
    leadingIcon: ImageVector? = null,
    onClick: (() -> Unit)? = null
) {
    AppCard(modifier = modifier, onClick = onClick) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(MyProjectTheme.spacing.large)
        ) {
            if (leadingIcon != null) {
                Icon(
                    imageVector = leadingIcon,
                    contentDescription = null,
                    tint = MyProjectTheme.colors.primary
                )
            }
            Column {
                AppBody(text = title, color = MyProjectTheme.colors.onSurface)
                if (subtitle != null) {
                    AppLabel(text = subtitle, color = MyProjectTheme.colors.onSurface)
                }
            }
        }
    }
}
