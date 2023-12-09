// 영토에 대한 지도 정보가 주어졌을 떄, 땅의 둘레를 구하는 프로그램

public class P05 {
    public static void main(String[] args) {
        // test code
        int[][] grid = {{1}};
        System.out.println(solution2(grid));

        int[][] grid2 = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(solution2(grid2));

    }

    // 반복구조 풀이
    private static int solution(int[][] grid) {
        int[][] directions = {{0,1}, {1,0}, {-1,0}, {0,-1}}; // 순서대로 남,동,서,북쪽
        int result = 0;

        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) { // 땅
                    for (int[] d : directions) {
                        int x = i + d[0];
                        int y = i + d[1];

                        if (x < 0 || y < 0 || x >= row || y >= col || grid[x][y] == 0) {
                            result++;
                        }
                    }
                }
            }
        }
        return result;

    }

    // 재귀구조 풀이
    private static int solution2(int[][] grid) {
        int[][] directions = {{0,1}, {1,0}, {-1,0}, {0,-1}}; // 순서대로 남,동,서,북쪽

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return recursion(grid, i, j, directions);
                }
            }
        }
        return 0;
    }

    private static int recursion(int[][] grid, int i, int j, int[][] directions) {
        int row = grid.length;
        int col = grid[0].length;

        grid[i][j] = -1; // 방문표시
        int count = 0;

        for (int[] d : directions) {
            int x = i + d[0];
            int y = j + d[1];

            if (x < 0 || y < 0 || x >= row || y >= col || grid[x][y] == 0) {
                count++;
            } else {
                if (grid[x][y] == 1) { // 방문한 곳은 다시 가지 않기 위해
                    count += recursion(grid, x, y, directions);
                }
            }
        }
        return count;
    }
}
