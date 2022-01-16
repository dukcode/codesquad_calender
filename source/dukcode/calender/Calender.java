package dukcode.calender;

class Calender {
    private static final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 30, 31, 30, 31, 30};
    private static final int[] LEAP_MAX_DAYS = {31, 29, 31, 30, 31, 30, 31, 30, 31, 30, 31, 30};

    public boolean isLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 != 0) {
            return true;
        }

        return true;
    }
    public int getMaxDaysOfMonth(int year, int month) {
        if (isLeapYear(year)) {
            return LEAP_MAX_DAYS[month - 1];
        } else {
        return MAX_DAYS[month - 1];
        }
    }

    public void printCalender(int year, int month) {
        System.out.printf("    << %4d년%3d월 >>%n", year, month);
        System.out.println("일  월  화  수  목  금  토");
        System.out.println("--------------------------");

        int maxDay = getMaxDaysOfMonth(year, month);

        for (int day = 1; day <= maxDay; ++day) {
            System.out.printf("%2d  ", day);
            if (day % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

}
