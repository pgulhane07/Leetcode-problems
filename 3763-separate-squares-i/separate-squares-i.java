class Solution {
    public boolean check(int[][] squares, double y, double tot){
        double area=0;
        for(int [] arr: squares){
            if(arr[1] < y){
                area += Math.min(arr[2],(y-arr[1]))*arr[2];
            }
        }
        return area >=tot;
    }
    public double separateSquares(int[][] squares) {
        double total_area=0;
        double ymax=0;
        // double area[][]=new double[squares.length][2];
        for(int i=0;i<squares.length;i++){
            total_area+= (double)squares[i][2]*squares[i][2];
            ymax= Math.max(ymax, squares[i][1]+squares[i][2]);
            // area[i][1]=total_area;
            // area[i][0]=squares[i][1]+squares[i][2];
        }
        double tar= total_area/2;
        double i=0;
        double j= ymax;
        double dif= 1e-5;

        while(Math.abs(j-i) > dif){
            double mid= (i+j)/2;
            if(check(squares, mid, tar)){
                j=mid;
            }
            else{
                i=mid;
            }
        }
        return j;
        // double yax=0;
        // for(int i=0;i<area.length;i++){
        //     if(tar - area[i][1]> 0 ){
        //         yax= area[i][0];
        //         tar=tar-area[i][1];
        //     }
        //     else if(tar - area[i][1]==0){return area[i][0];}
        //     // else{
        //     //     yax= //equliibrium
        //     // }
            
        // }
        // return yax;
    }
}

// for(int j=0;j<squares[0].length;j++){
                
//             }