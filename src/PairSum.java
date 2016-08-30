/**
 * Created by skoded001c on 8/25/16.
 */

public class PairSum
{
    private static final int MAX = 100000; // Max size of Hashmap

    static void printPairs(int arr[],int sum)
    {
        // Declares and initializes the whole array as false
        boolean[] binMap = new boolean[MAX];

        for (int i=0; i<arr.length; ++i)
        {
            int temp = sum-arr[i];

            // checking for condition
            if (temp>=0 && binMap[temp])
            {
                System.out.println("Pair with given sum " +
                        sum + " is (" + arr[i] +
                        ", "+temp+")");
                /*System.out.println("Pair with given sum " +
                        sum + " is (" +  +
                        ", "+i+")");*/
            }
            binMap[arr[i]] = true;
        }
    }

    static void printIndices(int[] nums, int sum){
        if(nums.length==0|| sum==0)
            return;
    }

    // Main to test the above function
    public static void main (String[] args)
    {
        int A[] = {1, 4, 45, 6, 10, 8};
        int n = 16;
        printPairs(A, n);
        printIndices(A, n);
    }
}
