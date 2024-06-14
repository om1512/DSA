class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] str = s.split(" ");
        if(str.length != pattern.length()) return false;
        
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for(int i=0;i<pattern.length();i++){
            if(map.containsKey(pattern.charAt(i))){
                if(!map.get(pattern.charAt(i)).equals(str[i])){
                    return false;
                }
            }else if(!set.add(str[i])){
                return false;
            }else{
                map.put(pattern.charAt(i), str[i]);
            }
        }
        return true;
    }
}