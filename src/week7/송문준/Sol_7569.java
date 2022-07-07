package week7.송문준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Sol_7569 {
    static int tomato[][][];
    static Queue<Position> queue = new LinkedList<>();
    static int zeroCnt = 0;
    static int day = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int yxz[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        tomato = new int[yxz[1]][yxz[0]][yxz[2]];

        init(br, yxz);


        if (zeroCnt != 0) {
            while (!queue.isEmpty()) {
                Position position = queue.poll();

                spreadTomato(position);
            }
        }

        System.out.println(zeroCnt < 1 ? day : -1);
    }

    private static void spreadTomato(Position position) {
        if (position.x < 0 || position.y < 0 || position.z < 0
                || position.y > tomato.length - 1 || position.x > tomato[0].length - 1 || position.z > tomato[0][0].length - 1
                || (position.day != 0 && tomato[position.y][position.x][position.z] != 0)) {
            return;
        }

        tomato[position.y][position.x][position.z] = 1;

        day = position.day;
        if (day != 0)
            zeroCnt--;

        queue.offer(new Position(position.x - 1, position.y, position.z, position.day + 1));
        queue.offer(new Position(position.x, position.y - 1, position.z, position.day + 1));
        queue.offer(new Position(position.x, position.y, position.z - 1, position.day + 1));
        queue.offer(new Position(position.x + 1, position.y, position.z, position.day + 1));
        queue.offer(new Position(position.x, position.y + 1, position.z, position.day + 1));
        queue.offer(new Position(position.x, position.y, position.z + 1, position.day + 1));
    }

    private static void init(BufferedReader br, int[] yxz) throws IOException {
        for (int z = 0; z < yxz[2]; z++) {
            for (int y = 0; y < yxz[1]; y++) {
                int input[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int x = 0; x < input.length; x++) {
                    tomato[y][x][z] = input[x];

                    if (input[x] == 1)
                        queue.offer(new Position(x, y, z));
                    else if (input[x] == 0)
                        zeroCnt++;
                }
            }
        }
    }

    static class Position {
        int x;
        int y;
        int z;
        int day;

        public Position(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.day = 0;
        }

        public Position(int x, int y, int z, int day) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.day = day;
        }
    }

}
