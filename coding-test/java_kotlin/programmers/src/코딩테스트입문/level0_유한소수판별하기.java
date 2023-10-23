package 코딩테스트입문;

public class level0_유한소수판별하기 {
    public int solution(int a, int b) {

        int divisor = (a < b) ? a : b;
        int dividend = (a >= b) ? a : b;
        int remainder;
        int gcd;

        // 유클리드 호제법을 사용한 최대공약수(gcd) 구하기
        while ((remainder = dividend % divisor) != 0) {
            dividend = divisor;
            divisor = remainder;
        }

        gcd = divisor;
        b /= gcd;
        int quotient = b;

        while (quotient != 1) {
            if (quotient % 2 == 0) quotient /= 2;
            else if (quotient % 5 == 0) quotient /= 5;
            else                   break;
        }

        if (quotient == 1) return 1;
        else               return 2;
    }

    public int solution2(int a, int b) {

        b /= gcd(a, b);

        while (b != 1) {
            if (b % 2 == 0) b /= 2;
            else if (b % 5 == 0) b /= 5;
            else                   break;
        }

        if (b == 1) return 1;
        else        return 2;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a; // b -> 나머지, a -> 나누는 수

        return gcd(b, a % b);
    }
}
