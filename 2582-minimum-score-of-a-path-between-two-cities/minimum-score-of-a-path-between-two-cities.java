class DSU{
    int[] parent;
    int[] size;
    // int[] min;
    DSU(int n){
        parent= new int[n];
        size= new int[n];
        // min= new int[n];
        for(int i=0;i<n;i++){
            size[i] = 1;
            parent[i]= i;
            // min[i]= Integer.MAX_VALUE;
        }
    }
    public int getParent(int n){
        if(n==parent[n])return n;
        return getParent(parent[n]);
    }
    public void add(int a, int b){
        int pa= getParent(a);
        int pb= getParent(b);
        if(pa == pb)return;

        if(size[pa] > size[pb]){
            size[pa]+=size[pb];
            parent[pb]= pa;
            // min[pa] = Math.min(min[pa], min[pb]);  
        }
        else{
            size[pb]+=size[pa];
            parent[pa]= pb;
            // min[pb] = Math.min(min[pa], min[pb]);  
        }
    }
}

class Solution {
    //int res;
    // public boolean dfs(int node, int target, List<List<int[]>> list, int min, boolean[] visited){

    //     if(node== target){
    //         res= Math.min(min, res);
    //         return true;
    //     }
        

    //     for(int[] x : list.get(node) ){

    //        // if(!visited[x[0]]){
    //          //   visited[node] =true;
    //             if(dfs(x[0], target, list, Math.min(min, x[1]) , visited))return true;
    //           //  visited[node] =false;;
    //         //}

    //     }
    //     return false;

    // }
    public int minScore(int n, int[][] roads) {
        
        List<List<int[]>> list= new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        DSU d= new DSU(n+1);
        int res= Integer.MAX_VALUE;
        for(int [] r : roads){
            // res= Math.min(res ,r[2]);

            d.add(r[0],r[1]);
            // list.get(r[0]).add(new int[]{r[1],r[2]});
            // list.get(r[1]).add(new int[]{r[0],r[2]});
        }
        
        int par = d.getParent(1);
        Set<Integer> nodes= new HashSet<>();

        for(int i=1;i<=n;i++){
            if(d.getParent(i) == par){
                nodes.add(i);
            }
        }
        for(int [] r : roads){
            if(nodes.contains(r[0]))
                res= Math.min(res ,r[2]);

            // d.add(r[0],r[1]);
            // list.get(r[0]).add(new int[]{r[1],r[2]});
            // list.get(r[1]).add(new int[]{r[0],r[2]});
        }
        // boolean visited[] = new boolean[n+1];
        // visited[1]= true;
        // boolean x = dfs(1, n, list, Integer.MAX_VALUE, visited);

        return res;
    }
}