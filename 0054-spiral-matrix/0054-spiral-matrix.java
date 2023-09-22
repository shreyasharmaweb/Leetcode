
class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    static List<Integer> spiralOrder(int matrix[][])
    {
        // code here 
        List<Integer> al = new ArrayList<>();
        int r=matrix.length;
        int c=matrix[0].length;
        int top=0;
        int bottom=r-1;
        int left=0;
        int right=c-1;
        while(left<=right && top<=bottom)
        {
            for(int i=left;i<=right;i++)
            {
                  al.add(matrix[top][i]);
            }
            top++;
            for(int i=top;i<=bottom;i++)
            {
                al.add(matrix[i][right]);
            }
            right--;
            if(top<=bottom){
                for(int i=right;i>=left;i--)
                {
                al.add(matrix[bottom][i]);
                }
                bottom--; 
                
            }
            if(left<=right)
              {
            for(int i=bottom;i>=top;i--)
            {
                al.add(matrix[i][left]);
            }
            left++;
              }
        }
        return al;
    }
}