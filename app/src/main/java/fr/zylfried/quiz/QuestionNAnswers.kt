package fr.zylfried.quiz

/**
 * Classe représentant une question et ses réponses possibles.
 * @param question La question
 * @param answersList Liste des réponses possibles
 * @param goodAnswerId Index de la bonne réponse dans la liste des réponses
 */
class QuestionNAnswers(
    val question: String,
    val answersList: List<String>,
    val goodAnswerId: Int
)
