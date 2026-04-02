package algorithms.stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        for(int i=0;i<s.length();i++){
            if(String.valueOf(s.charAt(i)) == String.valueOf(s.charAt(i+1))){
                i++;
                continue;
            }
            return false;
        }
        return true;
    }
    public static void main(String args[]){
        String s="()";
        ValidParentheses validParentheses=new ValidParentheses();
        validParentheses.isValid(s);
    }
}
