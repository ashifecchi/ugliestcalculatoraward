/** This class is for calculating all the stuffs.
 * @author AshiFecchi */
public class LinearEquation {
    /**Instance Variables:
    *The first x*/
    private double x1;
    /**The second x*/
    private double x2;
    /**The first y*/
    private double y1;
    /**The second y*/
    private double y2;
    //private double slope;
    /**Temporary variable x*/
    private double tempx;
    /**temporary variable y*/
    private double tempy;


    /** The constructor class for an equation.
     *
     * */
    public LinearEquation(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    /**Method to create the equation used for all calculations.*/
    public String CalculateEquation(){
        double rise = y2 - y1;
        double run = x2 - x1;
        double slope = rise / run;
        if (slope * x1 == y1 && slope * x2 == y2){
            if (rise%run==0) {
                return "y=" + SlopeWhole() + "x";
            } else {
                return "y=" + SlopeFrac() + "x";
            }
        }
        double b = CalculateB();
        if (Math.abs(slope)==1||Math.abs(slope)==1.0){
            if (b>0) {
                if (rise % run == 0) {
                    return "y=" + SlopeWhole() + "x";
                } else {
                    return "y=" + SlopeFrac() + "x";
                }
            }
        }else if(slope==1) {
            return "y=x+"+b;
        } else if(slope==-1){
            return "y=-x+"+b;
        }
        return "y=" + slope + "x-"+b;
    }
    /**helper method to find B*/
    public double CalculateB(){
        return y1-(SlopeWhole()*x1);
    }
    /**helper method to find slope if it is perfectly divisible*/
    public double SlopeWhole(){
        double slope = (double)((y2-y1)/(x2-x1));
        return slope;
    }
    /**find slope as a string fraction*/
    public String SlopeFrac(){
        double rise = (y2-y1);
        double run = (x2-x1);
        if (rise<0&&run<0){
            return Math.abs(rise)+"/"+Math.abs(run);
        }
        if (run<0){
            return "-"+rise+"/"+Math.abs(run);
        }
        return rise+"/"+run;
    }
    /**returms a string of the first point in coordinate form*/
    public String coord1(){
         tempx = RoundtoHundreds(x1);
         tempy = RoundtoHundreds(y1);
        return "("+tempx+", "+tempy+")";
    }
    /**returns a string of the second point in coordinate form*/
    public String coord2(){
        tempx = RoundtoHundreds(x2);
        tempy = RoundtoHundreds(y2);
        return "("+tempx+", "+tempy+")";
    }
    /**calculates distance between points*/
    public double Distance(){
        tempx = Math.pow(x2-x1,2);
        tempy= Math.pow(y2-y1,2);
        return RoundtoHundreds(Math.sqrt(tempx+tempy));
    }
    /**method to print the line info*/
    public String lineInfo(){
        return "The two points are: " + coord1() +" and " + coord2() + "\nThe equation of the line between these points is: "+CalculateEquation()+"\nThe slope of this line is: "+SlopeWhole()+"\nThe y-intercept of this line is:"+ CalculateB()+"\nThe distance between these points is: "+Distance();
    }
    /**helper method for rounding to nearest hundreds*/
    public double RoundtoHundreds(double inp){
            return (double)Math.round(inp*100) / 100;
    }
    /**method to calculate y based on user input using the created equation object*/
    public double calcy(double x){
        return (SlopeWhole()*x)+CalculateB();
    }
}
