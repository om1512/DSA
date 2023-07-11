class Solution {
    public int lengthOfLastWord(String str) {
        String[] strArr = str.split(" ");
      return (strArr[strArr.length-1].length());
    }
}