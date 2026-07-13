class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix[0].length;
        int n = matrix.length;

        int low = 0;
        int high = m*n - 1;
        
        while(low<=high){
            int mid = low + (high-low)/2;

            int rowVal = mid / m;
            int colVal = mid % m;

            if(matrix[rowVal][colVal] == target) return true;

            if(matrix[rowVal][colVal] < target){
                low = mid + 1;
            }else{
                high = mid-1;
            }
        }
        return false;
    }
}
