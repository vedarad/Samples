/**
 * Created by skoded001c on 8/30/16.
 */
public class AsanaBotTaskType {
    int[] tasksTypes(int[] deadlines, int day) {

        int[] t = new int[3];
        if(deadlines.length < 1)
            return t;

        for (int i = 0; i < deadlines.length; i++) {
            if (deadlines[i] <= day) {
                t[0]++;
            } else if (deadlines[i] >= day + 1 && deadlines[i] <= day + 7) {
                t[1]++;
            } else {
                t[2]++;
            }
        }
        return t;
    }
}
