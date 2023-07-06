class Solution {
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int ans = 0;
        int left = 0;
        int mostFreqLatter = 0;
        int n = s.length();
        for(int right = 0;right<n;right++){
            arr[s.charAt(right) - 'A']++;
            mostFreqLatter = Math.max(mostFreqLatter,arr[s.charAt(right) - 'A']);
            int changes = (right-left+1) - mostFreqLatter;
            if(changes>k){
                arr[s.charAt(left) - 'A']--;
                left++;
            }
            ans = Math.max(ans,(right-left+1));
        }
        return ans;
    }
}