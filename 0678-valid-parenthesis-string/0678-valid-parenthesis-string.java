class Solution {
    public boolean checkValidString(String s) {
        int open=0, close=0;
        for(char x: s.toCharArray()){
        if(x == ')')
        open--;
        else
        open++;
        if(open < 0)
        return false;
        }
        for(int i=s.length()-1; i>=0; i--){
        if(s.charAt(i) == '(')
        close--;
        else
        close++;
        if(close < 0)
            return false;
        }
        return true;
    }
}