package algorithms.greedy;

import java.util.HashSet;

public class UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morseCode={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> hashSet=new HashSet<>();
        for(int i=0;i<words.length;i++){
            String word=words[i];
            StringBuilder stringBuilder=new StringBuilder();
            for(int j=0;j< word.length();j++){
                int val= letterToAlphabetPos(word.charAt(j));
                stringBuilder.append(morseCode[val-1]);
            }
            hashSet.add(stringBuilder.toString());
            stringBuilder.delete(0,stringBuilder.length());
        }
        return hashSet.size();

    }
    private static int letterToAlphabetPos(char letter) {
        return Character.toUpperCase(letter) - 64;
    }

    public static void main(String[] args) {
        String[] arr={"gin","zen","gig","msg"};
        UniqueMorseCodeWords uniqueMorseCodeWords=new UniqueMorseCodeWords();
        uniqueMorseCodeWords.uniqueMorseRepresentations(arr);

    }
}
