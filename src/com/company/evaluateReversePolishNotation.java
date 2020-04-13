package com.company;

import java.util.Stack;

public class evaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
           try{
               int num = Integer.parseInt(tokens[i]);
               numStack.push(num);
           }catch (Exception e){
               //如果是其他计算符号在parseInt时会异常，进入异常处理程序
               int b = numStack.pop();
               int a = numStack.pop();
               numStack.push(compute(a,b,tokens[i]));
           }
        }

        return numStack.pop();
    }

    public int compute(int num1, int num2, String sym) {
        Integer num3;
        switch (sym) {
            case "+":
                num3 = num1 + num2;
                break;
            case "-":
                num3 = num1 - num2;
                break;
            case "*":
                num3 = num1 * num2;
                break;
            case "/":
                num3 = num1 / num2;
                break;
            default:
                num3 = 0;
        }
        return num3;
    }

}
