package dukcode.calender;

import java.util.Scanner;
import dukcode.calender.Calender;

public class Prompt {
    private final static String PROMPT = "cal > ";

    public void runShell() {
        String PROMPT = new String("cal> ");
        Scanner scanner = new Scanner(System.in);
        Calender cal = new Calender();

        int month = 0;
        while (true) {
            System.out.println("달을 입력하세요");
            System.out.print(PROMPT);
            month = scanner.nextInt();
            if (month == -1) {
                break;
            }

            if (month > 12) {
                continue;
            }
            System.out.printf("%d월은 %d일까지 있습니다.%n", month, cal.getMaxDaysOfMonth(month));
            cal.printCalender(2022, month);
        }

        scanner.close();
    }

    public static void main(String[] args) {
        // 셸 실행
        Prompt p = new Prompt();
        p.runShell();
    }
}
