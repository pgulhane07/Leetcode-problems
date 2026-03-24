class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int row=grid.length, col= grid[0].length;
        long prefix[][] = new long[row][col];
        long suffix[][] = new long[row][col];
        long[] rowMul= new long[row];
        int res[][]= new int[row][col];
        for(int i=0;i<row;i++){
            long pre=1;
            for(int j=0;j<col;j++){
                prefix[i][j] = pre;
                pre= (pre*grid[i][j]) %12345;
            }
            rowMul[i] = pre;
        }
        for(int i=0;i<row;i++){
            long pre=1;
            for(int j=col-1;j>=0;j--){
                suffix[i][j] = pre;
                pre= (pre*grid[i][j])% 12345;
            }
            // rolMul[i] = pre;
        }

        // for(int i=0;i<row;i++){
        //     //int pre=1;
        //     for(int j=0;j<col;j++){
        //         System.out.print(prefix[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        // System.out.println("--=-=-=---");
        //  for(int i=0;i<row;i++){
        //     //int pre=1;
        //     for(int j=0;j<col;j++){
        //         System.out.print(suffix[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        // System.out.println("----=-=-=-----");
        // for(int i=0;i<row;i++){
        //      System.out.print(rowMul[i]+" ");
        // }
        long[] rowPref= new long[row];
        long[] rowsuf= new long[row];
        long p=1;
        for(int i=0;i<row;i++){
            rowPref[i]=p;
            p=(p*rowMul[i])%12345;
        }
        p=1;
        for(int i=row-1;i>=0;i--){
            rowsuf[i]=p;
            p=(p*rowMul[i])%12345;
        }
        // System.out.println("----=-row pref=-=-----");
        // for(int i=0;i<row;i++){
        //      System.out.print(rowPref[i]+" ");
        // }
        // System.out.println("----=row suf-=-=-----");
        // for(int i=0;i<row;i++){
        //      System.out.print(rowsuf[i]+" ");
        // }
        // System.out.println();
        
        for(int i=0;i<row;i++){
            //int pre=1;
            // long rowprod=1;
            for(int j=0;j<col;j++){
                long prod= ((prefix[i][j])%12345 * (suffix[i][j])%12345)%12345;
                long prod2= ((rowPref[i])%12345 * (rowsuf[i])%12345)%12345;
                res[i][j] = (int)(prod*prod2) % 12345;
            }
        }
        return res;
    }
}

//1 2 3
//4 5 6

// 720 