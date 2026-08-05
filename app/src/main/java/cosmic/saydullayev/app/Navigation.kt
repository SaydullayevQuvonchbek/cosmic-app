package cosmic.saydullayev.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import cosmic.saydullayev.app.ui.screens.SignInScreen
import cosmic.saydullayev.app.ui.screens.SplashScreen
import cosmic.saydullayev.app.ui.screens.HomeScreen
import cosmic.saydullayev.app.ui.screens.FavouritesScreen
import cosmic.saydullayev.app.ui.screens.ProfileScreen
import cosmic.saydullayev.app.ui.screens.PlanetDetailsScreen

@Composable
fun MainNavigation() {
  val backStack = rememberNavBackStack(Splash)

  NavDisplay(
    backStack = backStack,
    onBack = { backStack.removeLastOrNull() },
    entryProvider =
      entryProvider {
        entry<Splash> {
          SplashScreen(onTimeout = { 
            backStack.removeLast()
            backStack.add(SignIn) 
          })
        }
        entry<SignIn> {
          SignInScreen(onSignInClick = {
            backStack.removeLast()
            backStack.add(Home)
          })
        }
        entry<Home> {
          HomeScreen(onNavigate = { backStack.add(it) })
        }
        entry<Favourites> {
          FavouritesScreen(onNavigate = { backStack.add(it) })
        }
        entry<Profile> {
          ProfileScreen(
            onNavigate = { backStack.add(it) },
            onBack = { backStack.removeLast() }
          )
        }
        entry<PlanetDetails> { navKey ->
          PlanetDetailsScreen(
            planetName = navKey.planetName,
            onBack = { backStack.removeLast() }
          )
        }
      },
  )
}
