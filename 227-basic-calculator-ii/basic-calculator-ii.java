class Solution {
    public int calculate(String s) {
        Stack<Integer> num= new Stack<>();
        //Stack<Character> ch= new Stack<>();
        int n=0;
        char op='+';
        for(int i=0;i<s.length();i++){
            char c= s.charAt(i);
            //if(Character.isWhitespace(c) )continue;
            if(Character.isDigit(c)){
                n= n*10;
                n += c-'0';
            }
            if(!Character.isDigit(c) && !Character.isWhitespace(c) || i==s.length()-1){

                if(op == '-'){
                    num.push(n*-1);
                }
                else if(op=='+'){
                    num.push(n);
                }
                else if(op=='*'){
                    int prev= num.pop();
                    num.push(prev* n);
                }
                else if(op=='/'){
                    int prev= num.pop();
                    num.push(prev/n);
                }
                op=c;
                
                n=0;
                 // if(c == '*')ch.push(c);
            }
        }
        
                

        int res=0;
        while(!num.isEmpty()){
            res+= num.pop();
        }
        return res;

    }
}