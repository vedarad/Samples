/**
 * Created by skoded001c on 9/15/16.
 */
public class ImplementCompareTo<T> implements Comparable<T> {
    private T data;

    @Override
    public int compareTo(T o){
        int len1 = data.toString().length();
        int len2 = o.toString().length();
        int lim = len1 - len2;

        char v1[] = data.toString().toCharArray();
        char v2[] = o.toString().toCharArray();

        int k = 0;
        while(k<lim){
            char c1 = v1[k];
            char c2 = v2[k];

            if(c1 != c2)
                return c1 - c2;

            k++;
        }
        return len1 - len2;
    }

}
