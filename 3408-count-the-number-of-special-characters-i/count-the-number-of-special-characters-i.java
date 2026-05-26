class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> upper= new HashSet<Character>();
        Set<Character> lower= new HashSet<Character>();
        Set<Character> set= new HashSet<Character>();

        int cnt=0;
        for(char c: word.toCharArray())set.add(c);
        for(char c: set){
            if(c>='a' && c <='z'){
                if(upper.contains((char)(c-32))){
                    cnt++;
                }
                lower.add(c);
            }   
            else{
                if(lower.contains((char)(c+32))){
                    cnt++;
                }
                upper.add(c);
            }
        }
        return cnt;
    }
}