class Solution {
    public int[] nextGreaterElement(int[] arr1, int[] arr) {
       Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        Map<Integer,Integer> m = new HashMap<>();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<=arr[i]){
            stack.pop();
            } 
            if(!stack.isEmpty()) m.put(arr[i], stack.peek());
            stack.push(arr[i]);
        }
        for(int i=0;i<arr1.length;i++){
        arr1[i] = m.getOrDefault(arr1[i],-1); 
        }
        return arr1;
    }
}