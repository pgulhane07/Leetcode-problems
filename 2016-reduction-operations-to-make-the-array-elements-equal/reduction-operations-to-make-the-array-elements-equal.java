class Solution {
    public int reductionOperations(int[] nums) {
        Map<Integer, Integer> map= new TreeMap<>();
        for(int n:nums)
        {
            map.put(n, map.getOrDefault(n, 0)+1);

        }
        //System.out.println(map);
        if(map.size()==1)return 0;
        Set<Integer> set= map.keySet();
        List<Integer> list= new ArrayList<>(set);
        //System.out.println(list);
        int sum=0;
        for(int i=list.size()-1;i>0;i--){
            int nos=map.get(list.get(i));
            sum=  sum+ nos;
            map.put(list.get(i-1), map.get(list.get(i-1))+nos);
            // System.out.print(sum+" ");
            // System.out.println(map);
            // System.out.println(list);
        }
        return sum;
    }
}