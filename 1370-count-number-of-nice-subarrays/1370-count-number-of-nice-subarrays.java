class Solution {
    public int numberOfSubarrays(int[] nums, int goal) {
        for(int i=0;i<nums.length;i++){
            nums[i] = (nums[i] % 2 != 0) ? 1 : 0;
        }
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0,count = 0;
        for(int i=0;i<nums.length;i++){
          sum += nums[i];
          if(sum == goal){
            count++;
          }
          if(map.containsKey(sum-goal)) count+=map.get(sum-goal);
          map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}


// 1 1 0 1 1
// 1 2 2 3 4


// 0 0 0 1 0 0 1 0 0 0
// 0 0 0 1 1 1 2 2 2 2

