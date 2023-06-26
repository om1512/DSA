class MinStack {
        
    class Pair{
    int a;
    int b;
    Pair(int a,int b){
      this.a = a;
      this.b = b;
    }
  }  
  Stack<Pair> s = new Stack<>();
  void push(int n){
    int min;
    if(s.isEmpty()){
      min = n;
    }else{
      min = Math.min(n,s.peek().b);
    }
    s.push(new Pair(n,min));
  }

  void pop(){
    s.pop();
  }

  int top(){
    return s.peek().a;
  }

  int getMin(){
    return s.peek().b;
  }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */