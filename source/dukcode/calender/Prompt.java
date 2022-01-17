package dukcode.calender;

import java.util.Scanner;

public class Prompt {
    final static String PROMPT = new String("CAL > ");

    public void cmdPrintMenu() {
        System.out.println("+------------------+");
        System.out.println("| 1. 일정 등록      ");
        System.out.println("| 2. 일정 검색      ");
        System.out.println("| 3. 달력 보기      ");
        System.out.println("| h. 도움말 q. 종료 ");
        System.out.println("+------------------+");
    }

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

    private void cmdShowCal(Scanner scanner, Calender cal) {
        int month = 1;
        int year = 2017;

        System.out.println("년도를 입력하세요 (exit : -1)");
        System.out.print(PROMPT);
        year = scanner.nextInt();

        System.out.println("달을 입력하세요");
        System.out.print(PROMPT);
        month = scanner.nextInt();
        if (month < 1 || 12 < month) {
            System.out.println("잘못된 입력입니다.");
            return;
        }

        cal.printCalender(year, month);
    }

    private void cmdRegister() {
    }

    private void cmdSearch() {
    }

    public void runShell() {
        Scanner scanner = new Scanner(System.in);
        Calender cal = new Calender();

        while (true) {
            System.out.println("명령 (1, 2, 3, h, q)");
            String cmd = scanner.next();

            if (cmd.equals("1")) cmdRegister();
            else if (cmd.equals("2")) cmdSearch();
            else if (cmd.equals("3")) cmdShowCal(scanner, cal);
            else if (cmd.equals("h")) cmdPrintMenu();
            else if (cmd.equals("q")) break;
        }

        System.out.println("Thank you. Bye~");
        scanner.close();
    }

    public static void main(String[] args) {
        // 셸 실행
        Prompt p = new Prompt();
        p.runShell();
    }
}
