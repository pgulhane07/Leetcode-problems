class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<int[]> st= new Stack<>();
        st.push(new int[]{prices[0],0});
        for(int i=1;i<prices.length;i++){

            while(!st.isEmpty() && st.peek()[0] >= prices[i]){
                int[] x =st.pop(); 
                prices[x[1]] =x[0] - prices[i];
            }
            st.push(new int[]{prices[i], i});
        }
        return prices;
    }
}