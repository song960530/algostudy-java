package leetcode;

public class Ex_695 {
    class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            int max = 0;
            int columns = grid[0].length;
            int rows = grid.length;

            boolean[][] visited = new boolean[rows][columns];

            for(int i=0; i<rows; i++) {
                for(int j=0; j<columns; j++) {
                    if(grid[i][j] == 1 && !visited[i][j]) {
                        max = Math.max(max, area(visited, grid, i, j));
                    }
                }
            }

            return max;


        }


        public int area(boolean[][] visited, int[][] grid, int row, int col) {
            int columns = grid[0].length;
            int rows = grid.length;

            System.out.println();
            System.out.println(rows+":"+columns);
            System.out.println(row+":"+col);

            if(row<0 || col < 0 || row>=rows || col>=columns || visited[row][col] || grid[row][col] == 0) {
                return 0;
            }

            visited[row][col] = true;
            return 1 + area(visited, grid, row+1, col) + area(visited, grid, row, col+1)  + area(visited, grid, row-1, col) + area(visited, grid, row, col-1);


        }

    }
}
