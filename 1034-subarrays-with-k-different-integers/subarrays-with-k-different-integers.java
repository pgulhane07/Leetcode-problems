class Solution {

    public int get(int[] nums ,int k){

        Map<Integer, Integer> map = new HashMap<>();
        int i=0;
        int cnt = 0;
        for(int j=0;j< nums.length;j++){
            
            map.put(nums[j], map.getOrDefault(nums[j], 0)+1);

            while(i< nums.length && map.size() > k){

                if(map.get(nums[i]) == 1){
                    map.remove(nums[i]);
                }
                else{
                    map.put(nums[i],map.get(nums[i]) -1);
                }
                i++;
            }
            cnt += (j-i+1);
        }
        return cnt;
        
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        
        return get(nums, k ) - get(nums, k-1);
    }
}