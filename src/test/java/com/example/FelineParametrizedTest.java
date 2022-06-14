package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParametrizedTest {
    private final int kittensNumber;
    private final int expected;

    Feline feline;

    @Before
    public void setUp() {
        feline = new Feline();
    }

    public FelineParametrizedTest(int kittensNumber, int expected) {
        this.kittensNumber = kittensNumber;
        this.expected = expected;
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
        assertEquals(feline.getKittens(kittensNumber),
                expected);
    }
}
