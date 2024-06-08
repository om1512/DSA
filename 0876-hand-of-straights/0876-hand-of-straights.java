class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i:hand){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }  
        int[] card = new int[map.size()];
        int index = 0;
        for(int i:map.keySet()){
            card[index++] = i;
        }
        Arrays.sort(card);
        for(int key: card){
            if(map.get(key) > 0){
                int start = map.get(key);
                for(int i=key;i<key+groupSize;i++){
                    if(map.getOrDefault(i,  0) < start){
                        return false;
                    }
                    map.put(i, map.get(i) - start);
                }
            }
        }
        return true;
    }
}