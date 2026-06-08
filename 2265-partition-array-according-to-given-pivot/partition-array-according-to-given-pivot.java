class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int pcnt=0;
        for(int n :nums){
            if(n<pivot){
                left.add(n);
            }
            else if(n>pivot)right.add(n);
            else{
                pcnt++;
            }
        }
        int res[]= new int[nums.length];
        int k=0;
        for(int n:left){
            res[k++]= n ;
        }
        for(int i=0;i<pcnt;i++){
            res[k++]=pivot;
        }
        for(int n:right){
            res[k++]= n ;
        }
        return res;

    }
}