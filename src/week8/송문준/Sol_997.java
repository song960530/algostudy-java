package week8.송문준;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Sol_997 {
    public int findJudge(int n, int[][] trust) {
        List<TrustNode> list = new ArrayList<>(); // 접근할땐 i-1로
        int judge = -1;

        // 초기화
        for (int i = 1; i <= n; i++) {
            list.add(new TrustNode(i));
        }

        // 믿는사람 연결
        for (int[] t : trust) {
            list.get(t[0] - 1).trusts.add(list.get(t[1] - 1));
        }

        for (TrustNode trustNode : list) {
            for (TrustNode node : trustNode.trusts) {
                node.trustCnt += 1;
            }
        }

        for (TrustNode trustNode : list) {
            if (trustNode.trustCnt == n - 1) {
                if (trustNode.trusts.size() == 0) {
                    judge = trustNode.idx;
                    break;
                }
            }
        }

        return judge;
    }

    static class TrustNode {
        int idx;
        int trustCnt;
        List<TrustNode> trusts;

        public TrustNode(int idx) {
            this.idx = idx;
            trustCnt = 0;
            trusts = new LinkedList<>();
        }
    }
}
