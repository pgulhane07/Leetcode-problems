class Solution {
    public String makeLargestSpecial(String s) {
        if(s.length()==2)return s;
        int bal= 0;
        int st=0;
        List<String> str= new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) =='1'){
                bal++;
            }
            else{
                bal--;
            }
            if(bal == 0){
                String k = "1"+makeLargestSpecial(s.substring(st+1,i))+"0";
                st=i+1;
                str.add(k);
            }
        }
        Collections.sort(str, Collections.reverseOrder());
        StringBuilder sb= new StringBuilder();
        for(String x:str){
            sb.append(x);
        }
        return sb.toString();
    }
}