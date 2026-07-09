class Solution {

    public boolean BinarySearch(int[] nums, int st, int end, int dif){
        boolean a=false;
        
        while( st < end){
            if(Math.abs(nums[end] - nums[st]) <=dif)return true;
            if(end - st <=1)return false;
            int mid = (st+end)/2;

            if(Math.abs(nums[mid]-nums[st]) <= dif && Math.abs(nums[mid]-nums[end]) <= dif){
                return true;
            }
            else if(Math.abs(nums[mid]-nums[st]) <= dif ){
                // a = BinarySearch(nums, mid+1, end,dif );
                // if(a== false)return false;
                st=mid;
            }
            else if(Math.abs(nums[mid]-nums[end]) <= dif){
                // a = BinarySearch(nums,st, mid-1,dif );
                // if(a== false)return false;
                end= mid;
            }
            else{
                a = BinarySearch(nums, mid, end,dif );
                if(a== false)return false;
                a = BinarySearch(nums,st, mid,dif );
                if(a== false)return false;
                return true;
            }

        }
        return false;

    }

    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        boolean[] res= new boolean[queries.length];
        for( int i=0; i<queries.length;i++){
            int q[] = queries[i];
            int st=Math.min(q[0],q[1]), end =Math.max(q[0],q[1]);
            if(st == end){
                res[i]= true;
                continue;
            }
           // System.out.println("gererg");
            boolean a = BinarySearch(nums, st, end, maxDiff);
            res[i] = a;

        }
        return res;
    }
}