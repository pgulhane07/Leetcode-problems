class Solution {
    public String findDifferentBinaryString(String[] nums) {
        
        Set<Integer> set= new HashSet<>();
        for(String s: nums){
            set.add(Integer.parseInt(s, 2));
        }
        for(int i=0;i<=nums.length;i++){
            if(!set.contains(i)){
                String ans= Integer.toBinaryString(i);
                while(ans.length()< nums.length){
                    ans= "0"+ans;
                }
                return ans;
            }
        }
        return "";
    }
}