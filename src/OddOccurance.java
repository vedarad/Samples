/**
 * Created by skoded001c on 8/25/16.
 */
class OddOccurance
{
    int getOddOccurrence(int ar[], int ar_size)
    {
        int i;
        int res = 0;
        for (i = 0; i < ar_size; i++)
        {
            res = res ^ ar[i];
        }
        return res;
    }

    public static void main(String[] args)
    {
        OddOccurance occur = new OddOccurance();
        int ar[] = new int[]{1,3,5,7,3,5,7,1,9};
        int n = ar.length;
        System.out.println(occur.getOddOccurrence(ar, n));
    }
}
