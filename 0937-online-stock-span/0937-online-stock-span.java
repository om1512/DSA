class StockSpanner {
    class Pair {
        int a;
        int b;

        Pair(int a, int b) {
        this.a = a;
        this.b = b;
        }
    }
    Stack<Pair> stack = new Stack<>();
    public int next(int price) {
        int span = 1;
    while (!stack.isEmpty() && stack.peek().a <= price) {
      span = span + stack.peek().b;
      stack.pop();
    }
    stack.push(new Pair(price, span));
    return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */