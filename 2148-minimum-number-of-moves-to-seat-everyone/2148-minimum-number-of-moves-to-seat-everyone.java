class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int ans = 0;
        for(int i =0;i<seats.length;i++){
            ans += Math.abs(seats[i] - students[i]);
        }
        return ans;
    }
}


// 1 4 5 9
// 1 2 3 6

// 0 2 2 3 = 8