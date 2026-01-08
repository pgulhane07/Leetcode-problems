class Solution {
    public boolean isSubstringPresent(String s) {
        // StringBuilder sb= 
        // sb.append(s);
        // sb.reverse();
        String nes = new StringBuilder(s).reverse().toString();

        for(int i=0;i<s.length()-1;i++){
            String temp= s.substring(i,i+2 );
            if(nes.contains(temp))return true;
        }
        return false;
    }
}