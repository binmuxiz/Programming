package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1021_회전하는큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        LinkedList<Integer> deque = new LinkedList<>();
        int count = 0; // 2, 3번 연산 횟수 누적 합

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        int[] seq = new int[M];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {

            int targetIdx = deque.indexOf(seq[i]);
            int halfIdx; // deque의 중간 지점 idx

            halfIdx = deque.size() / 2;

            if (targetIdx <= halfIdx) { // target이 중간지점보다 왼쪽에 있는 경우 -> 왼쪽 이동 연산
                for (int j = 0; j < targetIdx; j++) {
                    deque.addLast(deque.pollFirst());
                    count++;
                }

            } else { // // target이 중간지점보다 왼쪽에 있는 경우 -> 오른쪽 이동 연산
                for (int j = 0; j < deque.size() - targetIdx; j++) {
                    deque.addFirst(deque.pollLast());
                    count++;
                }
            }
            deque.pollFirst(); // 처음위치로 온 target을 제거한다.
        }
        System.out.println(count);
    }
}
