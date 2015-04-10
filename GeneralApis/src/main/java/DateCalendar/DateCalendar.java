package main.java.DateCalendar;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Reference: http://www.mkyong.com/java/java-date-and-calendar-examples/
 */
public class DateCalendar {
    public static void main(String[] args) {
        System.out.println(convertDateToString());
        System.out.println(convertStringToDate());
        System.out.println(getCurrentDateTime());
    }

    private static String convertDateToString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        String date = sdf.format(new Date());
        return date; //15/10/2013
    }

    private static String convertStringToDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String dateInString = "31-08-1982 10:20:56";
        Date date = null;
        try {
            date = sdf.parse(dateInString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date.toString(); //Tue Aug 31 10:20:56 SGT 1982
    }

    private static String getCurrentDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date).toString();
    }
}
