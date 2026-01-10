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
        int[][] dp= new int[s1.length()+1][s2.length()+1];
        // for(int i=0;i<s1.length();i++){
        //     Arrays.fill(dp[i], -1);
        // }
        // return rec(dp, s1,s2, 0,0);
        // int p=1, sadd=0;
        // for(char c:s2.toCharArray()){
        //     //if(s1.charAt(p-1)!=s2.charAt(0))
        //     sadd+= (int) s2.charAt(p-1);
        //     dp[p][0]= sadd;
        //     p++;
        // }
        for(int i=1;i<=s1.length();i++){
            dp[i][0]= s1.charAt(i-1) + dp[i-1][0];
        }
        for(int i=1;i<=s2.length();i++){
            dp[0][i]= s2.charAt(i-1) + dp[0][i-1];
        }

        // int q=1, sadd1=0;
        // for(char c:s1.toCharArray()){
        //     //if(s1.charAt(0)!=s2.charAt(q))
        //     sadd1+= (int) s1.charAt(q-1);
        //     dp[q][0]= sadd1;
        //     q++;
        // }

        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                // int a= Integer.MAX_VALUE;
                // int min = Integer.MAX_VALUE;
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.min(s1.charAt(i-1)+dp[i-1][j] ,s2.charAt(j-1)+dp[i][j-1] );
                }
                // int min1= Math.min((int)s1.charAt(i)+dp[i+1][j] ,(int)s2.charAt(j)+dp[i][j+1]);
                // dp[i][j] = Math.min(min,min1);
            }
        }
        return dp[s1.length()][s2.length()];



       
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