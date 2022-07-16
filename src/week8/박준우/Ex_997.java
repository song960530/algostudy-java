package week8.박준우;

import java.util.*;

/*
    Leetcode 그래프
    997 Find the Town Judge
 */
public class Ex_997 {

    public int findJudge(int n, int[][] trust) {

        int[] candidates = new int[n+1]; // who has value 0 represent trust nobody
        int[] trustNum = new int[n+1]; // who has value n represent who get all people's trust


        for(int[] relation : trust) {
            int a = relation[0];
            int b = relation[1];
            candidates[a]--; // judge trust nobody, so he or she will be 0
            trustNum[b]++; // judge get all people's trust. it means, judge trustNum will be n
        }

        for(int i=1; i<candidates.length; i++) {
            if(candidates[i]==0 && trustNum[i]==n-1) return i;
        }

        return -1;
    }
}
