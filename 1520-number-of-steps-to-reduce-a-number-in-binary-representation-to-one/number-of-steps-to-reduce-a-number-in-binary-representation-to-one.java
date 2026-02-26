class Solution {
    public int numSteps(String s) {
            int cnt=0;
        while(s.length() > 1){
            int len= s.length();
            if(s.charAt(len-1) == '1'){
                int j=len-1;
                StringBuilder sb= new StringBuilder();
                while(j>=0 && s.charAt(j) == '1'){
                    sb.append("0");
                    j--;
                }
                sb.append("1");
                j--;
                while(j>=0){
                    sb.append(s.charAt(j));
                    j--;
                }
                s= sb.reverse().toString();
                
            }
            else{
                
                s= s.substring(0,len-1);
            }
            cnt++;

        }
        return cnt;

        
    }
}