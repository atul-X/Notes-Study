package algorithms.string;

public class TruncateSentence {
    public String truncateSentence(String s, int k) {
      String[] list=  s.split(" ");
      StringBuilder stringBuilder=new StringBuilder();
      for (int i=0;i<k;i++){
          if(i==k-1){
              stringBuilder.append(list[i]);
          }else {
              stringBuilder.append(list[i]).append(" ");
          }
      }
      return stringBuilder.toString();
    }

    public static void main(String[] args) {

    }
}
