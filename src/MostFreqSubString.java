/*

We have a string of length N.
can you figure out the number of occurrence of the most frequent substring in this string?
we are only interested in substring of length from K to L and in each substring the number
of distinct characters must not exceed M. the string contain only lower-case letters(a-z).

constraints:
2<=N<=100000
2<=k<=L<=26,L<N
2<=M<=26

sample input
5
2 4 26
abcde

sample output
1
*/




import java.util.*;
public class MostFreqSubString {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        String[] klm = sc.nextLine().split(" ");
        int K = Integer.parseInt(klm[0]);
        int L = Integer.parseInt(klm[1]);
        int M = Integer.parseInt(klm[2]);

        String string = sc.nextLine().substring(0, N);
        int length = string.length();

        Map<String, Integer> substrCount = new HashMap<>();

        for (int i = 0 ; i < length ; i++) {
            for (int j = 2 ; j <= length - i ; j++) {
                String sub = string.substring(i, i+j);
                if (sub.length() < K || sub.length() > L) {
                    continue;
                }
                int distinct = countDistinct(sub);
                if (distinct < 2 || distinct > M) {
                    continue;
                }
                if (substrCount.containsKey(sub)) {
                    substrCount.put(sub, substrCount.get(sub) + 1);
                } else {
                    substrCount.put(sub, 1);
                }
            }
        }

        Set<String> count = rank(substrCount);
        System.out.println(Integer.valueOf(count.iterator().next().substring(0, 6)));
    }

    private static int countDistinct(String sub) {
        int distinct = 0;
        Set<Character> chars = new HashSet<>();
        for (Character character : sub.toLowerCase().toCharArray()) {
            if (chars.add(character)) {
                distinct++;
            }
        }
        return distinct;
    }

    private static Set<String> rank(Map<String, Integer> substrCount) {
        Set<String> count = new TreeSet<>(new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        for (Map.Entry<String, Integer> entry : substrCount.entrySet()) {
            int zeroes = 6 - String.valueOf(entry.getValue()).length();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < zeroes; i++) {
                sb.append("0");
            }
            sb.append(entry.getValue());
            count.add(sb.toString() + entry.getKey());
        }
        return count;
    }
}
