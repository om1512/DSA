class Solution {
    int solve(List<List<Integer>> t, int row, int index, int[][] dp){
        if(row == t.size()){
            return 0;
        }        
        if(dp[row][index] != Integer.MAX_VALUE) {
            return dp[row][index];
        }
        return dp[row][index] = t.get(row).get(index) + Math.min(solve(t, row + 1, index, dp), solve(t, row + 1, index + 1, dp));

    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size() + 1];
        
        for(int i = 0; i < triangle.size(); i++) {
            for(int j = 0; j < triangle.size(); j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        


        return solve(triangle, 0, 0, dp);
    }
}