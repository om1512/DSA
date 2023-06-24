import java.util.*;
class Solution {
    public double myPow(double x, int n) {
        if (n == 0){
            return 1;
        }
        if (n % 2 == 0){
            double m = Math.pow(x, n / 2);
            return m*m;
        }
        else{
            return x*myPow(x, n - 1);
        }
    }
}