import data_structure.Array.Array;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(5);
        list.addFirst(2);
        list.removeLast();
        System.out.println(list.indexOf(2));
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