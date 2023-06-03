class Solution {
    public int findKthPositive(int[] arr, int k) {
        int count = 1,errorCount  = 0,i =0;
        while(i<arr.length){
            if(count == arr[i]){
                count++;
                i++;
            }else{
                errorCount++;
                if(errorCount == k){
                    return count;
                }
                count++;
            }
        }
        return arr[arr.length-1]+(k-errorCount);
    }
}