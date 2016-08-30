import java.util.HashMap;

/**
 * Created by sreenathkodedala on 8/1/16.
 */
public class RepeatedChars {

    public static void main(String args[]){
        duplicateChars("ButterBetter");
    }

    private static void duplicateChars(String str){

        HashMap<Character, Integer> charCount = new HashMap<>();
        char[] strArr = str.toCharArray();

        for (char c: strArr){
            if(charCount.containsKey(c))
                charCount.put(c, charCount.get(c)+1);
            else
                charCount.put(c, 1);
        }

        for(char c : charCount.keySet()){
            System.out.println(c + ":"+ charCount.get(c));
        }

    }

}
