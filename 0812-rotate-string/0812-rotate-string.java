class Solution {
    public boolean rotateString(String str, String str2) {
        if(str.length() != str2.length()) return false;
        String temp = str+str;
        if(temp.indexOf(str2) != -1) return true;
        return false;
    }
}