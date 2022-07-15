package week8.송문준;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Sol_1791 {
    public int findCenter(int[][] edges) {
        List<StarNode> list = new ArrayList<>(); // 접근할땐 i-1로
        int center = 0;

        // 초기화
        for (int i = 1; i <= edges.length + 1; i++) {
            list.add(new StarNode(i));
        }

        // 링크 연결
        for (int[] t : edges) {
            list.get(t[0] - 1).links.add(list.get(t[1] - 1));
        }

        for (StarNode starNode : list) {
            for (StarNode link : starNode.links) {
                starNode.linkCnt += 1;
                link.linkCnt += 1;

                if (link.linkCnt == edges.length)
                    center = link.idx;
            }
            if (starNode.linkCnt == edges.length)
                center = starNode.idx;

            if (center != 0)
                break;
        }

        return center;
    }

    static class StarNode {
        int idx;
        int linkCnt;
        List<StarNode> links;

        public StarNode(int idx) {
            this.idx = idx;
            linkCnt = 0;
            links = new LinkedList<>();
        }
    }
}
