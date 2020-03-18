package com.github.thing;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ThingTest {

    @Test
    public void testSmallest() {
        Thing theThing = new Thing();
        theThing.takeNumber(new BigDecimal(1));
        theThing.takeNumber(new BigDecimal(2));

        BigDecimal smallest = theThing.giveSmallest();
        Assert.assertEquals(new BigDecimal(1), smallest);
    }

    @Test
    public void testLargest() {
        Thing theThing = new Thing();
        theThing.takeNumber(new BigDecimal(1));
        theThing.takeNumber(new BigDecimal(2));

        BigDecimal largest = theThing.giveLargest();
        Assert.assertEquals(new BigDecimal(2), largest);
    }

    @Test
    public void testAverage() {
        Thing theThing = new Thing();
        theThing.takeNumber(new BigDecimal(1));
        theThing.takeNumber(new BigDecimal(2));

        BigDecimal average = theThing.giveAverage();
        Assert.assertEquals(new BigDecimal(1.5), average);
    }

    @Test
    public void testWithoutOfferedNumbers() {
        Thing theThing = new Thing();
        Assert.assertNull(theThing.giveAverage());
        Assert.assertNull(theThing.giveSmallest());
        Assert.assertNull(theThing.giveLargest());
    }
}
