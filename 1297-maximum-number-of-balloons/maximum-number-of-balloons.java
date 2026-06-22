class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] arr = new int[26];
        for(char c:text.toCharArray()){
            arr[c-'a']++;
        }
        String re = "balloon";
        int[] ref=new int[26];
        for(char c:re.toCharArray()){
            ref[c-'a']++;
        }
        int min= text.length();
        for(char c:re.toCharArray()){
           // System.out.println(arr[c-'a']+" "+ref[c-'a']+" div= "+(arr[c-'a']/ref[c-'a']));
            min = Math.min(min,arr[c-'a']/ref[c-'a']);
        }
        return min;
    }
}