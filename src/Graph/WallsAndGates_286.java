package Graph;

/**
 You are given a m x n 2D grid initialized with these three possible values.

 -1 - A wall or an obstacle.
 0 - A gate.
 INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
 Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.


 Related:
     Surrounded Regions
     Number of Islands
     Shortest Distance from All Buildings
     Robot Room Cleaner
 */
public class WallsAndGates_286 {
    static int INF = Integer.MAX_VALUE;

    boolean[][] visited;
    int[][] rooms;

    public WallsAndGates_286(int[][] rooms){
        this.rooms = rooms;
    }

    public void wallsAndGates() {

        visited = new boolean[rooms.length][rooms[0].length];

        for(int i=0; i<rooms.length; i++){
            for(int j=0; j<rooms[0].length; j++){
                if(rooms[i][j] == 0){ //start from here
                    helper(rooms, i, j, 0);
                }
            }
        }

        printer(rooms);
    }

    public void helper(int[][] rooms, int i, int j, int distance){
        if(0 <= i && i < rooms.length && 0<= j && j < rooms[0].length && visited[i][j] == false && rooms[i][j] != -1 && rooms[i][j] >= distance){

            visited[i][j] = true;
            rooms[i][j] = distance;

            helper(rooms, i-1, j, distance+1);
            helper(rooms, i+1, j, distance+1);
            helper(rooms, i, j-1, distance+1);
            helper(rooms, i, j+1, distance+1);

            visited[i][j] = false;
        }
    }

    public void printer(int[][] rooms){
        for(int i=0; i<rooms.length; i++){
            for(int j=0; j<rooms[0].length; j++){
                System.out.print(rooms[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {INF,-1, 0,   INF},
                {INF,INF,INF, -1},
                {INF,-1, INF, -1},
                {0,  -1, INF, INF}};
        WallsAndGates_286 t = new WallsAndGates_286(matrix);
        t.wallsAndGates();
    }
}
