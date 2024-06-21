class Solution {
    public boolean solve(String s1, String s2, String s3, int i, int j, int k, Boolean[][][] dp){
        if(k == s3.length()) return true; 
        if (dp[i][j][k] != null) return dp[i][j][k];
        boolean one = false, two = false;

        if(i<s1.length() && s3.charAt(k) == s1.charAt(i)){
            one = one | solve(s1, s2, s3, i+1, j, k+1, dp);
        }
        if(j<s2.length() && s3.charAt(k) == s2.charAt(j)){
            two = two | solve(s1, s2, s3, i, j+1, k+1, dp);
        }
        return dp[i][j][k] = (one | two);
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != (s1.length() + s2.length())) return false;
        Boolean[][][] dp = new Boolean[s1.length() + 1][s2.length() + 1][s3.length() + 1];
        return solve(s1, s2, s3, 0, 0, 0, dp);
    }
}