package week7.박준우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Ex_1260 {

    static StringBuilder sb = new StringBuilder();

    static boolean[] visited;
    static int[][] arr;

    static int n, m, v;

    static Queue<Integer> que = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 정점의 수
        m = Integer.parseInt(st.nextToken()); // 간선의 수
        v = Integer.parseInt(st.nextToken()); // 시작 점

        arr = new int[n+1][n+1];
        visited = new boolean[n+1];

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = arr[y][x] = 1;
        }
        dfs(v);

        System.out.println(v);
    }

    public static void dfs(int v) {
        visited[v] = true;
        sb.append(v + " ");
        System.out.println(v);

        for(int i=1; i<=n; i++) {
            if (arr[v][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int v) {
        que.add(v);
        visited[v] = true;

        while(!que.isEmpty()) {
            v = que.poll();
            sb.append(v + " ");

            for(int i=1; i<=n; i++) {
                if(arr[v][i] == 1 && !visited[i]) {
                    que.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
