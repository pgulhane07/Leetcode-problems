class Solution {

    public int minElement(int[] nums) {
        // PriorityQueue<Integer> pq= new PriorityQueue<>();
        int min= Integer.MAX_VALUE;
        for(int n:nums){
            int sum = 0;
            while(n>0){
                sum+= n%10;
                n=n/10;
            }
            // pq.add(sum);
            min = Math.min(min, sum);
        }
        return min;
    }
}