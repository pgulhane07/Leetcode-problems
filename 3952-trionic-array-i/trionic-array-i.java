class Solution {
    public boolean isTrionic(int[] nums) {
        boolean flag=false, flag1=false;
        for(int i=1;i<nums.length-1;i++){
            if(nums[i-1] < nums[i] && nums[i+1] < nums[i]){
                if(flag1 && flag)return false;
                flag = true;
            }
            else if(flag && nums[i-1] > nums[i] && nums[i+1] > nums[i] ){
                if(flag1 && flag)return false;
                flag1= true;
            }
            else if(!flag && nums[i-1] > nums[i] && nums[i+1] > nums[i]){
                return false;
            }
            if(nums[i-1] == nums[i] || nums[i]==nums[i+1])return false;

        }

        return flag1 && flag;


        // int flag=1;
        // int num=nums[0];
        // for(int i=1;i<nums.length;i++){
        //     if(nums[i] > num && flag==2)flag++;
        //     if(nums[i] > num){
        //         num= nums[i];
        //     }
        //     else if(nums[i] < num && flag == 1){
        //         flag++;
        //         num=nums[i];
        //     }
        //     else if(nums[i] < num && flag == 2){
        //         continue;
        //     }
        // }
        // if(flag==2)return true;
        // return false;
    }
}