import data_structure.Array.Array;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String s = "Hello";
        String reversed = "";
        for(int i = s.length() - 1; i >= 0; i--){
            reversed += s.charAt(i);
        }
        System.out.println(reversed);
    }

    public static String reverse(String s){
        Stack<Character> stack = new Stack<>();
        for(var c : s.toCharArray()){
            stack.push(c);
        }
         String reversed = "";
        while(!stack.empty()){
            reversed += stack.pop();
        }

        return reversed;
    }

    public static boolean valid(String s){
        Stack<Character> stack = new Stack<>();
        for (var c: s.toCharArray()){
            if(c == '(') stack.push(')');
            else if(c == '{') stack.push('}');
            else if(c == '[') stack.push(']');
            else if(stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty();
    }
}