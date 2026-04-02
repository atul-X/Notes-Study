package practice.intermediate.array;

public class MiniMaxArray {
    public int minimum(int[] a){
        int minimum=a[0];
        for(int i=0;i<a.length;i++){
            if (a[i] < minimum) {
                minimum=a[i];
            }
        }
        return minimum;
    }
    public int maximum(int[] a){
        int maximum=0;
        for(int i=0;i<a.length;i++){
            if (a[i] > maximum) {
                maximum=a[i];
            }
        }
        return maximum;
    }
    public static void main(String args[]){
        int a[] ={1,2,34,5,4};
        MiniMaxArray miniMaxArray=new MiniMaxArray();
        int abv=miniMaxArray.maximum(a);
        int abv1=miniMaxArray.minimum(a);

        System.out.println("maximum "+abv);
        System.out.println("minimum "+abv1);

    }
}
