class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int j = 0;
        int count = 0;
        while(j < arr.length){
            if(arr[j] % 2 != 0){
                count+=1;
                if(count == 3) return true;
            }else{
                count=0;
            }
            j++;
        }
        return count == 3;
    }
}