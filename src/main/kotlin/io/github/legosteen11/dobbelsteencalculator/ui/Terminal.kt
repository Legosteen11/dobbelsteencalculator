package io.github.legosteen11.dobbelsteencalculator.ui

import java.math.BigDecimal
import java.math.BigInteger

class Terminal(var rolls: BigInteger,
               var average: BigDecimal): UIInterface {
    companion object {
        val MIN_WIDTH = 20

        fun createWhiteSpace(width: Int, minWidth: Int): String {
            var whiteSpace = ""
            (width..minWidth).forEach {
                whiteSpace += " "
            }

            return whiteSpace
        }
    }

    init {
        print()
    }

    fun print() {
        print("\rrolls: $rolls${createWhiteSpace(rolls.toString(10).length, MIN_WIDTH)} average: $average")
    }

    override fun updateRolls(rolls: BigInteger) {
        this.rolls = rolls
    }

    override fun updateAverage(average: BigDecimal) {
        this.average = average
    }
}