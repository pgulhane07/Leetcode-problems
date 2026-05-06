class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int row=boxGrid.length, col= boxGrid[0].length;
        int pref[][]= new int[row][col+1];
        Deque<int[]> dq= new ArrayDeque<>();
        char[][] res= new char[col][row];
        for(int i=0;i<row;i++){
            
            int num = 0;//boxGrid[i][0] == '#' ? 1:0;
            if(boxGrid[i][0]=='*')dq.add(new int[]{i,0});
            for(int j=0;j<col;j++){
                Arrays.fill(res[j],'.');
                if(boxGrid[i][j] == '*'){
                    pref[i][j] = num;
                    num=0;
                    dq.add(new int[]{i,j});
                }else if(boxGrid[i][j] == '#'){
                    num++;
                }
            }
            pref[i][col] = num;
            dq.add(new int[]{i,col});
        }
        // for(int i=0;i<col;i++){
        //     for(int j=0;j<row;j++){
        //         System.out.print(res[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        //  System.out.println("-------");
        while(!dq.isEmpty()){
            int[] stone= dq.poll();
            int r= stone[0];
            if(stone[1]==col){
                int c= stone[1]-1;
                int val= pref[stone[0]][stone[1]];
                while(val>0){
                    res[c][row-r-1] = '#';
                    c--;
                    val--;
                }
            }
            else{
                int c= stone[1]-1;
                res[stone[1]][row-r-1] = '*';
                int val= pref[stone[0]][stone[1]];
                while(val>0){
                    res[c][row-r-1] = '#';
                    c--;
                    val--;
                }
            }
            //for(int i=0;i<col;i++){
        //     for(int j=0;j<row;j++){
        //         System.out.print(res[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        //  System.out.println("-------");
        }
        return res;
    }
}