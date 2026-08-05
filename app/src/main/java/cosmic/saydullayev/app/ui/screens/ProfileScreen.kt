package cosmic.saydullayev.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavKey
import cosmic.saydullayev.app.Profile
import cosmic.saydullayev.app.theme.CosmicPrimary
import cosmic.saydullayev.app.theme.CosmicSecondary
import cosmic.saydullayev.app.theme.CosmicSurface
import cosmic.saydullayev.app.theme.CosmicTextSecondary

@Composable
fun ProfileScreen(onNavigate: (NavKey) -> Unit, onBack: () -> Unit) {
    Scaffold(
        bottomBar = { CosmicBottomBar(currentScreen = Profile, onNavigate = onNavigate) },
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
                    onClick = onBack,
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(CosmicSurface)
                ) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
                }
                
                Text("My Profile", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                
                Spacer(modifier = Modifier.size(48.dp)) // Placeholder for symmetry
            }
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // Profile Card
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(CosmicSurface, RoundedCornerShape(24.dp))
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(64.dp)
                                .border(2.dp, CosmicPrimary, CircleShape)
                                .padding(4.dp)
                                .background(Color.Gray, CircleShape) // Placeholder for image
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Column {
                            Text("Arthur Dent", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                            Text("Space adventurer", color = CosmicTextSecondary, fontSize = 14.sp)
                        }
                    }
                    Icon(Icons.Default.Edit, contentDescription = "Edit", tint = Color.White)
                }
            }
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // Show planetary progress switch
            var showProgress by remember { mutableStateOf(true) }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Switch(
                    checked = showProgress,
                    onCheckedChange = { showProgress = it },
                    colors = SwitchDefaults.colors(checkedTrackColor = CosmicPrimary)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text("Show planetary progress", color = Color.White, modifier = Modifier.weight(1f))
            }
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // Progress Indicator
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(200.dp)
                        .border(
                            width = 12.dp,
                            brush = Brush.sweepGradient(listOf(CosmicSecondary, CosmicPrimary, CosmicSecondary)),
                            shape = CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Personal", color = Color.White, fontSize = 16.sp)
                        Text("progress", color = Color.White, fontSize = 16.sp)
                        Text("87.1%", color = CosmicSecondary, fontSize = 36.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // Checkboxes
            var showInRating by remember { mutableStateOf(true) }
            var notifications by remember { mutableStateOf(true) }
            
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = showInRating,
                    onCheckedChange = { showInRating = it },
                    colors = CheckboxDefaults.colors(checkedColor = CosmicPrimary)
                )
                Text("Show me in Planet Rating", color = Color.White)
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = notifications,
                    onCheckedChange = { notifications = it },
                    colors = CheckboxDefaults.colors(checkedColor = CosmicPrimary)
                )
                Text("Notifications", color = Color.White)
            }
        }
    }
}
