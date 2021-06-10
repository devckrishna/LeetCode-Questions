public class FloodFill {
  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    int color = image[sr][sc];
    if (color != newColor)
      helper(image, sr, sc, color, newColor);
    return image;
  }

  public void helper(int[][] image, int i, int j, int color, int newColor) {
    if (i < 0 || j < 0 || i >= image.length || j >= image[0].length || image[i][j] != color) {
      return;
    }
    image[i][j] = newColor;
    helper(image, i + 1, j, color, newColor);
    helper(image, i - 1, j, color, newColor);
    helper(image, i, j + 1, color, newColor);
    helper(image, i, j - 1, color, newColor);
  }
}
