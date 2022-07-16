package week8.박준우;
/*
    Leetcode 그래프
    1791 Find Center of Star Graph
 */
public class Ex_1791 {
    public int findCenter(int[][] edges) {
        int n = edges.length;
        int count = 0;
        int[] status = new int[n+2];

        // CSG will have n-1 nodes;
        // edges array represent n-1 relations.
        // so, CSG will have all node's relations number's edge

        for(int[] relations : edges) {
            int head = relations[0];
            int tail = relations[1];
            status[head]++;
            status[tail]++;
        }

        for(int i=1; i<status.length; i++){
            if(status[i] == n) return i;
        }

        return -1;
    }
}
