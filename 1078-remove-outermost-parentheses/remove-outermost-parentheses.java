class Solution {
    public String removeOuterParentheses(String s) {
        int val= 0;
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            if(c == '('){
                if(val != 0){
                    sb.append(c);
                }
                val++;
            }
            if(c == ')'){
                if(val > 1){        
                    sb.append(c);
                }
                val--;
            }
        } 
        return sb.toString();
    }
}