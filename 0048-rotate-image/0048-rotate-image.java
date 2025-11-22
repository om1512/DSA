class Solution {
    public void rotate(int[][] matrix) {
        // transpose existing matrix
        for(int i=0;i<matrix.length;i++){
            for(int j=i+1;j<matrix[0].length;j++){
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
        for(int i = 0;i<matrix.length;i++){
            for(int j=0;j<Math.floor(matrix[0].length / 2);j++){
                int t = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = t;
            }
        }
    }
}