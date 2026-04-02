package algorithms.string;

public class SplitAStringInBalancedStrings {
    public int balancedStringSplit(String s) {
        int pairCount=0,count=0,i=0;
        while (i<s.length()){
            if(String.valueOf(s.charAt(i)).equals("R")){
                count++;
            }else {
                count--;
            }
            if (count==0){
                pairCount++;
            }
            i++;
        }
        return pairCount;
    }

    public static void main(String[] args) {
        SplitAStringInBalancedStrings splitAStringInBalancedStrings=new SplitAStringInBalancedStrings();
        splitAStringInBalancedStrings.balancedStringSplit("RRLRRLRLLLRL");
    }
}
