package fr.zylfried.quiz

/**
 * Classe qui contient une catégorie de questions et une liste de questions
 * @param category Nom de la catégorie
 * @param questionsList Liste des questions
 */
class QuestionsRepertory(
    val category: String,
    val questionsList: List<QuestionNAnswers>
)