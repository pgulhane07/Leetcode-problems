class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<String> set =new HashSet<>();
        for(int n : arr1){
            String s = Integer.toString(n);
            for(int i=1;i<=s.length();i++){
                set.add(s.substring(0,i));
            }
        }
       // System.out.println(set);
        int len=0;
        for(int n : arr2){
            String s = Integer.toString(n);
           // System.out.println(s);
            for(int i=1;i<=s.length();i++){
                // System.out.println(s.substring(0,i));
                if(set.contains(s.substring(0,i))){
                    len = Math.max(len, i);
                }
                
            }
        }
        return len;

    }
}