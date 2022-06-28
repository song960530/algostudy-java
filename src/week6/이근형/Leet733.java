package week6.이근형;

public class Leet733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        int baseColor = image[sr][sc];
        fill(image, sr, sc, color, baseColor);
        return image;

    }

    public void fill(int[][] image, int x, int y, int color, int baseColor) {
        if(x < 0 || y < 0 || x >= image.length || y >= image[0].length || image[x][y] != baseColor) return;

        image[x][y] = color;
        fill(image, x + 1, y, color, baseColor);
        fill(image, x - 1, y, color, baseColor);
        fill(image, x, y + 1, color, baseColor);
        fill(image, x, y - 1, color, baseColor);
    }
}
