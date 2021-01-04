class RotateImage {

  public void rotate(int[][] arr) {
    transpose(arr);
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length / 2; j++) {
        int temp = arr[i][j];
        arr[i][j] = arr[i][arr.length - 1 - j];
        arr[i][arr.length - 1 - j] = temp;
      }
    }
  }

  public static void transpose(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        if (i < j) {
          swap(i, j, arr);
        }
      }
    }
  }

  public static void swap(int i, int j, int[][] arr) {
    int temp = arr[i][j];
    arr[i][j] = arr[j][i];
    arr[j][i] = temp;
  }
}