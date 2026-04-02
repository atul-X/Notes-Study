package algorithms.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountItemsMatchingRule {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int  value=0;
        switch (ruleKey){
            case "type":
                value=0;
                break;
            case "color":
                value=1;
                break;
            case "name":
                value=2;
                break;

        }

        int count=0;
        for(List<String> list:items){
            if(list.get(value).equals(ruleValue) ){
                count++;
            }
        }
        return count;
    }

    public static void main(String args[]){
        List<List<String>> list=new ArrayList<>();
        list.add(Arrays.asList("lrllrl","l","l"));
        list.add(Arrays.asList("lrllrl","lrllrl","lrllrl"));
        list.add(Arrays.asList("l","l","lrllrl"));

        list.add(Arrays.asList("l","l","lrllrl"));
        list.add(Arrays.asList("lrllrl","l","lrllrl"));
        list.add(Arrays.asList("l","l","l"));
        list.add(Arrays.asList("l","lrllrl","l"));




        CountItemsMatchingRule countItemsMatchingRule=new CountItemsMatchingRule();
        countItemsMatchingRule.countMatches(list,"name","lrllrl");


    }
}



