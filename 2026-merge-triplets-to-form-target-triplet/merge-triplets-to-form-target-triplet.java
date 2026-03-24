class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int row= triplets.length;
        Set<Integer> set= new HashSet<>();
        for(int i=0;i<3;i++){
            int max= 0;
            for(int j=0; j<row; j++){
                if(triplets[j][i] > target[i])
                    set.add(j);
            }
            //if(max > target[i])return false;
        }
        int[][] arr= new int[row-set.size()][3];
        int rr=0;
        for(int i=0;i<row;i++){
            if(!set.contains(i)){
                for(int j=0;j<3;j++){
                    arr[rr][j] = triplets[i][j];
                }
                rr++;
            }
        }
        for(int i=0;i<3;i++){
            int max=0;
            for(int j=0; j<arr.length; j++){
                max= Math.max(max, arr[j][i]);
            }
            if(max != target[i])return false;
        }
        return true;
    }
}