package MathRelated;

public class GenerateRandomPointInACircle_478 {
    double rad, xc, yc;
    public GenerateRandomPointInACircle_478(double radius, double x_center, double y_center) {
        rad = radius;
        xc = x_center;
        yc = y_center;
    }

    public double[] randPoint() {
        double x0 = xc - rad;
        double y0 = yc - rad;

        while(true) {
            double r1 = Math.random();
            double r2 = Math.random();

            double xg = x0 + r1 * rad * 2;
            double yg = y0 + r2 * rad * 2;

            if (Math.sqrt(Math.pow((xg - xc) , 2) + Math.pow((yg - yc), 2)) <= rad)
                return new double[]{xg, yg};
        }
    }

    public static void main(String[] args) {
        GenerateRandomPointInACircle_478 t = new GenerateRandomPointInACircle_478(1, 0, 0);
        t.randPoint();
        t.randPoint();
        t.randPoint();
        t.randPoint();
        t.randPoint();
    }
}
