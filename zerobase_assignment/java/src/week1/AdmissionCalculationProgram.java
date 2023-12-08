package week1;

import java.util.Scanner;

// 20기 이은빈
// 놀이공원 입장권 계산 프로그램
public class AdmissionCalculationProgram {
    final static int ORIGINAL_FEE = 10000;
    final static int SPECIAL_FEE = 4000;
    final static int NORMAL_FEE = 8000;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int age, enteringTime;
        boolean isNationalMerit, hasWelfareCard;
        int admissionFee = ORIGINAL_FEE;

        System.out.println("[입장권 계산]");
        System.out.print("나이를 입력해 주세요.(숫자) : ");
        age = sc.nextInt();
        System.out.print("입장시간을 입력해 주세요.(숫자입력) : ");
        enteringTime = sc.nextInt();
        System.out.print("국가유공자 여부를 입력해주세요.(y/n) : ");
        isNationalMerit = (sc.next().charAt(0) == 'y') ? true : false;
        System.out.print("복지카드 여부를 입력해주세요.(y/n) : ");
        hasWelfareCard = (sc.next().charAt(0) == 'y') ? true : false ;

        if (age < 3) {
            admissionFee = 0;
        } else if (isNationalMerit || hasWelfareCard) {
            admissionFee = NORMAL_FEE;
        } else if (age < 13 || enteringTime >= 17) {
            admissionFee = SPECIAL_FEE;
        }

        System.out.println("입장료 : " + admissionFee);
    }
}
