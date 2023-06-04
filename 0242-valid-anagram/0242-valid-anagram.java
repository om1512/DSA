class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character,Integer> m = new HashMap<>();
        for(int i=0;i<s.length();i++){
        m.put(s.charAt(i), m.getOrDefault(s.charAt(i), 0)+1);
        }
        for(int i=0;i<s.length();i++){
        if(m.containsKey(t.charAt(i))){
            m.put(t.charAt(i),m.get(t.charAt(i))-1);
        }else{
            return false;
        }
        }
        Set<Character> keys = m.keySet();
        for (Character key : keys) {
            if (m.get(key) != 0) {
                return false;
            }
        }
        return true;
    }
}