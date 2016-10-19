import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by skoded001c on 9/21/16.
 */
public class PermutationsOfInt {

    public static void main(String[] args){
        /*Integer[] nums = new Integer[10];
        for(int i=1;i<=10; i++){
            nums[i-1]=i;
        }
        Set<Integer[]> s = getPermutationsRecursive(nums);
        System.out.println(s.size());*/
        secondRightmostZeroBit(37);
    }

    static int secondRightmostZeroBit(int n) {
        System.out.println(Integer.numberOfTrailingZeros(n));
        return 0;
    }

    public static Set<Integer[]> getPermutationsRecursive(Integer[] num){
        if (num == null)
            return null;

        Set<Integer[]> perms = new HashSet<>();

        //base case
        if (num.length == 0){
            perms.add(new Integer[0]);
            return perms;
        }

        //shave off first int then get sub perms on remaining ints.
        //...then insert the first into each position of each sub perm..recurse

        int first = num[0];
        Integer[] remainder = Arrays.copyOfRange(num, 1, num.length);
        Set<Integer[]> subPerms = getPermutationsRecursive(remainder);
        for (Integer[] subPerm: subPerms){
            for (int i=0; i <= subPerm.length; ++i){ // '<='   IMPORTANT !!!
                Integer[] newPerm = Arrays.copyOf(subPerm, subPerm.length+1);
                for (int j=newPerm.length-1; j>i; --j)
                    newPerm[j] = newPerm[j-1];
                newPerm[i]=first;
                perms.add(newPerm);
            }
        }

        return perms;
    }
}
