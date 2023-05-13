class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer> m = new HashMap<>();
        List<Integer> l = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            m.put(nums[i],m.getOrDefault(nums[i],0)+1);
        }
        int min = n/3;
        for(Map.Entry<Integer,Integer> e : m.entrySet()){
            if(e.getValue() > min){
                l.add(e.getKey());
            }
        }

        return l;
    }
}