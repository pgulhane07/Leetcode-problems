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
    // public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
    //     PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->a[0]-b[0]);
    //     for(int i=0;i<landStartTime.length;i++){
    //         pq.offer(new int[]{i, landStartTime[i],landStartTime[i]+landDuration[i] , 1});
    //     }
    //     for(int i=0;i<waterStartTime.length;i++){
    //         pq.offer(new int[]{i, waterStartTime[i],waterStartTime[i]+waterDuration[i] , 2});
    //     }
    //     int time=0;
    //     int prev=-1;
    //     boolean land=false, water=false;
    //     while(!pq.isEmpty()){
    //         int[] arr= pq.poll();
    //         if(arr[3] == 1 && !land){
    //             if(water){
    //                 water
    //             }
    //             land = true;
    //             time=arr[2];
    //         }
            
    //     }
    // }
}