import java.util.Arrays;

public class MyBubbleSort{

    public static void main(String[] params){
        int[] unsortedArray = {35, 49, 23, 01, 77, 93, -23};
        System.out.println("Sorted Array: "+Arrays.toString(unsortedArray));
        bubbleSort(unsortedArray);
    }

    public static void bubbleSort(int[] sortMe){
        if(sortMe.length == 0){
            System.out.println("Seriously you need to sort an Empty array!");
            return;
        }

        for(int i=0; i<sortMe.length-1; i++){
            for(int j=0; j<sortMe.length-1; j++){
                if(sortMe[j]>sortMe[j+1]){
                    int temp = sortMe[j+1];
                    sortMe[j+1] = sortMe[j];
                    sortMe[j] = temp;
                    System.out.println("Sorted Array: "+Arrays.toString(sortMe));
                }
            }
        }

        /*for(int i=sortMe.length; i>=0; i--){
            int swaps = 0;
            for(int m=0; m<sortMe.length-1; m++){
                if(sortMe[m]>sortMe[m+1]){
                    swapPosition(m, m+1, sortMe);
                    swaps++;
                }
            }
            if(swaps==0)
                break;
        }*/
    }

    public static void swapPosition(int j, int k, int[] sortMe){
        int temp = sortMe[k];
        sortMe[k] = sortMe[j];
        sortMe[j] = temp;
        System.out.println("Sorted Array: "+Arrays.toString(sortMe));
    }
}
