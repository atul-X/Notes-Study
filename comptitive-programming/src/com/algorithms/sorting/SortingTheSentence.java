package algorithms.sorting;

import java.util.Arrays;

public class SortingTheSentence {
    public String sortSentence(String s) {
        String[] wordAarray=s.split(" ");
        for(int i=0;i<wordAarray.length;i++){
            for(int j=0;j< wordAarray.length-1;j++){
               int number= Integer.parseInt(String.valueOf(wordAarray[j].charAt(wordAarray[j].length()-1)));
               int nextNumber=Integer.parseInt(String.valueOf(wordAarray[j+1].charAt(wordAarray[j+1].length()-1)));
               if(number>nextNumber){
                   String temp=" ";
                   temp=wordAarray[j];
                   wordAarray[j]=wordAarray[j+1];
                   wordAarray[j+1]=temp;
               }
            }
        }
        StringBuilder st= new StringBuilder();
        for(int j=0;j<wordAarray.length;j++){
            if(j!= wordAarray.length-1) {
                st.append(wordAarray[j]).append(" ");
            }else {
                st.append(wordAarray[j]);
            }
        }
        StringBuilder result= new StringBuilder();

        // Traverse the String from start to end
        for (int i = 0; i < st.length(); i++) {

            // Check if the specified character is not digit
            // then add this character into result variable
            if (!Character.isDigit(st.charAt(i))) {
                result = result.append(st.charAt(i));
            }
        }
        return result.toString();
    }
    public static void main(String args[]){
        String arr="is2 sentence4 This1 a3";
        SortingTheSentence sortingTheSentence=new SortingTheSentence();
        sortingTheSentence.sortSentence(arr);
    }
}
