package io.github.legosteen11.dobbelsteencalculator.ui

import java.math.BigDecimal
import java.math.BigInteger

interface UIInterface {
    fun updateRolls(rolls: BigInteger)

    fun updateAverage(average: BigDecimal)
}