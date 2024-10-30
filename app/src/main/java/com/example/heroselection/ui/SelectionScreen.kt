package com.example.heroselection.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.heroselection.R
import com.example.heroselection.data.HeroList
import com.example.heroselection.data.Heroes

@Composable
fun NavigationComponent() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "hero_list") {
        composable(route = "hero_list") {
            HeroSelectionScreen(navController)
        }
        composable(
            route = "hero_detail/{name}/{description}/{image}",
            arguments = listOf(
                navArgument("name") { type = NavType.StringType },
                navArgument("description") { type = NavType.StringType },
                navArgument("image") { type = NavType.IntType },
            )
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            val description = backStackEntry.arguments?.getString("description") ?: ""
            val image = backStackEntry.arguments!!.getInt("image")
            HeroScreen(
                name = name,
                description = description,
                image = image,
                navController = navController
            )
        }
    }
}

@Composable
fun HeroSelectionScreen(navController: NavHostController) {
    Column (modifier = Modifier.padding(25.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.marvel_studios_logo),
            contentDescription = "Marvel Logo",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 40.dp)
        )
        Text(
            text = "Choose your hero",
            textAlign = TextAlign.Center,
            fontSize = 40.sp,
            modifier = Modifier.width(600.dp).padding(15.dp),
            color = Color.White
        )
        HeroList(heroes = Heroes.heroes, navController = navController)
    }
}

@Composable
fun MainScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0d0d0d))
    ) {
        NavigationComponent()
    }
}