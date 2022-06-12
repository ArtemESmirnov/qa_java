package com.example;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock
    IFeline feline;

    @Before
    public void Setup() throws Exception {
        Mockito.when(feline.getFood("Хищник")).
                thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Mockito.when(feline.getKittens()).thenReturn(1);
    }


    private final String sex;
    private final boolean expected;

    @Test
    public void getKittensShouldBeOne() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertEquals(1, lion.getKittens());
    }

    public LionTest(String sex, boolean expected){
        this.sex = sex;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[] doesHaveManeData() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        assertEquals(expected, lion.doesHaveMane());
    }

    @Test
    public void doesHaveManeTestException() {
        String expectedMessage = "Используйте допустимые значения пола животного - самей или самка";
        String exceptionMessage = "";
        try {
            Lion lion = new Lion("sex", feline);
        }
        catch (Exception exception){
            exceptionMessage = exception.getMessage();
        }
        finally {
            assertEquals(expectedMessage, exceptionMessage);
        }

    }

    @Test
    public void foodShouldBePredators() throws Exception {
        Lion realLion = new Lion("Самец", feline);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");

        try {
            var got = realLion.getFood();
            assertEquals(got, expected);
        } catch (Exception expectedException) {
            fail();
        }
    }
}