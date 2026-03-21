class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int row= grid.length, col=grid[0].length;
        int[][] res= new int[row][col];
        res= grid;
        for(int i=x,m=1;i<x+(k/2);i++){
            for(int j=y;j<y+k;j++){

                int a= grid[i][j];
                res[i][j] = res[x+k-m][j];
                res[x+k-m][j]=a;
               
            }
             m++;
        }
        // for(int[] a:res){
        //     for(int b:a){
        //         System.out.print(b+" ");
        //     }
        //     System.out.println();
        // }
        return res;
    }
}