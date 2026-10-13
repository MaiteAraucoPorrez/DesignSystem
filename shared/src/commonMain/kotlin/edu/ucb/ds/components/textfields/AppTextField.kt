package edu.ucb.ds.components.textfields

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import edu.ucb.ds.theme.MyProjectTheme

@Composable
fun AppTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    singleLine: Boolean = true,
    errorMessage: String? = null
) {
    val colors = MyProjectTheme.colors
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.fillMaxWidth(),
        enabled = enabled,
        singleLine = singleLine,
        textStyle = MyProjectTheme.typography.body,
        label = { Text(text = label, style = MyProjectTheme.typography.label) },
        isError = errorMessage != null,
        supportingText = if (errorMessage != null) {
            { Text(text = errorMessage, style = MyProjectTheme.typography.label) }
        } else {
            null
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colors.primary,
            focusedLabelColor = colors.primary,
            cursorColor = colors.primary,
            errorBorderColor = colors.error,
            errorLabelColor = colors.error,
            errorCursorColor = colors.error,
            errorSupportingTextColor = colors.error
        )
    )
}
