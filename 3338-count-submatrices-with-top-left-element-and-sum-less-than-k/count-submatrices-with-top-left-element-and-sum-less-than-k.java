class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int row=grid.length, col= grid[0].length;
        int[][] rows = new int[row][col];
        int[][] cols = new int[row][col];
        int cnt=0;
        for(int i=0;i<row;i++){
            int rowsum=0;
            for(int j=0;j<col;j++){
                rowsum+= grid[i][j];
                rows[i][j] = rowsum;
                // if(i==0 && j==0){
                //     arr[i][j]=grid[i][j];
                //     if(arr[i][j] <= k)cnt++;
                // }
                // if(i-1>=0){
                //     arr[i][j]+= arr[i-1][j];
                // }
                // if(j-1>=0){
                //     arr[i][j]+=arr[i][j-1];
                // }


            }
        }
        for(int i=0;i<col;i++){
            int colsum=0;
            for(int j=0;j<row;j++){
                colsum+= rows[j][i];
                cols[j][i] = colsum;
                if(cols[j][i] <=k)cnt++;
            }
        }

//         for(int i=0;i<row;i++){
//             for(int j=0;j<col;j++){
//                 System.out.print(rows[i][j]+" ");
//             }
//             System.out.println();
//         }
//  System.out.println("---=-=-=-=-====-----");
//         for(int i=0;i<row;i++){
//             for(int j=0;j<col;j++){
//                 System.out.print(cols[i][j]+" ");
//             }
//             System.out.println();
//         }


        // for(int i=0;i<row;i++){
        //     for(int j=0;j<col;j++){
        //         if(cols[i][j] <=k)cnt++;
        //     }
        //     System.out.println();
        // }
        return cnt;

    }
}