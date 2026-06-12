class Solution {
    int[][] up;
    int[] depth;
    int LOG;
    public void dfs(int node, int parent, List<List<Integer>> list){
        up[node][0]= parent;
        for(int child : list.get(node)){
            if(child != parent){
                depth[child] = depth[node]+1;
                dfs(child, node, list);
            }
        }
    }
    public int LCA(int u, int v){
        if(depth[u] < depth[v]){
            int temp = u;
            u=v;
            v=temp;
        }
        int dif= depth[u]-depth[v];
        for(int j=LOG-1;j>=0;j--){
            if((dif &(1<<j)) != 0){
                u=up[u][j];
            }
        }
        if(u==v)return u;
        for(int j=LOG-1;j>=0;j--){
            if(up[u][j] != up[v][j]){
                u=up[u][j];
                v=up[v][j];
            }
        }
        return up[u][0];
    }
    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int MOD = 1_000_000_007;
        List<List<Integer>> list = new ArrayList<>();
        int n = edges.length+1;
        //int[] depth=new int[n+1];
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        // boolean[] child= new boolean[n+1];
        for(int e[]: edges){
            list.get(e[0]).add(e[1]);
            list.get(e[1]).add(e[0]);
            // child[e[1]]= true;
        }

        LOG = 0;
        while ((1 << LOG) <= n) {
            LOG++;
        }
        
        up = new int[n+1][LOG];
        depth = new int[n+1];
        // for(int i=1;i<n+1;i++){
        //     if(!child[i]){
                dfs(1,1,list);
        //     }
        // }
        for (int j = 1; j < LOG; j++) {
            for (int i = 1; i <= n; i++) {
                int halfJumpNode = up[i][j - 1];
                if (halfJumpNode != 0) {
                    up[i][j] = up[halfJumpNode][j - 1];
                }
            }
        }
        int out[]= new int[queries.length];
        int p=0;
        for(int q[]: queries){
            int ans = LCA(q[0],q[1]);
            if(q[0]==q[1]){
                out[p++]=0;
                continue;
            }
            int dis = depth[q[0]] + depth[q[1]] - 2 *(depth[ans]);
            long y= dis-1;
            long base = 2;
            long res=1;
            while(y>0){
                if((y&1)==1){
                    res= (res*base) %MOD;
                }
                base= (base*base)%MOD;
                y>>=1;
            }
            out[p++] = (int)res;
        }
        return out;

    }
}