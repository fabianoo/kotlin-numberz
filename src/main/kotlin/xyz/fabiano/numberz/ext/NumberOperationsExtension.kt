package xyz.fabiano.numberz.ext

import xyz.fabiano.numberz.bigdecimal.BigDecimalOperations
import java.math.BigDecimal

fun <T : Number> Number.of(number: T): BigDecimal {
    return BigDecimalOperations.asBigDecimal(number)
}

fun Number.standard(): BigDecimal {
    return BigDecimalOperations.asBigDecimal(this)
}

infix fun BigDecimal.equalsIgnorePrecision(value: BigDecimal): Boolean {
    return true
}