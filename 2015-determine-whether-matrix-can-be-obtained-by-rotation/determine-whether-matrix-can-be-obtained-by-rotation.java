class Solution {
    public boolean check(int[][] mat, int[][] arr){
        int row=mat.length, col= mat[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(mat[i][j] != arr[i][j])return false;
            }
        }
        return true;
    }
    public boolean findRotation(int[][] mat, int[][] target) {
        int row=mat.length, col= mat[0].length;
        if(check(target, mat))return true;
        int rot1[][]=  new int[row][col];
        int rot2[][]=  new int[row][col];
        int k=row-1;
        for(int m=0;m<3;m++){
            k=row-1;
            rot1=  new int[row][col];
            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){

                    rot1[j][k] = mat[i][j];

                }
                k--;
            }
            if(check(target, rot1))return true;
            mat = rot1;
        }
        
        // k=row-1;
        // for(int i=0;i<row;i++){
        //     for(int j=0;j<col;j++){

        //         rot2[j][k] = rot1[i][j];

        //     }
        //     k--;
        // }
        // if(check(target, rot2))return true;
        return false;
    }
}

// 1 1. => 1 1
// 0 1.    1 0

//0 1.  1 0 
//1 1   1 1