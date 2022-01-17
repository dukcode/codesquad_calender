package dukcode.calendar;

import java.util.Scanner;

public class Prompt {
    final static String PROMPT = new String("CAL > ");

    private void cmdPrintMenu() {
        System.out.println("+------------------+");
        System.out.println("| 1. 일정 등록      ");
        System.out.println("| 2. 일정 검색      ");
        System.out.println("| 3. 달력 보기      ");
        System.out.println("| h. 도움말 q. 종료 ");
        System.out.println("+------------------+");
    }

    private void cmdShowCal(Scanner scanner, Calendar cal) {
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

    private void cmdRegister(Scanner scanner, Calendar cal) {
        System.out.println("[새 일정 등록]");
        System.out.println("날짜를 입력해 주세요 (yyyy-MM-dd).");
        System.out.println(PROMPT);
        String date = scanner.next();
        System.out.println("일정을 입력해 주세요. (문장의 끝에 ;를 입력해 주세요");
        System.out.println(PROMPT);
        String strPlan = new String("");
        while (true) {
            String word = scanner.next();
            strPlan += word + " ";
            if (word.endsWith(";")) {
                break;
            }
        }
        strPlan.replace(";", "");
        cal.registerPlan(date, strPlan);
    }

    private void cmdSearch(Scanner scanner, Calendar cal) {
        System.out.println("[일정 검색]");
        System.out.println("날짜를 입력해 주세요 (yyyy-MM-dd).");
        System.out.println(PROMPT);
        String date = scanner.next();
        PlanItem plan = cal.searchPlan(date);
        if (plan != null) {
            System.out.println(plan.detail);
        } else {
            System.out.println("일정이 없습니다.");
        }
    }

    private void runShell() {
        Scanner scanner = new Scanner(System.in);
        Calendar cal = new Calendar();

        Loop : while (true) {
            System.out.println("명령 (1, 2, 3, h, q)");
            String cmd = scanner.next();

            switch (cmd) {
                case "1" :
                    cmdRegister(scanner, cal);
                    break;
                case "2" :
                    cmdSearch(scanner, cal);
                    break;
                case "3" :
                    cmdShowCal(scanner, cal);
                    break;
                case "h" :
                    cmdPrintMenu();
                    break;
                case "q" :
                    break Loop;
            }
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
