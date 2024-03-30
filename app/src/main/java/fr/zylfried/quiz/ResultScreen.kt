package fr.zylfried.quiz

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Composant de l'écran de résultat
 * @param modifier Modificateur de l'écran.
 * @param currentScore Score actuel du joueur.
 * @param exitAction Action à effectuer pour quitter l'écran.
 */
@Composable
fun ResultScreen(
    modifier: Modifier = Modifier,
    currentScore: Int,
    exitAction: () -> Unit
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Spacer(modifier = Modifier.weight(1f))
        // Ligne d'affichage du score
        Row(
            modifier = Modifier
                .size(200.dp)
                .border(
                    width = 5.dp,
                    color = Color.White,
                    shape = RoundedCornerShape(200.dp)
                ),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Texte affichant le score du joueur, multiplié par 6 pour afficher les points
            Text(
                text = "${currentScore * 6}",
                fontSize = 80.sp,
                fontWeight = FontWeight(500),
                color = Color.White
            )
            Spacer(modifier = Modifier.width(16.dp))
            // Image représentant les points
            Image(
                painter = painterResource(R.drawable.points),
                contentDescription = "Points",
                modifier = Modifier.size(45.dp)
            )
        } // fin de la ligne d'affichage du score

        // Texte affichant le nombre de questions correctement répondues par le joueur
        Text(
            text = "Vous avez répondu juste à\n$currentScore question(s).",
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            color = Color.White
        )
        Spacer(modifier = Modifier.weight(1f))
        // Bouton pour retourner à l'écran d'accueil
        Surface(
            modifier = Modifier
                .border(
                    width = 2.dp,
                    color = Color(0xFFB1A8BD),
                    shape = RoundedCornerShape(100.dp)
                ),
            color = Color(0xFFB1A8BD).copy(alpha = 0.1f),
            shape = RoundedCornerShape(100.dp),
            onClick = {
                // Incrémente le score total en ajoutant le score actuel multiplié par 6 (pour obtenir les points)
                ScoreCounter.incrementScore(currentScore*6)
                exitAction()
            }
        ) {
            // Texte affichant "Retour à l'Accueil" sur le bouton
            Text(
                text = "Retour à l'Accueil",
                fontSize = 20.sp,
                color = Color(0xFFB1A8BD),
                modifier = Modifier.padding(
                    horizontal = 24.dp,
                    vertical = 18.dp
                )
            )
        } // fin du bouton de retour à l'accueil
        Spacer(modifier = Modifier.weight(1f))
    }
}