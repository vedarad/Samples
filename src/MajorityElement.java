/**
 * Created by skoded001c on 8/25/16.
 */
public class MajorityElement {

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,5,5,5,6,6,6,5,5,5,5,5};

        //basic loop to pring majority
        /*for(int i=0; i<arr.length-1; i++){
            int count=1;
            for(int j=i+1; j<arr.length; j++){
                if(arr[i]==arr[j]){
                    count++;
                }
            }
            if(count>(arr.length/2)){
                System.out.println("Majority Element is: "+arr[i]);
                break;
            }
        }*/

        //TODO: Use binary search to find majority element

        /*Moore's voting algorithm: if we cancel out each occurrence of an element e with all the other elements that are different from e then
        e will exist till end if it is a majority element*/
        int e = findMajorityElement(arr, arr.length);

        if(isMajority(arr, arr.length, e))
            System.out.println("Element found: " + e);
        else
            System.out.println("Element Not Found!!!");
    }

    static int findMajorityElement(int[] arr, int s){
        int maj = 0; int count = 1;
        for(int i=1; i<s; i++){
            if(arr[maj]==arr[i])
                count++;
            else
                count--;
            if(count==0){
                maj = i;
                count = 1;
            }
        }
        return arr[maj];
    }

    static boolean isMajority(int[] arr, int size, int maj){
        int count =0;
        for(int i=0; i<size; i++){
            if(arr[i]==maj)
                count++;
        }
        if(count > size/2)
            return true;
        else
            return false;
    }
}
