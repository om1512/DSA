class Solution {
     public static String removeLeadingZeros(String str)
    {
        String regex = "^0+(?!$)";
        str = str.replaceAll(regex, "");
      
        return str;
    }
    public String removeKdigits(String num, int k) {
        String ans = "";
        Stack<Integer> s  = new Stack<>();
        for(int i=0;i<num.length();i++){
        char c = num.charAt(i);
        while(k>0 && !s.isEmpty() && Character.getNumericValue(c) < s.peek()){
            s.pop();
            k--;
        }
        s.push(Character.getNumericValue(c));
        }
        while(k-->0){
            s.pop();
        }
        while(!s.isEmpty()){
            ans = s.pop() + ans;
        }
        if(!ans.isEmpty()) return removeLeadingZeros(ans);;
        return "0";
    }
}