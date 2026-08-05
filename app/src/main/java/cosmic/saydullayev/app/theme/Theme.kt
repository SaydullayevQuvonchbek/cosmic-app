package cosmic.saydullayev.app.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = CosmicPrimary,
    secondary = CosmicSecondary,
    tertiary = CosmicPrimary,
    background = CosmicBackground,
    surface = CosmicBackground,
    onPrimary = CosmicText,
    onSecondary = CosmicText,
    onTertiary = CosmicText,
    onBackground = CosmicText,
    onSurface = CosmicText
)

// We only need a dark theme for Cosmic app
private val LightColorScheme = DarkColorScheme

@Composable
fun CosmicTheme(
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography,
        content = content
    )
}
