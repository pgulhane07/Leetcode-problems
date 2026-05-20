class Node{
    Node[] node;
    boolean end;
    int index;
    Node(){
        node= new Node[26];
        end= false;
        index=-1;
    }
}
class Solution {
    int dir[][] = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    boolean[] res;
    int row;
    int col;
    public void backtrack(char[][] board, int i, int j, Node cur){

        if(cur.end){
            res[cur.index]= true;
            //return;
        }

        for(int d[]:dir){
            int x= i+d[0];
            int y= j+d[1];
            if(x>=0 && x< row && y>=0 && y<col && board[x][y] !='#' && cur.node[board[x][y]-'a']!=null){
                char c= board[x][y];
                board[x][y] = '#';
                backtrack(board, x, y, cur.node[c-'a']);
                board[x][y] = c;
            }

        }



    }

    public List<String> findWords(char[][] board, String[] words) {
        Node n = new Node();

        for(int i=0;i<words.length;i++){
            String w= words[i];
            Node cur= n;
            for(char c: w.toCharArray()){
                if(cur.node[c-'a']==null){
                    cur.node[c-'a'] = new Node();
                }
                cur=cur.node[c-'a'];
            }
            cur.end= true;
            cur.index= i;
        }
        row= board.length;
        col = board[0].length;
        res=  new boolean[words.length];
        for(int i=0;i<row; i++){
            for(int j=0;j<col;j++){
                Node cur= n;
               
                if(cur.node[board[i][j] - 'a'] == null)continue;
                boolean[][] visited = new boolean[row][col];
                char c= board[i][j];
                board[i][j] = '#';
           
                backtrack(board, i, j, cur.node[c- 'a']);
                board[i][j] = c;
              

            }
        }
        List<String> list= new ArrayList<>();
        for(int i=0;i<words.length;i++){
            if(res[i]){
                list.add(words[i]);
            }
        }
        return list;
    }
}
