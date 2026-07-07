class Trie{

    Trie[] node;
    boolean isEnd;
    Trie(){
        node = new Trie[26];
        isEnd= false;
    }

    public boolean contains(char c){
        return node[c-'a'] != null;
    }
    public void put(char c, Trie n){
        node[c-'a'] = n;
    }
    public Trie get(char c){
        return node[c-'a'];
    }
    public void setEnd(){
        isEnd= true;
    }
    public boolean getEnd(){
        return isEnd;
    }

}

class Solution {

    List<List<String>> out ;
    public void dfs(Trie cur, List<String> res, StringBuilder sb){
        if(cur== null)return;
        if(cur.getEnd()){
            res.add(sb.toString());
        }

        if(res.size()==3){
            // out.add(new ArrayList<>(res));
            return ;
        }

        for(int i=0;i<26;i++){
            if(cur.get((char)('a'+i)) != null){
                sb.append((char)('a'+i));
                dfs(cur.get((char)('a'+i)), res, sb);
                sb.setLength(sb.length()-1);

                if(res.size() == 3) return;
            }
        }
        //return false;

    }


    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        Trie root= new Trie();
        out= new ArrayList<>();
        for(String s : products){
            Trie cur =root;
            for(char c: s.toCharArray()){
                if(!cur.contains(c)){
                    cur.put(c, new Trie());
                }
                cur= cur.get(c);
            }
            cur.setEnd();
        }
        
        Trie x = root;
        StringBuilder sb = new StringBuilder();
        char[] arr= searchWord.toCharArray();
        for(int i=0;i<arr.length;i++){
            char c= arr[i];
            // if(x== null)break; 
            if(x== null || !x.contains(c)){
                for(int j=i;j<arr.length;j++){
                    out.add(new ArrayList<>());
                }
                break;
            }
            sb.append(c);
            List<String> res= new ArrayList<>();
            dfs(x.get(c), res, sb);
            out.add(res);

            // if(i+1 <arr.length)
            //     x= x.get(arr[i+1]);
            // else{
            x=x.get(c);
            // }
        }
        return out;


    }
}