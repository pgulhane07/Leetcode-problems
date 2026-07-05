class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int[][] arr= new int[board.size()][board.size()];
        int dp[][] = new int[board.size()][board.size()];
        int ways[][] = new int[board.size()][board.size()];
        int row= board.size(), col = board.size();

        for(int i=0;i<board.size();i++){
            for(int j=0;j<col;j++){
                if((i==0 && j==0) || (i==row-1 && j == col-1))continue;
                if(board.get(i).charAt(j)=='X'){
                    arr[i][j] = Integer.MIN_VALUE;
                    continue;
                }
                arr[i][j] = board.get(i).charAt(j) - '0';
            }
        }
        int MOD = 1_000_000_007;
        ways[row-1][col-1]= 1;
        for(int i=row-1;i>=0;i--){
            for(int j=col-1;j>=0;j--){
                if(i==row-1 && j == col-1)continue;
                if(arr[i][j] == Integer.MIN_VALUE){
                    dp[i][j] = Integer.MIN_VALUE;
                    ways[i][j]=0;
                    continue;
                }
                // boolean r=false, bot= false, dia= false;
                int test=0;
                int a=0, b=0,c=0;
                if(i+1 < row && dp[i+1][j] != Integer.MIN_VALUE){
                    a = dp[i+1][j] + arr[i][j];
                    test++;
                    // if(a == -1)a=0;
                }
                if(j+1 < col && dp[i][j+1] != Integer.MIN_VALUE){
                    b= dp[i][j+1]+ arr[i][j];
                    // r = true;
                    test++;
                    // if(a == -1)a=0;
                }
                if(i+1<row && j+1 < col && dp[i+1][j+1] != Integer.MIN_VALUE){
                    c= dp[i+1][j+1]+ arr[i][j];
                    // dia = true;
                    test++;
                }

                //if(!(r && bot) && !(r && dia) && !(dia && bot)){
                if(test ==0){
                    dp[i][j] = Integer.MIN_VALUE;
                    ways[i][j] = 0;
                    continue;
                }

                 dp[i][j] = Math.max(a, Math.max(b,c));
                 int t= dp[i][j];
                if(a==t && i+1 < row){
                    ways[i][j] = (ways[i][j]+ ways[i+1][j]) % MOD ;
                }
                if(b==t && j+1 < col){
                    ways[i][j] = (ways[i][j]+ ways[i][j+1]) % MOD;
                }
                if(c==t && i+1 < row && j+1 < col){
                    ways[i][j] = (ways[i][j]+ ways[i+1][j+1]) % MOD;
                }

            }
        }

        // for(int i=0;i<board.size();i++){
        //     for(int j=0;j<col;j++){
        //         System.out.print(dp[i][j] +" ");
        //     }
        //     System.out.println();
        // }
        if(dp[0][0]== Integer.MIN_VALUE)return new int[]{0,0};
        return new int[]{dp[0][0], ways[0][0]};

    }
}