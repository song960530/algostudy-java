package week7.박준우;

/*
    프로그래머스 DFS/BFS

 */
import java.util.*;
public class Ex_43164 {

    static class Solution {
        public String[] solution(String[][] tickets) {
            HashMap<Integer, String> map = new HashMap();
            int count = 0;
            for(String[] strs : tickets) {
                for(String s : strs) {
                    if(!map.containsValue(s)) {
                        map.put(count++, s);
                    }
                }
            }
            System.out.println(map);



            String[] answer = {};
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();


        String[][] tickets;
        String[] result;
        tickets = new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        result = solution.solution(tickets);
        for(String s : result) {
            System.out.print(s+" "); // ICN, JFK, HND, IAD
        }
        System.out.println();


        tickets = new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        result = solution.solution(tickets);
        for(String s : result) {
            System.out.print(s+" "); // ICN, ATL, ICN, SFO, ATL, SFO
        }
        System.out.println();





    }
}
