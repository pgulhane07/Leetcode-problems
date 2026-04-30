class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int row=grid.length,col=grid[0].length;
        // if(k==0)return 0;
        int[][][] dp = new int[row][col][k+1];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }
        dp[0][0][0] =0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                for(int c= 0;c<=k;c++){
                    if(dp[i][j][c] == Integer.MIN_VALUE){
                        continue;
                    }
                    if(i+1 < row){
                        int val = grid[i+1][j];
                        int cost = grid[i+1][j] == 0 ? 0: 1;
                        if(c+cost <=k){
                            dp[i+1][j][c+cost] = Math.max(
                                dp[i+1][j][c+cost],
                                dp[i][j][c] + val
                            );
                        }

                    }

                    if(j+1 < col){
                        int val = grid[i][j+1];
                        int cost = grid[i][j+1] == 0 ? 0: 1;
                        if(c+cost <=k){
                            dp[i][j+1][c+cost] = Math.max(
                                dp[i][j+1][c+cost],
                                dp[i][j][c] + val
                            );
                        }

                    }


                }
            }
        }
        int max=-1;
        for(int i=0;i<=k;i++){
            max= Math.max(max, dp[row-1][col-1][i]);
        }
        return max;
        // Deque<int[]> dq= new ArrayDeque<>();
        // int st=grid[0][0] == 0 ? 0 : 1;
        // dq.add(new int[]{0,0,grid[0][0], st});
        // int max=-1;
        // boolean[][] visited=new boolean[row][col];
        // visited[0][0]= true;
        // while(!dq.isEmpty()){
        //     int[] node= dq.poll();

        //     int i= node[0];
        //     int j=node[1];
        //     int prof=node[2];
        //     int cost= node[3];
        //     if(i==row-1 && j==col -1){
        //         max= Math.max(prof, max);
        //     }
            
        //     if(i+1 < row){
        //         int x =grid[i+1][j] == 0 ? 0 : 1;
        //         if(cost+x<=k){
        //              visited[i+1][j]= true;
        //              dq.add(new int[]{i+1,j,prof+grid[i+1][j], cost+ x});
        //         }
                    
        //     }
        //     if(j+1 < col){
        //         int x =grid[i][j+1] == 0 ? 0 : 1;
        //         if(cost+x<=k){
        //              visited[i][j+1]= true;
        //              dq.add(new int[]{i,j+1,prof+grid[i][j+1], cost+ x});
        //         }
                    
        //     }
            
        // }
        // return max;




        
        // int[][] res= new int[row][col];
        // int[][] energy= new int[row][col];
        // res[0][0]=grid[0][0];
        // energy[0][0]=grid[0][0] == 0 ? k : k-1;

        // for(int i=1;i<row;i++){
        //     res[i][0] = res[i-1][0]+grid[i][0];
        //     int cost=1;
        //     if(grid[i][0] == 0)cost=0;
            
        //     energy[i][0]=energy[i-1][0] - cost;
        // }

        // for(int i=1;i<col;i++){
        //     res[0][i] = res[0][i-1]+grid[0][i];
        //     int cost=1;
        //     if(grid[0][i] == 0)cost=0;
            
        //     energy[0][i]=energy[0][i-1] - cost;
        // }

        // for(int i=1;i<row;i++){
        //     for(int j=1;j<col;j++){
        //         int cst= grid[i][j] == 0 ? 0 : 1;

        //         if(i==row-1 && j==col-1){
        //             if(energy[i][j-1]-cst >=0){
        //                 res[i][j]= grid[i][j] + res[i-1][j];
        //             }
        //             if(energy[i-1][j]-cst >=0){
        //                 res[i][j]= Math.max(res[i][j],grid[i][j] + res[i][j-1] );
        //             }
        //             if(energy[i-1][j]-cst <0 && energy[i][j-1]-cst<0)return -1;
        //             return res[i][j];
                    
        //         }
        //         if(energy[i-1][j]-cst <0 && energy[i][j-1]-cst<0){
        //             res[i][j]= Integer.MIN_VALUE;
        //         }
        //         else if(res[i-1][j] > res[i][j-1] && energy[i-1][j]-cst >=0){
        //             res[i][j] = grid[i][j] + res[i-1][j];
        //             energy[i][j] = energy[i-1][j] - cst;
        //         }
        //         else if(res[i-1][j] == res[i][j-1] ){
        //             res[i][j] = grid[i][j] + res[i-1][j];
        //             int mi= Math.max(energy[i-1][j],energy[i][j-1]);
        //             energy[i][j] = mi - cst;
        //         }
        //         else if(res[i-1][j] < res[i][j-1] && energy[i][j-1]-cst >=0){
        //             res[i][j] = grid[i][j] + res[i][j-1];
        //             energy[i][j] = energy[i][j-1] - cst;
        //         }
                
        //     }
        // }
        
        // // for(int i=0;i<row;i++){
        // //     for(int j=0;j<col;j++){
        // //         System.out.print(res[i][j]+" ");
        // //         // if(i==0 && j==0)continue;
        // //         // int up=0;
        // //         // if(i-1>=0){
        // //         //     if(energy[i-1][j] - grid[i][j] > 0){
        // //         //         up= res[i-1][j]+grid[i][j];
        // //         //     }
        // //         // }
        // //         // in right=0;
        // //         // if(j-1>=0){
        // //         //     if(energy[])
        // //         // }
                
        // //     }
        // //     System.out.println();
        // // }

        // // System.out.println();
        // // for(int i=0;i<row;i++){
        // //     for(int j=0;j<col;j++){
        // //         System.out.print(energy[i][j]+" ");
        // //         // if(i==0 && j==0)continue;
        // //         // int up=0;
        // //         // if(i-1>=0){
        // //         //     if(energy[i-1][j] - grid[i][j] > 0){
        // //         //         up= res[i-1][j]+grid[i][j];
        // //         //     }
        // //         // }
        // //         // in right=0;
        // //         // if(j-1>=0){
        // //         //     if(energy[])
        // //         // }
                
        // //     }
        // //     System.out.println();
        // // }
        // return 0;
    }
}

