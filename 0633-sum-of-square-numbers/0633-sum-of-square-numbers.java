class Solution {
    public boolean judgeSquareSum(int c) {
        long i = 0, j = (long)Math.sqrt(c);
        while(i <= j){
            long s = (i*i) + (j*j);
            if(c == s) return true;
            else if(c > s) i++;
            else j--;
        }
        return false;
    }
}