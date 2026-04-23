class Solution {
    public long[] distance(int[] nums) {
        Map<Integer,List<Integer> > map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int n=nums[i];
            if(!map.containsKey(n)){
                map.put(n , new ArrayList<>());
            }
            map.get(n).add(i);
        }
        long[] res= new long[nums.length];
        //long[] res = new long[n];
        for (List<Integer> group : map.values()) {
            long total = 0;
            for (int idx : group) {
                total += idx;
            }
            long prefixTotal = 0;
            int sz = group.size();
            for (int i = 0; i < sz; i++) {
                int idx = group.get(i);
                res[idx] = total - prefixTotal * 2 + (long) idx * (2 * i - sz);
                prefixTotal += idx;
            }
        }
        return res;
    }
}