class Solution {
    public static int peekFinder(int[] nums,int low,int high,int n){
        int mid = (low+high)/2;
        if((mid == 0 || nums[mid-1]<=nums[mid]) && (mid == n-1 || nums[mid+1] <= nums[mid])){
            return mid;
        }else if(mid > 0 && nums[mid-1]>nums[mid]){
            return peekFinder(nums,low,mid-1,n);
        }else{
            return peekFinder(nums,mid+1,high,n);
        }
    }
    public int findPeakElement(int[] nums) {
        int n = peekFinder(nums,0,nums.length-1,nums.length);
        return n;
    }
}