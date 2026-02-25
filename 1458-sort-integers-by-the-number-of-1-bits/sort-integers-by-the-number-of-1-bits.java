class Solution {
    public int[] sortByBits(int[] arr) {
        // Integer[] ar=new Integer[arr];
        PriorityQueue<Integer> pq= new PriorityQueue<>((a, b)->{
            if(Integer.bitCount(a) == Integer.bitCount(b)){
                return a-b;
            }
            else{
                return Integer.bitCount(a) - Integer.bitCount(b);
            }
        });
        for(int n:arr){
            pq.add(n);
        }
        int index=0;
        int res[]= new int[arr.length];
        while(!pq.isEmpty()){
            res[index++]=pq.poll();
        }
        return res;
    }
}