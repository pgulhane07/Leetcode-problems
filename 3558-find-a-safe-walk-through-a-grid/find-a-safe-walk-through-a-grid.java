class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)-> b[2]-a[2]);
        int row=grid.size(), col= grid.get(0).size();
        int[][] arr= new int[row][col];
        for(int i=0;i<grid.size();i++){
            for(int j=0;j<grid.get(0).size();j++){
                arr[i][j]= grid.get(i).get(j);
            }
        }
        if(grid.get(0).get(0)==1)health--;
        pq.add(new int[]{0,0,health});
        int[][] dir= new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int[][] h= new int[row][col];
        for(int i=0;i<grid.size();i++){
            Arrays.fill(h[i], -1);
        }
        h[0][0] = health;
        boolean[][] visited= new boolean[row][col];
        visited[0][0] =true;
        while(!pq.isEmpty()){
            
            int[] a= pq.poll();
            if(a[0]== row-1 && a[1]== col-1){
                if(a[2] >=1)  return true;
                return false;
            }
            for(int d[]:dir){
                int x= d[0]+a[0];
                int y= d[1]+a[1];
                
                if(x>=0 && x< row && y>=0 && y<col){
                    int newHealth = arr[x][y] == 0? a[2] : a[2]-1;
                    if(!visited[x][y] || h[x][y] < newHealth ){
                        visited[x][y]= true;
                        pq.add(new int[]{x,y,newHealth});
                        h[x][y]= newHealth;
                    }

                }
            }
        }
        return false;

    }
}