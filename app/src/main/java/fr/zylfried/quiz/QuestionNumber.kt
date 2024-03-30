package fr.zylfried.quiz

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

/**
 * Composant qui affiche le numéro de la question actuelle et le nombre total de questions.
 * @param questionId Identifiant de la question actuelle.
 * @param totalQuestion Nombre total de questions.
 */
@Composable
fun QuestionNumber(questionId: Int, totalQuestion: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.Bottom
    ) {
        // Texte pour afficher le numéro de la question actuelle
        Text(
            text = "Question ${questionId + 1}",
            fontSize = 24.sp,
            fontWeight = FontWeight(500),
            color = Color(0xFFB1A8BD)
        )
        // Texte pour afficher le nombre total de questions
        Text(
            text = "/${totalQuestion}",
            fontSize = 20.sp,
            color = Color(0xFFB1A8BD)
        )
    }
}