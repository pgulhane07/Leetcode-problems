class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int[][] dp= new int[grid.size()][grid.get(0).size()];
        int row= grid.size();
        int col = grid.get(0).size();
        for(int i=0;i<grid.size();i++){        
            Arrays.fill(dp[i], 1000);
        }
        if(grid.get(0).get(0) ==1 || grid.get(row-1).get(col-1) ==1){
            return 0;
        }
        ArrayDeque<int[]> dq= new ArrayDeque<>();
        int[][] dir= new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        for(int i=0;i<grid.size();i++){            
            for(int j=0; j< col;j++){

                if( grid.get(i).get(j) == 1){

                    
                    dq.add(new int[]{i,j});
                    dp[i][j]=0;
                    

                }

            }
        }
        int val=1;
        while(!dq.isEmpty()){
            int l= dq.size();
            for(int k=0;k<l;k++){
                int[]a =  dq.poll();
                for(int[] d:dir){
                    int x= a[0]+d[0];
                    int y= a[1]+d[1];
                    if(x>=0 && x<row && y>=0 && y<col && dp[x][y] > val){
                        dp[x][y] = val;
                        dq.add(new int[]{x,y});
                    }
                }

            }
            val++;
        }
        //  for(int i=0;i<row;i++){
        //     for(int j=0;j<col;j++){
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->b[2]-a[2]);
        // int[][] res= new int[row][col];
        boolean visited[][]= new boolean[row][col];
        visited[0][0]=true;
        // res[0][0]= dp[0][0];
        pq.add(new int[]{0,0,dp[0][0]});
        while(!pq.isEmpty()){
            int[] a= pq.poll();
            int x=a[0];
            int y=a[1];
            int dist= a[2];

            if(x== row-1 && y==col-1)return dist;

            for(int[] d:dir){
                int m= d[0]+x;
                int n= d[1]+y;
                if(m>=0 && m<row && n>=0 && n<col && !visited[m][n]){
                    visited[m][n]= true;
                    pq.add(new int[]{m,n,Math.min(dist,dp[m][n])});
                }

            }

        }
        return 0;

        // for(int i=1;i<col;i++){
        //     res[0][i] = Math.min(res[0][i-1],dp[0][i]);
        // }
        // for(int i=1;i<row;i++){
        //     for(int j=0;j<col;j++){
        //         int max= 0;
        //         if(i-1>=0){
        //             max= Math.max(max, res[i-1][j]);
        //         }
        //         if(j-1>=0){
        //             max= Math.max(max, res[i][j-1]);
        //         }
        //         res[i][j] = Math.min(max, dp[i][j]);
        //     }
        // }
        // System.out.println("--0==");
        // for(int i=0;i<row;i++){
        //     for(int j=0;j<col;j++){
        //         System.out.print(res[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        //return res[row-1][col-1];

    }
}