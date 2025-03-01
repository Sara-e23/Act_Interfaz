package com.example.interfaz_gp.ui.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.interfaz_gp.R

@Composable
fun PlayStoreScreen(navController: NavHostController) {
    topbar()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        AppSuggestionItem()
        AppRecommendationItem()
        Text(
            text = "Sugerencias para ti",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        LazyColumn {
            items(3) {
                AppSuggestionItem()
            }
        }

        Text(
            text = "Recomendados para ti",
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
        )

        LazyRow {
            items(5) {
                AppRecommendationItem()
            }
        }

        Text(
            text = "¿Cuáles son sus intereses?",
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 16.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            InterestButton("+ Sociales")
            InterestButton("+ Comunicación")
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            InterestButton("+ Reproductores y editores de video")
        }

        Button(
            onClick = { navController.navigate("Main_Menu") }
        ) {
            Text("Return to Main Menu")
        }

    }
}

@Composable
fun AppSuggestionItem() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = android.R.drawable.sym_def_app_icon),
            contentDescription = "App Icon",
            modifier = Modifier.size(50.dp)
        )
        Column(modifier = Modifier.padding(start = 8.dp)) {
            Text(text = "Nombre de la App", color = Color.White, fontWeight = FontWeight.Bold)
            Text(text = "Categoría • Tamaño", color = Color.Gray, fontSize = 12.sp)
            Text(text = "★ 4.5", color = Color.White, fontSize = 12.sp)
        }
    }
}

@Composable
fun AppRecommendationItem() {
    Column(modifier = Modifier.padding(8.dp)) {
        Image(
            painter = painterResource(id = android.R.drawable.sym_def_app_icon),
            contentDescription = "App Icon",
            modifier = Modifier.size(70.dp)
        )
        Text(text = "App", color = Color.White, fontSize = 12.sp)
    }
}

@Composable
fun InterestButton(text: String) {
    Button(
        onClick = {},
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.padding(4.dp)
    ) {
        Text(text = text)
    }
}

@Preview
@Composable
fun topbar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Color.Black)
            .padding(10.dp)
    ) {
        Icon(
            Icons.Filled.Menu,
            contentDescription = "Menu Icon",
            tint = Color.Green,
            modifier = Modifier
                .size(50.dp)
        )

        //barra superior
        Text(
            stringResource(R.string.app_name),
            color = Color.White,
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
    }
}