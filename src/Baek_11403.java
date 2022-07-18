import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_11403 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertex = Integer.parseInt(st.nextToken());
        int[][] graph = new int [vertex][vertex];

        for(int i = 0; i < vertex; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < vertex; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 플로이드 - 와샬
        // => i부터 j까지 존재하는 경로찾기
        // => i부터 k까지, k부터 j까지 경로 여부를 찾는다.

        for(int k = 0; k < vertex; k++) {
            for(int i = 0; i < vertex; i++) {
                for(int j = 0; j < vertex; j++) {
                    if(graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                sb.append(graph[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
