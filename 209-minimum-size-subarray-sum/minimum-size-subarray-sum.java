class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0, j=0;
        int sum=0;
        int length = Integer.MAX_VALUE;

        for(j=0; j < nums.length; j++){

            sum+= nums[j];
            

            while( sum >= target){
                sum -= nums[i];
                length = Math.min(length, j-i+1);
                i++;
            }
            // j++;
        }
        // while( i < nums.length && sum > target){
        //     sum -= nums[i];
        //         length = Math.min(length, j-i+1);
        //         i++;
        // }
        return length== Integer.MAX_VALUE ? 0:length;
    }

}