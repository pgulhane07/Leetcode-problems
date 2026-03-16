class Solution { 
    List<Character> list;
    List<String> res;
    public void backtrack(int len, int index, StringBuilder sb){

        if(index == len){
            // String s= arr.stream().map(String::valueOf).collect(Collectors.joining());
            res.add(sb.toString());
            return;
        }

        for(int i=0;i<list.size();i++){
            if(index == 0){
                sb.append(list.get(i));
                backtrack(len, index+1, sb);
                sb.setLength(sb.length()-1);
            }
            else{
                char cur=list.get(i);
                if(cur == sb.toString().charAt(sb.length()-1))continue;
                sb.append(list.get(i));
                backtrack(len, index+1, sb);
                sb.setLength(sb.length()-1);
            }
        }

    }
    public String getHappyString(int n, int k) {
        list= List.of('a','b','c');
        res= new ArrayList<>();
        StringBuilder sb= new StringBuilder();
        backtrack(n,0, sb);
        //System.out.println(res);
        if(k > res.size())return "";
        Collections.sort(res);
        return res.get(k-1);
        
    }
}