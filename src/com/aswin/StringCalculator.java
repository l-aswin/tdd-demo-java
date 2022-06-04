package com.aswin;

public class StringCalculator {
    public int add(String numbers){
        if(numbers.equals("")) {
            return 0;
        }
        else{
            String[] inputArray = numbers.split("[,\n]");
            int sum=0;
            for (String number : inputArray) {
                sum += Integer.parseInt(number);
            }
            return sum;
        }
    }
}
