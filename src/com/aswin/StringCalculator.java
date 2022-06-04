package com.aswin;

public class StringCalculator {
    public int add(String numbers){
        if(numbers.equals("")) {
            return 0;
        }
        else{
            String[] inputArray = numbers.split(",");
            if(inputArray.length == 1)
                return Integer.parseInt(inputArray[0]);
            else
                return Integer.parseInt(inputArray[0]) + Integer.parseInt(inputArray[1]);
        }
    }
}
