package com.example.interfaz_gp.ui.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.Black)
    ) {
        PreviewTopBarWithSubtitle()//para ti y patrocinado
        PreviewAppSuggestions()//3 sugerencias
        PreviewRecommendedAppsSection()//recomendados
        PreviewInterestsSection()//los intereses
        PreviewBottomNavigationBar()//sección inferior

        Text("PlayStore Screen")
    }
}
@Preview(showBackground = true)
@Composable
fun topbar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Color.Black)
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        //barra superior
        topbarItem("Para ti", isSelected = true)
        topbarItem("Listas de éxitos")
        topbarItem("Infantiles")
        topbarItem("Categorías")
    }
}//topbar

@Composable
fun topbarItem(text: String, isSelected: Boolean = false){
    Text(
        text = text,
        color = if (isSelected) Color.White else Color.Gray,//"para ti" blanco
        fontSize = 14.sp,
        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
        modifier = Modifier.padding(vertical = 10.dp)
    )
}
@Preview(showBackground = true)
@Composable
fun PreviewTopBar() {
    topbar()
}

@Composable
fun TopBarWithSubtitle() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
    ) {
        topbar()//topbar ya con pestañas
        Row(//texto de patrocinado y sugerencias
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween//distribuye los elementos a la orilla
        ) {
            Text(
                text = "Patrocinado • Sugerencias para ti",
                color = Color.Gray,
                fontSize = 12.sp
            )
            Text(
                text = "⋮",//tres puntitos
                color = Color.Gray,
                fontSize = 16.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTopBarWithSubtitle() {
    TopBarWithSubtitle()
}

@Composable
fun AppSuggestionItem() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        AppItem(
            imageRes = R.drawable.shein,
            name = "SHEIN - Compras en línea",
            category = "Compras • Minorista",
            rating = "4.3 ★",
            size = "29 MB"
        )
        AppItem(
            imageRes = R.drawable.temu,
            name = "Temu: compra como millonario",
            category = "Compras • Mercado en línea",
            rating = "4.6 ★",
            size = "13 MB"
        )
        AppItem(
            imageRes = R.drawable.warobots,
            name = "War Robots - PvP Multijugador",
            category = "Entretenimiento • Acción",
            rating = "4.9 ★",
            size = "3 GB"
        )
    }
}
@Composable
fun AppItem(imageRes: Int, name: String, category: String, rating: String, size: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        //imagen app
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = name,
            modifier = Modifier
                .size(50.dp)
                .clip(RoundedCornerShape(8.dp))
        )
        Spacer(modifier = Modifier.width(16.dp))//espacio entre imagen y texto

        Column {
            Text(text = name, color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Text(text = category, color = Color.Gray, fontSize = 14.sp)
            Text(text = "$rating  •  $size", color = Color.Gray, fontSize = 14.sp)
        }
    }
}
@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun PreviewAppSuggestions() {
    AppSuggestionItem()
}
@Composable
fun RecommendedAppsSection(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(//titulo de la sección
            text = "Recomendados para ti",
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
        LazyRow(//lazyRow EXTRA, para el desplazamiento de apps
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(recommendedApps) { app ->
                RecommendedAppItem(app)
            }
        }
    }
}
//agrupa info de cada app en una lista dinámica
data class RecommendedApp(val imageRes: Int, val name: String, val rating: String)

//lista de apps recomendadas
val recommendedApps = listOf(
    RecommendedApp(R.drawable.wallet, "Wallet: Finanzas Personales", "4.8 ★"),
    RecommendedApp(R.drawable.elsa, "ELSA Speak - Aprende inglés", "4.7 ★"),
    RecommendedApp(R.drawable.crunchy, "Crunchyroll Series", "4.8 ★")
)
//componente de cada tarjeta de aplicación recomendada
@Composable
fun RecommendedAppItem(app: RecommendedApp) {
    Column(
        modifier = Modifier
            .width(100.dp)
            .padding(end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = app.imageRes),
            contentDescription = app.name,
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(16.dp))
        )
        Text(
            text = app.name,
            color = Color.White,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 4.dp)
        )
        Text(
            text = app.rating,
            color = Color.Gray,
            fontSize = 12.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun PreviewRecommendedAppsSection() {
    RecommendedAppsSection()
}

@Composable
fun InterestsSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(//pregunta de la sección
            text = "¿Cuáles son sus intereses?",
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Text(//descripcion de intereses
            text = "Selecciona algunos elementos para mejorar tus recomendaciones en Play",
            color = Color.Gray,//gris de la desc
            fontSize = 12.sp,
            modifier = Modifier.padding(top = 4.dp)
        )
        Row(//fila con los button de intereses
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 6.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            InterestButton("Sociales")
            InterestButton("Comunicación")
        }
        Row(//botón de reproductores
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 6.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            InterestButton("Reproductores y editores de video", expanded = true)
        }
    }
}
@Composable
fun InterestButton(text: String, expanded: Boolean = false) {
    Button(
        onClick = { /* acción al hacer clic */ },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.DarkGray,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .padding(vertical = 4.dp)
            .then(
                if (expanded) Modifier.fillMaxWidth()
                else Modifier.wrapContentWidth()
            )
    ) {
        Text(text = "+ $text", fontSize = 14.sp)
    }
}
@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun PreviewInterestsSection() {
    InterestsSection()
}

@Composable
fun BottomNavigationBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Color.Black)
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {//iconos chiquitos de bottomBar
        BottomNavItem(R.drawable.mando, "Juegos")
        BottomNavItem(R.drawable.apps, "Apps")
        BottomNavItem(R.drawable.lupa, "Buscar")
        BottomNavItem(R.drawable.libro, "Libros")
    }
}
@Composable//componente para cada icono
fun BottomNavItem(iconRes: Int, label: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = label,
            modifier = Modifier.size(24.dp)//tamaño del icono
        )
        Text(
            text = label,
            color = Color.White,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}
@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun PreviewBottomNavigationBar() {
    BottomNavigationBar()
}