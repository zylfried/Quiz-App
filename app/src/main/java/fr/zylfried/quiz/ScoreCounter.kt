package fr.zylfried.quiz

import androidx.compose.runtime.mutableStateOf

/**
 * Objet qui permet de gérer le score du joueur.
 */
object ScoreCounter {
    // État mutable pour stocker le score
    private var _score = mutableStateOf(0)

    /**
     * Score actuel du joueur.
     */
    val score: Int
        get() = _score.value

    /**
     * Incrémente le score du montant spécifié.
     * @param increment: Int - le montant à ajouter au score.
     */
    fun incrementScore(increment: Int) {
        _score.value += increment
    }
}