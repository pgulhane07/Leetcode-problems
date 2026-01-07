class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list= new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
            String s = Integer.toString(nums[i]);
            for(char c: s.toCharArray()){
                list.add((int)(c-'0'));
            }
        }   
        return list.stream().mapToInt(i->i).toArray();
    }
}