class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int len= nums.length;
        int res[]= new int[len];

        for(int i=0;i<len;i++){
            int n= nums[i]%len;
            int ch= (i + n) % len < 0 ? (i+n+len)%len: (i+n)%len;

            int index = (ch)%len;
            res[i] = nums[index];
        }
        return res;

    }
}