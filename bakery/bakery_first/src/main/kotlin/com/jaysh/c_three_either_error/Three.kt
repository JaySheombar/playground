package com.jaysh.c_three_either_error

import arrow.core.Either
import com.jaysh.b_two_problem.MixerJammedException

/**
 * CAKE MACHINE
 */
private object Cake {}

private object Mixture {}

private class CakeMachine {
    suspend fun makeCake(): Cake {
        val mixture = mixIngredients()
        return bake(mixture)
    }

//    suspend fun makeCake(): Either<CakeFailure, Cake> {
//        val mixture = mixIngredients()
//        return bake(mixture)
//    }
}

private suspend fun mixIngredients(): Mixture = TODO()
//private suspend fun mixIngredients(): Either<CakeFailure, Mixture> = TODO()


private suspend fun bake(mixture: Mixture): Cake = TODO()

/**
 * PASTRY CHEF
 */
private class PastryChef(private val machine: CakeMachine) {

    suspend fun handleOrder() = try {
        val cake = machine.makeCake()
        serve(cake = cake)
    } catch (e: MixerJammedException) {
        // We do something smart
    }
}

private fun serve(cake: Cake): Unit = TODO()