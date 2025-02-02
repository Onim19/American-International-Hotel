package Hotel_Management_System.GUI;

import javax.swing.*;

public class Intro extends JFrame {
    public Intro(){

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("img/splash.gif"));
        JLabel label = new JLabel(imageIcon);
        label.setBounds(0,0,498,374);
        add(label);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        setTitle("Intro");
        ImageIcon icon=new ImageIcon("src/img/Icon.png");//Icon
        setIconImage(icon.getImage());
        setLayout(null);
        setSize(498,374);
        setLocationRelativeTo(null);
        setVisible(true);
        try{
            Thread.sleep(2150);
            new Welcome();
            setVisible(false);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
