class Robot {
    int dir;
    int[][] grid;
    int row;
    int col;
    int x;
    int y;
    int perimeter;
    public Robot(int width, int height) {
        grid=new int[width][height];
        dir=1;
        row= height;
        col= width;
        x=0;
        y=0;
        perimeter = 2*(width-1)+2*(height-1);
    }
    
    public void step(int num) {
        num= num % perimeter;
        if(num==0 && x==0 && y==0){
            dir=4;
            return;
        }

        while(num>0){
            if(dir==1){
                if(x+num < col){
                    x=x+num;
                    break;
                }
                else{
                    int rem = col-x-1;

                    num-= rem;
                    x=col-1;
                    //System.out.println(num+" -renain-="+rem);
                    dir++;
                }
            }
            else if(dir==2){
                if(y+num < row){
                    y=y+num;
                    break;
                }
                else{
                    int rem = row-y-1;
                    num-= rem;
                    y=row-1;
                    dir++;
                }
            }
            else if(dir==3){
                if(x-num >= 0){
                    x=x-num;
                    break;
                }
                else{
                    int rem = x;
                    num-= rem;
                    x=0;
                    dir=0;
                }
            }
            else{
                
                if(y-num >=0){
                    y=y-num;
                    break;
                }
                else{
                    int rem = y;
                    num-= rem;
                    y=0;
                    dir++;
                }
            
            }

            if(dir>4){
                dir=1;
            }
        }
        // System.out.println(x+" "+y);
        

    }
    
    public int[] getPos() {
        return new int[]{x,y};
    }
    
    public String getDir() {
        if(dir==1)return "East";
        else if(dir==2)return "North";
        else if(dir==3)return "West";
        else{
            return "South";
        }
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */