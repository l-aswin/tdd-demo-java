package com.aswin;

import com.aswin.assertions.NegativeInputException;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class StringCalculatorTest {
    String msgFailed=" test case failed";
    @Test
    public void addInputEmptyString() throws NegativeInputException {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(0,stringCalculator.add(""),"addInputEmptyString"+msgFailed);
    }

    @Test
    public void addInputLengthOne() throws NegativeInputException {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(1,stringCalculator.add("1"),"addInputLengthOne"+msgFailed);
    }

    @Test
    public void addInputLengthTwo() throws NegativeInputException {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(3,stringCalculator.add("1,2"),"addInputLengthTwo"+msgFailed);
    }

    @Test
    public void addInputLengthUnknown() throws NegativeInputException {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(120,stringCalculator.add("1,2,8,9,67,33"),"addInputLengthUnknown"+msgFailed);
    }

    @Test
    public void addInputWithNewline() throws NegativeInputException {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(6,stringCalculator.add("1\n2,3"),"addInputWithNewline"+msgFailed);
    }

    @Test
    public void addSupportDifferentDelimiters() throws NegativeInputException {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(3,stringCalculator.add("//;\n1;2"),"addSupportDifferentDelimiters"+msgFailed);
    }

    @Test
    public void addDisallowNegativeDifferentDelimiter() throws NegativeInputException {
        StringCalculator stringCalculator = new StringCalculator();
        stringCalculator.add("//;\n-1;2;-3;4");
    }

    @Test
    public void addDisallowNegative() throws NegativeInputException {
        StringCalculator stringCalculator = new StringCalculator();
        stringCalculator.add("-1\n-2,4,5,-6,7");
    }

    @Test
    public void addIgnoreHighNumber() throws NegativeInputException{
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(2,stringCalculator.add("2,1001"),"Ignore number>1000"+msgFailed);
    }

    @Test
    public void addDelimiterStringLengthNoLimit() throws NegativeInputException{
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(10, stringCalculator.add("//[***]\n1***2***3***4"),"addDelimiterStringLengthNoLimit"+msgFailed);

    }

    @Test
    public void testGetCalledCount() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(10,stringCalculator.getCalledCount(),"testGetCalledCount"+msgFailed);
    }

}
