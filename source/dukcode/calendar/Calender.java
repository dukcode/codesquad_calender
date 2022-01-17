package dukcode.calendar;

import java.util.Date;
import java.util.HashMap;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;

class Calendar {
    private static final int[] MAX_DAYS = {0, 31, 28, 31, 30, 31, 30, 31, 30, 31, 30, 31, 30};
    private static final int[] LEAP_MAX_DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 30, 31, 30, 31, 30};
    private static final String SAVE_FILE = "savefile.dat";

    private HashMap<Date, PlanItem> planMap;

    public Calendar() {
        planMap = new HashMap<Date, PlanItem>();
        File f = new File(SAVE_FILE);
        if (!f.exists()) {
            System.err.println("NO SAVE FILE");
            return;
        }
        try {
            Scanner s = new Scanner(f);
            while (s.hasNext()) {
                String line = s.nextLine();
                String[] words = line.split(",");
                String date = words[0];
                String detail = words[1].replaceAll("\"", "");
                PlanItem p = new PlanItem(date, detail);
                planMap.put(p.getDate(), p);
            }
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return true;
        }

        return false;
    }
    public int getMaxDaysOfMonth(int year, int month) {
        if (isLeapYear(year)) {
            return LEAP_MAX_DAYS[month];
        } else {
        return MAX_DAYS[month];
        }
    }

    public PlanItem searchPlan(String strDate) {
        Date date = PlanItem.getDateFromString(strDate);
        return planMap.get(date);
    }


    // @param date ex : "2022-01-17"
    // @param plan
    public void registerPlan(String strDate, String plan) {
        PlanItem p = new PlanItem(strDate, plan);
        planMap.put(p.getDate(), p);

        File f = new File(SAVE_FILE);
        String item = p.saveString();
        try {
            FileWriter fw = new FileWriter(f, true);
            fw.write(item);
            fw.close();
        } catch (IOException e) {
        }
    }

    private int getWeekDay(int year, int month, int day) {
        final int STANDARD_YEAR = 1970;
        final int STANDARD_WEEKDAY = 4; // weekDay of 1970/1/1 is TH

        int count = 0;
        int delta = 0;

        for (int y = STANDARD_YEAR; y < year; ++y) {
            delta = isLeapYear(y) ? 366 : 365;
            count += delta;
        }

        for (int m = 1; m < month; ++m) {
            delta = getMaxDaysOfMonth(year, m);
            count += delta;
        }

        count += day - 1;

        return (count + STANDARD_WEEKDAY) % 7;
    }

    public void printCalender(int year, int month) {
        System.out.printf("    << %4d년%3d월 >>%n", year, month);
        System.out.println("일  월  화  수  목  금  토");
        System.out.println("--------------------------");

        // get weekDay automatically
        int weekDay = getWeekDay(year, month, 1);
        int maxDay = getMaxDaysOfMonth(year, month);

        // print blank space
        for (int i = 0; i < weekDay; ++i) {
            System.out.print("    ");
        }
        for (int day = 1; day <= maxDay; ++day) {
            System.out.printf("%2d  ", day);
            if ((day + weekDay) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println();
    }

    // Simple test code here
    public static void main(String[] args) {
        Calendar cal = new Calendar();
        System.out.println(cal.getWeekDay(1970, 1, 1) == 4);
        System.out.println(cal.getWeekDay(1971, 1, 1) == 5);
        System.out.println(cal.getWeekDay(1972, 1, 1) == 6);
        System.out.println(cal.getWeekDay(1973, 1, 1) == 1);
        System.out.println(cal.getWeekDay(1974, 1, 1) == 2);

        cal.registerPlan("2022-01-17", "Let's eat beef!");
        System.out.println(cal.searchPlan("2022-01-17").equals("Let's eat beef!"));
    }

}
