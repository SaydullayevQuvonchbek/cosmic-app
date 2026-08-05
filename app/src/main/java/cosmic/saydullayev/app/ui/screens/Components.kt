package cosmic.saydullayev.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cosmic.saydullayev.app.Home
import cosmic.saydullayev.app.Favourites
import cosmic.saydullayev.app.Profile
import cosmic.saydullayev.app.theme.CosmicPrimary
import cosmic.saydullayev.app.theme.CosmicTextSecondary
import androidx.navigation3.runtime.NavKey

@Composable
fun CosmicBottomBar(
    currentScreen: NavKey,
    onNavigate: (NavKey) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
            .background(Color(0xFF141A28)),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BottomBarItem(
            title = "Home",
            iconRes = android.R.drawable.ic_menu_gallery, // placeholder
            isSelected = currentScreen == Home,
            onClick = { if (currentScreen != Home) onNavigate(Home) }
        )
        BottomBarItem(
            title = "Favourites",
            iconRes = android.R.drawable.star_off, // placeholder
            isSelected = currentScreen == Favourites,
            onClick = { if (currentScreen != Favourites) onNavigate(Favourites) }
        )
        BottomBarItem(
            title = "More",
            iconRes = android.R.drawable.ic_menu_more, // placeholder
            isSelected = currentScreen == Profile,
            onClick = { if (currentScreen != Profile) onNavigate(Profile) }
        )
    }
}

@Composable
fun BottomBarItem(
    title: String,
    iconRes: Int,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val color = if (isSelected) CosmicPrimary else CosmicTextSecondary
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable { onClick() }
            .padding(8.dp)
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = title,
            tint = color,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = title,
            color = color,
            fontSize = 12.sp,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}
