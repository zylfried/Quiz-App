package fr.zylfried.quiz

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Composant pour une option de réponse
 * @param answer Texte de l'option de réponse
 * @param onClickAction Action à effectuer lorsque l'option est cliquée
 * @param modifier Modificateur pour la mise en forme
 */
@Composable
fun AnswerOption(
    answer: String,
    onClickAction: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Affichage de l'option de réponse
    Surface(
        modifier = modifier,
        color = Color(0xFFB1A8BD).copy(alpha = 0.1f),
        onClick = onClickAction
    ) {
        Text(
            text = answer,
            fontSize = 24.sp,
            modifier = Modifier.padding(vertical = 20.dp, horizontal = 30.dp),
            color = Color.White
        )
    }
}