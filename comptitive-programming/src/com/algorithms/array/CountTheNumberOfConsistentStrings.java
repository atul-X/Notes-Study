package algorithms.array;

public class CountTheNumberOfConsistentStrings {
    public int countConsistentStrings(String allowed, String[] words) {
        int count=0;
        boolean check=false;
        for (int i=0;i<words.length;i++){
            String a=words[i];
            for(int j=0;j<a.length();j++){
                if(allowed.contains(String.valueOf(a.charAt(j)))){
                    check= true;
                    continue;
                }
                check=false;
                break;
            }
            if(check){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] arr={"ad","bd","aaab","baa","badab"};
        String allowed="ab";
        CountTheNumberOfConsistentStrings countTheNumberOfConsistentStrings=new CountTheNumberOfConsistentStrings();
        countTheNumberOfConsistentStrings.countConsistentStrings(allowed,arr);
    }
}
