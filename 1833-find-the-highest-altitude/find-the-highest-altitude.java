class Solution {
    public int largestAltitude(int[] gain) {
        int max= 0;
        int elevation=0;
        for(int n:gain){
            elevation += n;
            max= Math.max(max, elevation);
        }
        return max;
    }
}