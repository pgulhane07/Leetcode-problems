class Solution {
    public int maximumAmount(int[][] coins) {
        int row=coins.length, col=coins[0].length;
        int[][][] dp = new int[row][col][3];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                Arrays.fill(dp[i][j], Integer.MIN_VALUE/2);
            }
        }
        dp[0][0][0]=coins[0][0];
        if(coins[0][0] < 0){
            dp[0][0][1] = 0;
            dp[0][0][2] = 0;
            
        }
        else{
            dp[0][0][1] = coins[0][0];
            dp[0][0][2] = coins[0][0];
        }
            

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){

                if(i==0 && j==0)continue;



                for(int k=0;k<3;k++){
                    int up= i-1>=0? dp[i-1][j][k] : Integer.MIN_VALUE/2;
                    int left= j-1>=0? dp[i][j-1][k] : Integer.MIN_VALUE/2;
                    int max= Math.max(left,up);

                    if(coins[i][j] >=0){
                        dp[i][j][k] = max+coins[i][j];

                    }
                    else{
                        int choice1= max + coins[i][j];
                        int choice2= Integer.MIN_VALUE/2;
                        if(k>0){
                            int up1= i-1>=0? dp[i-1][j][k-1] : Integer.MIN_VALUE/2;
                            int left1= j-1>=0? dp[i][j-1][k-1] : Integer.MIN_VALUE/2;
                            choice2= Math.max(up1, left1);
                        }
                        
                        dp[i][j][k] = Math.max(choice1,choice2);
                    }
                    
                }
            }
        
        }
        return Math.max(dp[row-1][col-1][0], Math.max(dp[row-1][col-1][1], dp[row-1][col-1][2]));
    }
}