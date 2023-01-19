package com.jaysh.a_one_problem

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
}

private suspend fun mixIngredients(): Mixture = TODO()

private suspend fun bake(mixture: Mixture): Cake = TODO()

/**
 * PASTRY CHEF
 */
private class PastryChef(private val machine: CakeMachine) {

    suspend fun handleOrder() {
        val cake = machine.makeCake()
        serve(cake = cake)
    }
}

private fun serve(cake: Cake): Unit = TODO()