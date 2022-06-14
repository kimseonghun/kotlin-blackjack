package blackjack.domain.participant

import blackjack.domain.card.Card
import blackjack.domain.card.CardSuit
import blackjack.domain.card.CardSymbol
import blackjack.domain.game.Deck

class Dealer : Participant() {
    override val name = DEALER_NAME
    override val money: Money = Money(DEALER_BAT_MONEY)
    private val deck: Deck = shuffleNewDeck()

    override fun isDrawable(): Boolean {
        return hand.score() <= DEALER_DRAWABLE_SCORE_LIMIT
    }

    fun drawCards(num: Int): List<Card> {
        val cards = mutableListOf<Card>()
        repeat(num) {
            cards.add(deck.draw())
        }
        return cards.toList()
    }

    fun drawOneCard(): Card {
        return deck.draw()
    }

    private fun shuffleNewDeck(): Deck {
        return STANDARD_52_CARD_DECK.shuffle()
    }

    companion object {
        val ALL_CARDS = CardSuit.values().flatMap { suit ->
            CardSymbol.values().map { symbol ->
                Card(suit, symbol)
            }
        }
        const val FIRST_DRAW_NUMBER = 2
        const val DEALER_BAT_MONEY = 10000
        private val STANDARD_52_CARD_DECK: Deck = Deck(ALL_CARDS)
        private const val DEALER_DRAWABLE_SCORE_LIMIT = 16
        private const val DEALER_NAME = "딜러"
    }
}