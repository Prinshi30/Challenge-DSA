class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0]; //initially taking first element as min
        int max = 0; //max profit is 0 initially
        for(int i = 0;i < prices.length;i++)
        {
            if(prices[i] < min) //checking if there is any prices less than min 
                min = prices[i];
            if(max < prices[i] - min) //similarly checking max
                max = prices[i] - min;
        }
        return max;
        
    }
}
