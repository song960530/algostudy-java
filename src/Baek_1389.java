import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1389 {

    // KB 값이란, 특정 노드를 시작점으로 모든 노드를 편도로 방문하는데 걸리는 간선의 가중치
    // 문제에서는 가중치가 없지만 결국 모든 간선의 가중치는 1이다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertex = Integer.parseInt(st.nextToken());
        int edges = Integer.parseInt(st.nextToken());
        final int INF = 5001;

        int[][] graph = new int[vertex + 1][vertex + 1];

        // 그래프 초기화
        for(int i = 1; i <= vertex; i++) {
            for(int j = 1; j <= vertex; j++) {
                if(i == j) {
                    graph[i][j] = 0; // 자기 자신을 가리키는 경로
                }
                else {
                    graph[i][j] = INF;
                }
            }
        }

        for(int i = 0; i < edges; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from][to] = graph[to][from] = 1;
        }

        // 플로이드 와샬
        for(int k = 1; k <= vertex; k++) {
            for(int i = 1; i <= vertex; i++) {
                for(int j = 1; j <= vertex; j++) {
                    if(graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

        int[] candidate = new int [vertex + 1];
        int min = Integer.MAX_VALUE;

        for(int i = 1; i <= vertex; i++) {
            int total = 0;
            for(int j = 1; j <= vertex; j++) {
                total += graph[i][j];
            }
            candidate[i] = total;
            if(min > total) {
                min = total;
            }
        }

        for(int i = 1; i <= vertex; i++) {
            if(candidate[i] == min) {
                System.out.println(i);
                return;
            }
        }
    }
}
