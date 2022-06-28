package week6.이근형;

public class Leet695 {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int area = 0;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {

                if(grid[i][j] == 1) {
                    area = Math.max(area, checkLand(grid, i, j));
                }
            }
        }
        return area;
    }

    public int checkLand(int[][] grid, int x, int y) {
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0) return 0;
        grid[x][y] = 0;
        return 1 + checkLand(grid, x + 1, y)
                + checkLand(grid, x - 1, y)
                + checkLand(grid, x, y + 1)
                + checkLand(grid, x, y - 1);
    }
}
