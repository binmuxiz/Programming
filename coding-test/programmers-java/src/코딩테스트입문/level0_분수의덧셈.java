package 코딩테스트입문;

public class level0_분수의덧셈 {

    public int[] solution(int numer1, int denom1, int numer2, int denom2) {

        int numer = (numer1 * denom2) + (numer2 * denom1);
        int denom = denom1 * denom2;

                     // 35     34
        int minNum = (numer < denom) ? numer : denom;  // 34
        int gcd = 1; // 최대공약수

        int i = 1;
        while (i <= minNum) {
            int divisor = minNum / i;  // 34 / 34 = 1 (x)
            if (numer % divisor == 0 && denom % divisor == 0) {
                    gcd *= divisor;
                    break;

            }
            i++;
        }

        int[] answer = new int[]{numer / gcd, denom / gcd};

        return answer;
    }

    //TODO 유클리드 호제법 - 2개의 자연수/정수의 최대공약수를 구하는 알고리즘
    // a, b에 대해서 a를 b로 나눈 나머지를 r이라 하면 (단, a>b), a와 b의 최대공약수는 r과 b의 최대공약수와 같다.
    // 이 성질에 따라 b를 r로 나눈 나머지 r'을 구하고. 이 과정을 반복하여 나머지가 0이 되었을 때 나누는 수가 a와 b의 최대공약수이다.
    public int[] solution2(int numer1, int denom1, int numer2, int denom2) {

        int numer = (numer1 * denom2) + (numer2 * denom1);
        int denom = denom1 * denom2;

        int divisor = (numer < denom) ? numer : denom;  // 나누는 수
        int dividend = (numer >= denom) ? numer : denom;  // 나누어지는 수
        int remainder = 1; // 나머지
        int gcd = 0;

        while (true) {
            remainder = dividend % divisor;
            if (remainder == 0) {
                gcd = divisor;
                break;
            }
            dividend = divisor;
            divisor = remainder;
        }

        int[] answer = new int[]{numer / gcd, denom / gcd};

        return answer;
    }
}
