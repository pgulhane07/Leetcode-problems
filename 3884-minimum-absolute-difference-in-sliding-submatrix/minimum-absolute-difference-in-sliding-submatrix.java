class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int row= grid.length, col= grid[0].length;
        if(k==1)return new int[row][col];
        int res[][]= new int[row-k+1][col-k+1];
        for(int i=0;i< row-k+1 ;i++){
            for(int j=0;j< col-k+1;j++){
                List<Integer> list= new ArrayList<>();
                for(int m=i;m<i+k;m++){
                    for(int n=j;n<j+k;n++){
                        list.add(grid[m][n]);
                    }
                }
                Collections.sort(list);
               // System.out.println(list);
                int min = Integer.MAX_VALUE;
                for(int p=1;p<list.size();p++){
                    if(!list.get(p).equals(list.get(p-1)))
                        min= Math.min(min, Math.abs(list.get(p) - list.get(p-1)));
                }
                res[i][j]= min == Integer.MAX_VALUE? 0: min;
            }
        }
        return res;

    }
}