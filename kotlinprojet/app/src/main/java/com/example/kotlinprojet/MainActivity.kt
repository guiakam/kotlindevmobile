package com.example.kotlinprojet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlinprojet.ui.theme.KotlinprojetTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                           
            KotlinprojetTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Lance la galerie d'art
                    ArtGalleryApp()
                }
            }
        }
    }
}

// Classe pour stocker les informations sur chaque œuvre d'art
data class ArtWork(
    val title: String,         // Titre de l'œuvre
    val artist: String,        // Artiste de l'œuvre
    val year: Int,             // Année de création
    val imageResId: Int        // Identifiant de l'image ressource
)

// Liste d'œuvres d'art
val artworks = listOf(
    ArtWork("Mona Lisa", "Audrey du bois", 1503, R.drawable.peter_thomas_8ov11gxritm_unsplash),
    ArtWork("Starry Night", "Felicite du morceau", 1889, R.drawable.troy_olson_b17y2o1p3_e_unsplash),
    ArtWork("The Scream", "Edvard de riviere", 1893, R.drawable.barcs_tamas_bs3q_qapyq0_unsplash),
    ArtWork("Girl with a Pearl Earring", "Jonhathen du parket", 1665, R.drawable.zhen_yao_w_owctylghm_unsplash)
)

@Composable
fun ArtGalleryApp() {
    // Variable pour suivre l'index de l'œuvre d'art actuellement affichée
    var indexOeuvreActuelle by remember { mutableStateOf(0) }

    // Fonction pour afficher l'œuvre précédente
    fun afficherOeuvrePrecedente() {
        if (indexOeuvreActuelle > 0) {
            indexOeuvreActuelle = indexOeuvreActuelle - 1
        } else {
            indexOeuvreActuelle = artworks.size - 1
        }
    }

    // Fonction pour afficher l'œuvre suivante
    fun afficherOeuvreSuivante() {
        if (indexOeuvreActuelle < artworks.size - 1) {
            indexOeuvreActuelle = indexOeuvreActuelle + 1
        } else {
            indexOeuvreActuelle = 0
        }
    }

    // Affiche l'écran principal de la galerie
    EcranGalerieArt(
        oeuvreActuelle = artworks[indexOeuvreActuelle],
        surPrecedent = { afficherOeuvrePrecedente() },
        surSuivant = { afficherOeuvreSuivante() }
    )
}

// Fonction qui affiche les détails de l'œuvre d'art actuelle
@Composable
fun EcranGalerieArt(oeuvreActuelle: ArtWork, surPrecedent: () -> Unit, surSuivant: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Affiche l'image de l'œuvre d'art
        Image(
            painter = painterResource(id = oeuvreActuelle.imageResId),
            contentDescription = oeuvreActuelle.title,
            modifier = Modifier.size(300.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Affiche le titre, l'artiste et l'année de l'œuvre d'art
        Text(
            text = oeuvreActuelle.title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "${oeuvreActuelle.artist}, ${oeuvreActuelle.year}",
            fontSize = 16.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Affiche les boutons de navigation pour "Précédent" et "Suivant"
        Row {
            Button(onClick = surPrecedent, modifier = Modifier.padding(8.dp)) {
                Text("Précédent")
            }
            Button(onClick = surSuivant, modifier = Modifier.padding(8.dp)) {
                Text("Suivant")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ApercuGalerieArt() {
    KotlinprojetTheme {
        ArtGalleryApp()
    }
}
