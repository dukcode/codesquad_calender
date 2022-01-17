package dukcode.calendar;

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
    public int parseDay(String week) {
        switch (week) {
            case "SU" :
                return 0;
            case "MO" :
                return 1;
            case "TU" :
                return 2;
            case "WE" :
                return 3;
            case "TH" :
                return 4;
            case "FR" :
                return 5;
            case "SA" :
                return 6;
        }

        return 0;
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

    private void cmdRegister(Scanner scanner, Calendar cal) throws Exception {
        System.out.println("[새 일정 등록]");
        System.out.println("날짜를 입력해 주세요 (yyyy-MM-dd).");
        System.out.println(PROMPT);
        String date = scanner.next();
        System.out.println("일정을 입력해 주세요. (문장의 끝에 ;를 입력해 주세요");
        System.out.println(PROMPT);
        String plan = new String("");
        while (true) {
            String word = scanner.next();
            plan += word + " ";
            if (word.endsWith(";")) {
                break;
            }
        }
        cal.registerPlan(date, plan);
    }

    private void cmdSearch(Scanner scanner, Calendar cal) {
        System.out.println("[일정 검색]");
        System.out.println("날짜를 입력해 주세요 (yyyy-MM-dd).");
        System.out.println(PROMPT);
        String date = scanner.next();
        String plan = new String("");
        try {
        plan = cal.searchPlan(date);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("일정 검색 중 오류가 발생했습니다.");
        }
        System.out.println(plan);
    }

    public void runShell() throws Exception {
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

    public static void main(String[] args) throws Exception {
        // 셸 실행
        Prompt p = new Prompt();
        p.runShell();
    }
}
