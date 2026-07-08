class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        //Map<Integer, String> map  = new HashMap<>();
        //StringBuilder sb= new StringBuilder();
       // int k=0;
       int n= s.length();
        long [] prefix = new long[n+1];
        long[] power= new long[n+1];
        int[] count= new int[n+1];
        long[] val = new long[n+1];
        long q = 0;
        power[0] = 1;
        int res[]= new int[queries.length];
        int MOD = 1_000_000_007;
        
        for(int i=0;i< s.length();i++){
            power[i+1] = (power[i]*10) % MOD;
            int c = s.charAt(i)-'0';
            
            prefix[i+1] = prefix[i]+c;
            if(c != 0){
                count[i+1] = (count[i]+1);
                val[i+1] = (val[i] * 10 + c ) % MOD;
            }
            else{
                count[i+1]= count[i];
                val[i+1]=val[i];
            }
               
        }
        // for(int i=0;i<s.length();i++){
        //  System.out.println(i + " "+ map.get(i));
        // }

        for(int i=0;i<queries.length;i++){

            int l = queries[i][0]+1;
            int r= queries[i][1]+1;
            long sum = prefix[r]-prefix[l-1];
            int cnt = count[r]-count[l-1];
            
            long rt = val[r];
            long lt = (val[l-1] * power[cnt]) % MOD;

            long temp = (rt - lt + MOD ) %MOD;
            res[i] = (int)((temp * (sum %MOD)) %MOD);

        }
        // int w=0;
        // for(int[] x : queries){
        //     long p = 0;
        //     int st= x[0];
        //     if(st == 0){
        //         p = Integer.valueOf(map.get(x[1]));
        //     }
        //     else{
        //         String t= map.get(x[0]-1);
        //         int t1= t.length();
        //         String r = map.get(x[1]);
        //         if(t1 == 0 || t1 >= r.length()){
        //             res[w++]= 0;
        //             continue;
        //         }
        //         System.out.println(map.get(x[1]).substring(t1));
        //         p = Long.valueOf(map.get(x[1]).substring(t1));
        //     }
        //     long d = x[0] == 0? 0 : prefix[x[0]-1];
        //     long pr = prefix[x[1]] - d;

        //     res[w++] = (int)(p * pr) % MOD;     
        // }
        return res;


        // TreeMap<Integer, Integer> map  = new TreeMap<>();
        // long prefix[]= new long[s.length()+1];
        // long q = 0;
        // for(int i=0;i<s.length();i++){
        //     prefix[i]=q;
        //     q+= s.charAt(i)-'0';
        //     if(s.charAt(i) == '0')continue;
        //     map.put(i, s.charAt(i)-'0');
        // }
        // int MOD = 1_000_000_007;
        // int res[]= new int[queries.length];
        // for(int j=0;j< queries.length;j++){
        //     int[]x = queries[j];
        //     Integer st= map.ceilingKey(x[0]);
        //     Integer end = map.lowerKey(x[1]);
        //     System.out.println(st +"  "+end);
        //     int k=10;
        //     long num = 0;
        //     if(st == null || end==null){
        //         res[j]=0;
        //         continue;
        //     }
        //     for(int i=st;i<= end;i++){
        //         if(map.containsKey(i)){
        //            // System.out.println(i+" "+map.get(i));
        //             num = num * k+ map.get(i);
                    
        //             //k= k *10;
        //            // System.out.println(num + " "+ k);
        //         }
                
        //     }
        //     //System.out.println();
        //     res[j] = (int)(num * (prefix[x[1]]-prefix[x[0]]))%MOD;

        // }
        //return res;
        
    }
}