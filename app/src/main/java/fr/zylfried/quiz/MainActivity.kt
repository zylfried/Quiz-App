package fr.zylfried.quiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.zylfried.quiz.ui.theme.QuizTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuizTheme {
                QuizApp()
            }
        }
    }
}

/**
 * Composant principal de l'application
 * @param modifier Modificateur de la disposition
 */
@Composable
fun QuizApp(modifier: Modifier = Modifier) {
    // Liste des quiz disponibles
    val quizList = listOf(
        // Quiz sur le CV de Zephirin Faure
        QuestionsRepertory(
            category = "CV de Zephirin Faure",
            questionsList = listOf(
                QuestionNAnswers("Avez-vous lu mon CV et êtes vous prêt à répondre aux questions qui vont suivre ?", listOf("Oui"), 0),
                QuestionNAnswers("Quel est mon passe-temps préféré parmi ceux-ci ?", listOf("Jardinage", "Jeux vidéo", "Voyage", "Couture"), 2),
                QuestionNAnswers("Quelle est mon expérience professionnelle la plus récente ?", listOf("Professeur de mathématiques", "Stagiaire dans une brasserie", "Freelancer en Figma et PowerPoint"), 2),
                QuestionNAnswers("Dans quelle discipline suis-je actuellement étudiant ?", listOf("Médecine", "Informatique", "Droit", "Génie Civil"), 1),
                QuestionNAnswers("Quelle est la ville où se trouve mon établissement d'études actuel ?", listOf("Paris", "Lyon", "Grenoble", "Marseille"), 2),
                QuestionNAnswers("Quelle est ma principale compétence en matière de conception ?", listOf("Figma", "Photoshop", "Illustrator", "InDesign"), 0),
                QuestionNAnswers("Quelle est mon niveau en anglais selon le CECRL ?", listOf("A1", "B1", "C1", "C2"), 2),
                QuestionNAnswers("Quel langage de programmation est-ce que je ne maitrise pas encore ?", listOf("Java", "C", "Kotlin", "JavaScript", "SQL"), 4),
                QuestionNAnswers("Dans quel domaine ai-je effectué un stage en 2022 ?", listOf("Enseignement", "Brasserie", "Technologie", "Finance"), 1),
                QuestionNAnswers("Quelle est mon expérience en tant que membre de la Junior-Entreprise ?", listOf("Responsable de la communication", "Responsable des clients et des développeurs", "Développeur informatique"), 1)
            )
        ), // fin du CV de Zephirin Faure

        // Quiz sur la géographie
        QuestionsRepertory(
            category = "Géographie",
            questionsList = listOf(
                QuestionNAnswers("Quelle est la capitale de l'Espagne ?", listOf("Barcelone", "Valence", "Madrid", "Séville"), 2),
                QuestionNAnswers("Quelle est la plus grande île d'Asie ?", listOf("Sumatra", "Bornéo", "Honshu", "Java"), 1),
                QuestionNAnswers("Dans quel pays trouve-t-on la ville de Marrakech ?", listOf("Algérie", "Tunisie", "Égypte", "Maroc"), 3),
                QuestionNAnswers("Quelle est la langue officielle du Brésil ?", listOf("Portugais", "Espagnol", "Anglais", "Français"), 0),
                QuestionNAnswers("Quel est le plus grand lac d'Afrique ?", listOf("Lac Tanganyika", "Lac Malawi", "Lac Victoria", "Lac Turkana"), 2),
                QuestionNAnswers("Quelle est la plus grande ville du Canada ?", listOf("Montréal", "Toronto", "Vancouver", "Ottawa"), 1),
                QuestionNAnswers("Quelle est la monnaie officielle du Japon ?", listOf("Yen", "Dollar", "Euro", "Franc"), 0),
                QuestionNAnswers("Dans quel pays se trouve la ville de Prague ?", listOf("Hongrie", "Pologne", "Slovaquie", "République Tchèque"), 3),
                QuestionNAnswers("Quelle est la plus haute montagne d'Afrique ?", listOf("Mont Kenya", "Mont Kilimandjaro", "Mont Ruwenzori", "Mont Elgon"), 1),
                QuestionNAnswers("Quel est le plus grand désert de sable du monde ?", listOf("Désert du Sahara", "Désert de Gobi", "Désert du Kalahari", "Désert d'Atacama"), 0)
            )
        ), // fin de la géographie

        // Quiz sur l'histoire
        QuestionsRepertory(
            category = "Ecologie",
            questionsList = listOf(
                QuestionNAnswers("Le principal gaz à effet de serre contribuant au réchauffement climatique est-il le dioxyde de carbone (CO2) ?", listOf("Oui", "Non"), 0),
                QuestionNAnswers("Quel est le principal polluant responsable de la pollution de l'air dans les grandes villes ?", listOf("Dioxyde d'azote (NO2)", "Monoxyde de carbone (CO)", "Particules fines", "Ozone (O3)"), 2),
                QuestionNAnswers("Quelle est la principale source d'énergie renouvelable utilisée pour la production d'électricité dans le monde ?", listOf("Énergie solaire", "Énergie éolienne", "Énergie hydraulique", "Énergie géothermique"), 0),
                QuestionNAnswers("Quel phénomène naturel favorisé par l'activité humaine menace la biodiversité des récifs coralliens ?", listOf("Bleuissement", "Érosion", "Sédimentation", "Acidification"), 3),
                QuestionNAnswers("La gestion durable des forêts vise-t-elle uniquement à préserver la biodiversité ?", listOf("Oui", "Non"), 1),
                QuestionNAnswers("Le commerce mondial est-il le principal vecteur de propagation des espèces invasives dans de nouveaux environnements ?", listOf("Oui", "Non"), 0),
                QuestionNAnswers("Quel est le processus par lequel les océans absorbent une partie du dioxyde de carbone atmosphérique ?", listOf("Acidification", "Désalinisation", "Eutrophisation", "Séquestration"), 3),
                QuestionNAnswers("Les déchets en plastique à usage unique sont-ils la principale cause de la pollution plastique des océans ?", listOf("Oui", "Non"), 0),
                QuestionNAnswers("La rotation des cultures est-elle une pratique agricole contribuant à la dégradation des sols et à la perte de biodiversité ?", listOf("Oui", "Non"), 1),
                QuestionNAnswers("La fonte accélérée des calottes glaciaires polaires est-elle un effet préoccupant du réchauffement climatique ?", listOf("Oui", "Non"), 0)
            )
        ) // fin de l'écologie
    )

    // État de la page actuellement affichée (0: Accueil, 1: Quiz)
    var page by remember { mutableStateOf(0) }
    // Index du quiz actuellement sélectionné
    var currentQuiz by remember { mutableStateOf(0) }

    Surface {
        // Fond dégradé
        Image(
            painter = painterResource(id = R.drawable.gradient_bg_dark),
            contentDescription = "Gradient Background",
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = modifier.fillMaxSize()
        ) {
            // Affichage de la page en fonction de l'état de la variable page
            when (page) {
                // Page d'accueil
                0 -> {
                    // En-tête de la page d'accueil
                    Header(
                        title = "Accueil",
                        onClickAction = {},
                        iconId = R.drawable.icon,
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                    )
                    // Contenu de la page d'accueil
                    HomeBody(
                        modifier = Modifier
                            .fillMaxSize(),
                        quizList = quizList,
                        nextAction = {
                            currentQuiz = it
                            page = 1
                        }
                    )
                } // fin de la page d'accueil

                // Page du quiz
                1 -> {
                    // En-tête de la page du quiz
                    Header(
                        title = quizList[currentQuiz].category,
                        onClickAction = { page = 0 },
                        iconId = R.drawable.back,
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                    )
                    // Contenu de la page du quiz
                    QuizBody(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        questionsList = quizList[currentQuiz].questionsList,
                        exitAction = { page = 0 },
                        questionTime = 10000
                    )
                } // fin de la page du quiz
            } // fin du when
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun QuizzResumePreview() {
    QuizTheme {
        QuizApp()
    }
}