package com.example;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FelineTest {
    Feline feline;
    @Before
    public void setUp() {
        feline = new Feline();
    }

    @Test
    public void eatMeatShouldBeMeat() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");

        assertEquals(feline.eatMeat(), expected);
    }

    @Test
    public void familyShouldBeCats() {
        assertEquals(feline.getFamily(), "Кошачьи");
    }

    @Test
    public void shouldHaveOneKittenByDefault() {
        assertEquals(feline.getKittens(), 1);
    }

}