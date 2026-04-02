package algorithms.string;

import java.util.HashMap;
import java.util.Map;

public class EqualCharacterOccurrences {

    public boolean areOccurrencesEqual(String s) {
        HashMap<String,Integer> stringIntegerHashMap=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(stringIntegerHashMap.containsKey(String.valueOf(s.charAt(i)))){
                Integer val=stringIntegerHashMap.get(String.valueOf(s.charAt(i)));
                val++;
                stringIntegerHashMap.put(String.valueOf(s.charAt(i)),val);
            }else {
                stringIntegerHashMap.put(String.valueOf(s.charAt(i)),1);

            }
        }
        int inital=0;
        int count=0;
        boolean result= true;
        for (Map.Entry<String, Integer> map:stringIntegerHashMap.entrySet()){
            if (count==0){
                inital=map.getValue();
                count++;
            }
            if(inital!=map.getValue()){
                result= false;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        EqualCharacterOccurrences checkifAllCharactersHaveEqualNumberofOccurrences=new EqualCharacterOccurrences();
        checkifAllCharactersHaveEqualNumberofOccurrences.areOccurrencesEqual("aaabb");
    }
}
