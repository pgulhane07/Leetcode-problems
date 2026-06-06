class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] right= new int[nums.length];
        int[] res= new int[nums.length];
        for(int i=nums.length-2;i>=0;i--){
            right[i] = right[i+1]+nums[i+1];
        }
        // for(int n:right){
        //     System.out.print(n+" ");
        // }
        int left=0;
        for(int i=0;i<nums.length;i++){
            res[i] = Math.abs(left - right[i]);
            left+=nums[i];
        }
        return res;
    }
}