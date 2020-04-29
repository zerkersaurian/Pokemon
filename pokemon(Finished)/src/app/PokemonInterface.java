package app;
public interface PokemonInterface{

    //actions
    public void namechange(String inputname); //name change method
    public void expup(int winexp); //when pokemon win the battle trigger this method
    public void lvlchange(int changelvl); //when exp of pokemon > exp threshold or want to instant change lvl 
    public void damagecal(int oatk); //when attacked. deal with cur hp
    public void curhpchange(int amount); //use to restore hp equal to amount

    //get value
    public int getspd();
    public int getmaxhp();
    public int getcurhp();
    public int getatk();
    public int getdef();
    public String getname();
    public int getlvl();

    //for item use only
    public void maxhpincrease(int amount); //increase base maxhp
    public void atkincrease(int amount); //increase base atk
    public void defincrease(int amount); //increase base def
    public void spdincrease(int amount); //increase base spd

    //pokemon's sprite
    public void frontsprite(); //pokemon front sprite
    public void backsprite(); //pokemon back sprite
}