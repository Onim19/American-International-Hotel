package Hotel_Management_System.Service;

import Hotel_Management_System.GUI.BookRoom;
import Hotel_Management_System.GUI.Payment;
import Hotel_Management_System.Person.Details.GuestDetails;
import Hotel_Management_System.Person.GuestRegistration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Service implements ActionListener {
    JLabel services;
    JButton catering, laundry, gym;
    JButton bangla, chinese, thai;
    JButton confirm, cancel;
    JLabel clothes;
    JTextField noOfCloth;
    JButton wash;
    JLabel askHour;
    JTextField hours;
    JButton join;
    JFrame frame;
    GuestDetails guest;
    double price;
    int service_count=0;
    public Service(GuestDetails guest,double price) {
        this.guest=guest;
        this.price=price;

        frame = new JFrame("Services");
        frame.setSize(1280, 720);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon=new ImageIcon("src/img/Icon.png"); //Icon
        frame.setIconImage(icon.getImage()); //Adding icon
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adding Background Image
        ImageIcon image1=new ImageIcon("src/img/Service.jpg");
        Image image2=image1.getImage().getScaledInstance(1280,720,Image.SCALE_DEFAULT);
        ImageIcon image3=new ImageIcon(image2);

        JLabel image=new JLabel(image3);
        image.setBounds(0,0,1280,720);
        frame.add(image);

        Font font1 = new Font("Sherif", Font.BOLD, 35);
        Font font2 = new Font("Sherif", Font.PLAIN,35);

        // Services
        services = new JLabel("Services");
        services.setBounds(498,38,283,83);
        services.setFont(new Font("Sherif", Font.BOLD, 52));
        services.setForeground(Color.WHITE);
        image.add(services);

        // Button for Catering
        catering = new JButton("Catering");
        catering.setFocusable(false);
        catering.setBounds(72,184,496,108);
        catering.setBackground(Color.BLACK);
        catering.setForeground(Color.WHITE);
        catering.setFont(font1);
        catering.addActionListener(this);

        // Sub-button of catering
        bangla = new JButton("Bangla 300Tk");
        bangla.setFocusable(false);
        bangla.setFont(font2);
        bangla.setBounds(712,184,496,108);
        bangla.setForeground(Color.decode("#004aad"));
        bangla.addActionListener(this);
        image.add(bangla);
        bangla.setVisible(false);

        chinese = new JButton("Chinese 500Tk");
        chinese.setFocusable(false);
        chinese.setFont(font2);
        chinese.setBounds(712,326,496,108);
        chinese.setForeground(Color.decode("#004aad"));
        chinese.addActionListener(this);
        image.add(chinese);
        chinese.setVisible(false);

        thai = new JButton("Thai 800Tk");
        thai.setFocusable(false);
        thai.setFont(font2);
        thai.setBounds(712,476,496,108);
        thai.setForeground(Color.decode("#004aad"));
        thai.addActionListener(this);
        image.add(thai);
        thai.setVisible(false);

        // Button for laundry
        laundry = new JButton("Laundry");
        laundry.setFocusable(false);
        laundry.setBounds(72,330,496,108);
        laundry.setBackground(Color.BLACK);
        laundry.setForeground(Color.WHITE);
        laundry.setFont(font1);
        laundry.addActionListener(this);

        // No of clothes input
        clothes = new JLabel("Number of Clothes \nyou want to wash:");
        clothes.setBounds(700,182,550,104);
        clothes.setFont(new Font("Sherif", Font.BOLD, 30));
        clothes.setForeground(Color.WHITE);
        clothes.setVisible(false);
        image.add(clothes);

        noOfCloth = new JTextField();
        noOfCloth.setBounds(737,330,424,78);
        noOfCloth.setFont(new Font("Sherif", Font.PLAIN, 25));
        noOfCloth.setVisible(false);
        image.add(noOfCloth);

        wash = new JButton("Wash");
        wash.setFocusable(false);
        wash.setBounds(842,476,216,78);
        wash.setBackground(Color.BLACK);
        wash.setForeground(Color.WHITE);
        wash.setFont(new Font("Sherif", Font.PLAIN, 20));
        wash.addActionListener(this);
        wash.setVisible(false);
        image.add(wash);

        // GYM button
        gym = new JButton("GYM");
        gym.setFocusable(false);
        gym.setBounds(72,476,496,108);
        gym.setBackground(Color.BLACK);
        gym.setForeground(Color.WHITE);
        gym.setFont(font1);
        gym.addActionListener(this);

        // Ask you about gym session
        askHour = new JLabel("Hours of gym\n you want to gym:");
        askHour.setBounds(737,182,500,104);
        askHour.setFont(new Font("Sherif", Font.BOLD, 30));
        askHour.setForeground(Color.WHITE);
        askHour.setVisible(false);
        image.add(askHour);

        hours = new JTextField();
        hours.setBounds(737,330,424,78);
        hours.setFont(new Font("Sherif", Font.PLAIN, 25));
        hours.setVisible(false);
        image.add(hours);

        join = new JButton("Join");
        join.setFocusable(false);
        join.setBounds(842,476,216,78);
        join.setBackground(Color.BLACK);
        join.setForeground(Color.WHITE);
        join.setFont(new Font("Sherif", Font.PLAIN, 20));
        join.addActionListener(this);
        join.setVisible(false);
        image.add(join);


        // Add buttons with spacing between them
        image.add(catering);
        image.add(laundry);
        image.add(gym);

        // Confirm Button
        confirm = new JButton("Confirm");
        confirm.setFocusable(false);
        confirm.setBounds(350,620,250,60);
        confirm.setBackground(Color.decode("#008000")); // Green color
        confirm.setForeground(Color.WHITE);
        confirm.setFont(new Font("Sherif", Font.BOLD, 25));
        confirm.addActionListener(this);
        image.add(confirm);

        // Cancel Button
        cancel = new JButton("Cancel");
        cancel.setFocusable(false);
        cancel.setBounds(680,620,250,60);
        cancel.setBackground(Color.decode("#FF0000")); // Red color
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Sherif", Font.BOLD, 25));
        cancel.addActionListener(this);
        image.add(cancel);

        // Make the frame visible
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed( ActionEvent e ) {
        if(e.getSource() == catering) {
            askHour.setVisible(false);
            hours.setVisible(false);
            join.setVisible(false);

            clothes.setVisible(false);
            noOfCloth.setVisible(false);
            wash.setVisible(false);

            bangla.setVisible(true);
            chinese.setVisible(true);
            thai.setVisible(true);
        }
        if(e.getSource() == laundry) {
            bangla.setVisible(false);
            chinese.setVisible(false);
            thai.setVisible(false);

            askHour.setVisible(false);
            hours.setVisible(false);
            join.setVisible(false);

            clothes.setVisible(true);
            noOfCloth.setVisible(true);
            wash.setVisible(true);
        }
        if(e.getSource() == gym) {
            bangla.setVisible(false);
            chinese.setVisible(false);
            thai.setVisible(false);

            clothes.setVisible(false);
            noOfCloth.setVisible(false);
            wash.setVisible(false);

            askHour.setVisible(true);
            hours.setVisible(true);
            join.setVisible(true);
        }
        if(e.getSource()==bangla){
            int response=JOptionPane.showConfirmDialog(null,"Want to add Bangla Foods as services at 300 TAKA for "+(int)guest.getStayingDay()+"Day/s?","CONFIRM",JOptionPane.YES_NO_OPTION);
            if(response==JOptionPane.YES_OPTION){
                guest.setPaymentwService(300*2*guest.getStayingDay());//2 times meal for each day
                service_count++;
                JOptionPane.showMessageDialog(null,"Added Bangla foods");
            }
        }
        if(e.getSource()==chinese){
            int response=JOptionPane.showConfirmDialog(null,"Want to add Chinese Foods as services at 300 TAKA for "+(int)guest.getStayingDay()+"Day/s?","CONFIRM",JOptionPane.YES_NO_OPTION);
            if(response==JOptionPane.YES_OPTION){
                guest.setPaymentwService(500*2*guest.getStayingDay());//2 times meal for each day
                service_count++;
                JOptionPane.showMessageDialog(null,"Added Chinese foods");
            }
        }
        if(e.getSource()==thai){
            int response=JOptionPane.showConfirmDialog(null,"Want to add Thai Foods as services at 300 TAKA for "+(int)guest.getStayingDay()+"Day/s?","CONFIRM",JOptionPane.YES_NO_OPTION);
            if(response==JOptionPane.YES_OPTION){
                guest.setPaymentwService(800*2*guest.getStayingDay());//2 times meal for each day
                service_count++;
                JOptionPane.showMessageDialog(null,"Added Thai foods");
            }
        }
        if(e.getSource() == wash) {
            try {
                int number_clothes = Integer.parseInt(noOfCloth.getText());
                if(number_clothes <= 0) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number of clothes.");
                    return;
                }
                int response = JOptionPane.showConfirmDialog(null, "Per cloth wash 70 TAKA\nAdded " + number_clothes + " cloth/s", "CONFIRM", JOptionPane.YES_NO_OPTION);
                if(response == JOptionPane.YES_OPTION) {
                    guest.setPaymentwService(70 * number_clothes);
                    service_count++;
                    JOptionPane.showMessageDialog(null, "Added laundry");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number.");
            }
        }
        if(e.getSource() == join) {
            try {
                int gym_hours = Integer.parseInt(hours.getText());
                if(gym_hours <= 0) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number of hours.");
                    return;
                }
                int response = JOptionPane.showConfirmDialog(null, "Per hour gym 100TAKA\nAdded " + gym_hours + " hour/s", "CONFIRM", JOptionPane.YES_NO_OPTION);
                if(response == JOptionPane.YES_OPTION) {
                    guest.setPaymentwService(100 * gym_hours);
                    service_count++;
                    JOptionPane.showMessageDialog(null, "Added gym");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number.");
            }
        }
        if(e.getSource()==confirm){
            int response=JOptionPane.showConfirmDialog(null,"Are you sure?","CNFIRM",JOptionPane.YES_NO_OPTION);
            if(response==JOptionPane.YES_OPTION){
                frame.dispose();
                new Payment(guest,price,service_count);
            }
        }
        else if(e.getSource()==cancel){
            frame.dispose();
            new BookRoom();
        }
    }
}