import java.util.Arrays;

/**
 * Created by skoded001c on 8/8/16.
 */
public class MySelectionSort {

    public static void main(String args[]){
        int[] nums = {22,-99,-98,67,36,0,11};
        selectionSort(nums);
    }

    public static void selectionSort(int[] ns){
        System.out.println("Unsorted array: "+ Arrays.toString(ns));
        int temp, pos;
        for(int i=0; i<ns.length-1; i++){
            pos = i;
            for(int j=i+1; j<ns.length; j++){
                if(ns[j]<ns[pos])
                    pos = j;
            }
            temp = ns[i];
            ns[i] = ns[pos];
            ns[pos] = temp;
            System.out.println("Sorted array: "+ Arrays.toString(ns));
        }
    }
}
