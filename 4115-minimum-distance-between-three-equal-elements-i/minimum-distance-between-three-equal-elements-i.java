class Solution {
    public int minimumDistance(int[] nums) {
        int min= Integer.MAX_VALUE;
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                if(nums[i] != nums[j])continue;
                for(int k=j+1;k<nums.length;k++){
                    if(nums[j]==nums[k]){
                        min = Math.min(min, Math.abs(i-k)+Math.abs(i-j)+Math.abs(k-j));
                    }
                }
            }
        }
        return min==Integer.MAX_VALUE? -1:min;
    }
}