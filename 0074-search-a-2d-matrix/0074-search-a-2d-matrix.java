class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length,m = matrix[0].length;
        int low = 0, high = (n*m)-1,mid = (low+high)/2;
        while(low <= high){
            int i = mid/m,j = mid%m;
            if(matrix[i][j] == target){
                return true;
            }else if(matrix[i][j] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
            mid = (low+high)/2;
        }
        return false;
    }
}