class Solution {
        static boolean isSignDifferent(int a,int b){
            if(a<0 && b>0){
            return true;
            }
            return false;
        }
        public int[] asteroidCollision(int[] asteroids) {
            Stack<Integer> stack = new Stack<>();
            for (int i : asteroids) {
                if(i>0 || stack.isEmpty()){
stack.push(i);
                }
            else {
                int data = Math.abs(i);
                while (!stack.isEmpty() && stack.peek() > 0 && data > Math.abs(stack.peek())) {
                stack.pop();
                }
                if(!stack.isEmpty() && stack.peek() == data){
                    stack.pop();
                }else{
                    if(stack.isEmpty() || stack.peek() <0){
stack.push(i);
                    }
                }
            }
            
            }
            int[] ans = new int[stack.size()];
            int index = stack.size() - 1;
            while (!stack.isEmpty()) {
                ans[index--] = stack.pop();
            }
        return ans;
  }
}