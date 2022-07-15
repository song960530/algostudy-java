package week8.이근형;

public class Leet1791 {
    public int findCenter(int[][] edges) {
        // 중앙에 있는 노드는 n - 1개의 노드와 연결된다.
        // 노드의 번호 순서대로 순차적으로 방문한다.
        // 핵심은 첫번째 연결과 두번째 연결의 공통 노드를 찾으면 되는 것

        if(edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) {
            return edges[0][0];
        }
        return edges[0][1];
    }
}
