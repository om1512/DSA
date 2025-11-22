class Solution {
    public boolean isAnagram(String s, String t) {
        int[] ch1 = new int[26];
        int[] ch2 = new int[26];
        if(s.length() != t.length()) return false;
        for(int i = 0; i< s.length(); i++){
            ch1[s.charAt(i) - 'a']+=1;
            ch2[t.charAt(i) - 'a']+=1;
        }
        for(int i = 0; i<26; i++){
            if(ch1[i] != ch2[i]){
                return false;
            }
        }
        return true;
    }
}