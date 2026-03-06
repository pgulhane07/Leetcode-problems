class Solution {
    public boolean checkOnesSegment(String s) {
        if(s.length()==1)return true;
        char[] arr= s.toCharArray();
        boolean flag=false;
        for(int i=1;i<s.length();i++){
            if(arr[i] != '1')flag= true;
            if(arr[i]=='1' && flag)return false;
            // if(arr[i] == arr[i-1] && arr[i]== '1')return true;
        }
        return true;
    }
}