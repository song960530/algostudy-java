import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2606 {
    static int computer, edge, count;
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        computer = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());
        graph = new int[computer + 1][computer + 1];
        visited = new boolean[computer + 1];

        for(int i = 0; i < edge; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from][to] = graph[to][from] = 1;
        }

        count = 0;
        dfs(1);
        System.out.println(count - 1); // 1번 컴퓨터는 제외한다.(1번 컴퓨터를 통해 감염된 바이러스를 찾는 것)
    }

    static void dfs(int start) {
        visited[start] = true;
        count++;

        for(int i = 0; i <= computer; i++) {
            if(graph[start][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}
