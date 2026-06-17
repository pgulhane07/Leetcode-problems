class Solution {
    public char processStr(String s, long k) {
        // StringBuilder sb= new StringBuilder();
        long len=0;
        for(char c:s.toCharArray()){
            switch(c){

            case '*':
            
                if(len>0){
                    len--;
                }
                break;
                // if(sb.length()>=1){
                //     sb.setLength(sb.length()-1);
                // }
            
            case '#':
                len= 2*len;
                // sb.append(sb.toString());
                break;
            case '%':
                break;

                // String x= sb.reverse().toString();
                // sb= new StringBuilder();
                // sb.append(x);
            default:
                len++;
                 break;        
            
            
            }
        }   
        if(len <  k+1)return '.';
        
        for(int i=s.length()-1;i>=0;i--){
            char c= s.charAt(i);
            switch(c){

            case '*':
                len++;
                break;
                
            case '#':
                if(k+1 > (len+1)/2){
                    k -= len/2;
                }
                len= (1+len)/2;
                break;
            case '%':
                k = len-k-1;
                break;

            default:
                if(k+1 == len){
                    return c;
                }

                len--;   
                break;        
            
            }
        }
        return '.';
    }
}