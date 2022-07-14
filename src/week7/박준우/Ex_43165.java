package week7.박준우;

public class Ex_43165 {

    /*
        프로그래머스 DFS/BFS
        43165 타겟 넘버
     */

    class Solution {

        int count;
        public int solution(int[] numbers, int target) {
            count = 0;
            dfs(numbers, 0, target, 0);

            return count;
        }

        public void dfs(int[] numbers, int depth, int target, int result) {
            if (depth == numbers.length) {
                if(target == result) {
                    count++;
                }
                return;
            }

            int add = result + numbers[depth];
            int sub = result - numbers[depth];

            dfs(numbers, depth+1, target, add);
            dfs(numbers, depth+1, target, sub);

        }
    }
//
//    public static void main(String[] args) {
//        int result;
//        result = Solution.solution(new int[]{1,1,1,1,1}, 3);
//        System.out.println(result); // 5
//
//        result = Solution.solution(new int[]{4,1,2,1}, 4);
//        System.out.println(result); // 2
//    }
}
