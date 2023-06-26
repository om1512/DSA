class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] result = new int[nums1.length];
        int[] ans = new int[n];
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<=arr[i]){
              stack.pop();
            } 
            if(!stack.isEmpty()) ans[i] = stack.peek();
            else ans[i] = -1;
            stack.push(arr[i]);
            for(int j=0;j<nums1.length;j++){
                if(nums1[j] == arr[i]){
                    result[j] = ans[i];
                }
            }
        }
        return result;
    }
}