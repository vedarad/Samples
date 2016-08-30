/**
 * Created by skoded001c on 8/8/16.
 */
public class MySwappingTwoNumbers {

    public static void main(String a[]){
        int x = 33;
        int y = 29;
        System.out.println("Before swap:");
        System.out.println("x value: "+x);
        System.out.println("y value: "+y);
        x = x+y;
        y=x-y;
        x=x-y;
        System.out.println("After swap:");
        System.out.println("x value: "+x);
        System.out.println("y value: "+y);
    }
}