package com.aswin;

import com.aswin.assertions.NegativeInputException;

public class StringCalculator {
    private static int countAddMethodCall=0;
    public int add(String numbers) throws NegativeInputException {
        countAddMethodCall++;
        if (numbers.matches("//(.*)\n(.*)")) {
            //split user input into lines
            String[] lines = numbers.split("\n");
            //extract delimiter from first line
            String delimiter = lines[0].replaceFirst("//", "");
            //extract numbers from line 2
            String[] numberArray = lines[1].split(delimiter);
            //iterate through array and calculate sum
            int sum = 0;
            StringBuilder negativesInInput= new StringBuilder();
            for (String number : numberArray) {
                if(Integer.parseInt(number)<0)
                    negativesInInput.append(number).append(",");
                else {
                    //ignore number if it is greater than 1000
                    if(Integer.parseInt(number)<=1000)
                        sum += Integer.parseInt(number);
                }
            }
            //if input has negative number, throw exception
            if(!negativesInInput.toString().equals(""))
                throw new NegativeInputException("negatives not allowed " + negativesInInput);
            else
                return sum;
        } else if (numbers.equals(""))
            return 0;
        else {
            //extract numbers from string using delimiters , or \n
            String[] numberArray = numbers.split("[,\n]");
            //iterate through array and calculate sum
            int sum = 0;
            StringBuilder negativesInInput= new StringBuilder();
            for (String number : numberArray) {
                if(Integer.parseInt(number)<0)
                    negativesInInput.append(number).append(",");
                else {
                    //ignore number if it is greater than 1000
                    if(Integer.parseInt(number)<=1000)
                        sum += Integer.parseInt(number);
                }
            }
            //if input has negative number, throw exception
            if(!negativesInInput.toString().equals(""))
                throw new NegativeInputException("negatives not allowed " + negativesInInput);
            else
                return sum;
        }
    }

    public int getCalledCount() {
        return countAddMethodCall;
    }
}
