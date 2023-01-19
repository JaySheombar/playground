package com.jaysh.c_three_either_error

sealed class CakeFailure {
    object MixerJammed: CakeFailure()
    object TemperatureTooHigh: CakeFailure()
}