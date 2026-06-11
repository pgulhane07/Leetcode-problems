class Solution {
    public int calculate(int max, int i){
        int x=i, num=1;
        for(int j=0;j<x;j++){
            num= num* max;
            max--;
        }
        int deno=1;
        for(int m=0;m<i;i++){
            deno = deno * i;
            i--;
        }
        return (num/deno)%1000000007;
    }
    public int assignEdgeWeights(int[][] edges) {
        int MOD = 1_000_000_007;
        Deque<Integer> dq= new ArrayDeque<>();
        List<List<Integer>> list= new ArrayList<>();
        for(int i=0;i<edges.length+2;i++){
            list.add(new ArrayList<>());
        }
        //Arrays
        boolean[] arr= new boolean[edges.length+2];
        for(int e[]:edges){
            list.get(e[0]).add(e[1]);
            arr[e[1]]= true;
        }
        for(int i=1;i<edges.length+2;i++){
            if(!arr[i])dq.add(i);
        }
        int depth=0;
        System.out.println(dq);
        while(!dq.isEmpty()){
            int len=dq.size();
            for(int i=0;i<len;i++){
                int x= dq.poll();
                for(int p:list.get(x)){
                    dq.add(p);
                }
            }
            if(dq.isEmpty())break;
          //  System.out.println(dq);
            depth++;
        }
        System.out.println(depth);
        long y= depth-1;
        long base = 2;
        long res=1;
        while(y>0){
            if((y&1)==1){
                res= (res*base) %MOD;
            }
            base= (base*base)%MOD;
            y>>=1;
        }
        return (int)res;

        // HashMap<Integer,Integer> map=new HashMap<>();
        // int max=0;
        // Arrays.sort(edges, (a,b) -> Integer.compare(a[0],b[0]));
        // for(int[] n : edges){
        //     int num=map.getOrDefault(n[0],0)+1;
        //     if(num > max)max =num;
        //     map.put(n[1],num);
        // }
        // System.out.println(map);
        // int sum=0;
        // if(max %2 != 0){
        //     for(int i=1;i<=max;i=i+2){
        //         sum+= calculate(max, i);
        //     }
        //     return sum;
        // }else{
        //     return max;
        // }
        
    }
}