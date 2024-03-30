package fr.zylfried.quiz

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

/**
 * Composant pour un indicateur de compte à rebours
 * @param progress Progrès de la barre de progression
 * @param modifier Modificateur pour la mise en forme
 */
@Composable
fun CountDown(progress: Float, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
    ) {
        // Affichage de la progression du compte à rebours
        LinearProgressIndicator(
            progress = progress,
            modifier = Modifier
                .weight(1f)
                .height(24.dp)
                .clip(RoundedCornerShape(12.dp))
                .border(
                    width = 2.dp,
                    color = Color(0xFFB1A8BD),
                    shape = RoundedCornerShape(12.dp)
                ),
            color = Color(0xFFB1A8BD),
            trackColor = Color.Transparent,
            strokeCap = StrokeCap.Round
        )
        Spacer(modifier = Modifier.width(8.dp))
        // Affichage de l'icône de l'horloge
        Image(
            painter = painterResource(R.drawable.clock),
            contentDescription = "Clock"
        )
    }
}
