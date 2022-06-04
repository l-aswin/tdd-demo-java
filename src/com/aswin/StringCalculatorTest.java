package com.aswin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    @Test
    public void addEmptyInputString(){
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(0,stringCalculator.add(""),"addEmptyInputString test case failed");
    }

    @Test
    public void addOneInputString(){
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(1,stringCalculator.add("1"),"addOneInputString test case failed");
    }

    @Test
    public void addTwoInputString(){
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(3,stringCalculator.add("1,2"),"addTwoInputString test case failed");
    }
}
