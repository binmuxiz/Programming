// 회문 또는 팰린드롬은 앞 뒤 방향으로 같은 순서의 문자로 구성된 문자열을 말한다
// 유사회문은 한 문자를 삭제하면 회문이 되는 문자열을 말한다.
// 주어진 문자열을 확인한 후 문자열 종류에 따라 다음과 같이 출력하는 프로그램을 작성
// 회문 : 0, 유사회문 : 1, 기타 :2

public class P07 {
    public static void main(String[] args) {
        System.out.println(solution("abba")); // 0
        System.out.println(solution("summuus")); // 1
        System.out.println(solution("xabba")); // 1
        System.out.println(solution("xabbay")); // 2
        System.out.println(solution("comcom")); // 2
        System.out.println(solution("comwwmoc")); // 0
        System.out.println(solution("comwwtmoc")); // 1

    }

    private static int solution(String str) {
        return isPalindrome(0, str.length() - 1, str.toCharArray(), 0);
    }

    // delCnt는 삭제 카운트
    private static int isPalindrome(int left, int right, char[] arr, int delCnt) {
        while (left < right) {
            if (arr[left] != arr[right]) {
                if (delCnt == 0) {
                    if (isPalindrome(left + 1, right, arr, 1) == 0
                        || isPalindrome(left, right - 1, arr, 1) == 0) {
                        return 1; // 유사회문
                    }
                    return 2; // 기타
                }
                return 2;
            } else {
                left++;
                right--;
            }
        }
        return 0;
    }
}
