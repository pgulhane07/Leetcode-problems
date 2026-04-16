class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        Map<Integer, List<Integer>> map= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }   
        int len =nums.length;
        List<Integer> res= new ArrayList<>();
        int[] minDist= new int[len];
        Arrays.fill(minDist, -1);
        for(List<Integer> temp:map.values())
        {   int size= temp.size();
            if(temp.size()==1)continue;
            for(int i=0;i< temp.size();i++){
                int curr= temp.get(i);
                int next= temp.get((i+1)%size);
                int prev= temp.get((i-1+size)%size);

                int left= Math.abs(curr-prev);
                left= Math.min(left, len-left);
                int right= Math.abs(curr-next);
                right= Math.min(right, len-right);
                minDist[curr] = Math.min(left, right);
            }
            
        }
        for(int q:queries){
            res.add(minDist[q]);
        }
        

    //     Map<Integer, Integer> store = new HashMap<>();
    //    // System.out.println(map);
    //     
    //     for(int i=0;i<queries.length;i++){
    //         int q= queries[i];
    //         if(store.containsKey(q)){
    //             res.add(store.get(q));
    //             continue;
    //         } 
    //         if(map.containsKey(nums[q])){
    //             int min= Integer.MAX_VALUE;
    //             List<Integer> temp= map.get(nums[q]);

    //            // System.out.println(i+" <-query| list-> "+temp);
    //             if(temp.size()==1){
    //                res.add(-1);
    //                store.put(q, -1);
    //                 continue;
    //             }
    //             else{
    //                 for(int n : temp){
    //                     if(n == q)continue;
    //                     int dif= Math.abs(q - n);
    //                     int cir= nums.length-dif;
    //                     min= Math.min(min, Math.min(dif, cir));
    //                 }
    //                 res.add(min);
    //                 store.put(q, min);
    //             }

    //         }
    //         else{
    //             store.put(q, -1);
    //             res.add(-1);
    //         }
            

    //     }
        return res;
    }
}