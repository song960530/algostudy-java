package week10.송문준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 못품
public class BaekJoon_1719 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        // 첫번째줄 read
        int[] cmd = readLine();

        // a -> b까지 가는 경로를 저장하는 배열
        // 최종결과물이 된다
        int[][] route = new int[cmd[0] + 1][cmd[0] + 1];

        // 노드에서 노드르 이동하는 간선정보를 저장하는 배열
        int[][] graph = initMaxValue(cmd[0] + 1, 999999);

        // 입력값 받아서 그래프 그리기
        for (int i = 0; i < cmd[1]; i++) {
            int[] cmd2 = readLine();
            graph[cmd2[0]][cmd2[1]] = cmd2[2];
            graph[cmd2[1]][cmd2[0]] = cmd2[2];

            route[cmd2[0]][cmd2[1]] = cmd2[1];
            route[cmd2[1]][cmd2[0]] = cmd2[0];
        }

        floydWarshall(route, graph);

        // 결과 출력
        print(route);
    }

    private static void floydWarshall(int[][] route, int[][] graph) {
        for (int k = 1; k < graph.length; k++) { // 경유지
            for (int i = 1; i < graph.length; i++) { // 출발지
                for (int j = 1; j < graph.length; j++) { // 도착지
                    int weight = graph[i][k] + graph[k][j];
                    if (weight < graph[i][j]) {
                        graph[i][j] = weight;
                        route[i][j] = route[k][j];
                    }
                }
            }
        }
    }

    private static int[][] initMaxValue(int count, int value) {
        int[][] result = new int[count][count];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                if (i == j) {
                    result[i][j] = 0;
                } else {
                    result[i][j] = value;
                }
            }
        }

        return result;
    }

    private static int[][] fillGraph(int[] cmd) throws IOException {
        int[][] graph = initMaxValue(cmd[0] + 1, Integer.MAX_VALUE);

        for (int i = 0; i < cmd[1]; i++) {
            int[] cmd2 = readLine();
            graph[cmd2[0]][cmd2[1]] = cmd2[2];
            graph[cmd2[1]][cmd2[0]] = cmd2[2];
        }

        return graph;
    }

    private static void print(int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            if (i == 0)
                continue;
            for (int j = 0; j < graph[0].length; j++) {
                if (j == 0)
                    continue;
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }


    private static int[] readLine() throws IOException {
        return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
