package java_coding_interview_book.ch07_array;



public class P02_TrappingRainWater {

    public static void main(String[] args) {
        P02_TrappingRainWater p = new P02_TrappingRainWater();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(p.twoPointer(height));
        height = new int[]{4, 2, 0, 3, 2, 5};
        System.out.println(p.twoPointer(height));
    }

/* TWO POINTER 풀이 -> O(N)
 1. left와 right의 높이를 비교한다.
 2. 작은 쪽의 포인터를 한칸 이동한다. (left는 오른쪽, right는 왼쪽으로)
 3. 가장 큰 높이의 left 또는 right에서 자신의 높이를 뺀다.
 4. 그 결과가 <= 0이면 rain에 더하지 않는다.
 5. 그 결과가 > 0이면 rain에 더한다.
 6. left < right일 때까지 반복한다.
 * 이동할 떄마다 가장 큰 left, right를 갱신한다.
*/
    private int twoPointer(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];

        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (height[left] <= height[right]) {
                if (leftMax - height[left] > 0) {
                    result += leftMax - height[left];
                }
                left++;

            } else {
                if (rightMax - height[right] > 0) {
                    result += rightMax - height[right];
                }
                right--;
            }
        }

        return result;
    }

    /* 스택 쌓기
     */
    private void stack(int[] height) {

    }


}
