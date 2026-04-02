package algorithms.greedy;

import java.util.HashMap;

public class JewelsAndStones {
    public int numJewelsInStones(String jewels, String stones) {
        int count=0;
        for(int i=0;i<jewels.length();i++){
            for (int j=0;j<stones.length();j++){
                if (stones.charAt(j)==jewels.charAt(i)){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
