class Solution {
    // int len;
    // //List<Integer> finalList;
    // long maxpath;
    // int res;
    // // int visited
    // public void dfs(int node, List<List<int[]>> list, long sum, int min, boolean[] online){

    //     if(node == len){
           
    //         if(sum > maxpath)return;
    //         res= Math.max(res, min);
    //         return;
    //     }
        
    //     List<int[]> x= list.get(node);
    //     for(int i=0;i<x.size();i++){
    //         int[] t= x.get(i);
    //         if(!online[t[0]])return;
    //         min= Math.min(min, t[1]);
    //         temp.add(t[0]);
    //         dfs(t[0],list,temp, sum+t[1],min, online) ;
    //         temp.remove(temp.size()-1);
    //     }
        
        
    // }
    public long dfs(List<List<int[]>> list, long mid, int node,int target, long[] temp)
    {
        if(node == target)return 0;

        if(temp[node] != -1)return temp[node];

        long min = Long.MAX_VALUE;
        for(int[] x : list.get(node)){
            if(x[1] >= mid){
                long next = dfs(list,mid, x[0],target, temp);
                if(next!= Long.MAX_VALUE){
                    min = Math.min(min,next+x[1]);
                }
            }
        }
        temp[node] = min;
        return temp[node];

    }
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        if(edges.length == 0)return -1;
        int len= online.length-1;
        // finalList= new ArrayList<>();
        // maxpath= k;
        List<List<int[]>> list= new ArrayList<>();
        for(int i=0;i<online.length;i++){
            list.add(new ArrayList<>());
        }
        long max=0;
        for(int[] x: edges){
            if(online[x[1]] && online[x[0]] ){
                list.get(x[0]).add(new int[]{x[1],x[2]});
                max= Math.max(max, x[2]);
            }
        }
        long i=0,j = max;
        long res = -1;
        while(i<=j){
            long mid = i+(j-i)/2;

            long[] temp = new long[online.length+1];
            Arrays.fill(temp, -1);
            long val = dfs(list, mid, 0, len, temp);
            if(val <=k){
                res= mid;
                i=mid+1;
            }
            else{
                j=mid-1;
            }
        }
        return (int)res;

        
    }
}