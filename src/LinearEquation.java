public class LinearEquation {

    private double x1;
    private double x2;
    private double y1;
    private double y2;
    private double slope;
    private double tempx;
    private double tempy;


    public LinearEquation(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

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
    public double CalculateB(){
        return y1-(slope*x1);
    }
    public double SlopeWhole(){
        slope = (int)((y2-y1)/(x2-x1));
        return slope;
    }
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
    public String coord1(){
         tempx = RoundtoHundreds(x1);
         tempy = RoundtoHundreds(y1);
        return "("+tempx+", "+tempy+")";
    }
    public String coord2(){
        tempx = RoundtoHundreds(x2);
        tempy = RoundtoHundreds(y2);
        return "("+tempx+", "+tempy+")";
    }
    public double Distance(){
        tempx = Math.pow(x2-x1,2);
        tempy= Math.pow(y2-y1,2);
        return RoundtoHundreds(Math.sqrt(tempx+tempy));
    }
    public String lineInfo(){
        return "The two points are: " + coord1() +" and " + coord2() + "\nThe equation of the line between these points is: "+CalculateEquation()+"\nThe slope of this line is: "+slope+"\nThe y-intercept of this line is:"+CalculateB()+"\nThe distance between these points is: "+Distance();
    }
    public double RoundtoHundreds(double inp){
            return (double)Math.round(inp*100) / 100;
    }
    public double calcy(double x){
        return (slope*x)+CalculateB();
    }
}
