class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }
        int count = 0;
        boolean flag = false;
        for(Map.Entry<Character, Integer> m : map.entrySet()){
            if(m.getValue() % 2 == 0) count+=m.getValue();
            else{
                count += m.getValue()-1;
                flag = true;
            }
        }
        return count + ((flag) ? 1 : 0);
    }
}