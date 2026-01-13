class Solution {
    public int calculate(String s) {
        Stack<Integer> num= new Stack<>();
        //Stack<Character> ch= new Stack<>();
        int n=0;
        char op='+';
        int res=0;
        int last=0;
        for(int i=0;i<s.length();i++){
            char c= s.charAt(i);
            //if(Character.isWhitespace(c) )continue;
            if(Character.isDigit(c)){
                n= n*10;
                n += c-'0';
            }
            if(!Character.isDigit(c) && !Character.isWhitespace(c) || i==s.length()-1){

                if(op == '-'){
                    res+= last;
                    last= -n;
                    //num.push(n*-1);
                }
                else if(op=='+'){
                    res+= last;
                    //num.push(n);
                    last=n;
                }
                else if(op=='*'){
                    // int prev= num.pop();
                    // num.push(prev* n);
                    last= last * n;
                }
                else if(op=='/'){
                    // int prev= num.pop();
                    // num.push(prev/n);
                    last= last/n;
                }
                op=c;
                n=0;
                 // if(c == '*')ch.push(c);
            }
        }
        res+= last;
                

        // int res=0;
        // while(!num.isEmpty()){
        //     res+= num.pop();
        // }
        return res;

    }
}