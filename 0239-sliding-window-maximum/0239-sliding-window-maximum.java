class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
            Deque<Integer> queue = new ArrayDeque<>();
            int index = 0;
            int[] ans = new int[nums.length - k + 1];
            for (int i = 0; i < nums.length; i++) {
              if (!queue.isEmpty() && queue.peekFirst() == (i - k))
                queue.removeFirst();
              while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.removeLast();
              }
              queue.addLast(i);
              if (i >= k - 1)
                ans[index++] = nums[queue.peekFirst()];
            }
            return ans;
    }
}