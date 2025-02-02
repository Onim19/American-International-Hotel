package Hotel_Management_System.GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Welcome extends JFrame implements ActionListener{
    JButton BookRoom;
    JMenuBar menu;
    JMenu Admin;
    JMenuItem login;
    public Welcome(){
        //frame creating
        //basic background setting
        super.setSize(1280,720);
        super.setLocationRelativeTo(null);
        super.setLayout(null);
        ImageIcon icon=new ImageIcon("src/img/Icon.png");//Icon
        ImageIcon image_background1=new ImageIcon("src/img/Welcome.jpg");//image for background
        Image image_background2=image_background1.getImage().getScaledInstance(1280,720,Image.SCALE_DEFAULT);
        ImageIcon image_background=new ImageIcon(image_background2);
        super.setResizable(false);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setIconImage(icon.getImage());
        super.setTitle("American International Hotel Service");//adding title for the project

        //adding a label for background
        JLabel L_Background=new JLabel(image_background);//label1 for adding image on background
        L_Background.setBounds(0,0,1280,720);
        super.add(L_Background);

        ImageIcon gif1=new ImageIcon("src/img/gif.gif");
        Image gif2=gif1.getImage().getScaledInstance(455,304,Image.SCALE_DEFAULT);
        ImageIcon gif3=new ImageIcon(gif2);
        JLabel gif=new JLabel(gif3);
        gif.setBounds(770,70,455,304);
        L_Background.add(gif);


        //adding BookRoom Button
        BookRoom=new JButton("Book Room");
        BookRoom.setBounds(200,580,200,50);
        BookRoom.setFocusable(false);
        BookRoom.setBackground(Color.RED);
        BookRoom.setForeground(Color.WHITE);
        BookRoom.addActionListener(this);
        BookRoom.setFont(new Font("Alice",Font.BOLD,25));
        L_Background.add(BookRoom);

        //adding menu bar
        menu=new JMenuBar();
        menu.setBounds(0,0,1280,25);
        menu.setBackground(Color.WHITE);
        L_Background.add(menu);

        Admin=new JMenu("ADMIN");
        Admin.setForeground(Color.RED);
        menu.add(Admin);

        login=new JMenuItem("Log in");
        Admin.add(login);
        login.addActionListener(this);
        super.setVisible(true);

    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()== login){
            super.dispose();
            new Admin();
        }
        else if(e.getSource()==BookRoom){
            super.dispose();
            new BookRoom();
        }
    }
}
