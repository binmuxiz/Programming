package java_coding_interview_book.ch12_graph;

// ***** 물에 둘러싸인 섬의 개수 구하기 문제
// DFS로 그래프 탐색. 재귀 구조 이용
public class P01_Number_Of_Islands {

    private static int solution1(char[][] grid) {

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int i, int j, char[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0') {
            grid[i][j] = '0';
            dfs(i, j + 1, grid); // 동
            dfs(i, j - 1, grid); // 서
            dfs(i + 1, j, grid); // 남
            dfs(i - 1, j, grid); // 북
        }
    }
}
