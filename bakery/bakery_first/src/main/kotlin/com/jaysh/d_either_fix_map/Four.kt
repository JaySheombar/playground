package com.jaysh.d_either_fix_map

import arrow.core.Either
import com.jaysh.b_two_problem.MixerJammedException
import com.jaysh.c_three_either_error.CakeFailure

/**
 * CAKE MACHINE
 */
private object Cake {}

private object Mixture {}

private class CakeMachine {
    suspend fun makeCake(): Either<CakeFailure, Cake> {
        return mixIngredients().map { mixture -> bake(mixture) }
    }
}

private suspend fun mixIngredients(): Either<CakeFailure, Mixture> = TODO()


private suspend fun bake(mixture: Mixture): Cake = TODO()

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