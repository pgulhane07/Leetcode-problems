class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list= new ArrayList<>();
        for(int n:nums){
            List<Integer> temp= new ArrayList<>();
            while(n>0){
                temp.add(n%10);
                n=n/10;
            }
            for(int i= temp.size()-1;i>=0;i--){
                list.add(temp.get(i));
            }

        }
        // int[] res= list.toArray(new Integer[0]);
        return list.stream().mapToInt(i->i).toArray();
    }
}