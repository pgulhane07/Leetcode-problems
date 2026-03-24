class Solution {
    public boolean mergeTriplets(int[][] t, int[] target) {
        int row= t.length;
        Set<Integer> set= new HashSet<>();
        for(int i=0;i<row;i++){
            if(t[i][0] > target[0]  || t[i][1] > target[1] || t[i][2] > target[2]){
                continue;
            }
            for(int j=0;j<3;j++){
                if(t[i][j]== target[j])set.add(j);
            }
        }
        if(set.size() == 3)
            return true;
        return false;
    }
}