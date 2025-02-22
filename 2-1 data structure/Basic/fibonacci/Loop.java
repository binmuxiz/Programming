import java.util.Scanner;

public class Loop {

    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);

        System.out.print("몇 번째 피보나치 수? : ");
        int n = sc.nextInt();
        int left = 0, right = 1, sum = 0;
        
        for (int i = 2; i <= n; i++) {
            sum = left + right;
            left = right;
            right = sum;
        }
        System.out.println("n번째 피보나치 수 : " + (n == 1 ? right : sum));

        sc.close();

        byte b1 = 127;
        b1 += 1;
        System.out.println(b1);
    }
}
