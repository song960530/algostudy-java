package baekjoon;

import java.util.*;

/*
    백준 스택
    괄호
 */

public class Ex_9012 {

    public static int T;
    public static Scanner sc = new Scanner(System.in);
    public static String result = "";

    public static void input() {
        T = sc.nextInt();

    }

    public static void main(String[] args) {
        /*
        (())()    ((())) VPS
        (()(     (())()))  not VPS
         */




        input();

        for(int i=0; i<T; i++) {
            String str = sc.next();
            result += isVPS(str) + "\n";
        }

        System.out.println(result.substring(0,result.length()-1));
    }


    public static String isVPS(String str) {

        int stack = 0;

        for(char c : str.toCharArray()) {
            if(c == '(') {
                stack++;
            }
            if(c == ')') {
                stack--;
                if(stack < 0) return "NO";
            }
        }


        return stack == 0 ? "YES" : "NO";
    }

    public static String isVPSWithHash(String str) {

        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : str.toCharArray()) {
            if(c == '(' || c == ')') {
                map.put(c, map.getOrDefault(c,0)+1);
            }
        }

        if(map.get('(') == map.get(')') && map.get('(') > 0) {
            return "YES";
        } else {
            return "NO";
        }

    }
}
