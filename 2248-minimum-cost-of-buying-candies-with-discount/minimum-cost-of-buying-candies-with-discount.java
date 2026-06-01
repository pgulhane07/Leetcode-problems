class Solution {
    public int minimumCost(int[] cost) {
        int sum = 0;
        Arrays.sort(cost);
        for(int i=cost.length-1,j=0;i>=0;i--,j++){
            if((j+1)%3 == 0){
                continue;
            }
            sum+=cost[i];
        }
        return sum;
    }
}