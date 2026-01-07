class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int less=0, more=0, eq=0;
        for(int n:nums){
            if(n < pivot)less++;
            else if(n > pivot)more++;
            else{
                eq++;
            }
        }
        int res[]= new int[nums.length];
        int p=0;
        for(int n :nums){
            if(n < pivot){
                res[p++] = n;
            }
        }
        for(int i=0;i<eq;i++){
            res[p++]= pivot;
        }
        for(int n :nums){
            if(n > pivot){
                res[p++] = n;
            }
        }
        return res;
    }
}