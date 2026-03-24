class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        Map<Integer,Integer> map = new HashMap<>();
        LinkedHashMap<Integer,Boolean> visited = new LinkedHashMap<>();
        for(int n:hand){
            map.put(n, map.getOrDefault(n,0)+1);
            visited.put(n, false);
        }
        List<Integer> keys = new ArrayList<>(visited.keySet());
        int k=0;
       // System.out.println(keys);
        while(k < keys.size()){
            if(!visited.get(keys.get(k))){
                int num = keys.get(k);
                 //System.out.println("cur num "+ num);
                while(num < keys.get(k)+groupSize){
                    if(!map.containsKey(num))return false;
                 //   System.out.println("cur num "+ num);
                    if(map.get(num) == 1){
                        map.remove(num);
                        visited.put(num, true);
                    }
                    else{
                        map.put(num, map.get(num)-1);
                    }
                    num++;
                }

            }else{
                k++;
            }
            //System.out.println(map);
        }
        return true;
    }
}