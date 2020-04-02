package com.company;

import java.util.LinkedList;

public class evaluateReversePolishNotation {

    public int main(String[] tokens) {
        LinkedList<String> num = new LinkedList<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                String num1 = num.getLast();
                num.removeLast();
                String num2 = num.getLast();
                num.removeLast();

                num.addLast(compute(num1, num2, tokens[i]));
            } else {
                num.addLast(tokens[i]);
            }
        }

        return Integer.parseInt(num.getLast());
    }

    public String compute(String num1, String num2, String sym) {
        Integer num3;
        switch (sym) {
            case "+":
                num3 = Integer.parseInt(num1) + Integer.parseInt(num2);
                break;
            case "-":
                num3 = Integer.parseInt(num1) - Integer.parseInt(num2);
                break;
            case "*":
                num3 = Integer.parseInt(num1) * Integer.parseInt(num2);
                break;
            case "/":
                num3 = Integer.parseInt(num1) / Integer.parseInt(num2);
                break;
            default:
                num3 = 0;
        }
        return Integer.toString(num3);
    }

}
