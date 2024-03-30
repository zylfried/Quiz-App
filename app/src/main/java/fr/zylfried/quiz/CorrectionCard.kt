package fr.zylfried.quiz

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Composant pour une carte de correction
 * @param text Texte à afficher sur la carte
 * @param imageId Identifiant de la ressource de l'image à afficher sur la carte
 */
@Composable
fun CorrectionCard(text: String, imageId: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(40.dp)
    ) {
        // Image représentant la correction
        Image(painter = painterResource(imageId), contentDescription = text)
        // Texte affichant la correction
        Text(
            text = text,
            fontSize = 24.sp,
            color = Color.White
        )
    }
}
