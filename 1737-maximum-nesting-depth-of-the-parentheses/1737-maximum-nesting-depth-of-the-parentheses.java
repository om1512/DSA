class Solution {
    public int maxDepth(String s) {
        int maxdepth = Integer.MIN_VALUE;
        char[] c = s.toCharArray();
        int open = 0;
        int pair = 0;
        for(char i:c){
            
            if(i == '('){
                open++;
            }else if(i == ')'){
                if(open >0) open--;
            }
            pair = Math.max(pair,open);
            if(open == 0){
                maxdepth = Math.max(maxdepth,pair);
                pair = 0;
            }
        }
        return maxdepth;
    }
}