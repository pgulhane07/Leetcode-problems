class DSU{
    int[] parent;
    int[] size;
    DSU(int n){
        parent= new int[n+1];
        size= new int[n+1];
        for(int i=0;i<=n;i++){
            parent[i]= i;
            size[i]=1;
        }
    }

    public int getParent(int n){
        if(parent[n] == n)return n;
        return getParent(parent[n]);
    }
    public void add(int a, int b){
        int pa= getParent(a);
        int pb= getParent(b);
        if(pa== pb)return ;
        if(size[pa] > size[pb]){
            size[pa] += size[pb];
            parent[pb]= pa;
        }
        else{
            size[pb]+=size[pa];
            parent[pa]= pb;
        }
    }
}
class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        
        DSU d= new DSU(edges.length);
        int[] node1= null;
        int[] node2= null;
        int[] par=new int[edges.length+1];

        for(int[]e:edges){
            if(par[e[1]] != 0){
                node1= new int[]{par[e[1]],e[1]};
                node2= new int[]{e[0],e[1]};
                // e[1]= -1;
                break;
            }
            else{
                par[e[1]]=e[0];
            }

        }
        for(int[] e: edges){
            if(node2!=null && e[0]== node2[0] && e[1]== node2[1])continue;
            if(d.getParent(e[0]) == d.getParent(e[1])){
                if(node1== null)return e;
                return node1;
            }
            d.add(e[0],e[1]);
        }
        return node2;


    }
}