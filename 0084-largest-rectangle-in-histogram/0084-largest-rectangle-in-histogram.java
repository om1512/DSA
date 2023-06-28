class Solution {
  class Pair {
    int a;
    int b;

    Pair(int a, int b) {
      this.a = a;
      this.b = b;
    }
  }

     public int[] leftSmall(int[] arr) {
    int[] ans = new int[arr.length];
    Stack<Pair> stack = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      while (!stack.isEmpty() && stack.peek().a >= arr[i]) {
        stack.pop();
      }
      if (!stack.isEmpty())
        ans[i] = stack.peek().b + 1;
      else
        ans[i] = 0;
      stack.push(new Pair(arr[i], i));
    }
    return ans;
  }

  public int[] rightSmall(int[] arr) {
    int[] ans = new int[arr.length];
    Stack<Pair> stack = new Stack<>();
    for (int i = arr.length-1; i>=0 ; i--) {
      while (!stack.isEmpty() && stack.peek().a >= arr[i]) {
        stack.pop();
      }
      if (!stack.isEmpty())
        ans[i] = stack.peek().b - 1;
      else
        ans[i] = arr.length-1;
      stack.push(new Pair(arr[i], i));
    }
    return ans;
  }

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 1)
        return heights[0];

        int[] left = leftSmall(heights);
        int[] right = rightSmall(heights);
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
        int width = (right[i] - left[i]) + 1;
        ans = Math.max(ans, width * heights[i]);
        }
        return ans;
    }
}