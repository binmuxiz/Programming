package queue;

import java.util.ArrayList;
import java.util.List;

public class P42586_기능개발 {

    public int[] solution(int[] progresses, int[] speeds) {

        List<Integer> result = new ArrayList<>();
        int beforeMaxDay = 0;
        int count = 0; // 배포하는 기능 count

        for (int i = 0; i < progresses.length; i++) {
            int temp = 100 - progresses[i];
            int day = (temp % speeds[i] == 0) ? temp / speeds[i] : temp / speeds[i] + 1;

            if (day > beforeMaxDay) {
                result.add(count);
                count = 1;
                beforeMaxDay = day;
            } else {
                count++;
            }
        }
        result.add(count);

        return result.stream().skip(1).mapToInt(Integer::intValue).toArray();
    }
}
