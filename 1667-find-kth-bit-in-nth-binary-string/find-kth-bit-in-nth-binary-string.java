class Solution {
    public List<Character> getRev(List<Character> list){
        List<Character> temp=new ArrayList<>();
        for(int i=list.size()-1;i>=0;i--){
            if(list.get(i) == '1')temp.add('0');
            else{
                temp.add('1');
            }
        }

        return temp;
    }
    public char findKthBit(int n, int k) {
        
        List<Character> res= new ArrayList<>();
        List<Character> rev= new ArrayList<>();
        res.add('0');
        int i=1;
        while(i<n){

            rev= getRev(res);
            res.add('1');
            res.addAll(rev);
            i++;
        }
        return res.get(k-1);
    }
}