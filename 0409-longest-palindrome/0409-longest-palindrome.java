class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }
        int[] count = {0, 0};
        map.forEach((k,v) -> {
            if(v % 2 == 0) count[0]+=v;
            else{
                count[0] += v-1;
                count[1] = 1;
            }
        });
        return count[0] + count[1];
    }
}