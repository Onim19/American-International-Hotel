package Hotel_Management_System.GUI;
import Hotel_Management_System.Person.Admin;
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
        super.setLocation(150,50);
        super.setLayout(null);
        ImageIcon icon=new ImageIcon("src/img/Icon.png");//Icon
        ImageIcon image_background=new ImageIcon("src/img/Welcome.png");//image for background

        super.setResizable(false);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setIconImage(icon.getImage());
        super.setTitle("American International Hotel Service");//adding title for the project

        //adding a label for background
        JLabel L_Background=new JLabel(image_background);//label1 for adding image on background
        L_Background.setBounds(0,0,1280,720);
        super.add(L_Background);

        //adding BookRoom Button
        BookRoom=new JButton("Book Room");
        BookRoom.setBounds(450,580,200,50);
        BookRoom.setFocusable(false);
        BookRoom.setBackground(Color.RED);
        BookRoom.setForeground(Color.WHITE);
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
    }
    public static void main(String[] args) {
        new Welcome();
    }
}
