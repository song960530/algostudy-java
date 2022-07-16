package week7.이근형;

import java.util.*;

public class TravelRoute {
    static List<Stack<String>> result;
    static boolean[] visited;
    static String[][] tickets;

    public static void main(String[] args) {
        TravelRoute foo = new TravelRoute();
        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[] result = foo.solution(tickets);
        System.out.println(Arrays.toString(result));
    }

    public String[] solution(String[][] tickets) {
        result = new ArrayList<>();
        this.tickets = tickets;

        visited = new boolean[tickets.length];
        Stack<String> candidate = new Stack<>();
        candidate.push("ICN");

        dfs(candidate, 0);

        if(result.size() > 1) {
            Collections.sort(result, new Comparator<Stack<String>>() {
                @Override
                public int compare(Stack<String> o1, Stack<String> o2) {
                    for(int i = 0; i < o1.size(); i++) {
                        String st1 = o1.get(i);
                        String st2 = o2.get(i);

                        if(!st1.equals(st2)) {
                            return st1.compareTo(st2);
                        }
                    }
                    return 0;
                }
            });
        }

        Stack<String> res = result.remove(0);
        String[] answer = new String[res.size()];

        for(int i = 0; i < answer.length; i++) {
            answer[i] = res.get(i);
        }
        return answer;
    }

    static void dfs(Stack<String> candidate, int len) {
        if(len == tickets.length) {
            Stack<String> res = new Stack<>();
            for(String s : candidate) {
                res.push(s);
            }

            result.add(res);
            return;
        }

        String depart = candidate.peek();
        for(int i = 0; i < tickets.length; i++) {
            String[] route = tickets[i];
            if(!visited[i] && depart.equals(route[0])) {
                candidate.push(route[1]);
                visited[i] = true;
                dfs(candidate, len + 1);
                visited[i] = false;
                candidate.pop();
            }
        }
    }
}
