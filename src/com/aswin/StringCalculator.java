package com.aswin;

import com.aswin.assertions.NegativeInputException;

public class StringCalculator {
    public int add(String numbers) throws NegativeInputException {
        if (numbers.matches("//(.*)\n(.*)")) {
            //split user input into lines
            String[] lines = numbers.split("\n");
            //extract delimiter from first line
            String delimiter = lines[0].replaceFirst("//", "");
            //extract numbers from line 2
            String[] numberArray = lines[1].split(delimiter);
            //iterate through array and calculate sum
            int sum = 0;
            String negativesInInput="";
            for (String number : numberArray) {
                if(Integer.parseInt(number)<0)
                    negativesInInput += number+",";
                else
                    sum += Integer.parseInt(number);
            }
            //if input has negative number, throw exception
            if(!negativesInInput.equals(""))
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
            String negativesInInput="";
            for (String number : numberArray) {
                if(Integer.parseInt(number)<0)
                    negativesInInput += number+",";
                else
                    sum += Integer.parseInt(number);
            }
            //if input has negative number, throw exception
            if(!negativesInInput.equals(""))
                throw new NegativeInputException("negatives not allowed " + negativesInInput);
            else
                return sum;
        }
    }

}
