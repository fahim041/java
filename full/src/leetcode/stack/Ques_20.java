package leetcode.stack;

import java.util.Stack;

public class Ques_20 {
    public static boolean isValid(String s){
        Stack<String> stack = new Stack<>();

        for(var c: s.toCharArray()){
            if(c == '(') stack.push(c);
            if(c == '{') stack.push(c);
            if(c == '[') stack.push(c);
            if(stack.isEmpty() || stack.pop() != c) return false;
        }

        return stack.isEmpty();
    }
}
