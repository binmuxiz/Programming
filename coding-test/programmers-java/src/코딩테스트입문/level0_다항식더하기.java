package 코딩테스트입문;

public class level0_다항식더하기 {
    public String solution(String polynomial) {
        String answer = "";

        String[] arr = polynomial.split(" ");

        int a = 0, b = 0;

        for (int i = 0; i < arr.length; i += 2) {
            if (arr[i].contains("x")) {
                arr[i] = arr[i].replace("x", "");
                if (arr[i].equals("")) a += 1;
                else a += Integer.parseInt(arr[i]);

            } else {
                b += Integer.parseInt(arr[i]);
            }
        }
        if (a == 0) answer = String.valueOf(b);
        else if (b == 0) answer = String.valueOf(a) + "x";
        else answer = String.valueOf(a) + "x + " + String.valueOf(b);
        return answer;
    }
}
