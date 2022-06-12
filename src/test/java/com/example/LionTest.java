package com.example;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

import static org.junit.Assert.*;

public class LionTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock
    IFeline feline;

    @Before
    public void setUp() throws Exception {
        Mockito.when(feline.getFood("Хищник")).
                thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Mockito.when(feline.getKittens()).thenReturn(1);
    }
    @Test
    public void getKittensShouldBeOne() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void doesHaveManeTestException() {
        String expectedMessage = "Используйте допустимые значения пола животного - самей или самка";
        try {
            Lion lion = new Lion("sex", feline);
        }
        catch (Exception exception){
            assertEquals(expectedMessage, exception.getMessage());
        }
    }

    @Test
    public void foodShouldBePredators() throws Exception {
        Lion realLion = new Lion("Самец", feline);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");

        List<String> got = realLion.getFood();
        assertEquals(got, expected);
    }
}