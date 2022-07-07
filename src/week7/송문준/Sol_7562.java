package week7.송문준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Sol_7562 {
    static Queue<Position> queue = new LinkedList<>();
    static String command[] = new String[3];
    static boolean chess[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loopCnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < loopCnt; i++) {
            queue.clear();
            inputCommand(br); // input값 받기
            Position findPosition = null;

            chess = createChess();
            Position startPosition = createPosition(1);
            Position endPosition = createPosition(2);

            queue.offer(startPosition);

            while (!queue.isEmpty()) {
                findPosition = findFlag(queue.poll(), endPosition);

                if (findPosition != null)
                    break;
            }

            System.out.println(findPosition.cnt);
        }
    }

    private static Position findFlag(Position position, Position endPosition) {
        if (position.x < 0 || position.y < 0 || position.x > chess.length - 1 || position.y > chess[0].length - 1 || chess[position.x][position.y]) {
            return null;
        }

        chess[position.x][position.y] = true;

        if (endPosition.equals(position)) {
            return position;
        }

        queue.offer(new Position(position.x - 2, position.y - 1, position.cnt + 1));
        queue.offer(new Position(position.x - 2, position.y + 1, position.cnt + 1));
        queue.offer(new Position(position.x + 2, position.y - 1, position.cnt + 1));
        queue.offer(new Position(position.x + 2, position.y + 1, position.cnt + 1));
        queue.offer(new Position(position.x - 1, position.y - 2, position.cnt + 1));
        queue.offer(new Position(position.x - 1, position.y + 2, position.cnt + 1));
        queue.offer(new Position(position.x + 1, position.y - 2, position.cnt + 1));
        queue.offer(new Position(position.x + 1, position.y + 2, position.cnt + 1));

        return null;
    }

    private static boolean[][] createChess() {
        return new boolean[Integer.parseInt(command[0])][Integer.parseInt(command[0])];
    }

    private static Position createPosition(int x) {
        Position startPosition = new Position(Integer.parseInt(command[x].split(" ")[0]), Integer.parseInt(command[x].split(" ")[1]));
        return startPosition;
    }

    private static void inputCommand(BufferedReader br) throws IOException {
        for (int j = 0; j < 3; j++) {
            command[j] = br.readLine();
        }
    }

    static class Position {
        int x;
        int y;
        int cnt;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
            cnt = 0;
        }

        public Position(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        public boolean equals(Position input) {
            return x == input.x && y == input.y;
        }
    }
}
