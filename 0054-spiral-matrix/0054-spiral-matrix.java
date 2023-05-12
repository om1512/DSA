class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> l = new ArrayList<Integer>();
        int n = matrix.length;
        int m = matrix[0].length;
        int left = 0,right = m-1;
        int bottom = n-1,top = 0;

        while(left<=right && top<=bottom){
            //right
            for(int i=left;i<=right;i++){
                l.add(matrix[top][i]);
            }
            top++;

            //down
            for(int i=top;i<=bottom;i++){
                l.add(matrix[i][right]);
            }
            right--;

            //right
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    l.add(matrix[bottom][i]);
                }
                bottom--;
            }

            //above
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    l.add(matrix[i][left]);
                }
                left++;
            }
        }

        return l;
    }
}