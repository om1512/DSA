class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s:strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String str = new String(ch);
            List<String> list = new ArrayList<>(map.getOrDefault(str, new ArrayList<>()));
            list.add(s);
            map.put(str, list);
        }
        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String, List<String>>  m : map.entrySet()){
            ans.add(m.getValue());
        }
        return ans;
    }
}