class DSU{
    int[] parent;
    int[] size;
    DSU(int n){
        parent= new int[n];
        size=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }

    public int getParent(int a){
        if(a== parent[a])return a;
        return parent[a]= getParent(parent[a]);
    }
    public void add(int a, int b){
        int pa= getParent(a);
        int pb= getParent(b);
        if(size[pa] > size[pb]){
            parent[pb]= pa;
            size[pa]+= size[pb];
        }
        else{
            parent[pa]= pb;
            size[pb]+= size[pa];
        }

    }
}
class Solution {
    public boolean containsCycle(char[][] grid) {
        int row= grid.length, col= grid[0].length;
        int[][] dir= new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
       
        boolean[][] visited=new boolean[row][col]; 
        DSU d= new DSU(row*col);

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                int pos = i*col+j;
                
                if(i+1< row && grid[i+1][j] == grid[i][j]){
                    int newPos= (i+1)*col+j;
                    if(d.getParent(pos) == d.getParent(newPos) )return true;
                    d.add(pos, newPos);
                }
                 if(j+1< col && grid[i][j+1] == grid[i][j]){
                    int newPos= i*col+(j+1);
                    if(d.getParent(pos) == d.getParent(newPos) )return true;
                    d.add(pos, newPos);
                }
            }
        }
        
        return false;
        
    }
}

/**
["f","a","a","c","b"],
["e","a","a","e","c"],
["c","f","b","b","b"],
["c","e","a","b","e"],
if(!visited[i][j]){
                    Deque<int[]> dq= new ArrayDeque<>();
                    dq.add(new int[]{i,j});
                    visited[i][j]=true;
                    while(!dq.isEmpty()){
                        int[] p= dq.poll();
                        char curr= grid[p[0]][p[1]];
                        int pos = p[0] * col+ p[1];
                        for(int[] di:dir){
                            int x= di[0]+p[0];
                            int y= di[1]+p[1];

                            if(x>=0 && x<row && y>=0 && y<col && !visited[x][y] && grid[x][y] == curr){
                                dq.add(new int[]{x,y});
                                visited[x][y]= true;
                                int newPos= x * col+ y;
                                if(d.getParent(pos) == d.getParent(newPos) && d.size[d.getParent(newPos)] >= 4)return true;
                                d.add(pos, newPos);
                            }
                         
                        }
                    }

                }
["f","e","f","b","f"]]
 */