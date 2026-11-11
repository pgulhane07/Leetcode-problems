class Solution {
    public int removeDuplicates(int[] nums) {
        int st=0;
        nums[st++] = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i] != nums[i-1]){
                nums[st++] = nums[i];
            }
        }
        return st;
    }
}