package baekjoon;

/*
    백준 큐/스텍
    5430  AC
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();



        for(int i=0; i<t; i++) {

            //String str = br.readLine().replaceAll("RR","");
            String str = br.readLine();
            //char[] commands = br.readLine().toCharArray(); // RDD - commands
            char[] commands = str.toCharArray();
            boolean isError = false;

            int arrSize = Integer.parseInt(br.readLine()); //  size of array
            String nums = br.readLine();

            if(arrSize == 0){
                sb.append("error\n");
            } else {
                /*
                nums = nums.substring(1,nums.length()-1);
                Deque<Integer> deque = Stream.of(nums.split(",")).mapToInt(Integer::parseInt).collect(LinkedList::new, List::add, List::addAll);
                */
                StringTokenizer st = new StringTokenizer(nums,"[],");
                Deque<Integer> deque = new ArrayDeque<Integer>();

                for(int j=0; j<arrSize; j++) {
                    deque.add(Integer.parseInt(st.nextToken()));
                }

                /*
                    R 뒤집기 - 배열에 있는 수의 순서를 뒤집는 함수
                    D 버리기 - 첫번째 수를 버리는 함수, 단 배열이 비어있다면 error발생
                 */
                boolean isReversed = false;

                for(char c : commands) {

                    if(c == 'R') {
                        isReversed = !isReversed;
                        continue;
                    }

                    if(isReversed) {
                        if(deque.pollLast() == null) {
                            sb.append("error\n");
                            isError = !isError;
                            break;
                        }
                    } else {
                        if(deque.pollFirst() == null) {
                            sb.append("error\n");
                            isError = !isError;
                            break;
                        }
                    }

                }


                if(!deque.isEmpty()) {
                    sb.append("[");

                    if(isReversed) {
                        while(!deque.isEmpty()) {
                            sb.append(deque.pollLast() + ",");
                        }
                    } else {
                        while(!deque.isEmpty()) {
                            sb.append(deque.pollFirst() + ",");
                        }
                    }


                    sb.deleteCharAt(sb.length() - 1);
                    sb.append("]\n");
                } else if(!isError) {
                    sb.append("[]\n");
                }

            }


        }
        System.out.print(sb);
    }

}


/*
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        ArrayDeque<Integer> deque = new ArrayDeque<>();


        for(int i=0; i<t; i++) {

            String str = br.readLine().replaceAll("RR","");
            //char[] commands = br.readLine().toCharArray(); // RDD
            char[] commands = str.toCharArray();
            boolean isError = false;

            int arrSize = Integer.parseInt(br.readLine()); // 4 size of array
            String nums = br.readLine();

            if(arrSize == 0){
                //System.out.println("error");
                sb.append("error\n");
            } else {
                nums = nums.substring(1,nums.length()-1);
                LinkedList<Integer> intArray = Stream.of(nums.split(",")).mapToInt(Integer::parseInt).collect(LinkedList::new, List::add, List::addAll);

                boolean isReversed = false;

                            for(char c : commands) {
                    if(c=='R') {
                        isReversed = !isReversed;
                    } else if (c == 'D') {
                        if(intArray.isEmpty()) {
                            sb.append("error\n");
                            isError = !isError;
                            break;
                        }else {
                            if(isReversed) {
                                intArray.remove(intArray.size()-1);

                            } else {
                                intArray.remove(0);

                            }
                        }

                    }
                }

                if(isReversed) Collections.reverse(intArray);

                if(!intArray.isEmpty()) {
        sb.append("[");
        for (int num : intArray) {
            sb.append(num + ",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]\n");
    } else if(!isError) {
        sb.append("[]\n");
    }

}


        }
                System.out.print(sb.substring(0,sb.length()-1));

                }
     */