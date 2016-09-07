import java.util.Arrays;

public class QuickSort {

    private int array[];
    private int length;

    public void sort(int[] inputArr) {

        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        this.array = inputArr;
        length = inputArr.length;
        quickSort(0, length - 1);
    }

    private void quickSort(int lowerIndex, int higherIndex) {

        int i = lowerIndex;
        int j = higherIndex;
        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        System.out.println("Pivot: "+pivot);
        while (i <= j) {
            
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
            System.out.println("Still Sorting: "+Arrays.toString(array));
        }
        
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
    }

    public static void main(String a[]){
        int[] input = {24,2,45,20,56,75,2,56,99,53,12};
        System.out.println("Unsorted array: "+Arrays.toString(input));
        QuickSort qs = new QuickSort();
        qs.sort(input);
        System.out.println("Sorted Array: "+Arrays.toString(input));
    }
}
