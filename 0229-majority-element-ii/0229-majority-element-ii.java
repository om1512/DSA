class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Arrays.sort(nums);
        int prev = nums[0];
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i] == prev){
                count++;
            }else{
                prev = nums[i];
                if(count > Math.floor(nums.length / 3)){
                    list.add(nums[i - 1]);
                }
                count = 1;
            }
        }
        if(count > Math.floor(nums.length / 3)){
            list.add(nums[nums.length - 1]);
        }

        return list;
    }
}