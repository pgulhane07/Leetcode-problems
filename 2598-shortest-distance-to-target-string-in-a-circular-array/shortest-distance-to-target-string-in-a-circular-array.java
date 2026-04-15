class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int min = words.length+2;
        boolean flag= false;
        for(int i=0;i<words.length;i++){
            if(words[i].equals(target)){
                int left= Math.abs(i-startIndex);
                int right= words.length-left;
                min= Math.min(min, Math.min(left, right));
                flag=true;
            }
        }
        if(!flag)return-1;
        return min;
    }
}