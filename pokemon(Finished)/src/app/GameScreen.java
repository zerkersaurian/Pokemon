package app;
import javax.swing.*;
import java.awt.*;
public abstract class GameScreen{
    protected JTextArea mainTextArea;
    protected JPanel mainTextPanel;
    protected Font normalFont = new Font("",Font.PLAIN,35);
    public GameScreen(Container c){
        
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(50,150,900,270);
        mainTextPanel.setBackground(Color.black);
        
        mainTextArea = new JTextArea("");
        mainTextArea.setBounds(50,150,900,270);
        mainTextArea.setLineWrap(true);
        mainTextArea.setFont(normalFont);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setEditable(false); 
        mainTextPanel.add(mainTextArea);
        
        c.add(mainTextPanel);
    }
}