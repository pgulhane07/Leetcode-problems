class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int [] e:edges){
            list.get(e[0]).add(e[1]);
            list.get(e[1]).add(e[0]);
        }
        int res=0;
        boolean[] visited= new boolean[n];
        for(int i=0;i<n;i++){

            if(!visited[i]){
                Deque<Integer> dq= new ArrayDeque<>();
                dq.add(i);
                visited[i] = true;
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                while( !dq.isEmpty() ){
                    int k =dq.poll();
                    for(int x : list.get(k)){
                        if(!visited[x]){
                            dq.add(x);
                            visited[x]=true;
                            temp.add(x);
                        }
                    }

                }
                boolean flag= true;
                int size = temp.size();
                for(int p : temp){
                    if(list.get(p).size() != size-1){
                        flag =false;
                        break;
                    }
                }
                if(flag){
                    res++;
                }
            }

            
        }
        return res;
    }
}