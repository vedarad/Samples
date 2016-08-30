/**
 * Created by skoded001c on 8/25/16.
 */
public class RotatedSortedArray {
    private static int[] a = {4,5,6,7,8,9,1,2,3};
    private static int x = 9;

    public static void main(String[] ar){

        int l = 0;
        int h = a.length-1;

        int res = findX1(l, h);
        System.out.println("Found element: "+res);
        res = FindSortedArrayRotation(a, a.length);
        System.out.println("Found element: "+a[res]);
    }

    public static int findX1(int l, int h){

        while(l <= h){
            int m = l+(h-l)/2;
            if(a[m]==x) return a[m];
            if(a[l]<=a[m]){
                if (a[l] <= x && x < a[m])
                    h = m - 1;
                else
                    l = m + 1;
            }else{
                if(a[m]<x && x<a[h])
                    l = m+1;
                else
                    h=m-1;
            }
        }
        return -1;
    }

    public static int FindSortedArrayRotation(int a[], int s) {
        int l = 0;
        int h = s - 1;

        while (a[l] > a[h]) {
            int m = l + (h - l) / 2;
            if (a[m] > a[h])
                l = m + 1;
            else
                h = m;
        }
        return l;
    }

    /*public static int findX(int l, int h){
        int m = l+(h-l)/2;
        if(a[m]==x)
            return a[m];

        if(a[m]<x){
            //search right
            return findX(m+1,h);
        }else if(a[m]>x){
            //search left
            return findX(l,m-1);
        }
    return -1;
    }*/

    /*public static int findXrotatedArray(int[] a, int x) {
        int l = 0;
        int r = a.length - 1;
        int p = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            System.out.printf("m=%d, a[m]=%d, l=%d, r=%d\n", m, a[m], l, r);
            // Found x
            if (x == a[m]) {
                // Continue search
                p = m;
            }
            // Search Rigth
            if (a[m] < x && a[l] != x && (a[l] > x || a[r] >= x)) {
                l = m + 1;
            }
            // Search Left
            else {
                r = m - 1;
            }
        }
        return p;
    }*/
}
