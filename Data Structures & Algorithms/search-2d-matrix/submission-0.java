class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int noOfRows = matrix.length;
        int noOfCols = matrix[0].length;
        int left = 0;
        int right = noOfRows*noOfCols - 1;

        while(left <= right) {
            int mid = left + (right-left)/2;
            int midRow = mid/noOfCols;
            int midCol = mid%noOfCols;

            if(matrix[midRow][midCol] == target) {
                return true;
            } 
            
            if(matrix[midRow][midCol] > target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return false;
    }
}
