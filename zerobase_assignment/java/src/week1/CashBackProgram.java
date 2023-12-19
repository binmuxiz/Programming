package week1;

import java.util.Scanner;

// 20기 이은빈
// 결제 금액 캐시백 계산 프로그램
public class CashBackProgram {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("[캐시백 계산]");
        System.out.print("결제 금액을 입력해 주세요. (금액) : ");

        int payment = sc.nextInt();
        int cashbackPoint = getCashbackPoint(payment);

        System.out.println(String.format("결제 금액은 %d원이고, 캐시백은 %d원 입니다.", payment, cashbackPoint));
    }

    private static int getCashbackPoint(int n) {
        int point = (int) (n * 0.1) / 100 * 100;
        if (point > 300) {
            point = 300;
        }
        return point;
    }
}
