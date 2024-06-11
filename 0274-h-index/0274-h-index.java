class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int max = 0;
        for(int i=0;i<n;i++){
            if(citations[i] >= n-i) max = Math.max(max, n-i);
        }
        return max;
    }
}

// 0 1 3 5 6
// 0 1 2 3 4

// 1 1 3
// 0 1 2