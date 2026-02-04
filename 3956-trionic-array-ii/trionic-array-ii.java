class Solution {
    public long maxSumTrionic(int[] nums) {
        int len= nums.length;
        long max= -1_000_000_000_000_000L;
        long start= nums[0];
        long up1= -1_000_000_000_000_000L;
        long up2= -1_000_000_000_000_000L;
        long down= -1_000_000_000_000_000L;
        // int dp0[]= new int[len];
        // int dp1[]= new int[len];
        // int dp2[]= new int[len];
        // int dp3[]= new int[len];
        // // Arrays.fill(dp1, Integer.MIN_VALUE);
        // // Arrays.fill(dp2, Integer.MIN_VALUE);
        // // Arrays.fill(dp3, Integer.MIN_VALUE);
        // dp1[0]=0;
        // dp2[0]=0;
        // dp3[0]=0;
        for(int i=1;i<len;i++){
            long cur= nums[i];
            long prevstart= start;
            long prevup1= up1;
            long prevup2= up2;
            long prevdown= down;

            start= cur;
            up1= -1_000_000_000_000_000L;
            up2= -1_000_000_000_000_000L;
            down= -1_000_000_000_000_000L;            
            if(nums[i] > nums[i-1]){

                up1= Math.max(prevstart,prevup1)+cur;
                up2= Math.max(prevdown,prevup2)+cur;
                // dp1[i]= Math.max(dp1[i-1]+nums[i], dp0[i-1]+nums[i]);
                // dp3[i]= Math.max(dp2[i-1]+nums[i], dp3[i-1]+nums[i]);
                // dp0[i]=dp0[i-1] + nums[i];
            }
            else if(nums[i] < nums[i-1]){
                down = Math.max(prevup1, prevdown)+cur;
                //dp2[i] = Math.max(dp2[i-1]+nums[i] , dp1[i-1]+nums[i]);
            }

            max= Math.max(max, up2);
        }
        
        // for(int n:dp3){
        //     max= Math.max(max, n);
        // }
        return max;
    }
}