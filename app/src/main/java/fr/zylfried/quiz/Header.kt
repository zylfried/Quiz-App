package fr.zylfried.quiz

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Composant pour l'en-tête de l'application
 * @param title Titre de l'en-tête
 * @param onClickAction Action à effectuer lorsqu'on clique sur le bouton
 * @param iconId Identifiant de la ressource de l'icône du bouton
 * @param modifier Modificateur pour la mise en forme
 */
@Composable
fun Header(title: String, onClickAction: () -> Unit, iconId: Int, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        // Bouton
        Surface(
            modifier = Modifier
                .size(30.dp),
            color = Color.Transparent,
            onClick = onClickAction
        ) {
            Image(
                painter = painterResource(iconId),
                contentDescription = "Close Icon",
            )
        } // Fin du bouton

        // Texte pour afficher le titre
        Text(
            text = title,
            fontSize = 26.sp,
            fontWeight = FontWeight(500),
            color = Color.White
        )
        Spacer(modifier = Modifier.weight(1f))

        // Affichage du score
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(32.dp))
                .background(Color(0xFFB1A8BD).copy(alpha = 0.2f))
                .padding(
                    horizontal = 8.dp,
                    vertical = 4.dp
                ),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.points),
                contentDescription = "Points"
            )
            Text(
                text = "${ScoreCounter.score}",
                color = Color.White,
                fontSize = 24.sp
            )
        }
    }
}
