class Solution {
    public int minOperations(String s) {
        int cnt1=0,cnt2=0;
        //0101010
        for(int i=0;i<s.length();i++){
            char c= s.charAt(i);
            if(i%2 ==0 && c!='0')cnt1++;
            else if(i%2 ==1 && c!='1')cnt1++;
        }
        for(int i=0;i<s.length();i++){
            char c= s.charAt(i);
            if(i%2 ==1 && c!='0')cnt2++;
            else if(i%2 ==0 && c!='1')cnt2++;
        }
        return Math.min(cnt1,cnt2);
    }
}