class Solution {
    public int appendCharacters(String text1, String text2) {
        int i = 0, j = 0;
        while(i < text1.length() && j < text2.length()){
            if(text1.charAt(i) == text2.charAt(j)){
                i++;
                j++;
            }else{
                i++;
            }
        }
        return text2.length() - j;
    }
}