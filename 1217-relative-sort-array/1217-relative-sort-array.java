class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i : arr1){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int index = 0;
        for(int i=0;i<arr2.length;i++){
            while(map.getOrDefault(arr2[i], 0) != 0){
                arr1[index++] = arr2[i];
                map.put(arr2[i], map.getOrDefault(arr2[i], 0) - 1);
            }
            map.remove(arr2[i]);
        }
        for(Map.Entry<Integer, Integer> m : map.entrySet()){
            while(m.getValue() != 0){
                arr1[index++] = m.getKey();
                map.put(m.getKey(), m.getValue() - 1);
            }
        }
        
        return arr1;
    }
}