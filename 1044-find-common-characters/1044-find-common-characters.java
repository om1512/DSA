class Solution {
    public List<String> commonChars(String[] words) {
        int[] ans = new int[26];
        int[] cur = new int[26];
        for(char ch : words[0].toCharArray()){
            ans[ch - 'a']++;
        }
        for(int i=1;i<words.length;i++){
            Arrays.fill(cur, 0);
            for(char ch:words[i].toCharArray()){
                cur[ch - 'a']++;
            }
            for(int j=0;j<26;j++){
                ans[j] = Math.min(ans[j], cur[j]);
            }
        }
        List<String> list = new ArrayList<>();
        for(int i=0;i<26;i++){
            for(int j=0;j<ans[i];j++){
                list.add(String.valueOf((char)(i + 'a')));
            }
        }
        return list;
    }
}