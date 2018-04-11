package xyz.fabiano.numberz.bigdecimal;

import xyz.fabiano.numberz.config.GlobalLeanMathContext;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Stream;

public class BigDecimalOperations {

    public static <T extends Number> BigDecimal divide(T dividend, T divisor) {
        return asBigDecimal(dividend).divide(
            asBigDecimal(divisor),
            GlobalLeanMathContext.INSTANCE.getDefaultScale(),
            GlobalLeanMathContext.INSTANCE.getDefaultRoundMode());
    }

    @SafeVarargs
    public static <T extends Number> BigDecimal sum(final T... factors) {
        BigDecimal product = bigDecimalStream(factors)
            .reduce(BigDecimal.ONE, BigDecimal::multiply);
        return standardBigDecimal(product);
    }

    @SafeVarargs
    public static <T extends Number> BigDecimal multiply(final T... factors) {
        BigDecimal product = Arrays.stream(factors)
            .map(BigDecimalOperations::asBigDecimal)
            .reduce(BigDecimal.ONE, BigDecimal::multiply);
        return standardBigDecimal(product);
    }

    public static BigDecimal sqrt(BigDecimal radicand) {
        Double sqrt = Math.sqrt(radicand.doubleValue());
        return asBigDecimal(sqrt);
    }

    public static <T extends Number> BigDecimal asBigDecimal(T value) {
        return standardBigDecimal(BigDecimal.valueOf(value.doubleValue()));
    }

    public static BigDecimal asBigDecimal(BigInteger value) {
        return standardBigDecimal(new BigDecimal(value));
    }

    public static BigDecimal asBigDecimal(BigDecimal value) {
        return standardBigDecimal(value);
    }

    public static BigDecimal asBigDecimal(CharSequence value) {
        return standardBigDecimal(new BigDecimal(value.toString()));
    }

    public static BigDecimal standardBigDecimal(BigDecimal bigDecimal) {
        return bigDecimal.setScale(GlobalLeanMathContext.INSTANCE.getDefaultScale(),
            GlobalLeanMathContext.INSTANCE.getDefaultRoundMode());
    }

    private static <T extends Number> Stream<BigDecimal> bigDecimalStream(T[] factors) {
        return Arrays.stream(factors)
            .map(BigDecimalOperations::asBigDecimal);
    }
}
