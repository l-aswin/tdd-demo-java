package com.aswin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    String msgFailed=" test case failed";
    @Test
    public void addEmptyInputString(){
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(0,stringCalculator.add(""),"addEmptyInputString"+msgFailed);
    }

    @Test
    public void addOneInputString(){
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(1,stringCalculator.add("1"),"addOneInputString"+msgFailed);
    }

    @Test
    public void addTwoInputString(){
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(3,stringCalculator.add("1,2"),"addTwoInputString"+msgFailed);
    }

    @Test
    public void addUnknownInput(){
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(120,stringCalculator.add("1,2,8,9,67,33"),"addUnknownInput"+msgFailed);
    }
}
