import java.util.*;

/**
 * Created by sreenathkodedala on 8/30/16.
 */
public class MixedMethods {

    public static void main(String args[]) {

    }

    int isSumOfConsecutive2(int n) {
        int sum=0,c=0,j=0;
        int count =0;
        for(int i=1;i<n;i++)
        {
            sum=i;
            j=i+1;


            while(sum<n)
            {
                sum=sum+j;
                j++;
            }

            if(sum==n)
            {
                count += 1;
            }
        }
        return count;
    }

    boolean whoseTurn(String p) {

        class Helper {

            int color(int r, int c) {
                return (r + c) % 2;
            }
        }
        Helper h = new Helper();

        int s = 0;
        for (int i = 0; i < 4; i++) {
            int c = p.charAt(i * 3) - 'a';
            int r = p.charAt(i * 3 + 1) - '0';
            s += h.color(r, c);
        }

        return s % 2 == 0;
    }

    int differentSubstrings(String inputStr) {
        class Helper {
            void addNode(ArrayList<int[]> lastVersion) {
                int[] line = new int[26];
                lastVersion.add(line);
            }
        }
        Helper h = new Helper();

        int nodesCount = 1;
        ArrayList<int[]> trie = new ArrayList<>();
        h.addNode(trie);

        for (int i = 0; i < inputStr.length(); i++) {
            int currentNode = 0;
            for (int j = i; j < inputStr.length(); j++) {
                int symbol = inputStr.charAt(j) - 97;
                if (trie.get(currentNode)[symbol] == 0) {
                    h.addNode(trie);
                    trie.get(currentNode)[symbol] = nodesCount;
                    nodesCount++;
                }
                currentNode = trie.get(currentNode)[symbol];
            }
        }

        return nodesCount - 1;
    }

    String capitalizeVowelsRegExp(String input) {
        String r = "";
        for (char c : input.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y') {
                String s = String.valueOf(c);
                r += s.toUpperCase();
            } else {
                r += c + "";
            }
        }
        return r;
    }

    ArrayList<Integer> possibleHeights(int[] parent) {

        class Graph {
            ArrayList<Integer>[] edges;
            int[] height;
            boolean[] isPossibleHeight;

            Graph(int[] parent) {
                edges = new ArrayList[parent.length];
                for (int i = 0; i < edges.length; i++) {
                    edges[i] = new ArrayList();
                }
                for (int i = 1; i < parent.length; i++) {
                    edges[parent[i]].add(i);
                }
                height = new int[parent.length];
                isPossibleHeight = new boolean[parent.length];
            }

            void calcHeight(int v) {
                for (int u : edges[v]) {
                    calcHeight(u);
                    height[v] = Math.max(height[v], height[u] + 1);
                }
                ArrayList<Integer>[] countHeights = new ArrayList[edges.length];
                for (int i = 0; i < edges.length; i++) {
                    countHeights[i] = new ArrayList<>();
                }
                for (int i = 0; i < edges[v].size(); i++) {
                    int u = edges[v].get(i);
                    countHeights[height[u]].add(u);
                }
                edges[v].clear();
                for (int i = edges.length - 1; i >= 0; i--) {
                    for (int j = 0; j < countHeights[i].size(); j++) {
                        edges[v].add(countHeights[i].get(j));
                    }
                }
            }

            void findNewHeights(int v, int tailHeight) {
                isPossibleHeight[Math.max(height[v], tailHeight)] = true;
                int firstMaxHeight = tailHeight + 1;
                int secondMaxHeight = tailHeight + 1;
                if (edges[v].size() > 0) {
                    firstMaxHeight = Math.max(firstMaxHeight, height[edges[v].get(0)] + 2);
                }
                //TODO
                if (edges[v].size() > 0) {
                    findNewHeights(edges[v].get(0), secondMaxHeight);
                }
                for (int i = 1; i < edges[v].size(); i++) {
                    findNewHeights(edges[v].get(i), firstMaxHeight);
                }
            }
        }

        Graph g = new Graph(parent);
        g.calcHeight(0);
        g.findNewHeights(0, 0);

        ArrayList<Integer> heights = new ArrayList<>();
        for (int i = 0; i < parent.length; i++) {
            if (g.isPossibleHeight[i]) {
                heights.add(i);
            }
        }
        return heights;
    }


    static int periodicSequence(int S0, int A, int B, int MOD) {
        int[] M = new int[100000];

        M[0] = S0;
        for (int i = 1; i < M.length; i++) {
            M[i] = (M[i - 1] * A + B) % MOD;
            System.out.println(i + ": " + M[i]);
            for (int j = 0; j < i; j++) {
                if (M[i] == M[j]) {
                    //System.out.println("\tS: "+i + " " + j);
                    boolean T = true;
                    for (int k = 0; k < i - j; k++) {
                        M[i + k] = (M[i + k - 1] * A + B) % MOD;
                        //System.out.println("\tK: "+k + " " + M[i+k] + " "+M[j+k]);
                        if (M[i + k] != M[j + k]) {
                            T = false;
                            break;
                        }
                    }
                    if (T)
                        return i - j;
                }
            }
        }
        return -1;
    }

    //TODO
    String[] repeatedSubstring(String inputString, int k) {

        List<String> result = new ArrayList<>();
        boolean[] used = new boolean[inputString.length()];

        for (int i = 0; i + k <= inputString.length(); i++) {
            if (!used[i]) {
                used[i] = true;
                boolean found = false;
                for (int j = i + 1; j + k <= inputString.length(); j++) {
                    boolean equal = true;
                    for (int p = 0; p < k; p++) {
                        if (inputString.charAt(i + p) != inputString.charAt(j + p)) {
                            equal = false;
                            break;
                        }
                    }
                    if (equal) {
                        found = true;
                        used[j] = true;
                    }
                }
                if (found) {
                    StringBuilder occurence = new StringBuilder();
                    for (int l = i; l < i + k; l++)
                        occurence.append(inputString.charAt(l));
                    result.add(occurence.toString());
                }
            }
        }

        Collections.sort(result);
        return result.toArray(new String[result.size()]);
    }


    //TODO
    static int holiday(int x, String weekDay, String month, int yearNumber) {
        final List<String> months = new ArrayList<String>(
                Arrays.asList(new String[]{
                        "January", "February", "March", "April",
                        "May", "June", "July", "August",
                        "September", "October", "November", "December"
                }));
        final List<String> daysInWeek = new ArrayList<String>(
                Arrays.asList(new String[]{
                        "Monday", "Tuesday", "Wednesday",
                        "Thursday", "Friday", "Saturday", "Sunday"
                }));
        final int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        class Helper {
            boolean isLeap(int year) {
                return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
            }

            int countLeap(int yearLeft, int yearRight) {
                int result = 0;
                for (int i = yearLeft; i <= yearRight; i++) {
                    if (isLeap(i)) {
                        result++;
                    }
                }
                return result;
            }

            int getDaysInMonth(int month, int year) {
                int result = days[month];
                if (isLeap(year) && month == 1) {
                    result++;
                }
                return result;
            }
        }

        int weekDayInt = daysInWeek.indexOf(weekDay);
        int monthInt = months.indexOf(month);

        /*01 January 2015 is Thursday*/
        Helper h = new Helper();
        int leaps = h.countLeap(2015, yearNumber - 1);
        int newWeekDay = (daysInWeek.indexOf("Thursday") + leaps * 366 +
                (yearNumber - 2015 - leaps) * 365) % 7;
        for (int i = 0; i < monthInt; i++) {
            newWeekDay = (newWeekDay + h.getDaysInMonth(i, yearNumber)) % 7;
        }
        int daysCount = 0;
        int daysInMonth = h.getDaysInMonth(monthInt, yearNumber);
        for (int i = 1; i <= daysInMonth; i++) {
            if (newWeekDay == weekDayInt) {
                daysCount++;
            }
            if (daysCount == x) {
                return i;
            }
            newWeekDay = (newWeekDay + 1) % 7;
        }
        return -1;
    }


    ArrayList<Integer> splitByValue(int k,
                                    ArrayList<Integer> elements) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i) < k) {
                result.add(elements.get(i));
            }
        }
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i) >= k) {
                result.add(elements.get(i));
            }
        }
        return result;
    }

    boolean areIsomorphic(int[][] array1, int[][] array2) {
        if (array1.length != array2.length)
            return false;
        for (int i = 0; i < array1.length; i++) {
            if (array1[i].length != array2[i].length)
                return false;
        }
        return true;
    }

    int leastSignificantBit(int n) {

        int ans = 1;
        while ((n & 1) == 0) {
            n >>= 1;
            ans <<= 1;
        }

        return ans;
    }

    boolean isSumOfConsecutive(int n) {
        for (int start = 1; start < n; start++) {
            int number = n,
                    subtrahend = start;
            while (number > 0) {
                number -= subtrahend;
                subtrahend++;
            }
            if (number == 0) {
                return true;
            }
        }
        return false;
    }

    int[][] matrixTransposition(int[][] matrix) {

        int[][] result = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                result[i][j] = matrix[j][i];
            }
        }
        return result;
    }

    static int[] zFunctionNaive(String s) {
        int[] Z = new int[s.length()];
        int n = s.length();
        int L, R, k;

        // [L,R] make a window which matches with prefix of s
        L = R = 0;
        for (
                int i = 1;
                i < n; ++i)

        {
            // if i>R nothing matches so we will calculate.
            // Z[i] using naive way.
            if (i > R) {
                L = R = i;

                // R-L = 0 in starting, so it will start
                // checking from 0'th index. For example,
                // for "ababab" and i = 1, the value of R
                // remains 0 and Z[i] becomes 0. For string
                // "aaaaaa" and i = 1, Z[i] and R become 5
                while (R < n && s.charAt(R - L) == s.charAt(R))
                    R++;
                Z[i] = R - L;
                R--;
            } else {
                // k = i-L so k corresponds to number which
                // matches in [L,R] interval.
                k = i - L;

                // if Z[k] is less than remaining interval
                // then Z[i] will be equal to Z[k].
                // For example, str = "ababab", i = 3, R = 5
                // and L = 2
                if (Z[k] < R - i + 1)
                    Z[i] = Z[k];

                    // For example str = "aaaaaa" and i = 2, R is 5,
                    // L is 0
                else {
                    //  else start from R  and check manually
                    L = i;
                    while (R < n && s.charAt(R - L) == s.charAt(R))
                        R++;
                    Z[i] = R - L;
                    R--;
                }
            }
        }

        Z[0] = n; // CodeFights test are passed
        return Z;
    }

    int[] bfsDistancesUnweightedGraph(boolean[][] matrix, int startVertex) {

        boolean[] visited = new boolean[matrix.length];
        LinkedList<Integer> queue = new LinkedList<>();
        int[] distance = new int[matrix.length];
        queue.add(startVertex);
        while (queue.size() != 0) {
            int currentVertex = queue.pop();
            visited[currentVertex] = true;
            for (int nextVertex = 0; nextVertex < matrix.length; nextVertex++) {
                if (matrix[currentVertex][nextVertex] && !visited[nextVertex]) {
                    visited[nextVertex] = true;
                    distance[nextVertex] = distance[currentVertex] + 1;
                    queue.add(nextVertex);
                }
            }
        }

        return distance;
    }


    int chessKnight(String cell) {
        int row = Integer.parseInt("" + cell.charAt(1)),
                column = cell.charAt(0) - 'a' + 1;
        int[][] steps = {
                {-2, -1}, {-1, -2}, {1, -2}, {2, -1},
                {2, 1}, {1, 2}, {-1, 2}, {-2, 1}
        };
        int answer = 0;

        for (int i = 0; i < steps.length; i++) {
            int tmpRow = row + steps[i][0];
            int tmpColumn = column + steps[i][1];
            if (tmpRow >= 1 && tmpRow <= 8 &&
                    tmpColumn >= 1 && tmpColumn <= 8) {
                answer++;
            }
        }

        return answer;
    }

    static int chartFix(int[] chart) {

        ArrayList<Integer> toRemove = new ArrayList<>();
        for (int i = 0; i < chart.length; i++) {
            int cur = i;
            for (int j = 0; j < i; j++) {
                if (chart[j] < chart[i]) {
                    cur = Math.min(cur, toRemove.get(j) + i - j);
                }
            }
            toRemove.add(cur);
        }

        return toRemove.get(chart.length - 1);
    }

    int dfsComponentSize(boolean[][] matrix, int vertex) {
        ArrayList<Integer> update = new ArrayList<Integer>();
        update.add(vertex);
        boolean[] v = new boolean[matrix.length];
        v[vertex] = true;
        int R = 1;
        while (update.size() > 0) {
            int i = update.get(0);
            update.remove(0);

            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] && !v[j]) {
                    v[j] = true;
                    update.add(j);
                    R++;
                }
            }
        }
        return R;
    }

    int axisAlignedCirclesBoundingBox(int[] x, int[] y, int[] r) {
        int maxx = Integer.MIN_VALUE;
        int maxy = Integer.MIN_VALUE;
        int minx = Integer.MAX_VALUE;
        int miny = Integer.MAX_VALUE;

        for (int i = 0; i < r.length; i++) {
            if (x[i] - r[i] < minx) minx = x[i] - r[i];
            if (x[i] + r[i] > maxx) maxx = x[i] + r[i];
            if (y[i] - r[i] < miny) miny = y[i] - r[i];
            if (y[i] + r[i] > maxy) maxy = y[i] + r[i];
        }

        return (maxx - minx) * (maxy - miny);
    }

    String pawnRace(String white, String black, char toMove) {
        int wHor = white.charAt(1) - '0';
        int wVert = white.charAt(0) - 'a';
        int bHor = black.charAt(1) - '0';
        int bVert = black.charAt(0) - 'a';
        if (wVert == bVert && wHor < bHor) {
            return "draw";
        }
        if (Math.abs(wVert - bVert) != 1 || wHor >= bHor) {
            int wRest = Math.min(8 - wHor, 5);
            int bRest = Math.min(bHor - 1, 5);
            if (wRest < bRest || wRest == bRest && toMove == 'w') {
                return "white";
            }
            return "black";
        }
        int[][] winningPairs = {{2, 5}, {2, 6}, {3, 6}, {4, 7}};
        if (toMove == 'w') {
            for (int i = 0; i < 4; i++) {
                if (wHor == winningPairs[i][0] && bHor == winningPairs[i][1]) {
                    return "white";
                }
            }
            if (wHor + 1 == bHor) {
                return "white";
            }
            return "black";
        } else {
            for (int i = 0; i < 4; i++) {
                if (wHor == 9 - winningPairs[i][1] && bHor == 9 - winningPairs[i][0]) {
                    return "black";
                }
            }
            if (wHor + 1 == bHor) {
                return "black";
            }
            return "white";
        }
    }

    //TODO need modification
    private static int squareInTheLabyrinth(boolean[][] labMap) {

        class Helper {
            boolean[][] labMap;
            int h, w;

            Helper(boolean[][] labMap) {
                this.labMap = labMap;
                this.h = labMap.length;
                this.w = labMap[0].length;
            }

            boolean valid(int x, int y, boolean[][] was, int k) {
                //
                if (x >= was.length || x < 0 || x + k >= labMap.length)
                    return false;
                if (y >= was[x].length || y < 0 || y + k >= labMap.length)
                    return false;
                //
                if (was[x][y]) {
                    return false;
                }
                for (int dx = 0; dx < k; dx++) {
                    for (int dy = 0; dy < k; dy++) {
                        if (!labMap[x + dx][y + dy]) {
                            return false;
                        }
                    }
                }
                return true;
            }

            void dfs(int curX, int curY, boolean[][] was, int k) {
                if (valid(curX, curY, was, k)) {
                    was[curX][curY] = true;
                    for (int dx = -1; dx <= 1; dx++) {
                        for (int dy = -1; dy <= 1; dy++) {
                            if (dx * dy == 0 && dx + dy != 0) {
                                dfs(curX + dx, curY + dy, was, k);
                            }
                        }
                    }
                }
            }
        }

        Helper helper = new Helper(labMap);

        boolean[][] was = new boolean[helper.h][helper.w];
        int maxRes = Math.min(helper.h, helper.w);

        for (int i = 0; i < helper.h; i++) {
            Arrays.fill(was[i], false);
        }

        for (int res = maxRes; res > 0; res--) {
            helper.dfs(0, 0, was, res);
            if (was[helper.h - res][helper.w - res]) {
                return res;
            }
            for (int i = 0; i < helper.h; i++) {
                for (int j = 0; j < helper.w; j++) {
                    was[i][j] = false;
                }
            }
        }

        return 0;
    }

    static String[] fileNaming(String[] names) {
        String[] s1 = new String[]{"s"};
        Map<String, Integer> hMap = new HashMap<>();
        int count = 1;
        for (String s : names) {
            if (hMap.containsKey(s))
                hMap.put(s, count + 1);
            else
                hMap.put(s, count);
        }
        return s1;
    }

    static boolean findPath(int[][] matrix) {
        int cx = -1, cy = -1;
        for (int i = 1; i <= matrix.length * matrix[0].length; i++) {
            for (int y = 0; y < matrix.length; y++) {
                for (int x = 0; x < matrix[y].length; x++) {
                    if (i == matrix[y][x]) {
                        if (cx != -1 && Math.abs(x + y - cx - cy) != 1) {
                            return false;
                        }
                        cx = x;
                        cy = y;
                    }
                }
            }
        }
        return true;
    }

    static boolean knightsAndKnaves(int[] answers) {

        int n = answers.length;
        boolean[] isKnight = new boolean[n];
        isKnight[0] = true;
        for (int i = 1; i < n; i++) {
            isKnight[i] = (answers[0] >> i & 1) == 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (
                        (isKnight[i] && isKnight[j]) ^
                                ((answers[i] >> j & 1) == 1)
                        ) {
                    return false;
                }
            }
        }

        return true;
    }


    static String[] isDivisibleBy6(String inputString) {

        int digitSum = 0;
        char leftBound = '0',
                rightBound = '9';
        ArrayList<String> answer = new ArrayList<>();
        char[] mask = inputString.toCharArray();
        int asteriskPos = -1;

        for (int i = 0; i < mask.length; i++) {
            if (leftBound <= mask[i] &&
                    mask[i] <= rightBound) {
                digitSum += mask[i] - leftBound;
            } else {
                asteriskPos = i;
            }
        }

        for (int i = 0; i < 10; i++) {
            if ((digitSum + i) % 3 == 0) {
                mask[asteriskPos] = (char) (i + leftBound);
                if ((mask[mask.length - 1] - leftBound) % 2 == 0) {
                    answer.add(String.valueOf(mask));
                }
            }
        }

        return answer.toArray(new String[0]);
    }

    boolean checkPalindrome(String inputString) {
        for (int i = 0; i < inputString.length() / 2; i++) {
            if (inputString.charAt(i) !=
                    inputString.charAt(inputString.length() - 1 - i)) return false;
        }
        return true;

    }

    static int champernowneDigit(int n) {

        for (int i = 1; ; i++) {
            int number = i;
            ArrayList<Integer> digits = new ArrayList<>();
            while (number != 0) {
                digits.add(number % 10);
                number = number / 10;
            }
            Collections.reverse(digits);
            if (n <= digits.get(n - 1)) {
                return n;
            }
            n -= digits.size();
        }
    }

    boolean latinLettersSearchRegExp(String input) {


        for (int i = 0; i < input.length(); i++) {
            if (Character.isLetter(input.charAt(i)))
                return true;
        }

        return false;
    }


    int factorialsProductTrailingZeros(int l, int r) {
        int result = 0,
                last = 0;
        for (int i = 1; i <= r; i++) {
            int number = i;
            while (number % 5 == 0) {
                number /= 5;
                result++;
            }
            if (i >= l) {
                result += last;
            }
        }
        return result;
    }

    boolean adaNumber(String line) {
        boolean atLeastOneDigit = false;
        if (line.charAt(line.length() - 1) == '#') {
            int i = 0;
            int base = 0;
            while (line.charAt(i) != '#' && base <= 16) {
                if (line.charAt(i) != '_') {
                    if ('0' <= line.charAt(i) && line.charAt(i) <= '9') {
                        base = base * 10 + (int) line.charAt(i) - (int) '0';
                    } else {
                        return false;
                    }
                }
                i++;
            }
            if (base < 2 || base > 16) {
                return false;
            }
            i++;
            while (i < line.length() - 1) {
                if (line.charAt(i) != '_') {
                    int digit = -1;
                    if ('a' <= line.charAt(i) && line.charAt(i) <= 'f') {
                        digit = (int) line.charAt(i) - (int) 'a' + 10;
                    }
                    if ('A' <= line.charAt(i) && line.charAt(i) <= 'F') {
                        digit = (int) line.charAt(i) - (int) 'A' + 10;
                    }
                    if ('0' <= line.charAt(i) && line.charAt(i) <= '9') {
                        digit = line.charAt(i) - (int) '0';
                    }
                    if (0 <= digit && digit < base) {
                        atLeastOneDigit = true;
                    } else {
                        return false;
                    }
                }
                i++;
            }
        } else {
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) != '_') {
                    if ('0' <= line.charAt(i) && line.charAt(i) <= '9') {
                        atLeastOneDigit = true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return atLeastOneDigit;
    }


    static int quotientKthDigitAfterDecimalPoint(int a, int b, int k) {

        a %= b;
        while (k > 1) {
            a = (a * 10) % b;
            k--;
        }

        return a * 10 / b;
    }

    int factorSum(int n) {
        int curr = n;
        while (true) {
            int sum = 0;
            for (int i = 2; i <= curr; i++) {
                while (n % i == 0) {
                    sum += i;
                    n /= i;
                }
            }
            if (sum == curr) return curr;
            else {
                curr = sum;
                n = curr;
            }
        }
    }


     /*typedef std::vector<std::vector<char>> matrix;

    std::vector<int> throwingBlocks(matrix field) {
        struct Helper {
            bool isFirstColumnFull(matrix field) {
                bool result = true;
                for (int i = 0; i < field.size(); i++) {
                    result &= field[i][0] == '#';
                }
                return result;
            }

        void countMoves(matrix& field, std::vector<int>& result, int moves) {
            if (isFirstColumnFull(field)) {
                result[0] = std::min(result[0], moves);
                result[1] = std::max(result[1], moves);
                return;
            }
            for (int i = 0; i < field.size(); i++) {
                if (field[i][0] == '#') {
                    continue;
                }
                int j = i;
                int column = 0;
                while (column < field[j].size() && field[j][column] == '.') {
                    column++;
                }
                column--;
                while (j < field.size() && field[j][column] == '.') {
                    j++;
                }
                j--;
                field[j][column] = '#';
                countMoves(field, result, moves + 1);
                field[j][column] = '.';
            }
        }
        };

        const int INF = field.size() * field[0].size() + 1;
        std::vector<int> result{INF, -INF};
        Helper h;
        h.countMoves(field, result, 0);
        return result;
    }*/

    //TODO need modification
    static int[] throwingBlocks(char[][] field) {
        class Helper {
            boolean isFirstColumnFull(char[][] field) {
                boolean result = true;
                for (int i = 0; i < field.length; i++) {
                    result &= field[i][0] == '#';
                }
                return result;
            }

            void countMoves(char[][] field, int[] result, int moves) {
                if (isFirstColumnFull(field)) {
                    result[0] = Math.min(result[0], moves);
                    result[1] = Math.max(result[1], moves);
                    return;
                }
                for (int i = 0; i < field.length; i++) {
                    if (field[i][0] == '#') {
                        continue;
                    }
                    int j = i;
                    int column = 0;
                    while (column < field[j].length && field[j][column] == '.') {
                        column++;
                    }
                    column--;
                    while (j < field.length && field[j][column] == '.') {
                        j++;
                    }
                    j--;
                    field[j][column] = '#';
                    countMoves(field, result, moves + 1);
                    field[j][column] = '.';
                }
            }
        }

        final int INF = field.length + field[0].length + 1;
        int[] result = new int[]{INF, -INF};
        Helper h = new Helper();
        h.countMoves(field, result, 0);
        return result;
    }


    static int squaresSumMinimization(int[] A) {

        int indexOfMinimum = -1,
                minimalSum = -1;

        for (int x = A[0]; x <= A[A.length - 1]; x++) {
            int sum = 0;
            for (int j = 0; j < A.length; j++) {
                sum += (A[j] - x) * (A[j] - x);
            }
            if (sum < minimalSum || indexOfMinimum == -1) {
                minimalSum = sum;
                indexOfMinimum = x;
            }
        }

        return indexOfMinimum;
    }

    static String caesarBoxCipherEncoding(String inputString) {

        int n = (int) Math.sqrt(inputString.length());
        String ans = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans += inputString.charAt(i + j * n);
            }
        }

        return ans;
    }

    int swapNeighbouringDigits(int n) {

        int result = 0,
                tenPower = 1;
        while (n != 0) {
            int digit1 = n % 10,
                    digit2 = ((n - digit1) / 10) % 10;
            result += tenPower * (10 * digit1 + digit2);
            n /= 100;
            tenPower *= 100;
        }
        return result;
    }

    static boolean isPermutation(int n, int[] inputArray) {

        java.util.Arrays.sort(inputArray);
        for (int index = 0; index <= inputArray.length - 1; index++) {
            System.out.println("" + inputArray[index] + " " + index);
            if (inputArray[index] != index + 1) {
                return false;
            }
        }
        return true;
    }

    static int finalizeColoring(int[][] board) {

        boolean[] found = new boolean[2];
        int[] evenness = new int[2];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != 0) {
                    if (found[board[i][j] - 1]) {
                        if (evenness[board[i][j] - 1] != (i + j) % 2) {
                            return 0;
                        }
                    } else {
                        found[board[i][j] - 1] = true;
                        evenness[board[i][j] - 1] = (i + j) % 2;
                    }
                }
            }
        }

        if (evenness[0] == 1 && evenness[1] == 1) {
            return 0;
        }

        if (found[0] || found[1]) {
            return 1;
        }

        return 2;
    }

    static boolean isCaseInsensitivePalindrome(String inputString) {

        boolean notPalindrome = false;

        inputString = inputString.replaceAll("[^a-zA-Z]+", "").toLowerCase();

        char[] array = inputString.toCharArray();
        for (int i = 0, j = array.length - 1; i < j; i++, j--) {
            if (array[i] != array[j]) {
                notPalindrome = true;
                break;
            }
        }
        return notPalindrome;
    }

    int numberOfAnagrams(String S) {
        HashMap<Character, Integer> set = new HashMap<Character, Integer>();
        for (int i = 0; i < S.length(); i++) {
            char item = S.charAt(i);
            if (!set.containsKey(item)) {
                set.put(item, 1);
            } else {
                int freq = set.get(item);
                set.put(item, freq + 1);
            }
        }
        int result = factorial(S.length());
        for (Character item : set.keySet()) {
            result /= factorial(set.get(item));
        }
        return result;
    }

    int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }


}
