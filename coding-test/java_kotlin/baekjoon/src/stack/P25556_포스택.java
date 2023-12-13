package stack;/*
 [문제 해결 아이디어]
 - 네 개의 스택에 모든 수를 다 삽입한 후,
 스택에서 수를 꺼낼 떄, 큰 수부터 꺼내야 작은 수가 앞쪽, 큰 수가 뒤쪽에 배치될 수 있다.
 따라서 스택에 요소를 넣을 때, 무조건 작은 수가 먼저, 큰 수가 나중에 삽입되어야 한다.
 하나의 스택이라도 작은 수가 큰 수보다 나중에 삽입될 수 밖에 없다면,
 NO를 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P25556_포스택 {

    public static void main(String[] args) throws IOException {
//        solution1();
//        solution2();
        solution3();
    }

    // 메모리 26092KB, 시간296ms
    private static void solution3() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] stack = new int[4];
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        boolean flag;

        for (String str : arr) {
            int item = Integer.parseInt(str);
            flag = false;

            for (int i = 0; i < 4; i++) {
                if (stack[i] < item) {
                    stack[i] = item;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    // 메모리 29316KB, 시간 344ms
    private static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        Deque<Integer> stack3 = new ArrayDeque<>();
        Deque<Integer> stack4 = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            int item = Integer.parseInt(arr[i]);

            if (stack1.peek() == null || stack1.peek() < item)  {
                stack1.push(item);
            } else if (stack2.peek() == null || stack2.peek() < item) {
                stack2.push(item);
            } else if (stack3.peek() == null || stack3.peek() < item) {
                stack3.push(item);
            } else if (stack4.peek() == null || stack4.peek() < item) {
                stack4.push(item);
            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    // 메모리 111200KB, 시간 964ms
    private static void solution1() {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        Deque<Integer> stack3 = new ArrayDeque<>();
        Deque<Integer> stack4 = new ArrayDeque<>();
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int item = sc.nextInt();

            if (stack1.peek() == null || stack1.peek() < item)  {
                stack1.push(item);
            } else if (stack2.peek() == null || stack2.peek() < item) {
                stack2.push(item);
            } else if (stack3.peek() == null || stack3.peek() < item) {
                stack3.push(item);
            } else if (stack4.peek() == null || stack4.peek() < item) {
                stack4.push(item);
            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
