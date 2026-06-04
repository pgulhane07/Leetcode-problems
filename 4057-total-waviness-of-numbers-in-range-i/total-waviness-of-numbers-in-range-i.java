class Solution {
    public int totalWaviness(int num1, int num2) {
        int cnt=0;
        for(int j=num1;j<=num2; j++){
            // List<Integer> list = new ArrayList<>();
            // while(j>0){
            //     list.add(j%10);
            //     j=j/10;
            // }
            String s= Integer.toString(j);
            for(int i=1;i<s.length()-1;i++){
                if((s.charAt(i) > s.charAt(i-1) && s.charAt(i) > s.charAt(i+1)) || (s.charAt(i) < s.charAt(i-1) && s.charAt(i) < s.charAt(i+1)))cnt++;
            }


        }
        return cnt;
    }
}