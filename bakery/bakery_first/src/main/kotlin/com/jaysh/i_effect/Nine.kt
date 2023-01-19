package com.jaysh.i_effect

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
    suspend fun makeCake(): Effect<CakeFailure, Cake> = effect {
        val ingredients = mixIngredients().bind()
        val temperature = setTemperature().bind()
        bake(ingredients, temperature).bind()
    }
}

private suspend fun mixIngredients(): Effect<CakeFailure, Mixture> = effect {
    if (true) {
        delay(5.seconds)
        Mixture
    } else {
        shift(CakeFailure.MixerJammed)
    }
}

private suspend fun bake(mixture: Mixture, temperature: Temperature): Effect<CakeFailure, Cake> =
    TODO()

//private suspend fun setTemperature(): Effect<CakeFailure, Temperature> = effect {
//    if (temperature > 60) shift(CakeFailure.TemperatureTooHigh)
//    else Temperature
//}

// With ensure
private suspend fun setTemperature(): Effect<CakeFailure, Temperature> = effect {
    ensure(temperature > 60) { CakeFailure.TemperatureTooHigh }
    Temperature
}

/**
 * PASTRY CHEF
 */
private class PastryChef(private val machine: CakeMachine) {

    suspend fun handleOrder() {
        val cake = machine.makeCake().fold(
            error = {},
            recover = { error ->
                when (error) {
                    CakeFailure.MixerJammed -> TODO()
                    CakeFailure.TemperatureTooHigh -> TODO()
                }
            },
            transform = { cake -> serve(cake = cake) }
        )
    }
}

private fun serve(cake: Cake): Unit = TODO()