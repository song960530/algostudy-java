package baekjoon;

/*
    백준 스택
    오큰수
 */
import java.util.*;
public class Ex_17298 {
    public static Scanner sc;
    public static int T;
    public static int[] arr;
    public static LinkedList<Integer> result;


    public static void input() {
        sc = new Scanner(System.in);
        T = sc.nextInt();

        arr = new int[T];
        result = new LinkedList<>();
        for(int i=0; i<T; i++) {
            arr[i] = sc.nextInt();
        }

    }

    public static void main(String[] args) {
        input();
        NGE();
        /*
        for(int i : arr) {
            System.out.print(i+" ");
        }

        */
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<arr.length;i++){
            sb.append(arr[i]).append(' ');
        }

        System.out.println(sb);


    }

    public static void NGE() {
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<T; i++) {

            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                arr[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            arr[stack.pop()] = -1;
        }
    }


    public static void NGEWithDoubleFor() {

        for(int i=0; i<T; i++) {
            int num = arr[i];
            boolean flag = false;
            for(int j=i+1; j<T; j++) {
                if(!flag) {
                    if(arr[j] > num) {
                        result.add(arr[j]);
                        flag = true;
                    }
                } else {
                    continue;
                }
            }
            if(!flag) result.add(-1);
        }
    }
}
