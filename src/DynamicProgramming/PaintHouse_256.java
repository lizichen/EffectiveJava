package DynamicProgramming;

public class PaintHouse_256 {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0){
            return 0;
        }
        for(int i=1; i<costs.length; i++){
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
        }
        int lastRow = costs.length - 1;
        return Math.min(costs[lastRow][0], Math.min(costs[lastRow][1], costs[lastRow][2]));
    }
}