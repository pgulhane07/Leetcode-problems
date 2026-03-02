class Solution {
    public int concatenatedBinary(int n) {
        int res=0;
        StringBuilder sb= new StringBuilder();
        for(int i=1;i<=n;i++){
            String s= Integer.toBinaryString(i);
            sb.append(s);
            long x = Long.parseLong(sb.toString(),2);
            if(x > 1000000007){
                sb= new StringBuilder();
                x = x % 1000000007;
                sb.append(Long.toBinaryString(x));
            }
            
        }
        return Integer.parseInt(sb.toString(),2) % 1000000007;
    }
}