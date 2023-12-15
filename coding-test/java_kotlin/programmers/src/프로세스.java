import java.util.*;

public class 프로세스 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 3, 2}, 2));
        System.out.println(solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }

    private static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Process> queue = new LinkedList<>();
        int[] nums = new int[10]; // 우선순위(1~9) 별 프로세스 개수

        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Process(i, priorities[i]));
            nums[priorities[i]]++;
        }

        boolean isRemovedProcess;
        while (true) {
            Process p = queue.remove();
            isRemovedProcess = true;

            for (int i = p.priority+ 1; i < 10; i++) {
                if (nums[i] > 0) {
                    queue.add(p);
                    isRemovedProcess = false;
                    break;
                }
            }
            if (isRemovedProcess) {
                if (p.id == location) {
                    return answer + 1;
                }
                nums[p.priority]--;
                answer++;
            }
        }
    }
}

class Process {
    int id;
    int priority;

    public Process(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
}