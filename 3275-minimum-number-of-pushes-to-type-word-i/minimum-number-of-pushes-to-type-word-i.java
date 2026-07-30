class Node{
    char ch;
    int val;
    Node(char c, int v){
        ch= c;
        val=v;
    }
}
class Solution {
    public int minimumPushes(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : word.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        if(map.size() <= 8)return word.length();
        else if(map.size() >8 && map.size() <=16 ){
            int res = 8 + ((map.size()-8)*2);
            return res;
        }
        else if(map.size() >16 && map.size() <=24){
            int res = 8 + 16;
            res += ((map.size()-16)*3);
            return res;
        }
        else{
            int res = 8 + 16 + 24;
            res += ((map.size()-24)*4);
            
            return res;
        }

        // PriorityQueue<Node> pq= new PriorityQueue<>((a,b)-> b.val- a.val);
        // for(char c :map.keySet()){
        //     pq.add(new Node(c, map.get(c)));
        // }
        // int i=0, mul=1;
        // int res = 0;
        // while(!pq.isEmpty()){

        //     Node x = pq.poll();
        //     res += (x.val * mul);
        //     i++;
        //     if(i% 8 ==0)mul++;
        // }
        // return res;

    }
}