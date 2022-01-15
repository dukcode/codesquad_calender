package dukcode.calender;

class Calender {
    private static final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 30, 31, 30, 31, 30};

    public int getMaxDaysOfMonth(int month) {
        return MAX_DAYS[month - 1];
    }

    public void printCalender(int year, int month) {
        System.out.printf("    << %4d년%3d월 >>%n", year, month);
        System.out.println("일  월  화  수  목  금  토");
        System.out.println("--------------------------");

        int maxDay = getMaxDaysOfMonth(month);

        for (int day = 1; day <= maxDay; ++day) {
            System.out.printf("%2d  ", day);
            if (day % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}
