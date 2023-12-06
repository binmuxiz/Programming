package week1;

import java.util.*;

// 20기 이은빈
// 주민등록번호 생성 프로그램
public class P04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year, month, day;
        char gender;

        while (true) {
            try {

                System.out.println("=============================");
                System.out.println("[주민등록번호 계산]");

                System.out.print("출생년도를 입력해 주세요.(yyyy): ");
                year = sc.nextInt();  // 2020년 이후만 입력 가능

                System.out.print("출생월을 입력해 주세요.(MM): ");
                month = sc.nextInt();

                System.out.print("출생일을 입력해 주세요.(dd): ");
                day = sc.nextInt();

                if (!ResidentRegistrationNumber.isValidDate(year, month, day))
                    throw new InputMismatchException("올바른 생년월일을 입력해주세요.");

                System.out.print("성별을 입력해 주세요.(m/f): ");
                gender = sc.next().charAt(0);

                if (!ResidentRegistrationNumber.isValidGender(gender))
                    throw new InputMismatchException();

                System.out.println(ResidentRegistrationNumber.getSSN(year, month, day, gender));

                System.out.print("\n입력 종료(y/n) : ");
                if (sc.next().charAt(0) == 'y')
                    break;

            } catch (InputMismatchException e) {
                System.out.println("올바르지 않은 입력입니다. 다시 입력해주세요.");
                sc.nextLine(); // 이전 입력 버퍼 비우기
            }
        }
    }
}



class ResidentRegistrationNumber {
    private static final Random rand = new Random();

    // key : 생년월일+성별, value : randomSet
    private static final Map<String, Set<String>> ssn = new HashMap<>();

    private ResidentRegistrationNumber() {}


    public static boolean isValidDate(int year, int month, int day) {
        if (!(2020 <= year)) return false;
        if (!(1 <= month && month <= 12)) return false;
        if (!(1 <= day && day <= 31)) return false;

        if (isLeapYear(year) && month == 2) {
            if (day > 29) return false;
        }

        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12 :
                if (day > 31) return false;

            case 4: case 6: case 9: case 11:
                if (day > 30) return false;

            case 2 :
                if (day > 28) return false;
        }
        return true;
    }

    public static String getSSN(int year, int month, int day, char gender) {
        String prefix = getPrefix(year, month, day, gender);
        return prefix + getRandomSuffix(prefix);
    }

    public static boolean isValidGender(char gender) {
        return (gender == 'm' || gender == 'M' || gender == 'f' || gender == 'F');
    }

    private static String getPrefix(int year, int month, int day, char gender) {
        String prefix = String.format("%02d%02d%02d-", year % 100, month, day);;

        if (gender == 'm') prefix += GENDER.MALE;
        else               prefix += GENDER.FEMALE;

        return prefix;
    }

    private static String getRandomSuffix(String key) {
        String suffix = "";
        Set<String> suffixSet = ssn.get(key);

        if (suffixSet == null) {
            suffixSet = new LinkedHashSet<>();
            suffix = getRandomStrNumber();
            suffixSet.add(suffix);
            ssn.put(key, suffixSet);
        }

        else {
            while (true) {
                suffix = getRandomStrNumber();

                if (!suffixSet.contains(suffix)) {
                    suffixSet.add(suffix);
                    break;
                }
            }
        }
        return suffix;
    }

    private static String getRandomStrNumber() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            str.append(rand.nextInt(10));
        }
        return str.toString();
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    private static class GENDER {
        static final short MALE  = 3;
        static final short FEMALE = 4;
    }
}
