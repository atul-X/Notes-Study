package algorithms.array;

public class CheckIfNumberHasEqualDigitCountAndDigitValue {
    public boolean digitCount(String num) {
        for (int i=0;i<num.length();i++){
            int val= Integer.parseInt(String.valueOf(num.charAt(i)));
            int count=0;
            for (int j=0;j<num.length();j++){
                if(Integer.parseInt(String.valueOf(num.charAt(j)))==i){
                    count++;
                }
            }
            if (count==val){
                continue;
            }
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        String nums="1210";
        CheckIfNumberHasEqualDigitCountAndDigitValue checkifAllCharactersHaveEqualNumberofOccurrence=new CheckIfNumberHasEqualDigitCountAndDigitValue();
        checkifAllCharactersHaveEqualNumberofOccurrence.digitCount(nums);
    }
}
