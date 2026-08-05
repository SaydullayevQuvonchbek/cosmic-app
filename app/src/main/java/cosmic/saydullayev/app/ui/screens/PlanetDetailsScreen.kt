package cosmic.saydullayev.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cosmic.saydullayev.app.theme.CosmicPrimary
import cosmic.saydullayev.app.theme.CosmicSecondary
import cosmic.saydullayev.app.theme.CosmicSurface
import cosmic.saydullayev.app.theme.CosmicTextSecondary

@Composable
fun PlanetDetailsScreen(planetName: String, onBack: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFF0D1B2A), Color(0xFF1B263B), Color(0xFF0F172A))
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(bottom = 32.dp)
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            
            // Top Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = onBack,
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(CosmicSurface)
                ) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
                }
                
                IconButton(
                    onClick = { },
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(CosmicSurface)
                ) {
                    Icon(Icons.Outlined.FavoriteBorder, contentDescription = "Favorite", tint = Color.White)
                }
            }
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // Planet Image Container
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(200.dp)
                        .background(Brush.radialGradient(listOf(Color.Cyan, Color.Blue, Color.Transparent)), CircleShape)
                )
            }
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // Details Card
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(32.dp))
                    .background(CosmicSurface)
                    .padding(32.dp)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(planetName, color = Color.White, fontSize = 36.sp, fontWeight = FontWeight.Bold)
                    
                    Spacer(modifier = Modifier.height(48.dp))
                    
                    // Stats Row 1
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        PlanetStat(iconRes = android.R.drawable.ic_menu_crop, title = "Mass", subtitle = "(10²⁴kg)", value = "5.97")
                        PlanetStat(iconRes = android.R.drawable.ic_menu_compass, title = "Gravity", subtitle = "(m/s²)", value = "9.8")
                        PlanetStat(iconRes = android.R.drawable.ic_menu_day, title = "Day", subtitle = "(hours)", value = "24")
                    }
                    
                    Spacer(modifier = Modifier.height(48.dp))
                    
                    // Stats Row 2
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        PlanetStat(iconRes = android.R.drawable.ic_media_play, title = "Esc. Velocity", subtitle = "(km/s)", value = "11.2")
                        PlanetStat(iconRes = android.R.drawable.ic_menu_info_details, title = "Mean Temp", subtitle = "(C)", value = "15")
                        PlanetStat(iconRes = android.R.drawable.ic_menu_send, title = "Distance", subtitle = "from Sun", value = "5.97")
                    }
                    
                    Spacer(modifier = Modifier.height(48.dp))
                    
                    // Visit Button
                    Button(
                        onClick = { },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .background(
                                brush = Brush.horizontalGradient(listOf(CosmicSecondary, CosmicPrimary)),
                                shape = RoundedCornerShape(28.dp)
                            ),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                        shape = RoundedCornerShape(28.dp)
                    ) {
                        Text("Visit", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
                    }
                }
            }
        }
    }
}

@Composable
fun PlanetStat(iconRes: Int, title: String, subtitle: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        // Mock icons using android resources
        Icon(
            painter = androidx.compose.ui.res.painterResource(id = iconRes),
            contentDescription = title,
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(title, color = CosmicTextSecondary, fontSize = 10.sp, textAlign = TextAlign.Center)
        Text(subtitle, color = CosmicTextSecondary, fontSize = 10.sp, textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(8.dp))
        Text(value, color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
    }
}
