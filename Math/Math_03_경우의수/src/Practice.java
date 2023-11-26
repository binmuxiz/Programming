// 약수 구하기, 두 수의 최대공약수와 최소공배수 구하기
// 활용 ) 1-10 중 a의 약수 또는 b의 약수인 경우의 수
// 활용 ) 1-10 중 a의 약수이면서 b의 약수인 경우의 수

import java.util.ArrayList;

public class Practice {

// 약수
    public ArrayList getDivisor(int num) {
        ArrayList<Object> result = new ArrayList<>();

        for (int i = 1; i <= num/2; i++) {
            if (num % i == 0) {
                result.add(i);
            }
        }
        result.add(num);
        return result;
    }

// 최대공약수 (GCD : Greatest Common Denominator)
    public int getGCD(int numA, int numB) {
        int gcd = -1;

        ArrayList divisorA = this.getDivisor(numA);
        ArrayList divisorB = this.getDivisor(numB);

        for (int itemA : (ArrayList<Integer>) divisorA) {
            for (int itemB : (ArrayList<Integer>) divisorB) {
                if (itemA == itemB && itemA > gcd) {
                    gcd = itemA;
                }
            }
        }

        return gcd;
    }


    // 최소공배수 (LCM : the Lowest Common Multiple)
    public int getLCM(int numA, int numB) {

        int lcm = -1;

        int gcd = getGCD(numA, numB);
        if (gcd != -1) {
            lcm = numA * numB / gcd;
        }
        return lcm;
    }




    public static void main(String[] args) {
        Practice practice = new Practice();

        System.out.println("약수 : " + practice.getDivisor(15));
        System.out.println("최대공약수 : " + practice.getGCD(10, 6));
        System.out.println("최소공배수 : " + practice.getLCM(10, 6));

    }
}


