class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> l = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            ArrayList<Integer> subList = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j == 0 || j == i){
                    subList.add(j,1);
                }else{
                    subList.add(j,l.get(i-1).get(j-1) + l.get(i-1).get(j));
                }
            }
            l.add(subList);
        }
        return l;
    }
}