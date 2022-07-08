package week7.이근형;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/1260

public class Baek_1260 {

    static int[][] graph;
    static int node, vertex, root;
    static boolean[] visited;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        vertex = Integer.parseInt(st.nextToken());
        root = Integer.parseInt(st.nextToken());
        graph = new int[node + 1][node + 1];

        for(int i = 0; i < vertex; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st2.nextToken());
            int to = Integer.parseInt(st2.nextToken());
            graph[from][to] = graph[to][from] = 1;
        }

        visited = new boolean[node + 1];
        dfs(root);
        visited = new boolean[node + 1];
        result.append("\n");
        bfs(root);
        System.out.println(result);
    }

    static void dfs(int root) {
        if(visited[root]) return;

        visited[root] = true;
        result.append(root + " ");
        for(int i = 1; i <= node; i++) {
            if(graph[root][i] == 1) {
                dfs(i);
            }
        }
    }

    static void bfs(int root) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(root);
        visited[root] = true;

        while(!que.isEmpty()) {
            int curn = que.poll();
            result.append(curn + " ");

            for(int i = 1; i <= node; i++) {
                if(graph[curn][i] == 1 && !visited[i]) {
                    que.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
