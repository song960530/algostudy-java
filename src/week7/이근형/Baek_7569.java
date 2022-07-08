package week7.이근형;

// https://www.acmicpc.net/problem/7569

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_7569  {
    static int[][][] box;
    static int[] moveX = {1, -1, 0, 0, 0, 0};
    static int[] moveY = {0, 0, 1, -1, 0, 0};
    static int[] moveZ = {0, 0, 0, 0, 1, -1};
    static int count = 0;
    static int col, row, height;
    static Queue<Tomato> que;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        col = Integer.parseInt(st.nextToken()); // m = 가로 = 열
        row = Integer.parseInt(st.nextToken()); // n = 세로 = 행
        height = Integer.parseInt(st.nextToken()); // h = 높이
        box = new int[height][row][col];
        que = new LinkedList<>();

        for(int h = 0; h < height; h++) {
            for(int i = 0; i < row; i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                for(int j = 0; j < col; j++) {
                    int tomato = Integer.parseInt(st2.nextToken());
                    box[h][i][j] = tomato;
                    if(tomato == 1) {
                        que.offer(new Tomato(i, j, h));
                    }
                }
            }
        }
        System.out.println(bfs());
    }

    static int bfs() {
        while(!que.isEmpty()) {
            Tomato tomato = que.poll();

            for(int i = 0; i < 6; i ++) {
                int nX = tomato.x + moveX[i];
                int nY = tomato.y + moveY[i];
                int nZ = tomato.z + moveZ[i];

                if(nX >= 0 && nY >= 0 && nZ >= 0 && nX < row && nY < col && nZ < height && box[nZ][nX][nY] == 0) {
                    // 위와 같은 조건문은 옳은 경우만 생각하는 것이다. 옳지 않은 경우는 생각할 필요가 없다.
                    que.add(new Tomato(nX, nY, nZ));
                    box[nZ][nX][nY] = box[tomato.z][tomato.x][tomato.y] + 1;
                }
            }
        }

        int result = Integer.MIN_VALUE;
        for(int h = 0; h < height; h++) {
            for(int i = 0; i < row; i++) {
                for(int j = 0; j < col; j++) {
                    if(box[h][i][j] == 0) return -1;
                    result = Math.max(result, box[h][i][j]);
                }
            }
        }

        if(result == 1) return 0;
        else return result - 1;
        // 1을 빼는 이유는 최초에 익은 토마토가 1이기 때문이다.
        // 익은 토마토를 기준으로 안익은 토마토를 발견하는 경우, 익은 토마토의 값(= 1) + 1을 한다.
        // 즉, 저장되는 값이 2부터 시작되므로 1을 빼줘야 올바른 계산이다..

    }

    static class Tomato {
        int x;
        int y;
        int z;

        public Tomato(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

}
