package app;
abstract class Pokemon implements PokemonInterface{
    // it's stat will be (base + mul*lvl)
    protected String name;

    protected int basemaxhp;
    protected int curhp;
    protected int baseatk;
    protected int basedef;
    protected int basespd;

    protected double hpmul; // stat + per level
    protected double atkmul;
    protected double defmul;
    protected double spdmul;

    protected int exp=0;
    protected int exptolvlup=10;
    protected int lvl=1;
    protected String species;
    
    public Pokemon(){
        curhp = getmaxhp();
    }

    public void namechange(String inputname){ // naming pokemon 
        name = inputname;
    }

    public void expup(int winexp){ // when win battle
        exp += winexp;
        if(exp >= exptolvlup){
            while(exp >= exptolvlup){
                lvlchange(1) ;
                exp -= exptolvlup;
                System.out.println(name + " grew to Lv." + lvl + "!");
            }
        }
    }

    public void lvlchange(int amount){ //when lvl up
        lvl += amount;
        for(int i = 0 ; i <= amount ; i++){
            exptolvlup *= 1.2;
        }
        curhp = getmaxhp();
    }

    public void damagecal(int oatk){ //damage cal part
        int damage = oatk - getdef();
        if(damage <= 0) //if def is higher than other one's attack then damage = 1
        {
            curhp -= 1;
        }
        else{
            curhp -= damage;
        }
        if(curhp <= 0){//curhp can't be less than 0
            curhp = 0; 
        }
    }
    
    public void curhpchange(int amount){
        curhp += amount;
        System.out.println("Your "+ name + " HP is " + curhp + " now!");
        if(curhp > getmaxhp()){
            curhp = getmaxhp();
            System.out.println(name + " HP is full!");
        }
    }
    public int getspd(){
        return basespd + (int)(lvl*spdmul);
    }
    public int getmaxhp(){
        return basemaxhp + (int)(lvl*hpmul);
    }
    public int getcurhp(){
        return curhp;
    }
    public int getatk(){
        return baseatk + (int)(lvl*atkmul);
    }
    public int getdef(){
        return basedef + (int)(lvl*defmul);
    }
    public String getname(){
        return name;
    }
    public int getlvl(){
        return lvl;
    }
    public String getspecies(){
        return species;
    }
    public int getexp(){
        return exp;
    }
    public int getexptolvl(){
        return exptolvlup;
    }
    public void maxhpincrease(int amount){ //item use only
        basemaxhp += amount;
    }
    public void atkincrease(int amount){ //item use only
        baseatk += amount;
    }
    public void defincrease(int amount){ //item use only 
        basedef += amount;
    }
    public void spdincrease(int amount){ //item use only
        basespd += amount;
    }
}