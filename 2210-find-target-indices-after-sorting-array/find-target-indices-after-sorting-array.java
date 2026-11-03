class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        //Arrays.sort(nums);
        int more=0, less=0;
        List<Integer> res = new ArrayList<>();
        for(int i=0;i< nums.length;i++){
            if(nums[i] > target ){
                more++;
            }
            else if(nums[i] < target)less++;
        }
        if(less + more == nums.length)return new ArrayList<>();
        int cnt = nums.length - less - more;
        for(int i=less;i<less+cnt;i++)res.add(i);
        return res;
    }
}