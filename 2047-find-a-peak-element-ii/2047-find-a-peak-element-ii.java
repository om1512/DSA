class Solution {
    static int maxfinder(int[] arr,int n){
        int index = -1,max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(arr[i]>max){
                max=arr[i];
                index=i;
            }
        }
        return index;
    }
    public int[] findPeakGrid(int[][] mat) {
        int startRow = 0,endRow = mat.length;
        while(startRow <= endRow){
            int midRow =(startRow + endRow)/2;
            int maxE = maxfinder(mat[midRow],mat[midRow].length);
            if(midRow == 0){
                if(mat[midRow][maxE] > mat[midRow+1][maxE]){
                    return new int[]{midRow,maxE};
                }
            }
            if(midRow == mat.length-1){
                if(mat[midRow][maxE] > mat[midRow-1][maxE]){
                    return new int[]{midRow,maxE};
                }
            }

            if(mat[midRow][maxE] > mat[midRow-1][maxE] && 
            mat[midRow][maxE] > mat[midRow+1][maxE]){
                    return new int[]{midRow,maxE};
            }

            if(mat[midRow][maxE] < mat[midRow-1][maxE]){
                endRow = midRow-1;
            }else{
                startRow = midRow+1;
            }

        }
        return new int[]{-1,-1};
    }
}