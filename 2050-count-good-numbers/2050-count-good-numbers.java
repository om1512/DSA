class Solution {
    public  long MOD = 1_000_000_007;
    long mypow(long x,long y){
        if(y == 0) return 1;
        long t = mypow(x,y/2);
        if(y%2 == 0){
            return ((t*t)%MOD);
        }else{
            return ((t*t*x)%MOD);
        } 
    }
    public int countGoodNumbers(long n) {
        long even = (n/2), odd = ((n/2) + (n%2));
        return (int)((mypow(5,odd) * mypow(4,even))%MOD);
    }
}