package com.jaysh.j_effect_final

import arrow.core.continuations.Effect
import arrow.core.continuations.EffectScope
import arrow.core.continuations.effect
import com.jaysh.c_three_either_error.CakeFailure
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

/**
 * CAKE MACHINE
 */
private object Cake {}
private object Mixture {}
private object Temperature {}

private val temperature = 100

private class CakeMachine {
    context(EffectScope<CakeFailure>)
    suspend fun makeCake(): Cake {
        val ingredients = mixIngredients()
        val temperature = setTemperature()
        return bake(ingredients, temperature)
    }
}

context(EffectScope<CakeFailure>)
private suspend fun mixIngredients(): Mixture = TODO()

context(EffectScope<CakeFailure>)
private suspend fun bake(mixture: Mixture, temperature: Temperature): Cake = TODO()

//private suspend fun setTemperature(): Effect<CakeFailure, Temperature> = effect {
//    if (temperature > 60) shift(CakeFailure.TemperatureTooHigh)
//    else Temperature
//}

// With ensure
context(EffectScope<CakeFailure>)
private suspend fun setTemperature(): Temperature {
    ensure(temperature > 60) { CakeFailure.TemperatureTooHigh }
    return Temperature
}

/**
 * PASTRY CHEF
 */
private class PastryChef(private val machine: CakeMachine) {

    suspend fun handleOrder() = effect { machine.makeCake() }
        .fold(
            recover = { error ->
                when (error) {
                    CakeFailure.MixerJammed -> TODO()
                    CakeFailure.TemperatureTooHigh -> TODO()
                }
            },
            transform = { cake -> serve(cake = cake) },
        )
}

private fun serve(cake: Cake): Unit = TODO()