class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        if(s.charAt(s.length()-1) =='1')return false;
        int[] arr= new int[s.length()+1];
        boolean[] possible = new boolean[s.length()];
        arr[minJump]++;
        arr[maxJump+1]--;
        int sum = 0;
        possible[0] = true;
        char ch[] = s.toCharArray();
        for(int i=0;i<s.length();i++){
            sum+= arr[i];
            if(sum == 0 || ch[i] != '0')continue;
            possible[i]= true;
            if(i+maxJump+1 < s.length()){
                arr[i+maxJump+1]--;
            }
            if(i+minJump < s.length())
                arr[i+minJump]++;
           
        }
        return possible[s.length()-1];
    }
}