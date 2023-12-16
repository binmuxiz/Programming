package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 디스크컨트롤러 {
    public static void main(String[] args) {

        System.out.println(solution(new int[][]{{1, 3}, {1, 2}, {3, 4}, {2, 7}, {4,1}, {5,6}}));
    }

    public static int solution(int[][] jobs) {

        // 요청시간으로 오름차순 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        PriorityQueue<Task> queue = new PriorityQueue<>(jobs.length, (o1, o2) -> o1.timeSpent - o2.timeSpent);

        int idx = 0;
        int curTime = 0;
        int completedTaskCnt = 0;
        int totalTimeSpent = 0;

        while (completedTaskCnt < jobs.length) {

            // 요청 시간이 현재 시점보다 작거나 같은 task들을 queue에 모두 넣는다.
            while (idx < jobs.length && jobs[idx][0] <= curTime) {
                queue.add(new Task(jobs[idx][0], jobs[idx][1]));
                idx += 1;
            }

            // 만약 queue가 비어있다면 처리되지 않은 task 중 가장 요청시간이 빠른 task의 요청시간을 현재 시점으로 만든다.
            if (queue.isEmpty()) {
                curTime = jobs[idx][0];
            }
            else {
                Task completed = queue.remove();
                totalTimeSpent += (curTime - completed.requestTime) + completed.timeSpent;
                curTime = curTime + completed.timeSpent;
                completedTaskCnt++;
            }
        }

        return totalTimeSpent / jobs.length;
    }



    public static class Task {

        int requestTime;
        int timeSpent;

        public Task(int requestTime, int timeSpent) {
            this.requestTime = requestTime;
            this.timeSpent = timeSpent;
        }
    }
}
