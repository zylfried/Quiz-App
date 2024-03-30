package fr.zylfried.quiz

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlin.time.DurationUnit
import kotlin.time.toDuration

/**
 * Composant principal du quiz qui gère l'affichage des questions, des réponses et des corrections.
 * @param modifier Modificateur de l'élément.
 * @param questionsList Liste des questions et réponses.
 * @param exitAction Action à effectuer pour quitter le quiz.
 * @param score Score actuel du joueur.
 * @param questionTime Temps en millisecondes pour répondre à une question.
 */
@Composable
fun QuizBody(
    modifier: Modifier = Modifier,
    questionsList: List<QuestionNAnswers>,
    exitAction: () -> Unit,
    score: Int = 0,
    questionTime: Int
) {
    // État de la question actuelle
    var state by remember { mutableIntStateOf(1) }
    // Identifiant de la question actuelle
    var questionId by remember { mutableIntStateOf(0) }
    // Score actuel
    var currentScore by remember { mutableIntStateOf(score) }
    // Progression du compte à rebours
    var countDownProgress by remember { mutableFloatStateOf(1f) }

    // Vérifie si la question actuelle est inférieure au nombre total de questions
    if (questionId < questionsList.size) {
        val currentQuestion = questionsList[questionId]
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Composant pour le compte à rebours
            CountDown(progress = countDownProgress, modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(8.dp))
            // Affichage du numéro de la question actuelle
            QuestionNumber(questionId = questionId, totalQuestion = questionsList.size)
            Divider(
                color = Color(0xFFB1A8BD),
                thickness = 1.dp
            )

            // Gestion des différents états de la question
            when (state) {
                // État initial, lorsque la question est affichée
                1 -> {
                    // Lance un effet coroutine pour le compte à rebours
                    LaunchedEffect(Unit) {
                        var currentTime = questionTime
                        while (currentTime > 0 && state == 1) {
                            delay(questionTime.toDuration(DurationUnit.MILLISECONDS)/100)
                            currentTime -= questionTime/100
                            countDownProgress = (currentTime.toFloat() / questionTime.toFloat()).coerceIn(0f, 1f)
                        }
                        if (currentTime <= 0 && state == 1) {
                            state = 4
                        }
                    }
                    // Affichage de la question et des options de réponse
                    QuestionComponent(
                        questionNAnswers = currentQuestion,
                        onValidAction = {
                            currentScore++
                            state = 2
                        },
                        onWrongAction = { state = 3 },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                // État lorsque la réponse est correcte
                2 -> {
                    Spacer(modifier = Modifier.weight(1f))
                    // Affichage de la carte de correction pour la réponse correcte
                    CorrectionCard(
                        text = "Bonne Réponse !",
                        imageId = R.drawable.true_answer
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    // Lance une coroutine pour passer à la question suivante après un délai
                    LaunchedEffect(Unit) {
                        delay(1000)
                        questionId++
                        state = 1
                    }
                }
                // État lorsque la réponse est incorrecte
                3 -> {
                    Spacer(modifier = Modifier.weight(1f))
                    // Affichage de la carte de correction pour la réponse incorrecte
                    CorrectionCard(
                        text = "Mauvaise Réponse...",
                        imageId = R.drawable.false_answer
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    // Lance une coroutine pour passer à la question suivante après un délai
                    LaunchedEffect(Unit) {
                        delay(1000)
                        questionId++
                        state = 1
                    }
                }
                // État lorsque le temps est écoulé
                4 -> {
                    Spacer(modifier = Modifier.weight(1f))
                    // Affichage de la carte de correction pour le temps écoulé
                    CorrectionCard(
                        text = "Temps Ecoulé...",
                        imageId = R.drawable.times_out
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    // Lance une coroutine pour passer à la question suivante après un délai
                    LaunchedEffect(Unit) {
                        delay(1000)
                        questionId++
                        state = 1
                    }
                }
            } // fin du when
        }

    // Si toutes les questions ont été répondues, afficher l'écran des résultats
    } else {
        ResultScreen(
            modifier = modifier,
            currentScore = currentScore,
            exitAction = exitAction
        )
    } // end of else
}
