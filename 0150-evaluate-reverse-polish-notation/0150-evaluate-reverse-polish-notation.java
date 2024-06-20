class Solution {
    static boolean isSymbol(String s){
        if(s.equals("+") || s.equals("*") || s.equals("/") || s.equals("-")) return true;
        return false;
    }
    static int operation(Stack<Integer> stack, String op){
        int e1 = stack.pop();
        int e2 = stack.pop();
        if(op.equals("+")){
            return e2 + e1;
        }else if(op.equals("-")){
            return e2 - e1;
        }else if(op.equals("*")){
            return e2 * e1;
        }
        return e2 / e1;
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String str : tokens){
            if(isSymbol(str)){
                stack.push(operation(stack, str));
            }else{
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }
}