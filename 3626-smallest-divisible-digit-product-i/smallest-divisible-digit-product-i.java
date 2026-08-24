class Solution {
    public int getProd(int n){
        int prod = 1;
        while(n > 0){
            int k = n%10;
            prod= prod * k;
            n = n/10;
        }
        return prod;
    }
    public int smallestNumber(int n, int t) {
        
        while(true){
            int prod = getProd(n);
            if(prod % t == 0)return n;
            n++;
        }

    }
}