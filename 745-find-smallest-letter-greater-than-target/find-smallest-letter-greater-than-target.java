class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int i=0,j= letters.length-1;
        char res='/';
        while(i<=j){
            int mid = (i+j)/2;
            if(letters[mid] > target){
                res = letters[mid];
                j=mid-1;
            }
            else{
                i=mid+1;
            }
        }   
        if(res != '/')return res;
        return letters[0];
    }
}