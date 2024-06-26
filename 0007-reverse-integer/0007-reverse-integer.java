class Solution {
    public int reverse(int x) {
            long num = 0;
            while (x != 0) {
                int n = x % 10;
                num = (num * 10) + n;
                x /= 10;
            }
            return (num >= Math.pow(-2,31)  && num <= Math.pow(2,31) - 1) ? (int)num : 0;
    }
}