class Solution {
    public void rotate(int[][] matrix) {
        int r=matrix.length;
        int c=matrix[0].length;
        int arr[][]=new int[r][c];

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){

                arr[j][r-1-i]=matrix[i][j];
            }
        }

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                matrix[i][j]=arr[i][j];
            }
        }
    }
}