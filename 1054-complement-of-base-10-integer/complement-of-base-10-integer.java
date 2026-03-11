class Solution {
    public int bitwiseComplement(int n) {
        String s= Integer.toBinaryString(n);
        int k=0;
        int sum=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i) == '0'){
                sum+= Math.pow(2, k);
            }
            k++;
        }
        return sum;
    }
}