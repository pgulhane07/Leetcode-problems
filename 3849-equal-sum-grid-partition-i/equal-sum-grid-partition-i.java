class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int row= grid.length, col = grid[0].length;
        long[] colSum= new long[col];
        long[] rowSum = new long[row];
        long sum=0;
        for(int i=0;i<row;i++){
            long rs=0;
            for(int j=0;j<col;j++){
                rs+= grid[i][j];
                sum+= grid[i][j];
            }
            rowSum[i] = rs;
        }
        for(int i=0;i<col;i++){
            long cs=0;
            for(int j=0;j<row;j++){
                cs+= grid[j][i];
            }
            colSum[i] = cs;
        }
        if(sum%2 !=0)return false;
        long target= sum/2;
        long r=0;
        for(long n:rowSum){
            r+=n;
            if(r == target)return true;
            else if(r >target)break;
        }
        long c=0;
        for(long n:colSum){
            c+=n;
            if(c == target)return true;
            else if(c >target)break;
        }
        return false;

    }
}