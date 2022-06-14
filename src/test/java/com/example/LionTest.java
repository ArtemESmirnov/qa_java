package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
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
    public void foodShouldBePredators() throws Exception {
        Lion realLion = new Lion("Самец", feline);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");

        List<String> got = realLion.getFood();
        assertEquals(got, expected);
    }

    @Test
    public void doesHaveManeShouldBeException() {
        try{
            Lion lion = new Lion("sex", feline);
            Assert.fail("Expected exception was not thrown");
        }
        catch (Exception exception){
            assertEquals("Используйте допустимые значения пола животного - " +
                    "самей или самка", exception.getMessage());
        }

    }
}