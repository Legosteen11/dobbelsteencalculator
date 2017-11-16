package io.github.legosteen11.dobbelsteencalculator.simulation

import io.github.legosteen11.dobbelsteencalculator.dice.Dice
import java.math.BigDecimal
import java.math.BigInteger
import java.math.MathContext
import java.math.RoundingMode

class Simulator(val dice: Dice) {
    companion object {
        val MATH_CONTEXT = MathContext(5, RoundingMode.HALF_UP)
    }

    var runs = BigInteger.ZERO
    var sum = BigInteger.ZERO

    fun run() {
        runs = runs.add(BigInteger.ONE)
        sum = sum.add(BigInteger.valueOf(dice.roll().toLong()))
    }

    fun getAverage(): BigDecimal = if(runs == BigInteger.ZERO || sum == BigInteger.ZERO) {
        BigDecimal.ZERO
    } else {
        BigDecimal(sum).divide(BigDecimal(runs), MATH_CONTEXT)
    }
}