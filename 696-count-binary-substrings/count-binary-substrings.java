class Solution {
    public int countBinarySubstrings(String s) {
        char[] arr= s.toCharArray();
        boolean flag0=false, flag1= false;
        int cnt1=0, cnt0=0,res=0;
        if(arr[0]=='1'){
            flag1=true;
            cnt1=1;
        }
        else{
            flag0=true;
            cnt0=1;
        }
        for(int i=1;i<arr.length;i++){
            if(arr[i] == '0' && !flag0){
                flag0= true;
                flag1=false;
                cnt0=1;
                if(cnt0 <= cnt1)res++;
            }
            else if(arr[i]=='0' && flag0){
                cnt0++;//2
                if(cnt0 <= cnt1)res++;
            }
            else if(arr[i]=='1' && !flag1){
                flag1= true;
                flag0=false;
                cnt1= 1;
                if(cnt1 <= cnt0)res++;//1

            }
            else if(arr[i]=='1' && flag1){
                cnt1++;//2
                if(cnt1 <= cnt0)res++;//1
            }
        }
        return res;
    }
}