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

        String[] finalData = new String[n];
        String[] dayOfWeek = {"Sunday", "Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};

        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        Date date;
        try {
            date = sdf.parse(firstDate);
            c.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<String> myList = new ArrayList<>();
        myList.add(0, firstDate);

        int day = c.get(Calendar.DAY_OF_WEEK);
        String dayWeek = dayOfWeek[day-1];
        int diff = 0;
        for(String s : daysOfTheWeek){
            if(!s.equalsIgnoreCase(dayWeek)){
                switch (s) {
                    case "Monday": {
                        diff = Calendar.MONDAY - c.get(Calendar.DAY_OF_WEEK);
                        if (!(diff > 0)) {
                            diff += 7;
                        }
                        c.add(Calendar.DAY_OF_MONTH, diff);
                        break;
                    }
                    case "Tuesday": {
                        diff = Calendar.TUESDAY - c.get(Calendar.DAY_OF_WEEK);
                        if (!(diff > 0)) {
                            diff += 7;
                        }
                        c.add(Calendar.DAY_OF_MONTH, diff);
                        break;
                    }
                    case "Wednesday": {
                        diff = Calendar.WEDNESDAY - c.get(Calendar.DAY_OF_WEEK);
                        if (!(diff > 0)) {
                            diff += 7;
                        }
                        c.add(Calendar.DAY_OF_MONTH, diff);
                        break;
                    }
                    case "Thursday": {
                        diff = Calendar.THURSDAY - c.get(Calendar.DAY_OF_WEEK);
                        if (!(diff > 0)) {
                            diff += 7;
                        }
                        c.add(Calendar.DAY_OF_MONTH, diff);
                        break;
                    }
                    case "Friday": {
                        diff = Calendar.FRIDAY - c.get(Calendar.DAY_OF_WEEK);
                        if (!(diff > 0)) {
                            diff += 7;
                        }
                        c.add(Calendar.DAY_OF_MONTH, diff);
                        break;
                    }
                    case "Saturday": {
                        diff = Calendar.SATURDAY - c.get(Calendar.DAY_OF_WEEK);
                        if (!(diff > 0)) {
                            diff += 7;
                        }
                        c.add(Calendar.DAY_OF_MONTH, diff);
                        break;
                    }
                    case "Sunday": {
                        diff = Calendar.SUNDAY - c.get(Calendar.DAY_OF_WEEK);
                        if (!(diff > 0)) {
                            diff += 7;
                        }
                        c.add(Calendar.DAY_OF_MONTH, diff);
                        break;
                    }
                    default:
                        break;
                }
                if(n>1)
                    myList.add(1,sdf.format(c.getTime()));
            }

        }

        List<String> temp = new ArrayList<>();
        temp.addAll(myList);
        for(String s : temp){
            try {
                date = sdf.parse(s);
                c.setTime(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            c.add(Calendar.DAY_OF_MONTH, (k * 7));

            for(int i=2; i<=n; i++) {
                myList.add(myList.size(), sdf.format(c.getTime()));
                break;
            }

        }
        finalData = new String[myList.size()];
        finalData = myList.toArray(finalData);

        return finalData;

    }
}
