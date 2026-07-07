class Solution {
    public int[] getOrder(int[][] tasks) {

        int[][] arr= new int[tasks.length][3];
        // int p=0;
        for(int i=0;i<tasks.length;i++){
            arr[i][0] = tasks[i][0];
            arr[i][1] = tasks[i][1];
            arr[i][2] = i;
        }
        Arrays.sort(arr, (a,b)->{
            if(a[0]==b[0])return a[1]-b[1];
            return a[0] - b[0];
        });

        // for(int n[]: arr){
        //     System.out.println(n[0]+" "+n[1]+" "+n[2]);
        // }
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->{
            if(a[1]==b[1])return a[2]-b[2];
            return a[1] - b[1];
        });
    
        int[] x= arr[0];
    
        pq.add(new int[]{x[0],x[1],x[2]});
        // for(int i=0;i< tasks.length; i++){
        //     pq.add(new int[]{tasks[i][0],tasks[i][1],i});
        // }
        int j=1;
        int q=0;
        int time = x[0];
        int[] res= new int[arr.length];
        while(!pq.isEmpty()){
            int [] s= pq.poll();

            time += s[1];
            res[q++] = s[2];
            while(j< arr.length && arr[j][0] <= time){
                pq.add(new int[]{arr[j][0], arr[j][1], arr[j][2]});
                j++;
            }

            if(j  < arr.length  && pq.isEmpty()){
               pq.add(new int[]{arr[j][0], arr[j][1], arr[j][2]});
               time = arr[j][0];
               time+= arr[j][1];
               j++;
            }
        }
        return res;

    }
}