class Solution {
    public int maxRotateFunction(int[] nums) {
        int n= nums.length;
        // int res[]= new int[n];
        
        int sum = 0;
        int f0=0;
        int k=0;
        for(int p:nums){
            sum+= p;
            f0 += k * p;
            k++;
        }
        int max=f0;

        for(int i=1;i<nums.length;i++){
            int f1 = f0 + sum - n*(nums[n-i]);
            max= Math.max(f1, max);
            f0=f1;
            // int j=i+1;
            // int prod = 0;
            // int k=1;
            // while((j%n) != i){
            //     prod+= k* nums[j % n];
            //     j=(j+1)%n;
            //     k++;
            // }
            // max= Math.max(max , prod);
            
        }
        return max;
    }
}