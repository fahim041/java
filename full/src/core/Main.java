package core;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String hello = "helloy";
        int[] store = new int[26];
        for (int i = 0; i < hello.length(); i++){
            System.out.println(hello.charAt(i)-'a');
            store[hello.charAt(i)-'a']++;
        }
        System.out.println(Arrays.toString(store));
    }

    public static void show(UIControl control){
        var textbox = (TextBox)control;
        textbox.setText("Hello");
        System.out.println(control);
    }
}