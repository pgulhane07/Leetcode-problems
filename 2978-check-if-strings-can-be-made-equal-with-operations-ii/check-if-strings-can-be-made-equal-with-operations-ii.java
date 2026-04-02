class Solution {
    public boolean checkStrings(String s1, String s2) {
        HashMap<Character,Integer> odd= new HashMap<>();
        HashMap<Character,Integer> even= new HashMap<>();
        for(int i=0;i<s1.length();i++){
            if(i%2 ==0){
                even.put(s1.charAt(i), even.getOrDefault(s1.charAt(i),0)+1);
            }
            else{
                odd.put(s1.charAt(i), odd.getOrDefault(s1.charAt(i),0)+1);
            }
        }
        for(int i=0;i<s2.length();i++){
            char c= s2.charAt(i);
            if(i%2 ==0){
                
                if(!even.containsKey(c))return false;
                even.put(c, even.getOrDefault(c,0)-1);
                if(even.get(c) == 0)even.remove(c);
            }
            else{
                //char c= s2.charAt(i);
                if(!odd.containsKey(c))return false;
                odd.put(c, odd.getOrDefault(c,0)-1);
                if(odd.get(c) == 0)odd.remove(c);
            }
        }
        return true;


    }
}
//cabdab