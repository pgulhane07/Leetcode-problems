class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited= new boolean[arr.length];

        Deque<Integer> dq= new ArrayDeque<>();
        dq.add(start);
        //System.out.println(dq);
        while(!dq.isEmpty()){
            int x= dq.poll();
            //if(arr[x]==0)return true;
            if(x+arr[x] < arr.length && !visited[x+arr[x]]){
                if(arr[x+arr[x]]==0)return true;
                visited[x+arr[x]]= true;
                dq.add(x+arr[x]);
            }
            if(x-arr[x] >=0  && !visited[x-arr[x]]){
                if(arr[x-arr[x]]==0)return true;
                visited[x-arr[x]]= true;
                dq.add(x-arr[x]);
            }
           // System.out.println(dq);
        }
        return false;
    }
}