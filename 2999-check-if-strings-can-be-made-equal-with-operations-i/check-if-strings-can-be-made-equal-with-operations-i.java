class Solution {
    public boolean canBeEqual(String s1, String s2) {
        char[] a1= s1.toCharArray();
        char[] a2= s2.toCharArray();
        for(int i=0;i<4;i++){
            if(a1[i]!= a2[i]){
                if(i+2 <4 && a1[i+2] == a2[i] ){
                    char c= a1[i];
                    a1[i]=a1[i+2];
                    a1[i+2]=c;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}