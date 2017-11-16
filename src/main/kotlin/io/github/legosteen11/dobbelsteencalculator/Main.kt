package io.github.legosteen11.dobbelsteencalculator

import io.github.legosteen11.dobbelsteencalculator.dice.Dice
import io.github.legosteen11.dobbelsteencalculator.simulation.Simulator
import io.github.legosteen11.dobbelsteencalculator.ui.Terminal

val DEFAULT_DICE_SIZE = 6

fun main(args: Array<String>) {
    println("Hoi! Ik heb vandaag echt zin om dobbelsteendingen te simuleren :).")

    val slow = args.isNotEmpty() && args[0].toLowerCase() == "slow"

    if(slow)
        println("Slow mode enabled")

    val dice_size = if(args.isEmpty()) {
        println("Using default dice size $DEFAULT_DICE_SIZE")
        DEFAULT_DICE_SIZE
    } else {
        args[0].toIntOrNull().let {
            if(it == null) {
                println("Using default dice size $DEFAULT_DICE_SIZE")
                DEFAULT_DICE_SIZE
            } else {
                println("Using custom dice size: $it")
                it
            }
        }
    }

    val dice = Dice(dice_size)
    val simulator = Simulator(dice)

    val ui = Terminal(simulator.runs, simulator.getAverage())

    while (true) {
        simulator.run()

        ui.updateRolls(simulator.runs)
        ui.updateAverage(simulator.getAverage())

        ui.print()

        if(slow)
            Thread.sleep(10)
    }
}