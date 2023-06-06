class Solution {
    int maxLen=0, st = 0;
    public String longestPalindrome(String s) {
        int n = s.length();
        char[] c = s.toCharArray();
        if(n<2) return s;
        for(int i=0;i<n;i++){
            expand(c,i,i);
            expand(c,i,i+1);
        }
        return s.substring(st,st+maxLen);
    }
    void expand(char[] c,int l,int r){
            while(l>=0 && r<c.length && c[l] == c[r]){
                l--;
                r++;
            }
            if((r-l-1) > maxLen){
                maxLen= (r-l-1);
                st = l+1;
            }
    }
}