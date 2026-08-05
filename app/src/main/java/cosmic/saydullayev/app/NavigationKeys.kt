package cosmic.saydullayev.app

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable data object Splash : NavKey
@Serializable data object SignIn : NavKey
@Serializable data object Home : NavKey
@Serializable data object Favourites : NavKey
@Serializable data object Profile : NavKey
@Serializable data class PlanetDetails(val planetName: String) : NavKey
