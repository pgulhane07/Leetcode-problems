class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        
        Set<Integer> set1= new HashSet<>();
        Set<Integer> set2= new HashSet<>();
        int cntr=0;
        int[] res= new int[A.length];
        for(int i=0;i<A.length;i++){
            if(A[i] == B[i]){
                cntr++;
                // set1.add(A[i]);
                //  set2.add(B[i]);
            }
            else{
                if(set2.contains(A[i])){
                    
                    cntr++;
                }
                if(set1.contains(B[i])){
                    
                    cntr++;
                }

            }
            set1.add(A[i]);
            set2.add(B[i]);
            res[i] = cntr;
        }
        
        return res;
    }
}