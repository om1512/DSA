class Solution {
    public int minOperations(String[] logs) {
        int count = 0;
        for(String str : logs){
            String[] temp = str.split("/");
            System.out.println(temp[0]);
            if(temp[0].equals(".")){
                continue;
            }else if(temp[0].equals("..")){
                if(count > 0) count--;
            }else{
                count++;
            }
        }

        return (count < 0) ? 0 : count;
    }
}