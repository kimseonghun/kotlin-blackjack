package blackjack.ui

import blackjack.domain.player.Player

object BlackJackInputView {

    private fun inputString(): String = readLine() ?: ""

    fun inputParticipantsPrompt(): List<String> {
        println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)")
        return inputString().split(",")
    }

    fun firstDrawMessage(players: List<Player>) {
        println("${players.joinToString(",") { it.name.value }}에게 2장을 나누었습니다.")
    }

    fun askIntentionToPlay(player: Player): Boolean {
        println("${player.name.value}는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)")
        val intention = inputString()
        return "y" == intention || "Y" == intention
    }
}