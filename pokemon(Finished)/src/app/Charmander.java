package app;
public class Charmander extends Pokemon{

    public Charmander(){

        basemaxhp   = 12;
        baseatk     = 5;
        basedef     = 3;
        basespd     = 3;    
        
        hpmul   = 3;
        atkmul  = 3;
        defmul  = 1;
        spdmul  = 1;
        curhp   = getmaxhp();

        species = "Charmander";
    }

    public void backsprite(){
        System.out.println("                                       ******");
        System.out.println("                 *                  ***********");
        System.out.println("                **               ****************");
        System.out.println("              *****             *******************");
        System.out.println("            *******            **********************");
        System.out.println("           **********          **********************");
        System.out.println("           ******               ******************");
        System.out.println("           ***                   *********************    **");
        System.out.println("        ****                       ******************** ****");
        System.out.println("      ****                          ****************** **");
        System.out.println("      ****                       *********************");
        System.out.println("        ****                    ***********************");
        System.out.println("          *****                ***********************");
        System.out.println("             *****             **********************");
        System.out.println("              *******          *********************");
        System.out.println("               **********       *******************");
    }

    public void frontsprite(){
        System.out.print("                                                                           ");System.out.println("            ****                                 ");
        System.out.print("                                                                           ");System.out.println("        *************                            ");
        System.out.print("                                                                           ");System.out.println("       ****************                          ");
        System.out.print("                                                                           ");System.out.println("       ****************                 *        ");
        System.out.print("                                                                           ");System.out.println("      ******************               ***       ");
        System.out.print("                                                                           ");System.out.println("       *****************              *****      ");
        System.out.print("                                                                           ");System.out.println("          ************               ********    ");
        System.out.print("                                                                           ");System.out.println("       ****************                ****      ");
        System.out.print("                                                                           ");System.out.println("*********************************        **      ");
        System.out.print("                                                                           ");System.out.println(" **********************************      ***     ");
        System.out.print("                                                                           ");System.out.println("       ******************               ****     ");
        System.out.print("                                                                           ");System.out.println("       *******************             *****     ");
        System.out.print("                                                                           ");System.out.println("        *******************          ******      ");
        System.out.print("                                                                           ");System.out.println("      **********************     *********       ");
        System.out.print("                                                                           ");System.out.println("    *************************************        ");
        System.out.print("                                                                           ");System.out.println("  *************************************          ");
        System.out.print("                                                                           ");System.out.println("*************       ****************             ");
        System.out.print("                                                                           ");System.out.println("  ********            ************               ");
        System.out.print("                                                                           ");System.out.println("   ****                 *****                    ");
    }
}