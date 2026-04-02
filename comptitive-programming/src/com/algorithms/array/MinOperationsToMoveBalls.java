package algorithms.array;

public class MinOperationsToMoveBalls {
    public int[] minOperations(String boxes) {
        int[] result=new int[boxes.length()];
        int operationCount=0;
        for (int i=0;i<boxes.length();i++){
            for(int j=0;j<boxes.length();j++){
                if(i!=j){
                    if(String.valueOf(boxes.charAt(j)).equals("1")){
                        int count=Math.abs(j-i);
                        operationCount+=count;
                    }

                }
            }
            result[i]=operationCount;
            operationCount=0;
        }
        return result;
    }

    public static void main(String args[]){
        String arr="110";
        MinOperationsToMoveBalls minOperationsToMoveBalls=new MinOperationsToMoveBalls();
        minOperationsToMoveBalls.minOperations(arr);
    }
}
