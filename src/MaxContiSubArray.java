import java.util.Arrays;
import java.util.List;

/**
 * Created by skoded001c on 8/25/16.
 */
public class MaxContiSubArray {

    public static void main(String[] args) {
        //List<integer> a = Arrays.asList(-2,1,-3,4,-1,2,1,-5,4);
        List<Integer> a = Arrays.asList(-1, -1, -3, -4, -1, -2, -1, -5, -4);
        System.out.println(maxSubArray(a));

        a = Arrays.asList(-2, -3, 4, -1, -2, 1, 5, -3);
        System.out.println(maxSubArray(a));
    }

    public static int maxSubArray(final List<Integer> a) {

        if (a == null) {
            return 0;
        }

        int maxSum = Integer.MIN_VALUE;
        int prevSum = 0;

        for (int i = 0; i < a.size(); i++) {
            if (prevSum < 0) {
                prevSum = a.get(i);
            } else {
                prevSum = prevSum + a.get(i);
            }

            if (prevSum > maxSum) {
                maxSum = prevSum;
            }
        }
        return maxSum;
    }
}
