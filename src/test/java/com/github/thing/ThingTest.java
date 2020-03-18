package com.github.thing;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ThingTest {

    @Test
    public void testSmallest() {
        Thing theThing = new Thing();
        theThing.takeNumber(new BigDecimal(1));
        theThing.takeNumber(new BigDecimal(2));

        BigDecimal smallest = theThing.giveSmallest();
        assertEquals(new BigDecimal(1), smallest);
    }

    @Test
    public void testLargest() {
        Thing theThing = new Thing();
        theThing.takeNumber(new BigDecimal(1));
        theThing.takeNumber(new BigDecimal(2));

        BigDecimal largest = theThing.giveLargest();
        assertEquals(new BigDecimal(2), largest);
    }

    @Test
    public void testAverage() {
        Thing theThing = new Thing();
        theThing.takeNumber(new BigDecimal(1));
        theThing.takeNumber(new BigDecimal(2));

        BigDecimal average = theThing.giveAverage();
        assertTrue(areEquals(new BigDecimal(1.5), average));

        theThing.takeNumber(new BigDecimal(2));
        average = theThing.giveAverage();
        assertTrue(areEquals(new BigDecimal(1.667), average));
    }

    @Test
    public void testWithoutOfferedNumbers() {
        Thing theThing = new Thing();
        assertNull(theThing.giveAverage());
        assertNull(theThing.giveSmallest());
        assertNull(theThing.giveLargest());
    }

    @Test
    public void testAreEqualsMethod() {
        assertFalse(areEquals(new BigDecimal("1.000"), new BigDecimal("1.001")));
        assertFalse(areEquals(new BigDecimal("1.000"), new BigDecimal("1.0005")));
        assertTrue(areEquals(new BigDecimal("1.000"), new BigDecimal("1.0004")));
    }

    private boolean areEquals(BigDecimal a, BigDecimal b) {
        BigDecimal newA = a.setScale(3, RoundingMode.HALF_UP);
        BigDecimal newB = b.setScale(3, RoundingMode.HALF_UP);
        BigDecimal diff = newA.subtract(newB);
        BigDecimal delta = new BigDecimal(0.001).setScale(3, RoundingMode.HALF_UP);
        int compareResult = diff.abs().compareTo(delta);
        return compareResult<0;
    }
}
