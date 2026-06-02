class Solution {

    public int solve(int[] arr1, int[] time1, int[] arr2, int[] time2){
        int a= Integer.MAX_VALUE;
        for(int i=0;i<arr1.length;i++){
            a= Math.min(a, arr1[i]+time1[i]);
        }
        int b = Integer.MAX_VALUE;
        for(int i=0;i<arr2.length;i++){
            b= Math.min(b, Math.max(a,arr2[i])+time2[i]);
        }
        return b;

    }
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        
        int a = solve(landStartTime,landDuration,waterStartTime,waterDuration);
        int b = solve(waterStartTime,waterDuration,landStartTime,landDuration);
        return Math.min(a,b);
    }
}