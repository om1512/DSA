class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, Integer> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for(String s:strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String str = new String(ch);
            if (map.containsKey(str)) {
                ans.get(map.get(str)).add(s);
            } else {
                map.put(str, ans.size());
                ans.add(new ArrayList<>(Arrays.asList(s)));
            }
        }
        
        return ans;
    }
}