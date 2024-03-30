package fr.zylfried.quiz

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Composant pour une question et ses options de réponse
 * @param modifier Modificateur pour la mise en forme
 * @param questionNAnswers Objet contenant la question et les réponses possibles
 * @param onValidAction Action à effectuer lorsque la réponse est valide
 * @param onWrongAction Action à effectuer lorsque la réponse est incorrecte
 */
@Composable
fun QuestionComponent(
    modifier: Modifier = Modifier,
    questionNAnswers: QuestionNAnswers,
    onValidAction: () -> Unit,
    onWrongAction: () -> Unit
) {
    // Affichage de la question
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = questionNAnswers.question,
            fontSize = 24.sp,
            fontWeight = FontWeight(500),
            textAlign = TextAlign.Justify,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(32.dp))

        // Affichage des options de réponse
        for (answerId in questionNAnswers.answersList.indices) {
            AnswerOption(
                answer = questionNAnswers.answersList[answerId],
                onClickAction = {
                    if (answerId == questionNAnswers.goodAnswerId) {
                        onValidAction()
                    } else {
                        onWrongAction()
                    }
                },
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .fillMaxWidth()
                    .border(
                        width = 2.dp,
                        color = Color(0xFFB1A8BD),
                        shape = RoundedCornerShape(20.dp)
                    )
            )
        }
    }
}
