class Solution { 
    List<Character> list;
    List<String> res;
    public void backtrack(int len, int index, List<Character> arr){

        if(index == len){
            String s= arr.stream().map(String::valueOf).collect(Collectors.joining());
            res.add(s);
            return;
        }

        for(int i=0;i<list.size();i++){
            if(index == 0){
                arr.add(list.get(i));
                backtrack(len, index+1, arr);
                arr.remove(arr.size()-1);
            }
            else{
                char cur=list.get(i);
                if(cur == arr.get(arr.size()-1))continue;
                arr.add(list.get(i));
                backtrack(len, index+1, arr);
                arr.remove(arr.size()-1);
            }
        }

    }
    public String getHappyString(int n, int k) {
        list= List.of('a','b','c');
        res= new ArrayList<>();
        backtrack(n,0, new ArrayList<>());
        //System.out.println(res);
        if(k > res.size())return "";
        Collections.sort(res);
        return res.get(k-1);
        
    }
}