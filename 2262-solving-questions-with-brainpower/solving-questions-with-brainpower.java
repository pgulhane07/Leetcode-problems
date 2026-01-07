class Solution {
    long[] max;
    public long rec(int index, int[][] arr){

        if(index >= arr.length)return 0;
        if(max[index]!=-1)return max[index];
        long a  = arr[index][0] + rec(index +1+ arr[index][1] , arr);
        long b  = rec(index+1,arr);
        max[index] = Math.max(a,b);
        return Math.max(a,b);

    }

    public long mostPoints(int[][] questions) {
        max= new long[questions.length];
        Arrays.fill(max, -1);
        return rec(0, questions);
    }
}