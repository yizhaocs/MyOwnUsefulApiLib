package main.java.DateCalendar;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Reference: http://www.mkyong.com/java/java-date-and-calendar-examples/
 */
public class DateCalendar {
    public static void main(String[] args) {
        convertDateToString();
        convertStringToDate();
        getCurrentDateTime();
    }

    private static void convertDateToString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        String date = sdf.format(new Date());
        System.out.println(date); //15/10/2013
    }

    private static void convertStringToDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String dateInString = "31-08-1982 10:20:56";
        Date date = null;
        try {
            date = sdf.parse(dateInString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(date); //Tue Aug 31 10:20:56 SGT 1982
    }

    private static void getCurrentDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
    }
}
