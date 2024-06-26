class Solution {
    public int searchInsert(int[] arr, int x) {
        int n = arr.length;
        int l = 0, r = n - 1;
        while(l <= r){
            int mid = (l+r)/2;
            if(arr[mid] == x) return mid;
            else if(arr[mid] < x){
                l = mid+1;
            }else{
                r = mid -1;
            }
        }
        return l;
    }
}