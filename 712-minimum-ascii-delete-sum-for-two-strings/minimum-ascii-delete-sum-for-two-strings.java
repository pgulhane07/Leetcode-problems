class Solution {

    public int rec(int[][] dp , String s1, String s2, int i, int j){



        if(j >=s2.length()){
            int sum=0;
            for(int k=i;k<s1.length();k++){
                sum+= (int)s1.charAt(k);
            }
            return sum;
        }
        if(i >=s1.length()){
            int sum=0;
            for(int k=j;k<s2.length();k++){
                sum+= (int)s2.charAt(k);
            }
            return sum;
        }
        
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int a=Integer.MAX_VALUE,b=Integer.MAX_VALUE,c=Integer.MAX_VALUE;
        if(s1.charAt(i) == s2.charAt(j)){
            a= rec(dp, s1,s2, i+1,j+1);
        }
        b= (int)s1.charAt(i)+rec(dp,s1,s2,i+1,j);
        c= (int)s2.charAt(j)+rec(dp,s1,s2,i,j+1);
        dp[i][j] = Math.min(a,Math.min(b,c));
        return Math.min(a,Math.min(b,c));

    }
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp= new int[s1.length()][s2.length()];
        for(int i=0;i<s1.length();i++){
            Arrays.fill(dp[i], -1);
        }
        return rec(dp, s1,s2, 0,0);
       
        // min(dp(i+1,j+1), char of j + dp[i,j+1] , char i+dp[i+1,j])
       
        // int i=0, j=0;
        // int sum =0;
        // while(i<s1.length() && j<s2.length()){
        //     if(s1.charAt(i) < s2.charAt(j)){
        //         sum+= (int)s2.charAt(j);
        //         j++;
        //     }
        //     else if(s1.charAt(i) > s2.charAt(j)){
        //         sum+= (int)s1.charAt(i);
        //         i++;
        //     }
        //     else{
        //         i++;
        //         j++;
        //     }
        // }
        // while(i<s1.length()){
        //     sum+= (int)s1.charAt(i);
        //     i++;
        // }
        // while(j<s2.length()){
        //     sum+= (int)s2.charAt(j);
        //     j++;
        // }
        // return sum;
    }
}