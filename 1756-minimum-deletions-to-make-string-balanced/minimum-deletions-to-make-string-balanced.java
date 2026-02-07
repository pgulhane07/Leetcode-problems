class Solution {
    public int minimumDeletions(String s) {
        
        int[] bBefore= new int[s.length()];
        int[] aAfter= new int[s.length()];
        int countA= 0;//(int)s.chars().filter(x->x=='a').count();
        for(char c:s.toCharArray()){
            if(c=='a')countA++;
        }
        int countB= s.length()-countA;

        int curA=0, curB=0;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<s.length();i++){
            if(i-1>=0){
                bBefore[i] = curB;
            }
            if(i+1<s.length()){
                aAfter[i] = countA - curA;
            }

            min= Math.min(min , bBefore[i]+aAfter[i]);
            if(s.charAt(i) == 'a')curA++;
            else{
                curB++;
            }
        }
        return min;
    }
}