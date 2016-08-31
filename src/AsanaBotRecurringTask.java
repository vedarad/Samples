import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by skoded001c on 8/30/16.
 */
public class AsanaBotRecurringTask {

        String[] recurringTask(String firstDate, int k, String[] daysOfTheWeek, int n) {

        if(firstDate == null || k == 0 || daysOfTheWeek.length == 0 || n == 0)
            return null;

        Calendar c = Calendar.getInstance();
        String[] dayOfWeek = {"Sunday", "Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};

        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Date date;
        try {
            date = sdf.parse(firstDate);
            c.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int wd = c.get(Calendar.DAY_OF_WEEK)-1;
        List<Integer> dow = new ArrayList<>();
        for(String s : daysOfTheWeek) {
            dow.add(Arrays.asList(dayOfWeek).indexOf(s));
        }

        List<String> myList = getRecDays(firstDate, dow, wd, c, sdf);

        String last = myList.get(0);

        while(myList.size() < n){
            try {
                date = sdf.parse(last);
                c.setTime(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            c.add(Calendar.DAY_OF_MONTH, (k * 7));
            List<String> nexts = getRecDays(sdf.format(c.getTime()), dow, c.get(Calendar.DAY_OF_WEEK)-1, c, sdf);
            last = nexts.get(0);
            myList.addAll(nexts);
        }

        String[] finaldata = new String[myList.size()];
        return myList.toArray(finaldata);
    }

    static List<String> getRecDays(String firstDate,List<Integer> dow, int wd, Calendar c, DateFormat sdf){
        List<String> myList = new ArrayList<>();
        myList.add(firstDate);

        for(int i=0; i < dow.size(); i++){
            int day = dow.get(i);

            if(day == wd) continue;

            int diff = day - wd;

            if(diff < 0){
                diff = (7-wd) + day;
            }

            c.add(Calendar.DAY_OF_MONTH, diff);

            myList.add(sdf.format(c.getTime()));
        }
        return myList;
    }
    
}
