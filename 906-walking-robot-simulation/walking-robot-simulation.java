class Solution {
    HashMap<Integer, List<int[]>> row;
    HashMap<Integer, List<int[]>> col;
    public int[] check(int x1,int x2, int y1, int y2){
        
        if(x1==x2){
            int yval=0;
            if(row.get(x1)== null)return new int[]{x2,y2};
            if(y1 < y2 ){
                int ym=y2;
                for(int[] y :row.get(x1)){
                // 
                
                    if(y1<y[1] && y[1]<= y2){
                        ym=Math.min(ym, y[1]-1);
                    }
                }
                yval = ym;
            }
            else{
                int ym=y2;
                for(int[] y :row.get(x1)){
                // 
                
                    if(y1>y[1] && y[1]>= y2){
                        ym=Math.max(ym, y[1]+1);
                    }
                }
                yval = ym;
            }
            
            return new int[]{x1,yval};
        }
        else{ 
            
            if(col.get(y1)== null)return new int[]{x2,y1};
            int xval=0;
            if(x1 < x2){
                
                int xm=x2;
                for(int[] x :col.get(y1)){
                // 
                
                    if(x1<x[0] && x[0]<= x2){
                        xm=Math.min(xm, x[0]-1);
                    }
                }
                xval = xm;
            }
            else{
                int xm=x2;
                
                for(int[] x :col.get(y1)){
                // 
                
                    if(x1>x[0] && x[0]>= x2){
                        xm=Math.max(xm, x[0]+1);
                    }
                }
                xval = xm;
            }
            
            return new int[]{xval,y1};
        }
    }
    public int robotSim(int[] commands, int[][] obstacles) {
        int x=0,y=0;

        int dir=0;
        row = new HashMap<>();
        col = new HashMap<>();
        for(int[] arr:obstacles){
            if(row.get(arr[0]) ==null){
                row.put(arr[0], new ArrayList<>());
            }
            if(col.get(arr[1]) ==null){
                col.put(arr[1], new ArrayList<>());
            }
            row.get(arr[0]).add(new int[]{arr[0],arr[1]});
            col.get(arr[1]).add(new int[]{arr[0], arr[1]});
            
        }
        int max= Integer.MIN_VALUE;
        for(int act:commands){
            if(act==-1){
                dir = (dir + 1) % 4;
            }
            else if(act == -2){
               dir = (dir + 3) % 4;
            }
            else{

                if(dir%2 == 0){
                    if(dir==0){
                        if(row.isEmpty() && col.isEmpty()){
                            y+= act;
                        } 
                        else{
                            int[] val = check(x,x,y,y+act);
                            x=val[0];
                            y=val[1];
                        }
                        
                        
                    }
                    else{
                        if(row.isEmpty() && col.isEmpty()){
                            y-= act;
                        } 
                        else{
                            int[] val = check(x,x,y,y-act);
                            x=val[0];
                            y=val[1];
                        }
                    }
                    int distance = (x*x)+(y*y);
                    max= Math.max(max, distance);
                }
                else{
                    if(dir == 1){
                        if(row.isEmpty() && col.isEmpty()){
                            x+= act;
                        } 
                        else{
                            int[] val = check(x,x+act,y,y);
                            x=val[0];
                            y=val[1];
                        }
                    }
                    else{
                        if(row.isEmpty() && col.isEmpty()){
                            x-= act;
                        } 
                        else{
                            int[] val = check(x,x-act,y,y);
                            x=val[0];
                            y=val[1];
                        }
                    }
                    
                    int distance = (x*x)+(y*y);
                    max= Math.max(max, distance);
                }


            }
            // System.out.println(x+" "+y);

            if(dir%4==0){
                dir=0;
            }

        }
        return max;
        
    }
}