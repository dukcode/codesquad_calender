package dukcode.calender;

class Calender {
    private static final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 30, 31, 30, 31, 30};

    public int getMaxDaysOfMonth(int month) {
        return MAX_DAYS[month - 1];
    }

    public void printCalender(int year, int month) {
        System.out.printf("      << %4d  %3d >>", year, month);
        System.out.println("일  월  화  수  목  금  토");
        System.out.println("--------------------------");
        System.out.println(" 1   2   3   4   5   6   7");
        System.out.println(" 8  10  11  12  13  14  15");
        System.out.println("16  17  18  19  20  21  22");
        System.out.println("23  24  25  26  27  28  29");
    }
}
