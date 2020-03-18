package com.github.thing;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ThingTests {

    @Test
    public void testSmallest() {
        Thing theThing = new Thing();
        theThing.takeNumber(new BigDecimal(1));
        theThing.takeNumber(new BigDecimal(2));

        BigDecimal smallest = theThing.giveSmallest();
        Assert.assertEquals(new BigDecimal(1), smallest);
    }
}
