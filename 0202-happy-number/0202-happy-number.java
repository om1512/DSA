class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(true){
            int newN = 0;
            while(n > 0) {
                int remainder = n % 10;
                newN += Math.pow(remainder,2);
                n = n / 10;
            }
            if(newN == 1) return true;
            if(!set.add(newN)) return false;
            n = newN;
        }
    }
}