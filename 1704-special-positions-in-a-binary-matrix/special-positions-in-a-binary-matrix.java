class Solution {
    public int numSpecial(int[][] mat) {
        // Set<Integer> row= new HashSet<>();
        // Set<Integer> col= new HashSet<>();
        int[] row= new int[mat.length];
        int[] col= new int[mat[0].length];
        
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j] == 1){
                    row[i]++;
                    col[j]++;
                //     if(row.contains(i)){
                //         row.remove(i);
                //     }
                //     else if(!row.contains(i)){
                //         row.add(i);
                //     }
                //    if(col.contains(j)){
                //         col.remove(j);
                //     }else if(!col.contains(j)){
                //         col.add(j);
                //     }
                }
            }
        }
        int cnt=0;
         for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j] == 1){
                    if(row[i] ==1 && col[j]==1)cnt++;
                }
            }
        }
        return cnt;
    }
}
///
/**
[[0,0,0,0,0,1,0,0],
 [0,0,0,0,1,0,0,1],
 [0,0,0,0,1,0,0,0],
 [1,0,0,0,1,0,0,0],
 [0,0,1,1,0,0,0,0]] */