package leetcode.stack;

import java.util.*;

public class Ques_150 {
    public static int evalRPN(String[] tokens){
        Stack<Integer> stack = new Stack<>();
        for(var token : tokens){
            if(token.equals("+")) stack.push(stack.pop() + stack.pop());
            else if(token.equals("-")){
                int a = (int) stack.pop();
                int b = (int) stack.pop();

                stack.push(b - a);
            }
            else if(token.equals("*")) stack.push(stack.pop() * stack.pop());
            else if(token.equals("/")) {
                int a = (int) stack.pop();
                int b = (int) stack.pop();

                stack.push(b / a);
            }
            else stack.push(Integer.parseInt(token));
        }
        return stack.peek();
    }
}
