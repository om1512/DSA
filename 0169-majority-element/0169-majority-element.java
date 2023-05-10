class Solution {
    public int majorityElement(int[] nums) {
        int max = Integer.MIN_VALUE;
        int val = 0;
        Map<Integer,Integer> m = new HashMap<>();
        for(int i:nums){
            m.put(i, m.getOrDefault(i,0)+1);
        }
        for(Map.Entry<Integer,Integer> i : m.entrySet()){
            if(max < i.getValue()){
                max = i.getValue();
                val = i.getKey();
            }
        }
        return val;
    }
}