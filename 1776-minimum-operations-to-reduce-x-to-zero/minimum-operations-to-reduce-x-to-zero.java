class Solution {
    public int minOperations(int[] nums, int x) {
        
        int[] arr= new int[nums.length];
        arr[0] = nums[0];
        for(int i=1;i<nums.length; i++){
            arr[i] = arr[i-1]+ nums[i];
        }
        if(arr[nums.length-1] < x)return -1;
        if(arr[nums.length-1] == x)return nums.length;

        int min= Integer.MAX_VALUE;
        int sum=0;
        int ops = 0;
        for(int i=nums.length-1;i>=0;i--){
            //int ops = (nums.length-1) - i;
            // if(i==0){
            //     break;
            // }
           // if(sum > x)return -1;
            int st= 0, end = i;
            int val = 0;
            if(i+1 < nums.length){
                val = sum;
            }
            int req = x- val;
            if(req== 0){
                min = Math.min(min, ops);
                ops++;
                break;

            }
            int index=-1;
            while(st <= end){
                int mid = st + (end-st)/2;
                if(arr[mid] > req){
                    end = mid-1;
                }
                else if(arr[mid] < req){
                    st= mid+1;
                }
                else{
                    index = mid;
                    end= mid-1;
                }
            }
            if(index != -1){
                min = Math.min(min, index+1+ops);
            }
            sum+= nums[i];
            ops++;
        }
        return min == Integer.MAX_VALUE ? -1 : min;

    }
}