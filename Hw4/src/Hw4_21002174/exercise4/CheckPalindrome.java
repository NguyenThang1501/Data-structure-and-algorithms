package Hw4_21002174.exercise4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class CheckPalindrome {
    public static boolean check(String str) {
        Stack<Character> back = new Stack<>();
        Queue<Character> front = new LinkedList<>();
        for (char c : str.toCharArray()) {
            back.push(c);
            front.add(c);
        }
        while (!back.isEmpty()) {
            if (front.poll() != back.pop()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(check(str));
    }
}
