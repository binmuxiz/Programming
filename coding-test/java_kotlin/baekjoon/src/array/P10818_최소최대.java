package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10818_최소최대 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int max = Integer.parseInt(st.nextToken());
        int min = max;

        for (int i = 1; i < N; i++) {
            int item = Integer.parseInt(st.nextToken());

            if (item < min) {
                min = item;
            } else if (item > max) {
                max = item;
            }
        }
        System.out.print(min + " " + max);
    }
}
