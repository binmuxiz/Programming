package 코딩테스트입문;

public class level0_OX퀴즈 {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];

        int i = 0;
        for (String exp : quiz) {
            String[] arr = exp.split(" ");
            int x = Integer.parseInt(arr[0]);
            int y = Integer.parseInt(arr[2]);
            int z = Integer.parseInt(arr[4]);
            int res;

            res = arr[1].equals("+") ? x + y : x - y;
            answer[i++] = (res == z) ? "O" : "X";
        }

        return answer;
    }
}
