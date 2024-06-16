class Solution {
    
    public long countCompleteDayPairs(int[] hours) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long count = 0;
        for(int i:hours){
            int rem = i % 24;
            int com = (24 - rem) % 24;
            if(map.containsKey(com)){
                count+=map.get(com);
            }
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return count;
    }
}