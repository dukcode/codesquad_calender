package dukcode.calender;

import java.util.Scanner;

class Calender {
    private static final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 30, 31, 30, 31, 30};

    public int getMaxDaysOfMonth(int month) {
        return MAX_DAYS[month - 1];
    }

    public void printSampleCalender() {
        System.out.println("일  월  화  수  목  금  토");
        System.out.println("--------------------------");
        System.out.println(" 1   2   3   4   5   6   7");
        System.out.println(" 8  10  11  12  13  14  15");
        System.out.println("16  17  18  19  20  21  22");
        System.out.println("23  24  25  26  27  28  29");
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Calender cal = new Calender();

        cal.printSampleCalender();
        System.out.println("반복 횟수를 입력하세요.");
        int repeat = scanner.nextInt();

        for (int i = 0; i < repeat; ++i) {
            System.out.println("달을 입력하세요");
            int month = scanner.nextInt();
            System.out.printf("%d월은 %d일까지 있습니다.%n", month, cal.getMaxDaysOfMonth(month));
        }

        scanner.close();
    }
}
