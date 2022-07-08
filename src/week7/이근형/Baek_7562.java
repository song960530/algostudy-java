package week7.이근형;

// https://www.acmicpc.net/problem/7562

import java.util.*;
import java.io.*;

public class Baek_7562 {
    static int size;
    static int[][] table;
    static StringBuilder result = new StringBuilder();
    static int targetX, targetY;
    static int[] moveX = {2, 2, -2, -2, 1, -1, 1, -1};
    static int[] moveY = {1, -1, 1, -1, 2, 2, -2, -2};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            size = Integer.parseInt(br.readLine());
            table = new int[size][size];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int curnX = Integer.parseInt(st.nextToken());
            int curnY = Integer.parseInt(st.nextToken());
            Pointer root = new Pointer(curnX, curnY, 0);

            StringTokenizer st2 = new StringTokenizer(br.readLine());
            targetX = Integer.parseInt(st2.nextToken());
            targetY = Integer.parseInt(st2.nextToken());

            visited = new boolean[size][size];
            bfs(root);
        }

        System.out.println(result);
    }

    static void bfs(Pointer root) {
        Queue<Pointer> que = new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty()) {
            Pointer curn = que.poll();

            if(curn.x == targetX && curn.y == targetY) {
                result.append(curn.count + "\n");
                break;
            }

            for(int i = 0; i < 8; i++) {
                int nX = moveX[i] + curn.x;
                int nY = moveY[i] + curn.y;

                if(nX >=0 && nY >= 0 && nX < size && nY < size && !visited[nX][nY]) {
                    que.offer(new Pointer(nX, nY, curn.count + 1));
                    visited[nX][nY] = true;
                }
            }
        }
    }

    static class Pointer {
        int x;
        int y;
        int count;

        public Pointer(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}