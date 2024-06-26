class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        if(x == 0) return true;
        int num = 0;
        int b = x;
        while(x  != 0){
            int n = x%10;
            num = (num*10) + n;
            x /= 10;
        }
        return num == b;
    }
}