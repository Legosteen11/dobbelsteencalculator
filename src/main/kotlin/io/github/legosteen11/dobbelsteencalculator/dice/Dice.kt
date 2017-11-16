package io.github.legosteen11.dobbelsteencalculator.dice

import java.util.*

class Dice(val maxNumber: Int) {
    companion object {
        fun randomNumber(maxNumber: Int) = Random().nextInt(maxNumber) + 1

        enum class SampleDice(val dice: Dice) {
            D_6(Dice(6)),
            D_20(Dice(20))
        }
    }

    fun roll() = randomNumber(maxNumber)
}