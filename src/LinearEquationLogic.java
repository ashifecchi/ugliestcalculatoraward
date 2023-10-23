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
        pppp = Integer.parseInt(cord2.substring(cord2.indexOf(",")+1,cord.indexOf(")")));
    }
    private void loopw(){
        String loops = "";
        System.out.println("Enter an X and find the Y!!![stop to quit] \n");
            while (!loops.equals("stop")){
                SetCoords();
                LinearEquation line = new LinearEquation(p, pp, ppp, pppp);
                System.out.println(line.lineInfo());
                System.out.println("DO YOU WANNA GO AGAIN?");
                loops = scan.nextLine();
            }
    }
}
