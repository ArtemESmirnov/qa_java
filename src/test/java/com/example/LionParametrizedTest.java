package com.example;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParametrizedTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock
    IFeline feline;
    private final String sex;
    private final boolean expected;

    public LionParametrizedTest(String sex, boolean expected){
        this.sex = sex;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[] doesHaveManeData() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
                {"sex", false},
        };
    }

    @Test
    public void doesHaveManeTest() {
        try{
            Lion lion = new Lion(sex, feline);
            assertEquals(expected, lion.doesHaveMane());
        }
        catch (Exception exception){
            assertEquals("Используйте допустимые значения пола животного - " +
                    "самей или самка", exception.getMessage());
        }

    }
}
