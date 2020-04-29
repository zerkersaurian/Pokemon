package app;
public class Bulbasaur extends Pokemon{

    public Bulbasaur(){

        basemaxhp   = 14;
        baseatk     = 4;
        basedef     = 3;
        basespd     = 2;    
       
        hpmul   = 4;
        atkmul  = 2;
        defmul  = 1;
        spdmul  = 1;
        curhp   = getmaxhp();
        
        species = "Bulbasaur";
    }

    public void backsprite(){
        System.out.println("                     ****                                                ");
        System.out.println("                  ********                    *              **          ");
        System.out.println("                ****************             ***           ****          ");
        System.out.println("               ************************************************          ");
        System.out.println("             ***************************************************         ");
        System.out.println("          *******************************************************        ");
        System.out.println("      ************************************************************       ");
        System.out.println("    **************************************************************       ");
        System.out.println("   *************************************************************         ");
        System.out.println("    **********************************************************           ");
        System.out.println("     ******************************************************              ");
        System.out.println("       *************************************************                 ");
        System.out.println("     ****************************************************                ");
        System.out.println("    ******************************************************               ");
        System.out.println("   *********************************************************             ");
        System.out.println("  ***********************************************************            ");
        System.out.println("   **********************************************************            ");
        System.out.println("    ********************************************************             ");
        System.out.println("        **************                  ******************               ");
    }
    public void frontsprite(){
        System.out.print("                                                                           ");System.out.println("                                              ******                     ");
        System.out.print("                                                                           ");System.out.println("                                           ***********                   ");
        System.out.print("                                                                           ");System.out.println("             **         **             ***************                   ");
        System.out.print("                                                                           ");System.out.println("           *****      *****      ***********************                 ");
        System.out.print("                                                                           ");System.out.println("         ********    ******* ******************************              ");
        System.out.print("                                                                           ");System.out.println("          ***************************************************            ");
        System.out.print("                                                                           ");System.out.println("        *******************************************************          ");
        System.out.print("                                                                           ");System.out.println("      ************************************************************       ");
        System.out.print("                                                                           ");System.out.println("     ***************************************************************     ");
        System.out.print("                                                                           ");System.out.println("     *****************************************************************   ");
        System.out.print("                                                                           ");System.out.println("   ********************************************************************* ");
        System.out.print("                                                                           ");System.out.println("   **********************************************************************");
        System.out.print("                                                                           ");System.out.println("    **********************************************************************");
        System.out.print("                                                                           ");System.out.println("     ******************************************************************** ");
        System.out.print("                                                                           ");System.out.println("      *****************************************************************  ");
        System.out.print("                                                                           ");System.out.println("        *************************************************************    ");
        System.out.print("                                                                           ");System.out.println("      ****************************************************************   ");
        System.out.print("                                                                           ");System.out.println("    *******************************************************************  ");
        System.out.print("                                                                           ");System.out.println("   **************             **************              ************   ");
        System.out.print("                                                                           ");System.out.println("   *************              *************                **********    ");
    }
}