package cosmic.saydullayev.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavKey
import cosmic.saydullayev.app.Favourites
import cosmic.saydullayev.app.PlanetDetails
import cosmic.saydullayev.app.theme.CosmicPrimary
import cosmic.saydullayev.app.theme.CosmicSurface
import cosmic.saydullayev.app.theme.CosmicTextSecondary

@Composable
fun FavouritesScreen(onNavigate: (NavKey) -> Unit) {
    Scaffold(
        bottomBar = { CosmicBottomBar(currentScreen = Favourites, onNavigate = onNavigate) },
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            
            // Top Bar
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { },
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(CosmicSurface)
                ) {
                    Icon(Icons.Default.Menu, contentDescription = "Menu", tint = Color.White)
                }
                
                Text("Favourites", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                
                IconButton(
                    onClick = { },
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(CosmicSurface)
                ) {
                    Icon(Icons.Default.Person, contentDescription = "Profile", tint = Color.White)
                }
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                val favouritePlanets = listOf(
                    Triple("Mercury", "Mercury is the smallest planet in the Solar System and the closest to the Sun.", listOf(Color.Magenta, Color.Blue)),
                    Triple("Venus", "Venus is the second planet from the Sun and is Earth's closest planetary neighbor.", listOf(Color.Cyan, Color.Magenta)),
                    Triple("Earth", "Earth is an ellipsoid with a circumference of about 40,000 km. It is the densest planet in the Solar System.", listOf(Color.Blue, Color.Cyan)),
                    Triple("Mars", "Mars is the fourth planet from the Sun and the second-smallest planet in the Solar System.", listOf(Color.Cyan, Color.Blue))
                )
                
                items(favouritePlanets.size) { index ->
                    val planet = favouritePlanets[index]
                    FavouritePlanetCard(
                        name = planet.first,
                        description = planet.second,
                        colors = planet.third,
                        onClick = { onNavigate(PlanetDetails(planet.first)) }
                    )
                }
                
                item { Spacer(modifier = Modifier.height(16.dp)) }
            }
        }
    }
}

@Composable
fun FavouritePlanetCard(name: String, description: String, colors: List<Color>, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(CosmicSurface, RoundedCornerShape(24.dp))
            .padding(24.dp)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Row(modifier = Modifier.weight(1f)) {
                    Box(
                        modifier = Modifier
                            .size(64.dp)
                            .background(Brush.radialGradient(colors), CircleShape)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(name, color = CosmicPrimary, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            description,
                            color = CosmicTextSecondary,
                            fontSize = 12.sp,
                            lineHeight = 18.sp
                        )
                    }
                }
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    imageVector = Icons.Outlined.FavoriteBorder,
                    contentDescription = "Favorite",
                    tint = Color.White
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .align(Alignment.End)
                    .clickable { onClick() },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Details", color = Color.White, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.width(8.dp))
                Text("→", color = CosmicPrimary, fontWeight = FontWeight.Bold)
            }
        }
    }
}
