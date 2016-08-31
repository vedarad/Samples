

/**
 * Created by sreenathkodedala on 8/30/16.
 */
public class SomeTests {

    static String caesarBoxCipherEncoding(String inputString) {

        int n = (int)Math.sqrt(inputString.length());
        String ans = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans += inputString.charAt(i + j*n);
            }
        }

        return ans;
    }

    int swapNeighbouringDigits(int n) {

        int result = 0,
                tenPower = 1;
        while (n != 0) {
            int digit1 = n % 10,
                    digit2 =  ((n - digit1) / 10) % 10;
            result += tenPower * (10 * digit1 + digit2);
            n /= 100;
            tenPower *= 100;
        }
        return result;
    }

    static boolean isPermutation(int n, int[] inputArray) {

        java.util.Arrays.sort(inputArray);
        for(int index = 0 ; index <=inputArray.length-1 ; index++)
        {
            System.out.println(""+inputArray[index]+" "+index);
            if(inputArray[index] != index + 1){return false;}
        }
        return true;
    }

    static int finalizeColoring(int[][]  board) {

        boolean[] found = new boolean[2];
        int[] evenness = new int[2];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != 0) {
                    if (found[board[i][j] - 1]) {
                        if (evenness[board[i][j] - 1] != (i + j) % 2) {
                            return 0;
                        }
                    }
                    else {
                        found[board[i][j] - 1] = true;
                        evenness[board[i][j] - 1] = (i + j) % 2;
                    }
                }
            }
        }

        if (evenness[0] ==1 && evenness[1]==1) {
            return 0;
        }

        if (found[0] || found[1]) {
            return 1;
        }

        return 2;
    }

    static boolean isCaseInsensitivePalindrome(String inputString) {

        boolean notPalindrome = false;

        inputString = inputString.replaceAll("[^a-zA-Z]+","").toLowerCase();

        char[] array = inputString.toCharArray();
        for(int i=0, j=array.length-1; i<j; i++, j--) {
            if(array[i] != array[j]) {
                notPalindrome = true;
                break;
            }
        }
        return notPalindrome;
    }
}
