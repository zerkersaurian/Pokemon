package app;
import java.util.Random;
public class Item{

    private int hpupamount = 0;     //hp up is boost max hp
    private int proteinamount = 0;  //protein is boost atk
    private int ironamount = 0;     //iron is boost def
    private int carbosamount = 0;   //carbos is boost spd
    private int potionamount = 0;   //potion is use to restore curhp in battle
    private int pokeballamount = 0; //use to catch pokemon

    private Random rand = new Random();
    public Item(){
        potionamount = 3;
        pokeballamount = 3;
    }
    public void getitem(){
        // item can be get multiple at once
        if(rand.nextInt(3) == 1){ 
            hpupamount += 1;
        }
        if(rand.nextInt(3) == 1){
            proteinamount += 1;
        }
        if(rand.nextInt(3) == 1){
            ironamount += 1;
        }
        if(rand.nextInt(3) == 1){
            carbosamount += 1;
        }
        if(rand.nextInt(3) == 1){
            potionamount += 1;
        }
        if(rand.nextInt(3) == 1){
            pokeballamount += 1;
        }
    }
    public void usehpup(Pokemon target){
        target.maxhpincrease(3);
        hpupamount -= 1;
    }
    public void useprotein(Pokemon target){
        target.atkincrease(2);
        proteinamount -= 1;
    }
    public void useiron(Pokemon target){
        target.defincrease(1);
        ironamount -= 1;
    }
    public void usecarbos(Pokemon target){
        target.spdincrease(1);
        carbosamount -= 1;
    }
    public boolean usepokeball(Pokemon target){
        pokeballamount -= 1;
        if(rand.nextInt(3)==1){//33% to catch
            return true;
        }
        else return false;
    }
    public void usepotion(Pokemon target){
        if( (target.getmaxhp() - target.getcurhp()) <= 20 ){ // if target lose less than 20 hp then restore to full
            target.curhpchange(target.getmaxhp() - target.getcurhp());
        }
        else{
            target.curhpchange(20);
        }
        potionamount-=1;
    }
    public int getHPUPAmount(){
        return hpupamount;
    }
    public int getProtienAmount(){
        return proteinamount;
    }
    public int getIronAmount(){
        return ironamount;
    }
    public int getCarbosAmount(){
        return carbosamount;
    }
    public int getPotionAmount(){
        return potionamount;
    }
    public int getPokeballAmount(){
        return pokeballamount;
    }
    public int getTotalItem(){
        return hpupamount + ironamount + proteinamount + carbosamount + potionamount + pokeballamount;
    }
}