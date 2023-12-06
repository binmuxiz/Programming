package week1;

import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.InputMismatchException;
import java.util.Scanner;

// 20기 이은빈
// 달력 출력 프로그램
public class P05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year, month;

        try {
            System.out.println("[달력 출력 프로그램]");
            System.out.print("달력의 년도를 입력해 주세요.(yyyy): ");
            year = sc.nextInt();

            System.out.print("달력의 월을 입력해 주세요.(MM): ");
            month = sc.nextInt();

            MyCalendar.printCalendars(year, month);

        } catch (InputMismatchException e) {
            System.out.println("숫자를 입력해주세요.");
        } catch (DateTimeException e) {
            System.out.println("올바른 년도와 달을 입력해주세요.");
        }
    }
}

class MyCalendar {
    private static final int CALENDER_CNT = 3;
    private static final int YEAR = 0;
    private static final int MONTH = 1;
    private static final int DAY_OF_WEEK_OF_FIRST_DAY = 2;
    private static final int LENGTH_OF_MONTH = 3;

    // 입력값 기준으로 이전달, 입력달, 현재달 출력
    public static void printCalendars(int year, int month) throws DateTimeException {
        StringBuilder sb = new StringBuilder(450);

        int[][] calendar = setCalendar(year, month);
        printHeader(calendar, sb);
        printDays(calendar, sb);
        System.out.println(sb);
    }

    private static int[][] setCalendar(int year, int month) {
        int[][] calendar = new int[CALENDER_CNT][4];

        calendar[0][YEAR] = (month == 1) ? year - 1 : year;
        calendar[1][YEAR] = year;
        calendar[2][YEAR] = LocalDate.now().getYear();

        calendar[0][MONTH] = (month == 1) ? 12 : month - 1;
        calendar[1][MONTH] = month;
        calendar[2][MONTH] = LocalDate.now().getMonthValue();

        for (int i = 0; i < CALENDER_CNT; i++) {
            int dayOfWeek = LocalDate.of(calendar[i][0], calendar[i][1], 1).getDayOfWeek().getValue();
            calendar[i][DAY_OF_WEEK_OF_FIRST_DAY] = (dayOfWeek == DayOfWeek.SUNDAY.getValue()) ? 0 : dayOfWeek;

            calendar[i][LENGTH_OF_MONTH] = YearMonth.of(calendar[i][0], calendar[i][1]).lengthOfMonth();
        }
        return calendar;
    }

    private static void printHeader(final int[][] calendars, StringBuilder sb) {

        for (int i = 0; i < CALENDER_CNT; i++) {
            sb.append(String.format("[%04d년 %02d월]\t\t\t\t\t", calendars[i][0], calendars[i][1]));
        }
        sb.append("\n");

        for (int i = 0; i < CALENDER_CNT; i++) {
            sb.append("일\t월\t화\t수\t목\t금\t토\t\t");
        }
        sb.append("\n");
    }

    private static void printDays(final int[][] calendar, StringBuilder sb) {
        int start = 1;
        int[] lastDayOfWeek = new int[CALENDER_CNT];  // 한 주의 마지막 날짜

        // 첫째주 출력
        for (int i = 0; i < CALENDER_CNT; i++) {
            lastDayOfWeek[i] = 7 - calendar[i][DAY_OF_WEEK_OF_FIRST_DAY];
            printWeek(start, calendar[i][DAY_OF_WEEK_OF_FIRST_DAY], lastDayOfWeek[i],  sb);
        }
        sb.append("\n");

        for (int w = 0; w < 4; w++) {
            for (int i = 0; i < CALENDER_CNT; i++) {
                start = lastDayOfWeek[i] + 1;
                lastDayOfWeek[i] = start + 6;

                if (start <= calendar[i][LENGTH_OF_MONTH]) {
                    if (lastDayOfWeek[i] > calendar[i][LENGTH_OF_MONTH]) {
                        lastDayOfWeek[i] = calendar[i][LENGTH_OF_MONTH];
                    }
                    printWeek(start, 0, lastDayOfWeek[i], sb);
                } else {
                    sb.append("\t\t\t\t\t\t\t\t");
                }
            }
            sb.append("\n");
        }
    }


    // 한 주를 출력하는 메소드 (일 = 0 ~ 토 = 6)
    private static void printWeek(int start, int dayOfWeekOfStart, int last, StringBuilder sb) {

        int i = 0;
        // start 이전 공백
        for (int sp = 0; sp < dayOfWeekOfStart; sp++, i++) {
            sb.append("\t");
        }

        // start ~ last 날짜 출력
        for (int day = start; day <= last; i++, day++) {
            sb.append(String.format("%02d\t", day));
        }

        // last 이후 공백
        for (; i < 7; i++) {
            sb.append("\t");
        }
        sb.append("\t");
    }
}
