package com.github.thing;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Thing {

    private BigDecimal sum = BigDecimal.ZERO;
    private BigInteger amount = BigInteger.ZERO;

    private BigDecimal smallest;
    private BigDecimal largest;

    public void takeNumber(BigDecimal number) {
        amount = amount.add(BigInteger.ONE);
        sum = sum.add(number);

        if (smallest!=null) {
            if (smallest.compareTo(number) > 0) {
                smallest = number;
            }
        } else {
            smallest = number;
        }

        if (largest!=null) {
            if (largest.compareTo(number) < 0) {
                largest = number;
            }
        } else {
            largest = number;
        }
    }

    public BigDecimal giveSmallest() {
        return smallest;
    }

    public BigDecimal giveLargest() {
        return largest;
    }

    public BigDecimal giveAverage() {
        if (amount.equals(BigInteger.ZERO)) {
            return null;
        }
        return sum.divide(new BigDecimal(amount));
    }
}
