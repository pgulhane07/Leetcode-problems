class Obj{
    char c;
    int index;
    Obj(char ch, int i){
        c= ch;
        index=i;
    }
}
class Solution {
    public boolean checkValidString(String s) {
        Deque<Obj> brac= new ArrayDeque<>();
        Deque<Obj> star= new ArrayDeque<>();

        for(int i=0;i<s.length();i++){
            char c= s.charAt(i);
            if(c == '('){
                brac.push(new Obj(c, i));
            }
            else if(c == ')'){
                if(brac.isEmpty() && star.isEmpty())return false;
                // if(!star.isEmpty() && star.peek()[1] <){
                if(brac.isEmpty() &&  !star.isEmpty()){
                    star.pop();
                }// }
                
                else{
                    brac.pop();
                }
            }
            else{
                star.push(new Obj(c,i));
            }
        }
        if(brac.isEmpty() && star.isEmpty())return true;
        while(!brac.isEmpty() && !star.isEmpty()){
           
            if(brac.peek().index > star.peek().index)return false;
            else{
                brac.pop();
                star.pop();
            }
                
            
        }
        if(!brac.isEmpty())return false;
        return true;
    }
}