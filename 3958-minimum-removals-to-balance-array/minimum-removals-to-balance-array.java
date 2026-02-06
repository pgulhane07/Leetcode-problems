class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int ans=0;
        int len=nums.length;
        int min=0;
        int j=0;
        for(int i=0;i< nums.length;i++ ){
            //int j=nums.length-1;

            while(nums[i] > (long)nums[j] * k){
                j++;
            }
            min= Math.max(min, i-j+1);
        }
        return len-min;      
    }
}