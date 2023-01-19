package com.jaysh.f_bake_argument_butter

import arrow.core.Either
import arrow.core.flatMap
import com.jaysh.b_two_problem.MixerJammedException
import com.jaysh.c_three_either_error.CakeFailure

/**
 * CAKE MACHINE
 */
private object Cake {}
private object Mixture {}
private object Temperature {}

private class CakeMachine {
    suspend fun makeCake(): Either<CakeFailure, Cake> {
        return mixIngredients().flatMap { mixture ->
            setTemperature().flatMap { temperature ->
                bake(mixture, temperature)
            }
        }
    }
}

private suspend fun mixIngredients(): Either<CakeFailure, Mixture> = TODO()


// Updated this signature:
private suspend fun bake(mixture: Mixture, temperature: Temperature): Either<CakeFailure, Cake> =
    TODO()

private suspend fun setTemperature(): Either<CakeFailure, Temperature> = TODO()

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