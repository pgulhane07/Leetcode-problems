class Solution {
    public int countPrimes(int n) {

        if(n<=2)return 0;

        boolean[] arr= new boolean[n];

        for(int i=2;i<=(int)Math.sqrt(n);i++){
            if(arr[i])continue;
            for(int j=i*i ;j<n;j=j+i){
                arr[j]= true;
            }
        }
        int cnt=0;
        for(int i=2;i<n;i++){
            if(!arr[i])cnt++;
        }
        return cnt;
        
    }
}