class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        // Find the largest pile
        int maxValue = 0;
        for (int i : piles) {
            maxValue = Math.max(i, maxValue);
        }

        // Binary search
        int lo = 1;
        int hi = maxValue;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            long hours = calculateHours(piles, mid);
//only bit different from a standard binary search
            if (hours > H) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }
    
    private long calculateHours(int[] piles, int speed) {
//we have used a function like this in problems like leetcode 1011
//and leetcode 2187
        long hours = 0;
        for (int pile : piles) {
            hours += ((pile - 1) / speed )+ 1;
    //(pile - 1) / speed + 1 because we need total time koko
    //will spend on a pile having(say) 10 bananas, if her eating 
    //speed were 3. It would be 4.
        }
        return hours;
    }
}