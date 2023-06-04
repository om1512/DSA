class Solution {
    static String rightRotation(String s){
      return s.substring(1) + s.substring(0,1);
    }
    public boolean rotateString(String str, String str2) {
        int count = 0;
        while(count<str.length()){
            str = rightRotation(str);
            if(str.equals(str2)){
                return true;
            }
            count++;
        }   
        return false;
    }
}