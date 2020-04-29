package app;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
public class GameMenu extends GameScreen{

    private ArrayList<Pokemon> bags = new ArrayList<Pokemon>();
    private Item items = new Item();
    private Pokemon reserve,wildPokemon;
    private JLabel playerNameLabel,playerItemLabel,playerPokemonLabel,textPokemonLabel,textItemLabel; 
    private JPanel playerStatusPanel;
    private JButton itemButton,statButton,battleButton,restButton,returnButton;
    private JButton selectButton,itemComboBoxButton,battlePokeballButton,battlePotionButton,battleAttackButton,battleSwitchButton,battleNextButton,closeButton;
    private ActionListener itemAction,statAction,battleAction,restAction,restComboAction,statComboAction,returnStatAction,itemPokemonSelectAction,itemPokemonUseAction;
    private ActionListener returnItemAction,battlePokeballAction,battlePotionAction,battleAttackAction,battleSwitchAction,battleComboboxAction,closeAction;
    private ActionListener battleAttackNextPlayerAction,battleAttackNextWildAction,battleAttackNextMenuAction,battleAttackNextFinishedAction,battleSwitchPokemonAction,inputNameAction;
    private JComboBox<String> selectComboBox,itemComboBox;
    private JTextField inputNameTextField;
    private int i,numreserve,turn;
    private Random rand = new Random();
    private String[] itemList = {"HP UP","Protien","Iron","Carbos","Potion"};

    public GameMenu(Container c,String pokemonSpecies,String playerName,String pokemonName){
        super(c);
        switch(pokemonSpecies){
            case "Charmander" : 
                reserve = new Charmander();
                break;
            case "Squirtle" :
                reserve = new Squirtle();
                break;
            case "Bulbasaur" :
                reserve = new Bulbasaur();
                break;
            default :
                reserve = new Charmander();
                break;
        }
        reserve.namechange(pokemonName);
        reserve.lvlchange(4); //lvl boost to 5
        bags.add(reserve);
        playerStatusPanel = new JPanel();
        playerStatusPanel.setBackground(Color.black);
        playerStatusPanel.setBounds(50,50,900,50);
        playerStatusPanel.setLayout(new GridLayout(1,5));
        c.add(playerStatusPanel);

        mainTextArea.setText("What do you want to do?");
        //creating combobox
        selectComboBox = new JComboBox<String>();
        ComboboxUpdate();
        selectComboBox.setVisible(false);
        selectComboBox.setBounds(50,500,350,50);
        selectComboBox.setBackground(Color.black);
        selectComboBox.setForeground(Color.white);
        selectComboBox.setFont(normalFont);
        c.add(selectComboBox);
        //creating selectbutton(pair with combobox)
        selectButton = new JButton("Select");
        selectButton.setVisible(false);
        selectButton.setBounds(450,500,200,50);
        selectButton.setBackground(Color.black);
        selectButton.setForeground(Color.white);
        selectButton.setFont(normalFont);
        c.add(selectButton);
        //creating player status bar at top
        playerNameLabel = new JLabel(playerName);
        playerNameLabel.setForeground(Color.white);
        playerNameLabel.setFont(normalFont);
        playerStatusPanel.add(playerNameLabel);
        
        textItemLabel = new JLabel("Total Item : ");
        textItemLabel.setForeground(Color.white);
        textItemLabel.setFont(normalFont);
        playerStatusPanel.add(textItemLabel);

        playerItemLabel = new JLabel(Integer.toString(items.getTotalItem()));
        playerItemLabel.setForeground(Color.white);
        playerItemLabel.setFont(normalFont);
        playerStatusPanel.add(playerItemLabel);

        textPokemonLabel = new JLabel("Pokemon:");
        textPokemonLabel.setForeground(Color.white);
        textPokemonLabel.setFont(normalFont);
        playerStatusPanel.add(textPokemonLabel);

        playerPokemonLabel = new JLabel(Integer.toString(bags.size()));
        playerPokemonLabel.setForeground(Color.white);
        playerPokemonLabel.setFont(normalFont);
        playerStatusPanel.add(playerPokemonLabel);
        //creating return button
        returnButton = new JButton("<");
        returnButton.setBounds(50,670,100,50);
        returnButton.setBackground(Color.black);
        returnButton.setForeground(Color.white);
        returnButton.setVisible(false);
        returnButton.setFont(normalFont);
        c.add(returnButton);
        //creating item button
        itemButton = new JButton("Use Item");
        itemButton.setBounds(300,600,400,50);
        itemButton.setFont(normalFont);
        itemButton.setBackground(Color.black);
        itemButton.setForeground(Color.white);
        //creating item's combobox 
        itemComboBox = new JComboBox<String>(itemList);
        itemComboBox.setVisible(false);
        itemComboBox.setBounds(50,500,350,50);
        itemComboBox.setBackground(Color.black);
        itemComboBox.setForeground(Color.white);
        itemComboBox.setFont(normalFont);
        c.add(itemComboBox);
        //creating item combobox's button
        itemComboBoxButton = new JButton("Select");
        itemComboBoxButton.setVisible(false);
        itemComboBoxButton.setBounds(450,500,200,50);
        itemComboBoxButton.setBackground(Color.black);
        itemComboBoxButton.setForeground(Color.white);
        itemComboBoxButton.setFont(normalFont);
        c.add(itemComboBoxButton);
        returnItemAction = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                TurnOnMainMenu();
                itemComboBox.setVisible(false);
                itemComboBoxButton.setVisible(false);
            }
        };
        //itemcomboboxbutton action
        itemPokemonUseAction = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                switch ((String)itemComboBox.getSelectedItem()){
                    case "HP UP" : 
                        if(items.getHPUPAmount() <= 0){
                            mainTextArea.setText("You don't have a HP UP!");
                        }
                        else{
                            items.usehpup(reserve);
                            mainTextArea.setText("Your "+reserve.getname()+" max HP has rose to "+reserve.getmaxhp()+"!!!");
                        }
                        break;
                    case "Protien" : 
                        if(items.getProtienAmount() <= 0){
                            mainTextArea.setText("You don't have a Protien!");
                        }
                        else{
                            items.useprotein(reserve);
                            mainTextArea.setText("Your "+reserve.getname()+" ATK has rose to "+reserve.getatk()+"!!!");
                        }
                        break;
                    case "Iron" : 
                        if(items.getIronAmount() <= 0){
                            mainTextArea.setText("You don't have a Iron!");
                        }
                        else{
                            items.useiron(reserve);
                            mainTextArea.setText("Your "+reserve.getname()+" DEF has rose to "+reserve.getdef()+"!!!");
                        }
                        break;                          
                    case "Carbos" : 
                        if(items.getCarbosAmount() <= 0){
                            mainTextArea.setText("You don't have a Carbos!");
                        }
                        else{
                            items.usecarbos(reserve);
                            mainTextArea.setText("Your "+reserve.getname()+" SPD has rose to "+reserve.getspd()+"!!!");
                        }
                        break;
                    case "Potion" :
                        if(items.getPotionAmount() <= 0){
                            mainTextArea.setText("You don't have a Potion!");
                        }
                        else{
                            items.usepotion(reserve);
                            mainTextArea.setText("Your "+reserve.getname()+" HP has been restored to "+reserve.getcurhp()+"/"+reserve.getmaxhp()+"!");
                        }
                        break;
                    default :
                        mainTextArea.setText("Error. Some problem is caused. Please return to main menu.");     
                }    
                itemComboBox.setVisible(false);
                itemComboBoxButton.setVisible(false);
            }
        };
        itemComboBoxButton.addActionListener(itemPokemonUseAction);
        //selectcombobox item action
        itemPokemonSelectAction = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                for(i=0;i<bags.size();i++){
                    if(bags.get(i).getname().equals((String)selectComboBox.getSelectedItem())){
                        mainTextArea.setText(
                        "- HP UP ["+items.getHPUPAmount()+"] use for increase max HP"+
                        "\n- Protien ["+items.getProtienAmount()+"] use for increase ATK"+
                        "\n- Iron ["+items.getIronAmount()+"] use for increase DEF"+
                        "\n- Carbos ["+items.getCarbosAmount()+"] use for increase SPD"+
                        "\n- Potion ["+items.getPotionAmount()+"] use to restore HP 20 points" +
                        "\n- Pokeball ["+items.getPokeballAmount()+"] can be use in battle only");
                        TurnOffSelectButton();
                        itemComboBox.setVisible(true);
                        itemComboBoxButton.setVisible(true);
                        reserve = bags.get(i);
                        returnButton.setVisible(false);
                    }
                }
                returnButton.setVisible(true);
                returnButton.addActionListener(returnItemAction);
            }
        };     
        //itembutton action
        itemAction = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                TurnOffMainMenu();
                mainTextArea.setText("Which Pokemon do you want to use item to?");
                TurnOnSelectButton();
                RemoveComboActionListener();
                RemoveReturnActionListener();
                selectButton.addActionListener(itemPokemonSelectAction);
                returnButton.setVisible(false);
            }
        };
        itemButton.addActionListener(itemAction);
        //creating statbutton
        statButton = new JButton("See Pokemon Stats");
        statButton.setBounds(300,500,400,50);
        statButton.setFont(normalFont);
        statButton.setBackground(Color.black);
        statButton.setForeground(Color.white);
        //creating returnbutton action (return to main menu from status viewing action) 
        returnStatAction = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                TurnOnMainMenu();
            }
        };
        //combobox stat action
        statComboAction = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                TurnOffSelectButton();
                for(i=0;i<bags.size();i++){
                    if(bags.get(i).getname().equals((String)selectComboBox.getSelectedItem())){
                        mainTextArea.setText("Name     : "+bags.get(i).getname() +  
                        "\nLVL        : "+bags.get(i).getlvl()+
                        "                     EXP      : " +bags.get(i).getexp() + "/" + bags.get(i).getexptolvl()+
                        "\nSpecies  : "+bags.get(i).getspecies() +
                        "\nHP         : "+bags.get(i).getcurhp()+"/"+bags.get(i).getmaxhp()+
                        "\nATK       : "+bags.get(i).getatk() +
                        "                   DEF      : "+bags.get(i).getdef() +
                        "\nSPD       : "+bags.get(i).getspd()
                        );
                        RemoveReturnActionListener();
                        returnButton.setVisible(true);
                        returnButton.addActionListener(returnStatAction);
                        break;
                    }
                }
            }
        };
        //creating statbutton action
        statAction = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                TurnOffMainMenu();
                mainTextArea.setText("Which Pokemon do you want to see status?");
                TurnOnSelectButton();
                RemoveComboActionListener();
                RemoveReturnActionListener();
                selectButton.addActionListener(statComboAction);
                returnButton.setVisible(false);
            }
        };
        statButton.addActionListener(statAction);
        //creating restbuttton
        restButton = new JButton("Rest(Recover HP)");
        restButton.setBounds(300,550,400,50);
        restButton.setFont(normalFont);
        restButton.setBackground(Color.black);
        restButton.setForeground(Color.white);
        //creating combobox rest action
        restComboAction = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                TurnOffSelectButton();
                for(i=0;i<bags.size();i++){
                    if(bags.get(i).getname().equals((String)selectComboBox.getSelectedItem())){
                        bags.get(i).curhpchange(bags.get(i).getmaxhp()); //heal to full hp
                        mainTextArea.setText(bags.get(i).getname()+"'s HP is restored to "+bags.get(i).getcurhp()+"!!!");
                    }
                }
                returnButton.setVisible(true);
                returnButton.addActionListener(returnStatAction);
            }
        };
        //restbutton action
        restAction = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                TurnOffMainMenu();
                TurnOnSelectButton();
                RemoveComboActionListener();
                mainTextArea.setText("Which Pokemon do you want it to rest?");
                selectButton.addActionListener(restComboAction);
                RemoveReturnActionListener();
                returnButton.setVisible(false);
            }
        };
        restButton.addActionListener(restAction);
        //creating battlebuttton
        battleButton = new JButton("Go Battle!!!");
        battleButton.setBounds(300,450,400,50);
        battleButton.setFont(normalFont);
        battleButton.setBackground(Color.black);
        battleButton.setForeground(Color.white);
        //creating battlebutton component
        battleAttackButton = new JButton("Attack");
        battleAttackButton.setBounds(300,450,400,50);
        battleAttackButton.setFont(normalFont);
        battleAttackButton.setBackground(Color.black);
        battleAttackButton.setForeground(Color.white);
        battleAttackButton.setVisible(false);
        c.add(battleAttackButton);
        battlePotionButton = new JButton("Use Potion");
        battlePotionButton.setBounds(300,500,400,50);
        battlePotionButton.setFont(normalFont);
        battlePotionButton.setBackground(Color.black);
        battlePotionButton.setForeground(Color.white);
        battlePotionButton.setVisible(false);
        battlePotionAction = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(items.getPotionAmount()<=0){
                    mainTextArea.setText("You don't have a potion!");
                }   
                else{
                    items.usepotion(reserve);
                    RemoveNextActionListener();
                    mainTextArea.setText("You've use a Potion!"+"\n"+reserve.getname()+" HP is restored to "+reserve.getcurhp()+"/"+reserve.getmaxhp()+"!");            
                }
                battleNextButton.addActionListener(battleAttackNextMenuAction);
            }
        };
        battlePotionButton.addActionListener(battlePotionAction);
        c.add(battlePotionButton);
        battleSwitchButton = new JButton("Switch Pokemon");
        battleSwitchButton.setBounds(300,550,400,50);
        battleSwitchButton.setFont(normalFont);
        battleSwitchButton.setBackground(Color.black);
        battleSwitchButton.setForeground(Color.white);
        battleSwitchButton.setVisible(false);
        battleSwitchPokemonAction = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                for(i=0;i<bags.size();i++){
                    if(bags.get(i).getname().equals((String)selectComboBox.getSelectedItem())){
                        reserve = bags.get(i);
                        TurnOffSelectButton();
                        TurnOnBattleMenu();
                    }
                }
            }
        };
        battleSwitchAction = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                TurnOnSelectButton();
                TurnOffBattleMenu();
                mainTextArea.setText("Select Pokemon to switch out");
                RemoveComboActionListener();
                selectButton.addActionListener(battleSwitchPokemonAction);
            }
        };
        battleSwitchButton.addActionListener(battleSwitchAction);
        c.add(battleSwitchButton);
        battlePokeballButton = new JButton("Catch Pokemon");
        battlePokeballButton.setBounds(300,600,400,50);
        battlePokeballButton.setFont(normalFont);
        battlePokeballButton.setBackground(Color.black);
        battlePokeballButton.setForeground(Color.white);
        battlePokeballButton.setVisible(false);
        inputNameTextField = new JTextField(250);
        inputNameTextField.setBounds(200,500,600,50);
        inputNameTextField.setText("");
        inputNameTextField.setVisible(false);
        inputNameTextField.setFont(normalFont);
        inputNameAction = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                wildPokemon.namechange(e.getActionCommand());
                bags.add(wildPokemon);
                inputNameTextField.setVisible(false);
                mainTextArea.setText(wildPokemon.getname()+" is your partner now!");
                battleNextButton.setVisible(true);
                RemoveNextActionListener();
                battleNextButton.addActionListener(battleAttackNextFinishedAction);
            }
        };
        inputNameTextField.addActionListener(inputNameAction);
        battlePokeballAction = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(items.getPokeballAmount()<=0){
                    mainTextArea.setText("You don't have a Pokeball!");
                }
                else{
                    if(items.usepokeball(wildPokemon)){
                        mainTextArea.setText("You've caught a "+wildPokemon.getspecies()+"!\n"+
                        "Please name this "+wildPokemon.getspecies()+" you've caught!");
                        inputNameTextField.setVisible(true);
                        TurnOffBattleMenu();
                    }
                    else{
                        mainTextArea.setText("Oh no! "+ wildPokemon.getspecies()+" broke free!");
                    }
                    PanelUpdate();
                }
            }
        };
        battlePokeballButton.addActionListener(battlePokeballAction);
        c.add(inputNameTextField);
        c.add(battlePokeballButton);
        battleNextButton = new JButton(">");
        battleNextButton.setBounds(300,450,400,50);
        battleNextButton.setFont(normalFont);
        battleNextButton.setBackground(Color.black);
        battleNextButton.setForeground(Color.white);
        battleNextButton.setVisible(false);
        c.add(battleNextButton);
        //when finished battle action
        battleAttackNextFinishedAction = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                battleNextButton.setVisible(false);
                TurnOnMainMenu();
            }
        };
        //when all pokemon take turn action
        battleAttackNextMenuAction = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                battleNextButton.setVisible(false);
                TurnOnBattleMenu();
            }
        };
        //wild pokemon's attack
        battleAttackNextWildAction = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                wildAttack();
            }
        };
        //player pokemon's attack
        battleAttackNextPlayerAction = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                playerAttack();
            }
        };
        //battleattackbutton action
        battleAttackAction = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(wildPokemon.getspd()>reserve.getspd()){
                    wildAttack();
                }
                else{
                    playerAttack();
                }
                battleNextButton.setVisible(true);
            }
        };
        //battleCombobox action
        battleComboboxAction = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                for(i=0;i<bags.size();i++){
                    if(bags.get(i).getname().equals((String)selectComboBox.getSelectedItem())){
                        reserve = bags.get(i);
                        numreserve = rand.nextInt(3);
                        switch(numreserve){
                            case 0 :
                                wildPokemon = new Charmander();
                                break;
                            case 1 :
                                wildPokemon = new Squirtle();
                                break;
                            case 2 : 
                                wildPokemon = new Bulbasaur();
                                break;
                            default :
                                wildPokemon = new Charmander();
                                break;
                        }
                        turn = 0;
                        numreserve = rand.nextInt(3);
                        switch(numreserve){
                            case 0:
                                wildPokemon.lvlchange(reserve.getlvl() - 3);
                                break;
                            case 1:
                                wildPokemon.lvlchange(reserve.getlvl() - 2);
                                break;
                            case 2:
                                wildPokemon.lvlchange(reserve.getlvl() - 1); 
                                break;
                            default :
                                wildPokemon.lvlchange(reserve.getlvl() - 1);
                                break;
                        }
                        TurnOffSelectButton();
                        TurnOnBattleMenu();
                        mainTextArea.setText("A wild " + wildPokemon.getspecies() + " has appered!\n\n"
                        + reserve.getname() + " HP : "+ reserve.getcurhp() + "/" + reserve.getmaxhp() + "   LVL : " + reserve.getlvl() +
                        "\n\nWild " + wildPokemon.getspecies() + " HP : " + wildPokemon.getcurhp() + "/" + wildPokemon.getmaxhp() + "   LVL : " + wildPokemon.getlvl()
                        );
                       
                    }
                }
            }
        };
        battleAttackButton.addActionListener(battleAttackAction);
        //battlebutton action
        battleAction = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                mainTextArea.setText("Which Pokemon do you want to battle?");
                TurnOffMainMenu();
                TurnOnSelectButton();
                RemoveComboActionListener();
                RemoveReturnActionListener();
                selectButton.addActionListener(battleComboboxAction);
                returnButton.setVisible(false);
            }
        };
        battleButton.addActionListener(battleAction);
        //creating close button
        closeButton = new JButton("Close Game");
        closeButton.setBounds(300,650,400,50);
        closeButton.setFont(normalFont);
        closeButton.setBackground(Color.black);
        closeButton.setForeground(Color.white);
        closeAction = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
        closeButton.addActionListener(closeAction);
        c.add(closeButton);
        c.add(itemButton);
        c.add(battleButton);
        c.add(restButton);
        c.add(statButton);
        closeButton.revalidate();
        closeButton.repaint();
        itemButton.revalidate();
        itemButton.repaint();
        playerStatusPanel.revalidate();
        playerStatusPanel.repaint();
    }
    private void wildAttack(){
        TurnOffBattleMenu();
        battleNextButton.setVisible(true);
        reserve.damagecal(wildPokemon.getatk());
        //wild pokemon's win case
        if(reserve.getcurhp() <= 0){
            mainTextArea.setText(reserve.getname() + " is fainted!");
            RemoveNextActionListener();
            battleNextButton.addActionListener(battleAttackNextFinishedAction);
        }
        //if not yet
        else{
            mainTextArea.setText(
                "Wild "+wildPokemon.getspecies()+" is attacking" 
                +"\n\n" + reserve.getname() + " HP is " + reserve.getcurhp()+"/" + reserve.getmaxhp()+" now!"
            );
            RemoveNextActionListener();
            if(turn < 1){
                battleNextButton.addActionListener(battleAttackNextPlayerAction);
                turn += 1;
            }
            else{
                battleNextButton.addActionListener(battleAttackNextMenuAction);
                turn = 0;
            }
        }
    }
    private void playerAttack(){
        TurnOffBattleMenu();
        battleNextButton.setVisible(true);
        wildPokemon.damagecal(reserve.getatk());
        //player's win case
        if(wildPokemon.getcurhp() <= 0){
            numreserve = items.getTotalItem();
            items.getitem();
            //all pokemon get exp if win battle
            for(Pokemon s : bags){
                s.expup(5*wildPokemon.getlvl());
            }
            if(items.getTotalItem() > numreserve){
                mainTextArea.setText("Wild "+wildPokemon.getspecies() + " is fainted!" +
                "\nYou've got items. Check them in your bag");
            }
            else{
                mainTextArea.setText("Wild "+wildPokemon.getspecies() + " is fainted!" + 
                "\nNo item gained.");
            }
            RemoveNextActionListener();
            battleNextButton.addActionListener(battleAttackNextFinishedAction);
        }
        //if not win yet
        else{
            mainTextArea.setText(
                reserve.getname() + " is attacking" 
                +"\n\n" + wildPokemon.getspecies() + " HP is " + wildPokemon.getcurhp() + "/" + wildPokemon.getmaxhp() + " now!\n"
            );
            RemoveNextActionListener();
            if(turn < 1){
                battleNextButton.addActionListener(battleAttackNextWildAction);
                turn += 1;
            }
            else{
                battleNextButton.addActionListener(battleAttackNextMenuAction);
                turn = 0;
            }
        } 
    }
    private void TurnOffBattleMenu(){
        battleAttackButton.setVisible(false);
        battlePotionButton.setVisible(false);
        battleSwitchButton.setVisible(false);
        battlePokeballButton.setVisible(false);   
    }
    private void TurnOnBattleMenu(){
        mainTextArea.setText(reserve.getname() + " HP : "+ reserve.getcurhp() + "/" + reserve.getmaxhp() + "   LVL : " + reserve.getlvl() +
        "\n\nWild " + wildPokemon.getspecies() + " HP : " + wildPokemon.getcurhp() + "/" + wildPokemon.getmaxhp() + "   LVL : " + wildPokemon.getlvl()
        );
        battleAttackButton.setVisible(true);
        battlePotionButton.setVisible(true);
        battleSwitchButton.setVisible(true);
        battlePokeballButton.setVisible(true);    
        PanelUpdate();
        RemoveReturnActionListener();
    }
    private void ComboboxUpdate(){
        selectComboBox.removeAllItems();
        for(i=0;i<bags.size();i++){
            selectComboBox.addItem(bags.get(i).getname());
        }
    }
    private void PanelUpdate(){
        playerItemLabel.setText(Integer.toString(items.getTotalItem()));
        playerPokemonLabel.setText(Integer.toString(bags.size()));
    }
    private void TurnOnMainMenu(){
        closeButton.setVisible(true);
        statButton.setVisible(true);
        restButton.setVisible(true);
        battleButton.setVisible(true);
        itemButton.setVisible(true);
        PanelUpdate();
        mainTextArea.setText("What do you want to do?");    
    }
    private void TurnOffMainMenu(){
        statButton.setVisible(false);
        restButton.setVisible(false);
        battleButton.setVisible(false);
        itemButton.setVisible(false);   
        closeButton.setVisible(false);
    }
    private void TurnOffSelectButton(){
        selectButton.setVisible(false);
        selectComboBox.setVisible(false);
    }
    private void TurnOnSelectButton(){
        ComboboxUpdate();
        selectButton.setVisible(true);
        selectComboBox.setVisible(true);
    }
    private void RemoveNextActionListener(){
        for( ActionListener listener : battleNextButton.getActionListeners() ) {
            battleNextButton.removeActionListener(listener);
        }
    }
    private void RemoveReturnActionListener(){
        for( ActionListener listener : returnButton.getActionListeners() ) {
            returnButton.removeActionListener(listener);
        }
    }
    private void RemoveComboActionListener(){
        for( ActionListener listener : selectButton.getActionListeners() ) {
            selectButton.removeActionListener(listener);
        }
    }
}