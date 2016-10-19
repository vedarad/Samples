/**
 * Created by skoded001c on 10/19/16.
 */
public class FizzBuzzWoof {
    public void solution(int N) {
        for(int i=1; i<=N; i++){
            System.out.println(
                    (i % 105 == 0) ? "FizzBuzzWoof":
                    (i % 35 == 0) ? "BuzzWoof" :
                    (i % 21 == 0) ? "FizzWoof":
                    (i % 15 == 0) ? "FizzBuzz":
                    (i % 3 == 0) ? "Fizz":
                    (i % 5 == 0) ? "Buzz":
                    (i % 7 == 0) ? "Woof": i
            );
        }
    }

    public static void main(String args[]){
        FizzBuzzWoof s = new FizzBuzzWoof();
        s.solution(105);
    }
}
