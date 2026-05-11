class Solution {
    public int maximumJumps(int[] nums, int target) {
        
       // int i=0,j=1;
        int step = 0;
        int[] dp= new int[nums.length];
// 0.0.1.1
        int n=nums.length;
        boolean[] arr= new boolean[n];
        arr[0]= true;
        for(int i=0;i<n;i++){
            if(arr[i]){
                for(int j=i+1;j<n;j++){
                    if(Math.abs(nums[j]-nums[i]) <= target){
                        dp[j] = Math.max(dp[j], dp[i]+1);
                        arr[j]=true;
                    }
                }
            }
            
        }
        // while(j != nums.length){
        //     if(Math.abs(nums[j]-nums[i]) <= target){
        //         step++;
        //         i=j;
        //         if(j==nums.length-1)return step;
                
        //     }
        //     j++;
        // }
        // return -1 ;
        return dp[n-1] == 0? -1:dp[n-1];
    }
}