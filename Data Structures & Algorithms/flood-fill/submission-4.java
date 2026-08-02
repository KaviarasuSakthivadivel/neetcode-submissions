class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) {
            return image;
        }

        floodFillDFSRecursive(image, sr, sc, image[sr][sc], color);

        return image;
    }

    private void floodFillDFSRecursive(int[][] image, int r, int c, int original, int color) {
        // breaking conditions

        int rows = image.length;
        int columns = image[0].length;
        if(r < 0 || r >= rows || c < 0 || c >= columns || image[r][c] != original) {
            return;
        }

        image[r][c] = color;

        floodFillDFSRecursive(image, r + 1, c, original, color);
        floodFillDFSRecursive(image, r - 1, c, original, color);
        floodFillDFSRecursive(image, r, c + 1, original, color);
        floodFillDFSRecursive(image, r, c - 1, original, color);
    }
}