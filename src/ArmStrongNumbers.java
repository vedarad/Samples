import java.util.Scanner;

/**
 * Created by sreenathkodedala on 8/1/16.
 */
public class ArmStrongNumbers {

    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter digit: ");
        int num = sc.nextInt();
        int copy = num;

        int noOfDigits = String.valueOf(num).length();
        int sum = 0;

        while(num!=0) {
            int powerTo = 1;
            int mod = num % 10;
            for (int i = 0; i < noOfDigits; i++) {
                powerTo = powerTo * mod;
            }
            sum = sum + powerTo;

            num = num / 10;
        }

        if(copy==sum){
            System.out.println(copy+": " + sum);
        }
    }
}

