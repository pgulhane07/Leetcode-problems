class Solution {
    public boolean isGood(int[] nums) {
        int k = nums.length-1;
        Map<Integer,Integer> map= new HashMap<>();
        for(int n:nums)map.put(n,map.getOrDefault(n,0)+1);
        int ncnt=0;
        for(int i=1;i<k;i++){
            if(!map.containsKey(i))return false;
        }
        if(map.containsKey(k) && map.get(k) == 2 )return true;
        return false;
    }
}