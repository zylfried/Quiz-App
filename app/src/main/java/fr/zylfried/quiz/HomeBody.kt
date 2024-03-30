package fr.zylfried.quiz

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
 * Comosant qui affiche la liste des quiz disponibles.
 * @param modifier Modificateur pour la mise en forme.
 * @param quizList Liste des quiz disponibles.
 * @param nextAction Action à effectuer lorsqu'on clique sur un quiz.
 */
@Composable
fun HomeBody(
    modifier: Modifier = Modifier,
    quizList: List<QuestionsRepertory>,
    nextAction: (Int) -> Unit
) {
    Column(
        modifier = modifier.padding(
            horizontal = 16.dp,
            vertical = 40.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(modifier = Modifier.weight(0.5f))
        // Texte d'introduction.
        Text(
            text = "Choissisez votre quiz.",
            fontSize = 24.sp,
            fontWeight = FontWeight(500),
            textAlign = TextAlign.Justify,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(8.dp))
        // Affichage de la liste des quiz disponibles.
        for (quizId in quizList.indices) {
            AnswerOption(
                answer = quizList[quizId].category,
                onClickAction = { nextAction(quizId) },
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
        Spacer(modifier = Modifier.weight(3f))
    }

}