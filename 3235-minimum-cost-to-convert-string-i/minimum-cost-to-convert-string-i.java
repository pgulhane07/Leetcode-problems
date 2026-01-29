class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int len= original.length;
        long[][] dp= new long[26][26];
        
        for(int i=0;i<26;i++){
            Arrays.fill(dp[i], Long.MAX_VALUE);
        }
        for(int i=0;i<len;i++){
            dp[original[i]-'a'][changed[i]-'a'] = Math.min(dp[original[i]-'a'][changed[i]-'a'] ,cost[i]);
        }

        for(int k=0;k<26;k++){
            for(int i=0;i<26;i++){
                for(int j=0;j<26;j++){
                    if(dp[i][k] == Long.MAX_VALUE || dp[k][j]== Long.MAX_VALUE)continue;
                    dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k][j]);
                }
            }
        }
        long res=0;
        for(int i= 0;i<source.length();i++){
            if(source.charAt(i) != target.charAt(i)){
                if(dp[source.charAt(i)-'a'][target.charAt(i)-'a'] == Long.MAX_VALUE)return -1;
                res += dp[source.charAt(i)-'a'][target.charAt(i)-'a'];
            }
        }
        return res;
    }
}