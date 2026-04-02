package practice.intermediate.array;

public class StockPrice {
    public int maxProfit(int prices[]){
        if (prices.length==0){
            return 0;
        }
        int min=Integer.MAX_VALUE;
        int profit=0;
        for (int i=0;i<prices.length;i++){
            if(min>prices[i]){
                min=prices[i];
            }else if(profit<prices[i]-min){
                profit=prices[i]-min;

            }
        }
        return profit;
    }
    public static void main(String args[]){
        int[] ar={7,1,5,3,6,4};

        StockPrice stockPrice=new StockPrice();
        int st= stockPrice.maxProfit(ar);
        System.out.println(st);
    }
}
