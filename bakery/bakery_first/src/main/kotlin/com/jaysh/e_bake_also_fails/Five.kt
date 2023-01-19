package com.jaysh.e_bake_also_fails

import arrow.core.Either
import arrow.core.flatMap
import com.jaysh.b_two_problem.MixerJammedException
import com.jaysh.c_three_either_error.CakeFailure

/**
 * CAKE MACHINE
 */
private object Cake {}

private object Mixture {}

private class CakeMachine {
    suspend fun makeCake(): Either<CakeFailure, Cake> {
        return mixIngredients().flatMap { mixture -> bake(mixture) }
    }
}

private suspend fun mixIngredients(): Either<CakeFailure, Mixture> = TODO()


// Updated this signature:
private suspend fun bake(mixture: Mixture): Either<CakeFailure, Cake> = TODO()

/**
 * PASTRY CHEF
 */
private class PastryChef(private val machine: CakeMachine) {

    suspend fun handleOrder() = try {
//        serve(cake = cake)
        machine.makeCake().map { cake -> serve(cake) }
    } catch (e: MixerJammedException) {
        // We do something smart
    }
}

private fun serve(cake: Cake): Unit = TODO()