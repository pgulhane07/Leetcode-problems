class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int ind=0;
        for(char c:s.toCharArray()){
            map.put(c,ind);
            ind++;
        }
        List<Integer> res= new ArrayList<>();
        int i=0;
        int subStr=1;
        while(i< s.length()){
            char c= s.charAt(i);
            if(map.get(c) > i){
                int far=map.get(c);
                int j=i;
                while(j <= far){
                    far= Math.max(far, map.get(s.charAt(j)));
                    j++;
                }
                res.add(j-i);
                subStr++;
                //j++;
                i=j;
            }
            else{
                subStr++;
                res.add(1);
                i++;
            }
        }
        return res;
    }
}