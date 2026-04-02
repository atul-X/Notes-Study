package algorithms.greedy;

import java.util.*;

public class DestinationCity {

    public String destCity(List<List<String>> paths) {
        HashMap<String,String> result=new HashMap<>();
        for(int i=0;i< paths.size();i++){
            List<String> arr=paths.get(i);
            result.put(arr.get(0),arr.get(1));
        }
        String value=null;
        int count=0;
        for(Map.Entry<String,String> map:result.entrySet()){
           if(count==0){
               value= map.getValue();
           }
           if(result.containsKey(value)) {
               String val=result.get(value);
               value=val;
               count++;
           }
        }
        return value;


    }

    public static void main(String[] args) {
        List<List<String>> arr=new LinkedList<>();
        List<String> list=new ArrayList<>();
        list.add("B");
        list.add("C");
        arr.add(list);
        List<String> list1=new ArrayList<>();
        list1.add("D");
        list1.add("B");
        arr.add(list1);
        List<String> list2=new ArrayList<>();
        list2.add("C");
        list2.add("A");
        arr.add(list2);
        DestinationCity destinationCity=new DestinationCity();
        destinationCity.destCity(arr);
    }
}
