package week8.이근형;

public class Leet997 {
    public int findJudge(int n, int[][] trust) {
        // 마을 사람은 모두 town judge를 신뢰한다.
        // town judge는 아무도 신뢰하지 않는다.
        // 즉, town judge가 존재한다면 모든 마을 사람들의 신뢰(n - 1명)를 받아야한다.

        int[] in = new int[n + 1];
        int[] out = new int[n + 1];

        for(int i = 0; i < trust.length; i++) {
            out[trust[i][0]]++;
            in[trust[i][1]]++;
        }

        for(int i = 1; i <= n; i++) {
            if(out[i] == 0 && in[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
