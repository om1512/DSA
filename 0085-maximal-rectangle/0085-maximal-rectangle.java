class Solution {
   static class Pair {
    int a;
    int b;

    Pair(int a, int b) {
      this.a = a;
      this.b = b;
    }
  }

  public static int[] leftSmall(int[] arr) {
    int[] ans = new int[arr.length];
    Stack<Pair> stack = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      while (!stack.isEmpty() && stack.peek().a >= arr[i]) {
        stack.pop();
      }
      if (!stack.isEmpty()) {
        ans[i] = stack.peek().b + 1;
      } else {
        ans[i] = 0;
      }
      stack.push(new Pair(arr[i], i));
    }
    return ans;
  }

  public static int[] rightSmall(int[] arr) {
    int[] ans = new int[arr.length];
    Stack<Pair> stack = new Stack<>();
    for (int i = arr.length - 1; i >= 0; i--) {
      while (!stack.isEmpty() && stack.peek().a >= arr[i]) {
        stack.pop();
      }
      if (!stack.isEmpty()) {
        ans[i] = stack.peek().b - 1;
      } else {
        ans[i] = arr.length - 1;
      }
      stack.push(new Pair(arr[i], i));
    }
    return ans;
  }

  static int histogram(int[] arr) {
    int ans = 0;
    int[] left = leftSmall(arr);
    int[] right = rightSmall(arr);
    for (int i = 0; i < arr.length; i++) {
      ans = Math.max(ans, ((right[i] - left[i]) + 1) * arr[i]);
    }
    return ans;
  }

  public static int maximalRectangle(char[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    int max = 0;
    for (int k = 0; k < rows; k++) {
      int[] colHisto = new int[cols];
      for (int i = 0; i < cols; i++) {
        int colCount = 0;
        for (int j = 0; j <= k; j++) {
          if (matrix[j][i] == '1') {
            colCount++;
          } else {
            colCount = 0;
          }
        }
        colHisto[i] = colCount;
      }
      max = Math.max(max, histogram(colHisto));
    }
    return max;
  }
}   