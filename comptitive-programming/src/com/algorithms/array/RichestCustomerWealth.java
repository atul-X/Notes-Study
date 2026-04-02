package algorithms.array;

public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int maxSum=0,currentSum=0;
        for(int i=0;i< accounts.length;i++){
            for (int j=0;j<accounts[i].length;j++){
                currentSum+=accounts[i][j];
                if(currentSum>=maxSum){
                    maxSum=currentSum;
                }
            }
            currentSum=0;
        }
        return maxSum;

    }
    public static void main(String args[]){
        int[][] arr={{1,2,3},{3,2,1}};
        RichestCustomerWealth richestCustomerWealth=new RichestCustomerWealth();
        richestCustomerWealth.maximumWealth(arr);
    }
}
