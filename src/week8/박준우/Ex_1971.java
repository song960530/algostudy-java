package week8.박준우;

import java.util.*;

/*
    Leetcode 그래프
    1971 Find if Path Exists in Graph
 */
public class Ex_1971 {
    static int totalNodes;
    static boolean flag;
    static boolean[] visited;
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        if(source == destination) return true;

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        totalNodes = n;
        flag = false;
        visited = new boolean[n];

        for(int[] relations : edges) {
            int start = relations[0];
            int end = relations[1];
            if(!map.containsKey(start)) {
                map.put(start, new ArrayList<>());
            }
            if(!map.containsKey(end)) {
                map.put(end, new ArrayList<>());
            }
            map.get(start).add(end);
            map.get(end).add(start);

        }

        findPath(map, source, destination);


        return flag;
    }

    private static void findPath(HashMap<Integer, ArrayList<Integer>> map, int present, int destination) {
        if(visited[present] || flag) return;

        visited[present] = true;

        if(map.get(present) == null) return;

        for(int nextRoute : map.get(present)) {
            if(nextRoute == destination) {
                flag = true;
                break;
            }
            if(!visited[nextRoute]) findPath(map, nextRoute, destination);
        }
    }


}
