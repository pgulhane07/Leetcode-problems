class Solution {
    public int findMin(int[] nums) {
        int i=0, j=nums.length-1;
        int min = Integer.MAX_VALUE;
        if(nums.length==1)return nums[0];
        if(nums[i] < nums[j])return nums[i];
        while(i<j){
            int mid= (i+j)/2;

            min = Math.min(min, nums[mid]);
            if( nums[mid] > nums[mid+1])return nums[mid+1];
            if(nums[mid] < nums[mid-1])return nums[mid];
           
            if(nums[i] < nums[mid]){
                i=mid+1;
            }
            else{
                j = mid-1;
            }
        }
        return min;
    }
}