//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    grid[i][j] = S.charAt(j);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            int[][] ans = obj.searchWord(grid, word);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
            if(ans.length==0)
            {
                System.out.println("-1");
            }

        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    // char[] pattern;
    // int rows;
    // int columns;
    // // now function which recursivly check to any particular direction
    // // int 0 : left horizontal
    // // int 1 : right horizontal
    // // int 2 : top vertical
    // // int 3 : bottom vertical
    // // int 4 : top left diagonal
    // // int 5 : top right diagonal
    // // int 6 : bottom left diagonal
    // // int 7 : bottom right diagonal
    
    // // checkInDirection(char[][] matrix,int direction,int i,int j){
        
    // // }
    
    // static boolean rightHorizontal(int[][] matrix,int i,int j,int elementIndex){
    //     if(elementIndex == pattern.length + 1) return true;
    //     if(j >= columns){
    //         return false;
    //     }
    //     if(matrix[i][j] == pattern[elementIndex]){
    //         if(rightHorizontal(matrix,i,j + 1,elementIndex + 1)) return true;
    //     }
    //     return false;
    // }
    
    
    
    
    // boolean isStringValid(char[][] matrix,int i,int j){
    //     int length = pattern.length;
    //     if(length == 1) return true;
    //     char second = pattern[1];
    //     //in all possible direction we need to find its second char if found than we can check continues in that direction
        
    //     // for left element 
    //     if(j-1 >= 0 && matrix[i][j-1] == second){
    //         if(length == 2) return true;
    //         else{
                
    //         }
    //     }
        
    //     // for right element
    //     if(j+1 < colums && matrix[i][j+1] == second){
    //         if(length == 2) return true;
    //         else{
                
    //         }
    //     }
        
    //     // for top element
    //     if(i-1 >= 0 && matrix[i-1][j] == second){
    //         if(length == 2) return true;
    //         else{
                
    //         }
    //     }
        
    //     // for bottom element
    //     if(i+1 < rows && matrix[i+1][j] == second){
    //         if(length == 2) return true;
    //         else{
                
    //         }   
    //     }
        
    //     // for topLeft element
    //     if(i-1 >= 0 && j-1 >= 0 && matrix[i-1][j-1] == second){
    //         if(length == 2) return true;
    //         else{
                
    //         }
    //     }
        
    //     // for topRight element
    //     if(i-1 >= 0 && j+1 < colums && matrix[i-1][j+1] == second){
    //         if(length == 2) return true;
    //         else{
                
    //         }
    //     }
        
    //     // for bottomRight element
    //     if(i+1 < rows && j-1 >= 0 && matrix[i+1][j-1] == second){
    //         if(length == 2) return true;
    //         else{
                
    //         }
    //     }
        
    //     // for Right element
    //     if(i+1 < rows && j+1 < colums && matrix[i+1][j+1] == second){
    //         if(length == 2) return true;
    //         else{
                
    //         }
    //     }
        
    // }
    
    
    static public char[] pattern;
    static public int rows;
    static public int columns;

    static boolean rightHorizontal(char[][] matrix, int i, int j, int elementIndex) {
        if (elementIndex == pattern.length)
            return true;
        if (j >= columns) {
            return false;
        }
        if (matrix[i][j] == pattern[elementIndex]) {
            if (rightHorizontal(matrix, i, j + 1, elementIndex + 1))
                return true;
        }
        return false;
    }

    static boolean leftHorizontal(char[][] matrix, int i, int j, int elementIndex) {
        if (elementIndex == pattern.length)
            return true;
        if (j < 0) {
            return false;
        }
        if (matrix[i][j] == pattern[elementIndex]) {

            if (leftHorizontal(matrix, i, j - 1, elementIndex + 1))
                return true;
        }
        return false;
    }

    static boolean topVertical(char[][] matrix, int i, int j, int elementIndex) {
        if (elementIndex == pattern.length)
            return true;
        if (i < 0) {
            return false;
        }
        if (matrix[i][j] == pattern[elementIndex]) {

            if (topVertical(matrix, i - 1, j, elementIndex + 1))
                return true;
        }
        return false;
    }

    static boolean bottomVertical(char[][] matrix, int i, int j, int elementIndex) {
        if (elementIndex == pattern.length)
            return true;
        if (i >= rows) {
            return false;
        }
        if (matrix[i][j] == pattern[elementIndex]) {

            if (bottomVertical(matrix, i + 1, j, elementIndex + 1))
                return true;
        }
        return false;
    }

    static boolean topLeftDiagonal(char[][] matrix, int i, int j, int elementIndex) {
        if (elementIndex == pattern.length)
            return true;
        if (i  < 0 || j < 0) {
            return false;
        }
        if (matrix[i][j] == pattern[elementIndex]) {

            if (topLeftDiagonal(matrix, i - 1, j - 1, elementIndex + 1))
                return true;
        }
        return false;
    }

    static boolean topRightDiagonal(char[][] matrix, int i, int j, int elementIndex) {
        if (elementIndex == pattern.length)
            return true;
        if (i  < 0 || j >= columns) {
            return false;
        }
        if (matrix[i][j] == pattern[elementIndex]) {

            if (topRightDiagonal(matrix, i - 1, j + 1, elementIndex + 1))
                return true;
        }
        return false;
    }

    static boolean bottomLeftDiagonal(char[][] matrix, int i, int j, int elementIndex) {
        if (elementIndex == pattern.length)
            return true;
        if (i >= rows || j < 0) {
            return false;
        }
        if (matrix[i][j] == pattern[elementIndex]) {

            if (bottomLeftDiagonal(matrix, i + 1, j - 1, elementIndex + 1))
                return true;
        }
        return false;
    }

    static boolean bottomRightDiagonal(char[][] matrix, int i, int j, int elementIndex) {
        if (elementIndex == pattern.length)
            return true;
        if (i >= rows || j >= columns) {
            return false;
        }
        if (matrix[i][j] == pattern[elementIndex]) {

            if (bottomRightDiagonal(matrix, i + 1, j + 1, elementIndex + 1))
                return true;
        }
        return false;
    }
    
    static class node {
        int i;
        int j;

        node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    
    public int[][] searchWord(char[][] matrix, String word)
    {
        ArrayList<node> list = new ArrayList<>();
        rows = matrix.length;
        columns = matrix[0].length;
        pattern = word.toCharArray();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (leftHorizontal(matrix, i, j, 0) || rightHorizontal(matrix, i, j, 0) ||
                        topVertical(matrix, i, j, 0) || bottomVertical(matrix, i, j, 0) ||
                        topLeftDiagonal(matrix, i, j, 0) || topRightDiagonal(matrix, i, j, 0) ||
                        bottomLeftDiagonal(matrix, i, j, 0) || bottomRightDiagonal(matrix, i, j, 0)) {
                    list.add(new node(i, j));
                }
            }
        }
        
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i][0] = list.get(i).i;
            ans[i][1] = list.get(i).j;
        }
        return ans;
    }
}


// abe
// a b a b
// a b e b
// e b e b