
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by skoded001c on 8/8/16.
 */
public class OpenSomeExe{

    public static void main(String args[]) throws Exception{
        /*Runtime rt = Runtime.getRuntime();
        Process pr = rt.exec("C:\\Program Files (x86)\\Notepad++\\notepad++.exe");
        Thread.sleep(10000);
        pr.destroy();*/

        String[] days = new String[] {"Monday","Wednesday", "Thursday"};
        recurringTask("01/01/2015", 2, days, 4);

        /*String[][] some = new String[][]{{"John","1","2","6"},{"Martin","1","1","5"}};
        someMethod(some);*/
    }

    static void recurringTask(String firstDate, int k, String[] daysOfTheWeek, int n) {


        if(firstDate == null || k < 1 || daysOfTheWeek.length < 1 || n < 1)
            return;

        List<String> data = new ArrayList<>();
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] dayOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        Date date;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        try{
            date = sdf.parse(firstDate);
            calendar.setTime(date);
        }catch(ParseException e){
            //do something
        }
        String day = dayOfWeek[calendar.get(calendar.DAY_OF_WEEK)-1];
        int noOfDays = daysInMonth[calendar.get(calendar.MONTH)];
        String  month = monthNames[calendar.get(calendar.MONTH)];
        data.add(firstDate);

        for(String s : daysOfTheWeek){
            if(!s.equals(day)){
                int diff;
                switch (s){
                    case "Monday":
                        diff = calendar.DAY_OF_WEEK - Calendar.MONDAY;
                        if (!(diff > 0)) {
                            diff += 7;
                        }
                        calendar.set(Calendar.DAY_OF_MONTH, diff);
                        break;
                    case "Tuesday":
                        diff = calendar.DAY_OF_WEEK - Calendar.TUESDAY;
                        if (!(diff > 0)) {
                            diff += 7;
                        }
                        calendar.set(Calendar.DAY_OF_MONTH, diff);
                        break;
                    case "Wednesday":
                        diff = calendar.DAY_OF_WEEK - Calendar.WEDNESDAY;
                        if (!(diff > 0)) {
                            diff += 7;
                        }
                        calendar.set(Calendar.DAY_OF_MONTH, diff);
                        break;
                    case "Thursday":
                        diff = calendar.DAY_OF_WEEK - Calendar.THURSDAY;
                        if (!(diff > 0)) {
                            diff += 7;
                        }
                        calendar.set(Calendar.DAY_OF_MONTH, diff);
                        break;
                    case "Friday":
                        diff = calendar.DAY_OF_WEEK - Calendar.FRIDAY;
                        if (!(diff > 0)) {
                            diff += 7;
                        }
                        calendar.set(Calendar.DAY_OF_MONTH, diff);
                        break;
                    case "Saturday":
                        diff = calendar.DAY_OF_WEEK - Calendar.SATURDAY;
                        if (!(diff > 0)) {
                            diff += 7;
                        }
                        calendar.set(Calendar.DAY_OF_MONTH, diff);
                        break;
                    case "Sunday":
                        diff = calendar.DAY_OF_WEEK - Calendar.SUNDAY;
                        if (!(diff > 0)) {
                            diff += 7;
                        }
                        calendar.set(Calendar.DAY_OF_MONTH, diff);
                        break;
                }
                data.add(sdf.format(calendar.getTime()));
            }
        }

        while(data.size()!=n){
            calendar.set(calendar.DAY_OF_MONTH, (k *7));
            data.add(sdf.format(calendar.getTime()));
        }
    }


    public static String someMethod(String[][] information){

        String t = null;

        if(information.length < 1)
            return t;

        if(information.length == 1){
            t = information[0][0];
            return t;
        }

        if(information.length>1){
            for(int i=0; i<information.length; i++){
                String[] inner = information[i];
                for(int j = i+1; j < information.length; j++){
                    String[] subinner = information[j];

                    if(Integer.parseInt(inner[1]) == Integer.parseInt(subinner[1])){
                        if(Integer.parseInt(inner[3]) > Integer.parseInt(subinner[3])){
                            t= subinner[0];
                        }else if(Integer.parseInt(inner[3]) < Integer.parseInt(subinner[3])){
                            t= inner[0];
                        }else{
                            if(Integer.parseInt(inner[2]) < Integer.parseInt(subinner[2])){
                                t= inner[0];
                            }else if(Integer.parseInt(inner[2]) > Integer.parseInt(subinner[2])){
                                t= subinner[0];
                            }
                        }
                    }else if(Integer.parseInt(inner[1]) > Integer.parseInt(subinner[1])){
                        t= inner[0];
                    }else if(Integer.parseInt(inner[1]) < Integer.parseInt(subinner[1])){
                        t= subinner[0];
                    }

                }
            }
        }


        return t;
    }
}
