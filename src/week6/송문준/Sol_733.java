package week6.송문준;

public class Sol_733 {
    private int postColor;
    private int preColor;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        preColor = image[sr][sc];
        if (preColor != color) {
            postColor = color;
            floodFill(image, sr, sc);
        }
        return image;
    }

    public void floodFill(int[][] image, int sr, int sc) {
        if (sr == -1 || sc == -1 || sr == image.length || sc == image[0].length || preColor != image[sr][sc])
            return;

        image[sr][sc] = postColor;

        floodFill(image, sr - 1, sc);
        floodFill(image, sr + 1, sc);
        floodFill(image, sr, sc - 1);
        floodFill(image, sr, sc + 1);
    }
}
