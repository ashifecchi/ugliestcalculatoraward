public class LinearRegression {

    private double x1;
    private double x2;
    private double y1;
    private double y2;
    private double slope;

    public LinearRegression() {
        coordinate1 = null;
        coordinate2 = null;
    }

    public String CalculateEquation(){
        double rise = y2 - y1;
        double run = x2 - x1;
        double slope = rise / run;
        if (slope * x1 == y1 && slope * x2 == y2){
            return "y=" + slope + "x";
        }
        double b = CalculateB();
        if (b>0){
            return "y=" + slope + "x+"+b;
        }
        return "y=" + slope + "x-"+b;
    }
    public double CalculateB(){
        return y1-(slope*x1);
    }
}
