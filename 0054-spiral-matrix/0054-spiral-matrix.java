class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        List<Integer> result = new ArrayList<Integer>();
        while(top <= bottom && left <= right){
            // left to right traversal
            for(int i=left; i<=right;i++){
                result.add(matrix[top][i]);
            }
            top++;

            // top to bottom traversal
            for(int i=top; i<=bottom;i++){
                result.add(matrix[i][right]);
            }
            right--;

            // right to left traversal
            if(top <= bottom){
                for(int i=right; i>=left;i--){
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // bottom to top traversal
            if(left <= right){
                for(int i=bottom; i>=top;i--){
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }
}