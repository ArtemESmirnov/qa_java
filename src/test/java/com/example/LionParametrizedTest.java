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
    private final String SEX;
    private final boolean EXPECTED;

    public LionParametrizedTest(String sex, boolean expected){
        this.SEX = sex;
        this.EXPECTED = expected;
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
        Lion lion = new Lion(SEX, feline);
        assertEquals(EXPECTED, lion.doesHaveMane());
    }
}
