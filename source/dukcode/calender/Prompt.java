package dukcode.calender;

import java.util.Scanner;
import dukcode.calender.Calender;

public class Prompt {
    private final static String PROMPT = "cal > ";

    public void runShell() {
        String PROMPT = new String("cal> ");
        Scanner scanner = new Scanner(System.in);
        Calender cal = new Calender();

        int month = -1;
        int year = -1;
        while (true) {
            System.out.println("년도를 입력하세요");
            System.out.print("YEAR > ");
            year = scanner.nextInt();
            System.out.println("달을 입력하세요");
            System.out.print("MONTH > ");
            month = scanner.nextInt();

            if (month == -1) {
                break;
            }

            if (month > 12) {
                continue;
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
