class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer> m = new HashMap<>();
        List<Integer> l = new ArrayList<>();
        int n = nums.length;
        int min = n/3;
        for(int i=0;i<n;i++){
            m.put(nums[i],m.getOrDefault(nums[i],0)+1);
            if(m.getOrDefault(nums[i],0) > min && !l.contains(nums[i])){
                l.add(nums[i]);
            }
        }

        return l;
    }
}