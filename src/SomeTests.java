import java.util.HashMap;

/**
 * Created by sreenathkodedala on 8/30/16.
 */
public class SomeTests {

    public static void main(String args[]){

    }

    static int quotientKthDigitAfterDecimalPoint(int a, int b, int k) {

        a %= b;
        while (k > 1) {
            a = (a * 10) % b;
            k--;
        }

        return  a * 10 / b ;
    }

    int factorSum(int n) {
        int curr = n;
        while(true){
            int sum = 0;
            for(int i = 2; i <= curr; i++){
                while(n % i == 0){
                    sum += i;
                    n /= i;
                }
            }
            if(sum == curr) return curr;
            else {
                curr = sum;
                n = curr;
            }
        }
    }


     /*typedef std::vector<std::vector<char>> matrix;

    std::vector<int> throwingBlocks(matrix field) {
        struct Helper {
            bool isFirstColumnFull(matrix field) {
                bool result = true;
                for (int i = 0; i < field.size(); i++) {
                    result &= field[i][0] == '#';
                }
                return result;
            }

        void countMoves(matrix& field, std::vector<int>& result, int moves) {
            if (isFirstColumnFull(field)) {
                result[0] = std::min(result[0], moves);
                result[1] = std::max(result[1], moves);
                return;
            }
            for (int i = 0; i < field.size(); i++) {
                if (field[i][0] == '#') {
                    continue;
                }
                int j = i;
                int column = 0;
                while (column < field[j].size() && field[j][column] == '.') {
                    column++;
                }
                column--;
                while (j < field.size() && field[j][column] == '.') {
                    j++;
                }
                j--;
                field[j][column] = '#';
                countMoves(field, result, moves + 1);
                field[j][column] = '.';
            }
        }
        };

        const int INF = field.size() * field[0].size() + 1;
        std::vector<int> result{INF, -INF};
        Helper h;
        h.countMoves(field, result, 0);
        return result;
    }*/

    static int[] throwingBlocks(char[][] field) {
        class Helper {
            boolean isFirstColumnFull(char[][] field) {
                boolean result = true;
                for (int i = 0; i < field.length; i++) {
                    result &= field[i][0] == '#';
                }
                return result;
            }

            void countMoves(char[][] field, int[] result, int moves) {
                if (isFirstColumnFull(field)) {
                    result[0] = Math.min(result[0], moves);
                    result[1] = Math.max(result[1], moves);
                    return;
                }
                for (int i = 0; i < field.length; i++) {
                    if (field[i][0] == '#') {
                        continue;
                    }
                    int j = i;
                    int column = 0;
                    while (column < field[j].length && field[j][column] == '.') {
                        column++;
                    }
                    column--;
                    while (j < field.length && field[j][column] == '.') {
                        j++;
                    }
                    j--;
                    field[j][column] = '#';
                    countMoves(field, result, moves + 1);
                    field[j][column] = '.';
                }
            }
        }

        final int INF = field.length + field[0].length + 1;
        int[] result = new int[]{INF, -INF};
        Helper h = new Helper();
        h.countMoves(field, result, 0);
        return result;
    }


    static int squaresSumMinimization(int[] A) {

        int indexOfMinimum = -1,
                minimalSum = -1;

        for (int x = A[0]; x <= A[A.length - 1]; x++) {
            int sum = 0;
            for (int j = 0; j < A.length; j++) {
                sum += (A[j] - x) * (A[j] - x);
            }
            if (sum < minimalSum || indexOfMinimum == -1) {
                minimalSum = sum;
                indexOfMinimum = x;
            }
        }

        return indexOfMinimum;
    }

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

    int numberOfAnagrams(String S) {
        HashMap<Character,Integer> set = new HashMap<Character,Integer>();
        for(int i = 0; i < S.length(); i++) {
            char item = S.charAt(i);
            if(!set.containsKey(item)) {
                set.put(item,1);
            } else {
                int freq = set.get(item);
                set.put(item,freq+1);
            }
        }
        int result = factorial(S.length());
        for(Character item : set.keySet()) {
            result /= factorial(set.get(item));
        }
        return result;
    }
    int factorial(int n) {
        if(n==0) return 1;
        return n * factorial(n-1);
    }



}
