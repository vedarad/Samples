import java.util.Stack;

/**
 * Created by skoded001c on 10/19/16.
 */
public class StackMachine {

    public int solution(String S) {
        Stack stack = new Stack();
        if (S == null || S.length() == 0)
            return -1;

        String[] sa = S.split(" ");

        for(String s1 : sa){
            int num;
            try{
                num = Integer.parseInt(s1);
                stack.push(num);
            } catch (NumberFormatException e) {
                // do nothing and continue
            }
            try{
                switch(s1){
                    case "DUP":
                        stack.push(stack.peek());
                        break;
                    case "POP":
                        stack.pop();
                        break;
                    case "+":
                        try{
                            int sum = (int)stack.pop() + (int)stack.pop();
                            stack.push(sum);
                            break;
                        }catch(Exception e){
                            return -1;
                        }
                    case "-":
                        try{
                            int diff = (int)stack.pop() - (int)stack.pop();
                            stack.push(diff);
                            break;
                        }catch(Exception e){
                            return -1;
                        }
                }
            }catch(Exception e){
                return -1;
            }

        }
        return (int)stack.peek();
    }

    public static void main(String args[]){
        StackMachine s = new StackMachine();
        s.solution("13 DUP 4 POP 5 DUP + DUP + -");
    }
}
