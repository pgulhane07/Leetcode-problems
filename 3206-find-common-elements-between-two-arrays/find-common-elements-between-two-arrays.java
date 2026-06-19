class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        Set<Integer> set1= new HashSet<>();
        Set<Integer> set2= new HashSet<>();
        for(int n:nums1){
            set1.add(n);
        }
        int cnt1=0, cnt2=0;
        for(int n:nums2){
            set2.add(n);
            if(set1.contains(n)){
                cnt2++;
            }
        }
        for(int n:nums1){
            if(set2.contains(n)){
                cnt1++;
            }

        }
        return new int[]{cnt1 , cnt2};

    }
}