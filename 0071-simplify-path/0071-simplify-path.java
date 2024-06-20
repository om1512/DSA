class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String s: arr){
            if(s.equals("") || s.equals(".")) continue;
            else if(s.equals("..")){
                if(!stack.isEmpty()) stack.pop(); 
            }else{
                stack.push(s);
            }
        }
        String str = "";
        while(!stack.isEmpty()){
            String s = stack.pop();
            str = "/"+s.concat(str);
        }
        return (str.equals("") ? "/" : str);
    }
}