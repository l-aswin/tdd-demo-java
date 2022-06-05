package com.aswin;

import com.aswin.assertions.NegativeInputException;

import java.util.regex.Pattern;

public class StringCalculator {
    private static int countAddMethodCall = 0;

    public int add(String numbers) throws NegativeInputException {
        countAddMethodCall++;
        String specialCharacters = "\\.[]{}()<>*+-=!?^$|";

        if (numbers.matches("//\\[(.*)](.*)\n(.*)")) {
            //split user input into lines
            String[] lines = numbers.split("\n");
            //extract array of delimiters from first line
            String[] delimiterArray = Pattern.compile("\\[(.*?)]")
                    .matcher(lines[0])
                    .results()
                    .map(mr -> mr.group(1))
                    .toArray(String[]::new);
            //loop through array of delimiters
            StringBuilder delimiterExpression= new StringBuilder();
            for(String item:delimiterArray){
                //add escape sequence to delimiter,if it has reserved symbols
                StringBuilder temp = new StringBuilder();
                char[] array = item.toCharArray();
                for (char c : array) {
                    if (specialCharacters.contains(String.valueOf(c))) {
                        temp.append("\\").append(c);
                    } else {
                        temp.append(c);
                    }
                }
                //add this to delimiterExpr
                if(delimiterExpression.toString().equals(""))
                    delimiterExpression = new StringBuilder(temp.toString());
                else
                    delimiterExpression.append("|").append(temp);
            }
            //extract numbers from line 2
            String[] numberArray = lines[1].split(delimiterExpression.toString());
            //iterate through array and calculate sum
            return sumNumberArray(numberArray);
        }
        else if (numbers.matches("//(.*)\n(.*)")) {
            //split user input into lines
            String[] lines = numbers.split("\n");

            //extract delimiter from first line
            String delimiterUserInput = lines[0].replaceFirst("//", "");

            //add escape sequence to delimiter,if it has reserved symbols
            StringBuilder delimiter = new StringBuilder();
            char[] delimiterArray = delimiterUserInput.toCharArray();
            for (char c : delimiterArray) {
                if (specialCharacters.contains(String.valueOf(c))) {
                    delimiter.append("\\").append(c);
                } else {
                    delimiter.append(c);
                }
            }

            //extract numbers from line 2
            String[] numberArray = lines[1].split(delimiter.toString());

            //iterate through array and calculate sum
            return sumNumberArray(numberArray);

        } else if (numbers.equals(""))
            return 0;
        else {
            //extract numbers from string using delimiters , or \n
            String[] numberArray = numbers.split("[,\n]");
            //iterate through array and calculate sum
            return sumNumberArray(numberArray);
        }
    }

    public int getCalledCount() {
        return countAddMethodCall;
    }

    private int sumNumberArray(String[] numberArray) throws NegativeInputException {
        //iterate through array and calculate sum
        int sum = 0;
        StringBuilder negativesInInput = new StringBuilder();
        for (String number : numberArray) {
            if (Integer.parseInt(number) < 0)
                negativesInInput.append(number).append(",");
            else {
                //ignore number if it is greater than 1000
                if (Integer.parseInt(number) <= 1000)
                    sum += Integer.parseInt(number);
            }
        }
        //if input has negative number, throw exception
        if (!negativesInInput.toString().equals(""))
            throw new NegativeInputException("negatives not allowed " + negativesInInput);
        else
            return sum;
    }
}
