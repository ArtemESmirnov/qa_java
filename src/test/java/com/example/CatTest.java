package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Before
    public void setUp() throws Exception {
        Mockito.when(feline.eatMeat()).
                thenReturn(List.of("Животные", "Птицы", "Рыба"));
    }

    @Test
    public void soundShouldBeMeow() {
        Cat realCat = new Cat(feline);
        assertEquals(realCat.getSound(), "Мяу");
    }

    @Test
    public void foodShouldBePredators() throws Exception {
        Cat realCat = new Cat(feline);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");

        List<String> got = realCat.getFood();
        assertEquals(got, expected);
    }
}