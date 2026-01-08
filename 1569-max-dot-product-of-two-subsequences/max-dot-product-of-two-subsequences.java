class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int row= nums1.length, col= nums2.length;
        //int[][] dp= new int[row+1][col+1];
        int min1=Integer.MAX_VALUE, min2= Integer.MAX_VALUE;
        int max1=Integer.MIN_VALUE, max2= Integer.MIN_VALUE;
        for(int i=0;i<row;i++){
            min1= Math.min(min1, nums1[i]);
            max1= Math.max(max1, nums1[i]);
        }
        for(int i=0;i<col;i++){
            min2= Math.min(min2, nums2[i]);
            max2= Math.max(max2, nums2[i]);
        }

        if(min1 > 0 && max2 < 0){
            return max2* min1;
        }
        if(max1 < 0 && min2 > 0){
            return max1 * min2;
        }
        //int max=Integer.MIN_VALUE;
        int temp[]= new int[col+1];
        int dp1[]=new int[col+1];
        for(int i=row-1;i>=0;i--){
            dp1=new int[col+1];
            for(int j=col-1;j>=0;j--){
                
                int use = nums1[i]*nums2[j] + temp[j+1];

                dp1[j] = Math.max(use, Math.max(temp[j], dp1[j+1]));
                // int len=Math.min(row-i, col-j);
                // int prod=0;
                // for(int k=0;k<len; k++){
                //     prod += nums1[i+k] * nums2[j+k];
                //     max= Math.max(max, prod);
                // }
                // dp[i][j] = prod;
                
            }
            temp=dp1;

        }
        return dp1[0];
    }
}