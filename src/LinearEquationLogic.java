import java.util.Scanner;
public class LinearEquationLogic {
    Scanner scan = new Scanner(System.in);
    private double p;
    private double pp;
    private double ppp;
    private double pppp;

    public LinearEquationLogic(){

    }

    public void Run(){
            greeting();
            loopw();
    }
    private void greeting(){
        System.out.println("WELCOJME TO THE CALCUYLATOR !!!!!! SAY HELLO TO ME");
        String greeting = scan.nextLine();
        if (greeting.toLowerCase().contains("hi")||greeting.toLowerCase().contains("hello")) {
            System.out.println(":D !!");
        } else {
            System.out.println("well fuck you too ig");
        }
    }
    private void SetCoords(){
        System.out.println("TELL ME THE X AND Y OF BOTH POINTS!!!!");
        System.out.println("FIRST COORD?");
        String cord = scan.nextLine();
        System.out.println("SECOND COORD");
        String cord2 = scan.nextLine();
        p = Integer.parseInt(cord.substring(1, cord.indexOf(",")));
        pp = Integer.parseInt(cord.substring(cord.indexOf(",")+1,cord.indexOf(")")));
        ppp = Integer.parseInt(cord2.substring(1, cord2.indexOf(",")));
        pppp = Integer.parseInt(cord2.substring(cord2.indexOf(",")+1,cord2.indexOf(")")));
    }
    private void loopw(){
        double xinpd = 0.0;
        String xinp = "";
        String loops = "";
            while (!loops.equals("stop")){
                SetCoords();
                if (p==ppp){
                    if (pp==pppp){
                        System.out.println("They have the same x...and y.. give me something else!!");
                    } else{
                    System.out.println("THEY HAVE THE SAME X... GIVE ME SOMETHING ELSE!");}
                } else if(pp==pppp) {
                    System.out.println();
                }else {
                        LinearEquation line = new LinearEquation(p, pp, ppp, pppp);
                        System.out.println(line.lineInfo());
                        while (!(xinp.equals("stop"))) {
                            System.out.println("Enter an X and find the Y!!![stop to quit] \n");
                            xinp = scan.nextLine();
                            if (!(xinp.equals("stop"))) {
                                xinpd = Integer.parseInt(xinp);
                                System.out.println(line.calcy(xinpd));
                            }
                        }
                        System.out.println("DO YOU WANNA GO AGAIN?");
                        loops = scan.nextLine();
                    }
                }
            }
}
