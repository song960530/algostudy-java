package leetcode;

import java.util.Stack;

public class Ex_733 {
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int rows = image.length;
        int columns = image[0].length;

        int color = image[sr][sc];

        boolean[][] seen = new boolean[rows][columns];

        print(image);
        fill(seen, image, sr, sc, color, newColor);
        print(image);

        return image;
    }

    public static void fill(boolean[][] seen, int[][] image, int sr, int sc, int init, int newColor) {
        int rows = image.length;
        int columns = image[0].length;

        if( sr>=0
                && sc>=0
                && sc<columns
                && sr<rows
                && !seen[sr][sc]
                && (image[sr][sc]==init) ) {
            image[sr][sc] = newColor;
            seen[sr][sc] = true;
            fill(seen, image, sr+1, sc, init, newColor);
            fill(seen, image, sr, sc+1, init, newColor);
            fill(seen, image, sr-1, sc, init, newColor);
            fill(seen, image, sr, sc-1, init, newColor);
        }
    }

    public static void print(int[][] image) {
        for(int i=0; i<image.length; i++) {
            for(int j=0; j<image[0].length; j++) {
                System.out.print(image[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{0,0,0},{0,0,0}};

        print(floodFill(arr, 0, 0, 2));


        Stack<Integer> stack = new Stack<>();
    }
}
