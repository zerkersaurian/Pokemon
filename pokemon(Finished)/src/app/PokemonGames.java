package app;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PokemonGames {
    JFrame window;
    Container c;
    JButton startButton;
    JLabel startTitleLabel;

    Font titleFont = new Font("",Font.PLAIN,155);
    Font startButtonFont = new Font("",Font.PLAIN,50);
    Font normalFont = new Font("",Font.PLAIN,40);

    public static void main(String args[]){
        new PokemonGames();
    }
    public PokemonGames(){

        window = new JFrame("Pokemon Java");
        c = window.getContentPane();
        window.setSize(1000,800);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        
        startTitleLabel = new JLabel("Pokemon");
        startTitleLabel.setBounds(150,150,700,250);
        startTitleLabel.setForeground(Color.white);
        startTitleLabel.setFont(titleFont);
        
        startButton = new JButton("Start");
        startButton.setBounds(400,500,170,100);
        startButton.setFont(startButtonFont);
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                startButton.setVisible(false);
                startTitleLabel.setVisible(false);
                new Starting(c);
            }
        });
        
        c.add(startTitleLabel);
        c.add(startButton);
        window.setVisible(true);
        
        //after Starting is finished
    
    }
    
}