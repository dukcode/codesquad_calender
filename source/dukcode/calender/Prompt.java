package dukcode.calender;

import java.util.Scanner;
import dukcode.calender.Calender;

public class Prompt {
    final static String PROMPT = new String("CAL > ");

    /**
     * @param week 요일명
     * @return 0~ 6 (0 = Sunday, 6 = Saturday)
     */
    public int parsDay(String week) {
        if (week.equals("SU")) return 0;
        else if (week.equals("MO")) return 1;
        else if (week.equals("TU")) return 2;
        else if (week.equals("WE")) return 3;
        else if (week.equals("TH")) return 4;
        else if (week.equals("FR")) return 5;
        else if (week.equals("SA")) return 6;
        else return 0;
    }

    public void runShell() {
        Scanner scanner = new Scanner(System.in);
        Calender cal = new Calender();

        int month = 1;
        int year = 2017;
        while (true) {
            System.out.println("년도를 입력하세요 (exit : -1)");
            System.out.print(PROMPT);
            year = scanner.nextInt();
            if (year == -1) {
                break;
            }

            System.out.println("달을 입력하세요");
            System.out.print(PROMPT);
            month = scanner.nextInt();

            if (month < 1 || 12 < month) {
                System.out.println("잘못된 입력입니다.");
                break;
            }

            cal.printCalender(year, month);
        }

        System.out.println("Bye~");
        scanner.close();
    }

    public static void main(String[] args) {
        // 셸 실행
        Prompt p = new Prompt();
        p.runShell();
    }
}
