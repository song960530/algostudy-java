package week7.이근형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baek_1260 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int root = Integer.parseInt(input[2]);

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            String[] vertex = br.readLine().split(" ");
            int node1 = Integer.parseInt(vertex[0]);
            int node2 = Integer.parseInt(vertex[1]);
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        br.close();

        for(int i = 1; i <= 4; i++) {
            System.out.println(graph.get(i).toString());
        }
    }

//    public String dfs(List<List<Integer>> graph, int root) {
//
//    }
//
//    public String bfs(List<List<Integer>> graph, int root) {
//
//    }
}
