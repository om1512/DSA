class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i:nums){
            if(i != val){
                count++;
                list.add(i);
            }
        }
        for(int i=0;i<list.size();i++){
            nums[i] = list.get(i);
        }
        return count;
    }
}