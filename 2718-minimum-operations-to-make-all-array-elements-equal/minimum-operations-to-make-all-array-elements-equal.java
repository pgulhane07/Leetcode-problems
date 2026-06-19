class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        
        int len= nums.length;
        
        List<Long> res= new ArrayList<>();
        long[] arr= new long[len+1];
        Arrays.sort(nums);
       // arr[0]= nums[0];

        for(int i=1;i<=nums.length;i++){
            arr[i] = arr[i-1]+nums[i-1];
        }

        for(int q:queries){
            int r=-1;
            int i=0,j=len-1;
            while(i<j){
                int mid=i+(j-i)/2;
                if(nums[mid] == q){
                    r=mid;
                    break;
                }
                else if(nums[mid] > q){
                    j=mid;
                }
                else{
                    i=mid+1;
                }
            }
            if(r==-1){
                // if(j<0){
                //     r=0;
                // }
                // else
                    r=i;
            }
            // for(long n:arr){
            //     System.out.print(n+" ");
            // }
            // System.out.println("-=-=-=-=-=-=-=-= ");
            // System.out.println(r+" ");
            // System.out.println(((r)*q)+" left  "+arr[r]);
            // System.out.println(((len-r)*q) + " rigt  "+(arr[len]-arr[r]));
            long left =Math.abs(1L * r*q - arr[r]);
            long right =Math.abs(1L * (len-r)*q - (arr[len]-arr[r]));        

            res.add(left+right);
        }
        return res;
    }
}