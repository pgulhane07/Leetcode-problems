class Solution {
    public int maxProductPath(int[][] grid) {
        int row=grid.length, col= grid[0].length;
        long maximum[][]= new long[row][col];
        long minimum[][]= new long[row][col];
        maximum[0][0]= grid[0][0];
        minimum[0][0]= grid[0][0];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i==0 && j==0)continue;
                long min= Long.MAX_VALUE;
                long max= Long.MIN_VALUE;
                if(i>0){
                    long op1 =  minimum[i-1][j] * grid[i][j];
                    long op2 = maximum[i-1][j] * grid[i][j];
                    min = Math.min(min,Math.min(op1,op2));
                    max = Math.max(max,Math.max(op1,op2));
                }
                if(j>0){
                    long op1 =  minimum[i][j-1] * grid[i][j];
                    long op2 = maximum[i][j-1] * grid[i][j];
                    min = Math.min(min,Math.min(op1,op2));
                    max = Math.max(max,Math.max(op1,op2));
                }
                maximum[i][j]= max;
                minimum[i][j] = min;
            }
        }
        if(maximum[row-1][col-1] < 0)return -1;
        return (int)(maximum[row-1][col-1] % 1_000_000_007);
    }
}