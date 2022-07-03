package week6.송문준;

public class Sol_695 {
    int max = 0;
    int tmp = 0;

    public int maxAreaOfIsland(int[][] grid) {
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                find(grid, x, y);
                max = max < tmp ? tmp : max;
                tmp = 0;
            }
        }

        return max;
    }

    public void find(int[][] grid, int x, int y) {
        if (x == -1 || y == -1 || x == grid.length || y == grid[0].length || grid[x][y] == 0 || grid[x][y] == 99)
            return;

        grid[x][y] = 99;
        tmp += 1;

        find(grid, x - 1, y);
        find(grid, x + 1, y);
        find(grid, x, y - 1);
        find(grid, x, y + 1);

    }
}
