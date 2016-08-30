class MergeTwoArrays
{
    /* Function to move m elements at the end of array mPlusN[] */
    static void moveToEnd(int mPlusN[], int size)
    {
        int i, j = size - 1;
        for (i = size - 1; i >= 0; i--)
        {
            if (mPlusN[i] != -1)
            {
                mPlusN[j] = mPlusN[i];
                j--;
            }
        }
    }

    /* Merges array N[] of size n into array mPlusN[]
       of size m+n*/
    static void merge(int mPlusN[], int N[], int m, int n)
    {
        int i = n;

        /* Current index of i/p part of mPlusN[]*/
        int j = 0;

        /* Current index of N[]*/
        int k = 0;

        /* Current index of of output mPlusN[]*/
        while (k < (m + n))
        {
            /* Take an element from mPlusN[] if
            a) value of the picked element is smaller and we have
                not reached end of it
            b) We have reached end of N[] */
            if ((i < (m + n) && mPlusN[i] <= N[j]) || (j == n))
            {
                mPlusN[k] = mPlusN[i];
                k++;
                i++;
            }
            else // Otherwise take element from N[]
            {
                mPlusN[k] = N[j];
                k++;
                j++;
            }
        }
    }

    /* Utility that prints out an array on a line */
    static void printArray(int arr[], int size)
    {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");

        System.out.println("");
    }

    public static void main(String[] args)
    {
        /* Initialize arrays */
        int mPlusN[] = {2, 8, -1, -1, -1, 13, -1, 15, 20};
        int N[] = {5, 7, 9, 25};
        int n = N.length;
        int m = mPlusN.length - n;

        /*Move the m elements at the end of mPlusN*/
        moveToEnd(mPlusN, m + n);

        /*Merge N[] into mPlusN[] */
        merge(mPlusN, N, m, n);

        /* Print the resultant mPlusN */
        printArray(mPlusN, m + n);
    }
}


/*
import java.util.Arrays;

*/
/**
 * Created by skoded001c on 8/26/16.
 *//*

public class MergeTwoArrays {

        public static void main(String arg[])
        { int NA=-100;
            int mPlusN[] = {2, 8, NA, NA, NA, 13, NA, 15, 20};
            int N[] = {5, 7, 9, 25};
            mergeArrays(mPlusN,N);
        }

        static void mergeArrays(int[] mplusn,int[] N)
        {
            int j=0;
            for(int i=0;i<mplusn.length;i++) {
                if(mplusn[i]==-100) {
                    mplusn[i]=N[j];
                    j++;
                }
            }
            Arrays.sort(mplusn);
            for(int i=0;i<mplusn.length;i++)
                System.out.print(mplusn[i]+" ");
        }

*/
/*    public static void main(String args[]){
        int[] b = {1,-1,3,-1,6,9,11,-1,-1};
        int[] s = {2,4,47,99};
        //merge(b,b.length,s,s.length);
        merge(b,s,b.length,s.length);
        System.out.println("Arrays: "+ Arrays.toString(b));
        System.out.println("Arrays: "+ Arrays.toString(s));
    }

    static void merge(int M[], int N[], int m, int n)
    {
        int k = m + n -1;
        m--; n--;

        while(n >= 0 && m >= 0)
            M[k--] = M[m] > N[n] ? M[m--] : N[n--];

        while(n >= 0)
            M[k--] = N[n--];
    }

    static void merge(int bigger[], int bigger_len, int smaller[], int smaller_len) {
        int smaller_i, bigger_i, idx;

        if (smaller_len == 0)
            return;

        smaller_i = smaller_len-1;

        if (bigger_len == 0)
            bigger_i = -1;
        else
            bigger_i = bigger_len-1;

        idx = bigger_len+smaller_len-1;

        while (smaller_i >= 0 && bigger_i >= 0) {
            if (bigger[bigger_i] > smaller[smaller_i]) {
                bigger[idx] = bigger[bigger_i];
                bigger_i--;
            }
            else {
                bigger[idx] = smaller[smaller_i];
                smaller_i--;
            }
            idx--;
        }

        while (smaller_i >= 0) {
            bigger[idx] = smaller[smaller_i];
            smaller_i--;
            idx--;
        }
    }*//*


}
*/
