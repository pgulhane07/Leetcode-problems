class Solution {
    public long sumAndMultiply(int n) {
        long res=0;
        long sum=0;
        long k=1;
        while(n >= 1)
        {
            int x= n%10;
            n=n/10;
            if(x == 0)continue;
            res= res + x* k ;
            sum+= x;
            k=k*10;
        }
        return sum * res;
    }
}