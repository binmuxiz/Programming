package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class 알고리즘수업_힙정렬2_2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        new Solution(arr, K).solution();
    }

    static class Solution {
        private int swapCount = 0;
        private int K;
        private int[] arr;

        public Solution(int[] arr, int K) {
            this.arr = arr;
            this.K = K;
        }

        public void solution() {
            try {
                heapSort(arr);

                if (K > swapCount) {
                    System.out.println("-1");
                }
            } catch (RuntimeException e) {
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i < arr.length; i++) {
                    sb.append(arr[i] + " ");
                }
                System.out.println(sb);
            }
        }

        private void heapSort(int[] arr) {
            int size = arr.length - 1;
            // 최소힙으로 만들기
            buildMinHeap(arr, size);
            // 부분 힙 정렬
            for (int i = size; i >= 2; i--) {
                // 최소힙의 루트와 i번째 노드를 swap
                swap(arr, 1, i);
                // 정렬된 노드를 제외한 부분힙을 다시 최소힙으로 만든다.
                heapify(arr, 1, i - 1);
            }
        }

        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            swapCount++;
            if (swapCount == K) {
                throw new RuntimeException();
            }
        }

        private void buildMinHeap(int[] arr, int size) {
            for (int i = size / 2; i >= 1; i--) {
                heapify(arr, i, size);
            }
        }

        // sift down
        private void heapify(int[] arr, int k, int size) {
            // 재귀구조
//            int left = 2 * k;
//            int right = left + 1;
//            int smaller = 0;
//            if(right <= size) {
//                if(arr[left] < arr[right]) smaller = left;
//                else smaller = right;
//            } else if (left <= size) {
//                smaller = left;
//            } else {
//                return;
//            }
//            if(arr[smaller] < arr[k]) {
//                swap(arr, smaller, k);
//                heapify(arr, smaller, size);
//            }

            // 반복구조
            int child;
                    // 왼쪽 자식의 인덱스
            while ((child = 2 * k) <= size) {
                if (child < size && arr[child] > arr[child + 1]) {
                    child++; // 오른쪽 자식이 더 작다면 오른쪽의 인덱스로
                }
                if (arr[k] <= arr[child]) {
                    break;
                }
                swap(arr, k, child);
                k = child;
            }
        }
    }
}