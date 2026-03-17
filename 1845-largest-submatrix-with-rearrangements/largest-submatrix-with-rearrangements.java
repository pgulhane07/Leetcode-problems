class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int row= matrix.length, col= matrix[0].length;
        int max=0;
        int[][] arr= new int[row][col];
        // for(int i=0;i<col;i++){
        //     if(matrix[0][i]==1){
        //         arr[0][i]=1;
        //     }
        // }
        arr[0]= matrix[0];
        for(int i=0;i< matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(i>0 && matrix[i][j] == 1){
                    arr[i][j] = arr[i-1][j]+1;
                }
            }
            int[] last= IntStream.of(arr[i]).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();

       // Arrays.sort(last, Collections.reverseOrder());
        // System.out.println("-----");
        // for(int n:last){
        //     System.out.print(n+" ");
        // }
        
            for(int k=0;k<col;k++){
                max= Math.max(max, last[k]* (k+1));
            }
        }
        // for(int i=0;i< matrix.length;i++){
        //     for(int j=0;j<matrix[0].length;j++){
        //         System.out.print(arr[i][j]+" ");

        //     }
        //     System.out.println();
        // }
        // matrix[row-1];
         
        return max;
    }
}