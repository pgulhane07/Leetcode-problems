class Solution {
    public boolean isPrime(int num){
        
        if(num==1 || num==2)return true;

        for(int i=2;i*i<=num;i++){
            if(num%i==0)return false;
        }
        return true;
    }
    public int[] constructRectangle(int area) {
        if(isPrime(area))return new int[]{area,1};

        double sqrt = Math.sqrt(area);
        System.out.println(sqrt);
        if(sqrt%1 !=0){
            sqrt+= 1;
        }
        //System.out.println(sqrt);
        int a=(int)sqrt,b=(int)sqrt;
        while(true){
            int prod = a*b;
            if(prod > area){
                b--;
            }
            else if(prod < area){
                a++;
            }
            else{
                return new int[]{a,b};
            }
        }
        //return new int[]{0,0};
    }
}