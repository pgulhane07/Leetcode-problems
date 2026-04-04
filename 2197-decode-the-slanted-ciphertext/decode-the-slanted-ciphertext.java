class Solution {
    public String decodeCiphertext(String encodedText1, int rows) {
        int p=encodedText1.length()-1;
        while(p>=0 && Character.isWhitespace(encodedText1.charAt(p))){
            p--;
        }
        String encodedText= encodedText1.substring(0,p+1);
       //  System.out.println(encodedText1+". -----"+encodedText+".");
        int  len= encodedText.length();
        int col=0;
        if(len % rows == 0){
            col= len/rows;
        }
        else{
            col = (len/rows) +1;
        }
        char[][] arr= new char[rows][col];
        // for(int)
        for(int j=0, r=0;j<encodedText.length();j+= col){
            int inc=j;
            for(int k=0;k<col;k++){
                arr[r][k]= encodedText.charAt(inc++);
            }
            r++;
        }

        StringBuilder sb= new StringBuilder();
        int pad=0;
        int rr=rows;
        boolean flag= false;
        for(int i=0;i<col;i++){
            if(flag){
                rr--;
            }
            int j=0;
            while(j<rows && j+pad<col){
            //for(int j=0;j<rr;j++){
                sb.append(arr[j][j+pad]);
                if(j+pad+1 == col){
                    flag= true;
                }
                j++;
            }
            pad++;
        }

        while(sb.length()>0 && Character.isWhitespace(sb.charAt(sb.length()-1))){
            sb.deleteCharAt(sb.length()-1);
        }

        return sb.toString();
    }
}