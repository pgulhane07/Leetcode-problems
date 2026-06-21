class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int max=0;
        for(int n:costs){
            max= Math.max(max, n);
        }
        int[] arr= new int[max+1];
        for(int n:costs){
            arr[n]++;
        }
        int val=0;
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] !=0){
                if(arr[i]*i+val >coins){
                    int rem = coins-val;
                    int x= rem/i;
                    cnt+= x;
                    val+= x*i;
                    return cnt;
                }
                val+= arr[i]*i;
                cnt+=arr[i];
                // if(val)
            }
        }
        return cnt;
    }
}