package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParametrizedTest {
    private final int KITTENS_NUMBER;
    private final int EXPECTED;

    Feline feline;

    @Before
    public void setUp() {
        feline = new Feline();
    }

    public FelineParametrizedTest(int kittensNumber, int expected) {
        this.KITTENS_NUMBER = kittensNumber;
        this.EXPECTED = expected;
    }

    @Parameterized.Parameters
    public static Object[] getNumberOfKittensData() {
        return new Object[][]{
                {1, 1},
                {5, 5},
                {Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MIN_VALUE, Integer.MIN_VALUE},
                {-5, -5},
                {0, 0},
        };
    }

    @Test
    public void testGetKittens() {
        assertEquals(feline.getKittens(KITTENS_NUMBER), EXPECTED);
    }
}
