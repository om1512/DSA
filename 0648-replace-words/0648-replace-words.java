class Solution {
    static boolean check(String s1, String s2){
        int i = 0;
        while(i < s1.length() && i < s2.length()){
            if(s1.charAt(i) != s2.charAt(i)) return false;
            i++;
        }
        return (i == s1.length());
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        String ans = "";
        String[] splited = sentence.split(" ");
        for(int i=0;i<splited.length;i++){
            for(String sub:dictionary){
                if(check(sub, splited[i])){
                    splited[i] = sub;
                }
            }
        }
        for(String t : splited){
            ans += t + " ";
        }
        return ans.trim();
    }
}