package BackTracking;

public class Bloomberg_WordSearch_79 {

    static boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if((word.charAt(0) == board[i][j]) && search(board, word, i, j, 0)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean search(char[][] board, String word, int i, int j, int index){
        if(index == word.length()){
            return true;
        }

        if(i >= board.length
                || i < 0
                || j >= board[i].length
                || j < 0
                || board[i][j] != word.charAt(index)
                || visited[i][j]){
            return false;
        }

        visited[i][j] = true;
        if(search(board, word, i-1, j, index+1) ||
                search(board, word, i+1, j, index+1) ||
                search(board, word, i, j-1, index+1) ||
                search(board, word, i, j+1, index+1)){
            return true;
        }

        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        Bloomberg_WordSearch_79 t = new Bloomberg_WordSearch_79();
        char[][] board = new char[][]{{'A','A'}};
        String word = "AAA";
        System.out.println(t.exist(board, word));
    }
}
