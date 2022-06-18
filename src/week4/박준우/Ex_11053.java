package baekjoon;
/*
    백준 DP
    11053 가장 긴 증가하는 부분 수열
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.*;

public class Ex_11053 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] nums = new int[t];
        int[] mem = new int[t];

        for(int i=0; i<t; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<t; i++) {
            mem[i] = 1;

            for(int j=0; j<i; j++) {
                if(nums[j] < nums[i] && mem[i] < mem[j]+1) {
                    mem[i] = mem[j] +1;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i=0; i<t; i++) {
            max = mem[i] > max ? mem[i] : max;
        }
        System.out.println(max);
    }

    public static void mainTest(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());


        StringTokenizer st = new StringTokenizer(br.readLine());

        if(t == 1) System.out.println(1);

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> memo = new ArrayList<>();

        //int[] memo = new int[t];

        while(st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        for(int i=0; i<list.size(); i++) {
            Deque<Integer> deque = new LinkedList<>();
            deque.offer(list.get(i));
            for(int j=i+1; j<list.size(); j++) {
                int num = list.get(j);
                int last = deque.peekLast();
                if(num > last) {
                    deque.offer(num);
                }
            }
            //memo[i] = deque.size();
            memo.add(deque.size());
        }

        System.out.println(Collections.max(memo));

    }
}
