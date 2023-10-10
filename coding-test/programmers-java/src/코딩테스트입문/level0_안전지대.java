package 코딩테스트입문;

/**
 * created by 현민
 */
public class level0_안전지대 {
    public int solution(int[][] board) {
        int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
        int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};

        for(int i=0; i< board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if(board[i][j] == 1) {
                    for(int k=0; k<8; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(0 <= nx && 0 <= ny && nx < board.length && ny < board[0].length && board[nx][ny]!=1) {
                            board[nx][ny] = 2;
                        }
                    }
                }
            }
        }
        int answer = 0;

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if(board[i][j] == 0)
                    answer++;
            }
        }

        return answer;
    }
}
