class Solution {
    public int heightChecker(int[] heights) {
        List<Integer> list = new ArrayList<>(Arrays.stream(heights).boxed().toList());
        Collections.sort(list);
        int ans = 0;
        for(int i=0;i<heights.length;i++){
            if(heights[i] != list.get(i)) ans+=1;
        }
        return ans;
    }
}