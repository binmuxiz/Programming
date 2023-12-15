package linkedlist;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Silver4_요세푸스문제 {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int N = Integer.parseInt(st.nextToken());
//        int K = Integer.parseInt(st.nextToken());
//
//        LinkedList<Integer> list = new LinkedList<>();
//        for (int i = 1; i <= N; i++) {
//            list.add(i);
//        }
//
//        bw.write("<");
//        int tempIdx = 0;
//        while (list.size() > 1) {
//            tempIdx = (tempIdx + K) % list.size() - 1;
//            if (tempIdx < 0)
//                tempIdx = list.size() - 1;
//            bw.write(list.remove(tempIdx) + ", ");
//        }
//        bw.write(list.removeFirst() + ">");
//        bw.flush();
//        br.close();
//        bw.close();

//        // 이게 쬐에에끔 더 빠름
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        sb.append("<");
        int tempIdx = 0;
        while (list.size() > 1) {
            tempIdx = (tempIdx + K) % list.size() - 1;
            if (tempIdx < 0)
                tempIdx = list.size() - 1;
            sb.append(list.remove(tempIdx) + ", ");
        }
        sb.append(list.removeFirst() + ">");
        System.out.println(sb);
    }
}
