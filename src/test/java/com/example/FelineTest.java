package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FelineTest {

    Feline feline;
    @Before
    public void Setup() {
        feline = new Feline();
    }

    private final int KITTENS_NUMBER;
    private final int EXPECTED;

    @Test
    public void eatMeatShouldBeMeat() {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");

        try {
            assertEquals(feline.eatMeat(), expected);
        } catch (Exception expectedException) {
            fail();
        }
    }

    @Test
    public void familyShouldBeCats() {
        assertEquals(feline.getFamily(), "Кошачьи");
    }

    @Test
    public void shouldHaveOneKittenByDefault() {
        assertEquals(feline.getKittens(), 1);
    }

    public FelineTest(int kittensNumber, int expected) {
        this.KITTENS_NUMBER = kittensNumber;
        this.EXPECTED = expected;
    }

    @Parameterized.Parameters
    public static Object[] getNumberOfKittensData() {
        return new Object[][] {
                { 1, 1},
                { 5, 5},
                { Integer.MAX_VALUE, Integer.MAX_VALUE},
                { Integer.MIN_VALUE, Integer.MIN_VALUE},
                { -5, -5},
                { 0, 0},
        };
    }

    @Test
    public void testGetKittens() {
        assertEquals(feline.getKittens(KITTENS_NUMBER), EXPECTED);
    }
}