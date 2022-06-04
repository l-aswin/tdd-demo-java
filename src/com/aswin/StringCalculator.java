package com.aswin;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.matches("//(.*)\n(.*)")) {
            //split user input into lines
            String[] lines = numbers.split("\n");
            //extract delimiter from first line
            String delimiter = lines[0].replaceFirst("//", "");
            //extract numbers from line 2
            String[] numberArray = lines[1].split(delimiter);
            //iterate through array and calculate sum
            int sum = 0;
            for (String number : numberArray) {
                sum += Integer.parseInt(number);
            }
            return sum;
        } else if (numbers.equals(""))
            return 0;
        else {
            //extract numbers from string using delimiters , or \n
            String[] numberArray = numbers.split("[,\n]");
            //iterate through array and calculate sum
            int sum = 0;
            for (String number : numberArray) {
                sum += Integer.parseInt(number);
            }
            return sum;
        }
    }

}
