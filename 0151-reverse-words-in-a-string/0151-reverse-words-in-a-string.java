class Solution {
    public String reverseWords(String s) {
        String[] test = s.trim().split(" ");
        StringBuffer ans = new StringBuffer();
        for(int i=test.length-1;i>=0;i--){
            if(!test[i].isEmpty()){
                ans.append(test[i].trim()+" ");
            }
        }
        return ans.toString().trim();
    }
}