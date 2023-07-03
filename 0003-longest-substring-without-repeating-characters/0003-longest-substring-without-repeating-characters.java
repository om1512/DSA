class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new LinkedHashSet<>();
        int l = 0,r = 0;
        int result = 0;
        while(l<s.length() && r<s.length()){
                while(set.contains(s.charAt(r))){
                    set.remove(s.charAt(l));
                    l += 1;
                }
                set.add(s.charAt(r));
                result = Math.max(result,(r-l)+1);
                r++;
        }
        return result;
    }
}