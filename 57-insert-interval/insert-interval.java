class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        if(intervals.length == 0)return new int[][]{{newInterval[0],newInterval[1]}};
        int start=newInterval[0], end=newInterval[1];
        int i=0;
        boolean flagAdded= false;
        while(i<intervals.length){
        //for(int[] arr: intervals){
            if(newInterval[0] <= intervals[i][1] && !flagAdded){
                start = Math.min(newInterval[0], intervals[i][0]);
                boolean flag=false;
                while(i<intervals.length && newInterval[1] >= intervals[i][0]){
                    end= Math.max(newInterval[1], intervals[i][1]);
                    flag=true;
                    i++;
                }
                
                list.add(new int[]{start, end});
                flagAdded= true;
                // if(!flag){
                if(i<intervals.length)
                    list.add(new int[]{intervals[i][0], intervals[i][1]});
                   // i++;
                // }
                // else{
                //     //i--;
                // }
                //i--;
                //i++;
            }
            else{
                list.add(new int[]{intervals[i][0], intervals[i][1]});
                
            }
            i++;
            // for(int n[]:list)
            //         System.out.println(n[0]+ " "+n[1]);
            //     System.out.println("------"+i);
        }
        if(!flagAdded){
            list.add(new int[]{start, end});
        }
        return list.stream().toArray(int[][]::new);
    }
}