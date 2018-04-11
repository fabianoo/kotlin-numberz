package xyz.fabiano.numberz.config

import java.math.BigDecimal

object GlobalLeanMathContext {
    var defaultScale: Int = 10
    var defaultRoundMode: Int = BigDecimal.ROUND_HALF_EVEN
}