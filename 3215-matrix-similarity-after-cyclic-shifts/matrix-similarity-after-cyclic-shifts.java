class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int col=mat[0].length;
        k= k% col;
        int p=0;
        int[][] arr= Arrays.stream(mat)
                                 .map(int[]::clone)
                                 .toArray(int[][]::new);
        while(p< k){

            for(int i=0;i<mat.length;i++){
                if(i%2 == 0){
                    int f= mat[i][0];
                    for(int j=1;j<col;j++){
                        mat[i][j-1]= mat[i][j];
                    }
                    mat[i][col-1] = f;

                }else{
                    int l= mat[i][col-1];
                    for(int j=col-1;j>0;j--){
                        mat[i][j]= mat[i][j-1];
                    }
                    mat[i][0] = l;

                }
            }
            // for(int i=0;i<mat.length;i++){
            //     for(int j=0;j<col;j++){
            //         System.out.print(mat[i][j] +" ");
            //     }
            //     System.out.println();
            // }
            
            // System.out.println("---=-=-=-");
            p++;
        }
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<col;j++){
                if(arr[i][j] != mat[i][j])return false;
            }
        }
        return true;
    }
}