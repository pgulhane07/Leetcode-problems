class Solution {
    public int jump(int[] nums) {
        int sum=0;
        int[] arr= new int[nums.length];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[0]=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<=Math.min(nums.length-1,i+nums[i]);j++){
                arr[j]= Math.min(arr[j],arr[i]+1);
                // if(j == nums.length-1)return arr[j];
            }
            // for(int n:arr){
            //     System.out.print(n+" ");
            // }
            // System.out.println();

        }
        return arr[nums.length-1];
    }
}