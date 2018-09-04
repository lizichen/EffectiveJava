package DynamicProgramming;

public class PaintFence_276 {

    public static int numWays(int n, int k) {
        if(n == 0)
            return 0;
        else if(n == 1)
            return k;

        int diffColorCounts = k*(k-1);
        int sameColorCounts = k;

        System.out.println(sameColorCounts + " " + diffColorCounts);
        for(int i=2; i<n; i++) {
            int temp = diffColorCounts;
            diffColorCounts = (diffColorCounts + sameColorCounts) * (k-1);
            sameColorCounts = temp;
            System.out.println(sameColorCounts + " " + diffColorCounts);
        }
        return diffColorCounts + sameColorCounts;
    }

    public static void main(String[] args) {
        System.out.println(numWays(2,3));
    }
}
