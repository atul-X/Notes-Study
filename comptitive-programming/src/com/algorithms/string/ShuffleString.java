package algorithms.string;

public class ShuffleString {


    public String restoreString(String s, int[] indices) {
        char[] arr=new char[indices.length];
        for(int i=0;i<s.length();i++){
            int index=indices[i];
            Character character= s.charAt(i);
            arr[index]=character;
        }
        return String.valueOf(arr);

    }
    public static void main(String args[]){
        String s = "codeleet";
        int[] ae={4,5,6,7,0,2,1,3};
        ShuffleString shuffleString=new ShuffleString();
        shuffleString.restoreString(s,ae);
    }
}
