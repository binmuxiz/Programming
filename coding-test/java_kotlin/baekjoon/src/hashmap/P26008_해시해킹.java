package hashmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P26008_해시해킹 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 비밀번호 길이
        int M = Integer.parseInt(st.nextToken()); // 문자종류의 개수
        int A = Integer.parseInt(st.nextToken()); // 정수 A

        st = new StringTokenizer(br.readLine());
        int HASH = Integer.parseInt(st.nextToken()); // 재현이가 알아낸 해시값 (0이상 M미만)

        // 주어진 해시값을 갖는 비밀번호의 개수 출력
        // 비밀번호를 이루는 문자는 0이상 M-1 이하의 문자들로 이루어진다.

        long result = 1;
        for (int i = 0; i < N - 1; i++) {
            result = (result * M) % 1_000_000_007;
        }
        System.out.println(result);
    }
}
