class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int l=0;
        int oddcnt=0;
        int res=0;
        int even=0;
        for(int j=0;j<nums.length;j++){

            oddcnt+= nums[j]%2;

            if(oddcnt == k){
                even=0;
                while(oddcnt == k){
                    oddcnt -= nums[l]%2;
                    l++;
                    even++;
                }        
            }
            res+= even;

        }
        return res;
    }
}
//[2,2,2,1,2,2,1,2,2,2]