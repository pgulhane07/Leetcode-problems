class Solution {
    public int minMoves(int[] nums, int limit) {
        int n= nums.length;
        int[] dif= new int[2*limit+2];
        for(int i=0;i<n/2;i++){
            int A = Math.min(nums[i], nums[n-1-i]);
            int B = Math.max(nums[i], nums[n-1-i]);

            dif[2] += 2;
            dif[A+ 1] -= 1;
            dif[A+B] -=1;
            dif[A+B+1] +=1;
            dif[B + limit+1] +=1;
        }
        int max= n;
        int cur=0;
        for(int i=2;i<=2*limit;i++){
            cur += dif[i];
            max= Math.min(max, cur);
        }
        return max;
    }
}