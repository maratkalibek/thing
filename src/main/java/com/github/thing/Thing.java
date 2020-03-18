package com.github.thing;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

public class Thing {

    private BigDecimal sum = BigDecimal.ZERO;
    private BigInteger amount = BigInteger.ZERO;

    private BigDecimal smallest;
    private BigDecimal largest;
    private BigDecimal average;

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
        return sum.divide(new BigDecimal(amount));
    }
}
