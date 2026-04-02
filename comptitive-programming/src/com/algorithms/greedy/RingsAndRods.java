package algorithms.greedy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class RingsAndRods {
    public int countPoints(String rings) {
        HashMap<String,HashSet<String>> temp=new HashMap<String,HashSet<String>>();
        for(int i=0;i<rings.length()-1;i++){
            String color= String.valueOf(rings.charAt(i));
            String rod= String.valueOf(rings.charAt(i+1));
            if(temp.containsKey(rod)){
                HashSet<String> set=temp.get(rod);
                set.add(color);
            }else {
                HashSet<String> set=new HashSet<>();
                set.add(color);
                temp.put(rod, set);
            }
            i++;
        }
        int count=0;
        for (Map.Entry<String,HashSet<String>> entry : temp.entrySet()){
            if(entry.getValue().size()==3){
                count++;
            }
        }

        return count;
    }
    public static void main(String[] args) {
        RingsAndRods ringsAndRods=new RingsAndRods();
        ringsAndRods.countPoints("B0B6G0R6R0R6G9");
    }
}
