package com.example.heroselection.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun OutlinedText(
    text: String,
    style: TextStyle,
    modifier: Modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
    textColor: Color = Color.White,
    outlineColor: Color = Color.Black
) {
    Box(modifier = modifier) {
        Text(text = text, color = outlineColor, style = style, modifier = Modifier.offset(1.dp, 1.dp))
        Text(text = text, color = outlineColor, style = style, modifier = Modifier.offset(-1.dp, -1.dp))
        Text(text = text, color = outlineColor, style = style, modifier = Modifier.offset(1.dp, -1.dp))
        Text(text = text, color = outlineColor, style = style, modifier = Modifier.offset(-1.dp, 1.dp))

        Text(text = text, color = textColor, style = style)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroScreen(
    name: String,
    description: String,
    image: Int,
    navController: NavHostController
    ) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Column (
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {
            OutlinedText(text = name, style = TextStyle(fontSize = 50.sp))
            OutlinedText(text = description, style = TextStyle(fontSize = 30.sp))
        }
    }
    TopAppBar(
        title = { Text(
            text = name,
            color = Color.White
        ) },
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back Button",
                    tint = Color.White
                )
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Black)
    )
}