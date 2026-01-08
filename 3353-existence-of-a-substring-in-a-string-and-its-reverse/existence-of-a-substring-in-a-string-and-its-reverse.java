class Solution {
    public boolean isSubstringPresent(String s) {
        StringBuilder sb= new StringBuilder();
        sb.append(s);
        sb.reverse();
        String nes = sb.toString();

        for(int i=0;i<s.length()-1;i++){
            String temp= s.charAt(i)+""+s.charAt(i+1);
            if(nes.contains(temp))return true;
        }
        return false;
    }
}