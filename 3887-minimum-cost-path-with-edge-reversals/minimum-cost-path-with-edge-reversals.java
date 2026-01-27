class Solution {
    // int last;
    // boolean visited[];
    // int[] dp;
    // public int dfs(int node , List<List<int[]>> incoming, List<List<int[]>> out){
    //     if(node == last)return 0;

    //     //if(dp[node] != -1)return dp[node];
    //     //int min=cost;
    //     int cost1=Integer.MAX_VALUE,cost2=Integer.MAX_VALUE;
    //     visited[node]=true;
    //     for(int[] x : out.get(node)){
    //         if(!visited[x[0]]){
    //             visited[x[0]]=true;
    //             cost1 = Math.min(cost1, dfs(x[0],incoming, out) + x[1]);
    //             visited[x[0]]=false;
    //         }
                
    //     }
    //     for(int[] x : incoming.get(node)){
    //         if(!visited[x[0]]){
    //              visited[x[0]]=true;
    //              cost2 = Math.min(cost2, dfs(x[0],incoming, out)+x[1]);
    //              visited[x[0]]=false;
    //         }
    //     }
    //     visited[node]=false;
    //    // dp[node] = Math.min(cost1,cost2);
    //     return  Math.min(cost1,cost2);//dp[node];
        
        
    // }
    // int res=Integer.MAX_VALUE;
    // public boolean dfs1(int node, List<PriorityQueue<int[]>> list, int cost ){

    //     if(node == last){
    //         res= Math.min(res,cost);
    //         return true;
    //     }

    //     visited[node]=true;
    //    // List<int[]> temp= ;
    //     for(int n[]: list.get(node)){
    //         if(!visited[n[0]]){
    //             System.out.println(n[0]+" "+n[1]);
    //             int c= cost+n[1];
    //             if(dfs1(n[0], list,c) )return true;
    //         }
    //     }
    //     visited[node]=false;
    //     return false;

    // }
    public int minCost(int n, int[][] edges) {
        int last=n-1;
        // dp=new int[n];
        // Arrays.fill(dp,1000000);
        boolean[] visited=new boolean[n];
        List<List<int[]>> list=new ArrayList<>();
        // List<List<int[]>> out=new ArrayList<>();
        for(int i=0 ;i<n;i++){
            list.add(new ArrayList<>());
           // out.add(new ArrayList<>());
        }
        for(int[] x : edges){
            // incoming.get(x[1]).add(new int[]{x[0],2 * x[2]});
            list.get(x[0]).add(new int[]{x[1],x[2]});
            list.get(x[1]).add(new int[]{x[0],2 * x[2]});
        }

        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->a[1]-b[1]);
        int[] dist= new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0]=0;

        pq.add(new int[]{0,0});

        while(!pq.isEmpty()){
            int[] x=pq.poll();
            if(x[0] == last)return x[1];
            if(visited[x[0]])continue;
            
            visited[x[0]] = true;
            for(int[] nod : list.get(x[0])){
                if(x[1]+ nod[1] < dist[nod[0]]){
                    dist[nod[0]] = x[1]+ nod[1];
                    pq.add(new int[]{nod[0],x[1]+ nod[1]});
                }
            }
        }
        return -1;

        // dfs1(0,list, 0);
        // return res== Integer.MAX_VALUE? -1 : res;
        //dp[0]=0;
        // for(int i=0;i<n;i++){
        //     for(int[] x:incoming.get(i)){
        //         dp[x[0]] = Math.min(dp[x[0]] , dp[i]+x[1]);
        //     }
            
        // }
        //    for(int i=0;i<n;i++){
        //     System.out.print(dp[i]+" ");
        // }
        // System.out.println();
        
        // for(int i=0;i<n;i++){
        //     for(int[] x:out.get(i)){
        //         dp[x[0]] = Math.min(dp[x[0]] , dp[i]+x[1]);
        //     }
            
        // }
        
        // for(int i=0;i<n;i++){
        //     System.out.print(dp[i]+" ");
        // }
        // System.out.println();
        
        // for(int j=0;j<incoming.size();j++){
        //    // int i=0;
        //     for(int[] x:incoming.get(j)){
        //         System.out.println(x[0] + " -- "+j+"----val;; "+x[1]);
        //         //i++;
        //     }
        // }
        // // i=0;

        // System.out.println(";uttkjnkc sdsdasdvsv");
        // for(int j=0;j<incoming.size();j++){
        //     for(int[] x:out.get(j)){
        //         System.out.println(j + " -- "+x[0]+"----val;; "+x[1]);
        //        // i++;
        //     }
        // }
        // return dp[n-1] >= 1000000 ? -1 : dp[n-1];
        // int res= dfs(0,incoming, out);
        // return res == Integer.MAX_VALUE ? -1 : res;
        
    }
}



//    <-18----
// 1  --23-->   2.      
// |         /
// 23.     8
// |      /
// v    /
// 0

