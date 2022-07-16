package week8.이근형;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leet1971 {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
    // source(시작점) 에서 destination(도착점)으로 가는 경로(edge)가 존재하는지 판별하는 문제
    // BFS 방식

    if(edges.length == 0) return true;

    Queue<Integer> que = new LinkedList<>();
    List<Integer> visited = new LinkedList<>();
    que.add(source);

    while(!que.isEmpty()) {
        int curn = que.poll();

        for(int i = 0; i < edges.length; i++) {
            if(edges[i][0] == curn && !visited.contains(edges[i][1])) {
                que.add(edges[i][1]);
                visited.add(edges[i][1]);
            }

            if(edges[i][1] == curn && !visited.contains(edges[i][0])) {
                que.add(edges[i][0]);
                visited.add(edges[i][0]);
            }
        }

        if(que.contains(destination)) {
            return true;
        }
    }
    return false;
}
}
