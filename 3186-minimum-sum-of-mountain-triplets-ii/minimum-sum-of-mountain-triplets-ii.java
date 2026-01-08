class Solution {
    public int minimumSum(int[] nums) {
        int postmin[]= new int[nums.length];
        int min =Integer.MAX_VALUE;//nums[nums.length-1];
        postmin[nums.length-1]= min;
        for(int i=nums.length-2;i>=0;i--){
            min= Math.min(min, nums[i+1]);
            postmin[i]= min;
        }
        // for(int n:postmin)
        //     System.out.print(n+" ");

        int res= Integer.MAX_VALUE;
        int run=nums[0];
        for(int i=1;i<nums.length-1;i++){
            if(nums[i] > run && nums[i]> postmin[i]){
                res= Math.min(res, run+nums[i]+postmin[i]);
            }
            run= Math.min(run, nums[i]);
        }
        return res== Integer.MAX_VALUE ? -1:res;
    }
}