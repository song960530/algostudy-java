package week7.박준우;
/*
    백준 DFS/BFS
    7562 나이트의 이동
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Ex_7562 {

    static int size, curr_x, curr_y, target_x, target_y;
    static int[][] map;
    static int[][] visited;
    static int[] movalbe_x = {-1,-2,-2,-1,1,2,2,1};
    static int[] movalbe_y = {-2,-1,1,2,2,1,-1,-2};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());


        for(int i=0; i<t; i++){
            size = Integer.parseInt(br.readLine());
            map = new int[size+1][size+1];
            visited = new int[size+1][size+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            curr_x = Integer.parseInt(st.nextToken());
            curr_y = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            target_x = Integer.parseInt(st.nextToken());
            target_y = Integer.parseInt(st.nextToken());
            // System.out.println(bfs_recur(curr_x, curr_y, 0));
            bfs(curr_x, curr_y);
            sb.append(visited[target_x][target_y]+"\n");
        }
        System.out.println(sb);
    }
    /*
        나이트가 움직일 수 있는 경우
        1 (x+1) (y+2)
        2 (x+2) (y+1)
        3 (x-1) (y+2)
        4 (x-2) (y+1)
        5 (x-2) (y-2)
        6 (x-2) (y-1)
        7 (x+1) (y-2)
        8 (x+2) (y-1)
     */

    public static void bfs(int curr_x, int curr_y) {
        Queue<XY> queue = new LinkedList<>();
        queue.add(new XY(curr_x, curr_y));
        visited[curr_x][curr_y] = 0;

        while(!queue.isEmpty()) {
            XY cursor = queue.poll();

            if(cursor.x == target_x && cursor.y == target_y) break;

            for(int i=0; i<8; i++) {
                int new_x = cursor.x + movalbe_x[i];
                int new_y = cursor.y + movalbe_y[i];
                if(new_x >= 0
                        && new_x < size
                        && 0 <= new_y
                        && new_y < size
                        ) {
                    if((visited[new_x][new_y]==0 || visited[cursor.x][cursor.y]+1 < visited[new_x][new_y])){
                        visited[new_x][new_y] = visited[cursor.x][cursor.y]+1;
                        queue.add(new XY(new_x, new_y));
                    }

                }
            }
        }
    }

    public static int bfs_stack(int curr_x, int curr_y) {
        Queue<XY> queue = new LinkedList();
        queue.add(new XY(curr_x, curr_y));
        int count = 1;
        while(queue.peek().x != target_x && queue.poll().y != target_y){
            XY cursor = new XY(queue.peek().x, queue.peek().y);
            System.out.println(cursor);
            queue.poll();
            queue.add(new XY(cursor.x+1, cursor.y+2));
            queue.add(new XY(cursor.x+2, cursor.y+1));
            queue.add(new XY(cursor.x-1, cursor.y+2));
            queue.add(new XY(cursor.x-2, cursor.y+1));
            queue.add(new XY(cursor.x-2, cursor.y-2));
            queue.add(new XY(cursor.x-2, cursor.y-2));
            queue.add(new XY(cursor.x+1, cursor.y-2));
            queue.add(new XY(cursor.x+2, cursor.y-1));
            count++;
        }
        return count;

//        if(curr_x >= 0 && curr_x < size && curr_y >= 0 && curr_y < size && !visited[curr_x][curr_y]) {
//
//        }
    }

/*
    public static int bfs_recur(int curr_x, int curr_y, int count) {
        // map [x][y]

        if(curr_x < 0 || curr_x > size || curr_y < 0 || curr_y > size || visited[curr_x][curr_y]) {
            return 0;
        }

        visited[curr_x][curr_y] = true;

        if(curr_x == target_x && curr_y == target_y) {
            return count;
        } else {
            bfs_recur(curr_x+1, curr_y+2, count+1);
            bfs_recur(curr_x+2, curr_y+1, count+1);
            bfs_recur(curr_x-1, curr_y+2, count+1);
            bfs_recur(curr_x-2, curr_y+1, count+1);
            bfs_recur(curr_x-2, curr_y-2, count+1);
            bfs_recur(curr_x-2, curr_y-1, count+1);
            bfs_recur(curr_x+1, curr_y-2, count+1);
            bfs_recur(curr_x+2, curr_y-1, count+1);
        }
        return -1;
    }

*/
    public static class XY {
        int x;
        int y;

        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "XY{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

}
