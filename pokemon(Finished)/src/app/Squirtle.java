package app;
public class Squirtle extends Pokemon{

    public Squirtle(){

        basemaxhp   = 12;
        baseatk     = 4;
        basedef     = 5;
        basespd     = 2;    
        
        hpmul   = 3;
        atkmul  = 2;
        defmul  = 2;
        spdmul  = 1;
        curhp   = getmaxhp();
        
        species = "Squirtle";
    }
    public void backsprite(){
        System.out.println("                     *********                    ");
        System.out.println("                   *************                  ");
        System.out.println("                  ***************                 ");
        System.out.println("                  ***************                 ");
        System.out.println("              *******************                 ");
        System.out.println("           *********************                  ");
        System.out.println("         **********************    *  *           ");
        System.out.println("        ******************************            ");
        System.out.println("        *****************************             ");
        System.out.println("         **********************                   ");
        System.out.println("     **   **********************                  ");
        System.out.println("   ***** **********************                   ");
        System.out.println(" **************************                       ");
        System.out.println("   ***************************                    ");
        System.out.println("     *********   ***************                  ");
    }
    public void frontsprite(){
        System.out.print("                                                                           ");System.out.println("                  **********                          ");
        System.out.print("                                                                           ");System.out.println("              ******************                      ");
        System.out.print("                                                                           ");System.out.println("             ********************                     ");
        System.out.print("                                                                           ");System.out.println("            **********************                    ");
        System.out.print("                                                                           ");System.out.println("          *************************                   ");
        System.out.print("                                                                           ");System.out.println("          ***************************                 ");
        System.out.print("                                                                           ");System.out.println("              **************************              ");
        System.out.print("                                                                           ");System.out.println("             *****************************            ");
        System.out.print("                                                                           ");System.out.println("       ************************************           ");
        System.out.print("                                                                           ");System.out.println("   *****************************************          ");
        System.out.print("                                                                           ");System.out.println("         ***********************************          ");
        System.out.print("                                                                           ");System.out.println("          **********************************          ");
        System.out.print("                                                                           ");System.out.println("         **********************************  *****    ");
        System.out.print("                                                                           ");System.out.println("          ********************************  *******   ");
        System.out.print("                                                                           ");System.out.println("         ******************************** ********    ");
        System.out.print("                                                                           ");System.out.println("       *****************************************      ");
        System.out.print("                                                                           ");System.out.println("      ****************************************        ");
        System.out.print("                                                                           ");System.out.println("     ***************     *****************            ");
        System.out.print("                                                                           ");System.out.println("    **************         *************              ");

    }
    
}