class Solution {
    public int missingInteger(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int prev= nums[0];
        int sum = nums[0];
        int len = 1;
        int maxlen= 1, maxSum = nums[0];
        // set.add(nums[0]);
        for(int n:nums)set.add(n);
        for(int i=1;i<nums.length;i++){
            
            if(nums[i] - prev == 1){
                len++;
                sum+= nums[i];
                if(sum > maxSum){
                    maxlen = len;
                    maxSum = sum;
                }
            }
            else{
                // len=1;
                // sum = nums[i];
                // maxSum = Math.max(maxSum, sum);
                break;
            }
           // set.add(nums[i]);
            prev = nums[i];
        }
        int k = maxSum;
        while(true){
            if(!set.contains(k))return k;

            k++;
        }
    }

}