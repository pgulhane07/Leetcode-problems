class Solution {
    public int maximumLengthSubstring(String s) {
        int i=0,j=0, max=0;
        Map<Character, Integer> map = new HashMap<>();
        while(j < s.length()){
            char c = s.charAt(j);
            while(map.getOrDefault(c,0) >= 2){
                
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
                i++;
            }
            map.put(c, map.getOrDefault(c,0)+1);
            max= Math.max(max, j-i+1);
            j++;
        } 
        return max;

    }

}