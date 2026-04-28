class Solution {
    public int minOperations(int[][] grid, int x) {
        int row=grid.length;
        int col=grid[0].length;
        int remain = grid[0][0] % x;
        //int flag=0,sum=0;
        List<Integer> list= new ArrayList<>();
        for(int i=0;i<row; i++){
            for(int j=0;j<col;j++){
                //sum+=grid[i][j];
                if(grid[i][j]%x != remain){
                    return -1;
                }
                list.add(grid[i][j]);
            }
        }
        Collections.sort(list);
        int len= list.size();
        int i = 0, j= len-1;
        int res=0;
        while(i<j){

            if( i < len-j-1){
                int pref = ((i+1) * (list.get(i+1)-list.get(i)))/x;
                res+= pref;
                i++;
            }
            else{
                int suf= ((len- j) * (list.get(j)-list.get(j-1)))/x;
                res+= suf;
                j--;
            }
        }
        return res;
        
        // return cnt;
    }
}