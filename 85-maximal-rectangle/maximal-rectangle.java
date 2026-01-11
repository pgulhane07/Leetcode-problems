class Solution {

    public int getArea(int[] dp){
        if(dp.length==1)return dp[0];
        int area=0;
        Stack<int[]> st= new Stack<>();
        st.push(new int[]{-1,-1});
        for(int i=0;i<dp.length;i++){

            while(!st.isEmpty() && dp[i] < st.peek()[0]){
                int[] x= st.pop();
                area= Math.max(area, x[0] * (i-st.peek()[1]-1));
            }
            st.push(new int[]{dp[i], i});
        }
        while(st.peek()[1]!= -1){
            int[] x= st.pop();
            area= Math.max(area, x[0] * (dp.length-st.peek()[1]-1));
        }
        return area;

    }
    public int maximalRectangle(char[][] matrix) {

        int[] dp = new int[matrix[0].length];
        int maxArea= 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
               // if(matrix[i][j] )
                dp[j] = matrix[i][j] == '1' ? dp[j]+1 : 0;
            }
            int a= getArea(dp);
            System.out.println(a);
            maxArea = Math.max(maxArea, a);
        }
        return maxArea;



    }
}