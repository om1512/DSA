class Solution {
    public boolean searchMatrix(int[][] matrix, int t) {
         int n = matrix.length,m = matrix[0].length;
         int i = 0,j = m-1;
        while(i<n && j>=0){
            if(matrix[i][j] == t){
                return true;
            }else if(matrix[i][j] > t){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }
}