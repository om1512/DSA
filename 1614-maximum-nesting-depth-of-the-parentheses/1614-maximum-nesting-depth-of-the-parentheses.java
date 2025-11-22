class Solution {
    public int maxDepth(String s) {
        int maxDepth = 0;
        int p = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                p++;
                maxDepth = Math.max(maxDepth, p);
            }else if(c == ')'){
                p--;
            }
        }

        return maxDepth;
    }
}