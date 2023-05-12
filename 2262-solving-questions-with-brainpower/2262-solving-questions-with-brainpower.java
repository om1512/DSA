class Solution {
    public long mostPoints(int[][] questions) {
        int Q = questions.length;
        long[] dp = new long[Q];
        dp[Q-1] = questions[Q-1][0];
        for(int i = Q-2;i>=0;--i){
            dp[i] = questions[i][0];
            int skip = questions[i][1];
            if(i + skip + 1 < Q){
                dp[i] += dp[i + skip + 1]; 
            }
            dp[i] = Math.max(dp[i],dp[i+1]);
        }
        return dp[0];
    }
}