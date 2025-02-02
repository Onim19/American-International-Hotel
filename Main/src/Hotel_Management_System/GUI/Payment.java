package Hotel_Management_System.GUI;

import Hotel_Management_System.Person.Details.GuestDetails;
import Hotel_Management_System.Room.RoomDetails.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

public class Payment implements ActionListener {
    JFrame fm;
    JLabel image,payment_Label;
    JButton confirmPaymentButton,homeButton;
    GuestDetails guest;
    double price,service;

    public Payment(GuestDetails guest,double price,double service){
        this.guest=guest;
        this.price=price;
        this.service=service;

        fm=new JFrame();
        fm.getContentPane().setBackground(Color.LIGHT_GRAY);
        fm.setSize(1280,720);
        fm.setLocationRelativeTo(null);
        fm.setLayout(null);
        ImageIcon icon=new ImageIcon("src/img/Icon.png");
        fm.setResizable(false);
        fm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fm.setIconImage(icon.getImage());

        // Adding Background Image
        ImageIcon image1=new ImageIcon("src/img/Payment.jpg");
        Image image2=image1.getImage().getScaledInstance(1280,720,Image.SCALE_DEFAULT);
        ImageIcon image3=new ImageIcon(image2);

        image=new JLabel(image3);
        image.setBounds(0,0,1280,720);
        fm.add(image);
        payment_Label=new JLabel("Payment Details");
        payment_Label.setFont(new Font("Arial",Font.BOLD,32));
        payment_Label.setBounds(400,50,400,40);
        payment_Label.setForeground(Color.WHITE);
        image.add(payment_Label);
        double service_cost= guest.getPayment()-(price*guest.getStayingDay());

        addLabelWithBackground("Name:", guest.getName(), 150, 150);
        addLabelWithBackground("Room Number:", guest.getRoom(), 150, 200);
        addLabelWithBackground("Room Type:", guest.getType(), 150, 250);
        addLabelWithBackground("Room Price:", price+" Taka", 150, 300);
        addLabelWithBackground("Services cost:", service_cost+" Taka", 150, 350);
        addLabelWithBackground("Staying Duration:", (int)guest.getStayingDay()+" Day/s", 150, 400);
        addLabelWithBackground("Total:", guest.getPayment()+" TAKA", 150, 450);

        confirmPaymentButton=new JButton("Confirm Payment");
        confirmPaymentButton.setFont(new Font("Arial",Font.BOLD,20));
        confirmPaymentButton.setBounds(400,550,250,50);
        confirmPaymentButton.setBackground(Color.BLUE);
        confirmPaymentButton.setForeground(Color.white);
        confirmPaymentButton.setFocusable(false);
        confirmPaymentButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        confirmPaymentButton.addActionListener(this);
        image.add(confirmPaymentButton);

        homeButton=new JButton("BACK TO HOME");
        homeButton.setFont(new Font("Arial",Font.BOLD,20));
        homeButton.setBounds(400,620,250,50);
        homeButton.setBackground(Color.BLUE);
        homeButton.setForeground(Color.white);
        homeButton.setFocusable(false);
        homeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        homeButton.addActionListener(this);
        image.add(homeButton);

        fm.setVisible(true);
    }

    private void addLabelWithBackground(String title, String value, int x, int y){
        JLabel label=new JLabel(title);
        label.setFont(new Font("Arial",Font.BOLD,22));
        label.setBounds(x,y,200,30);
        label.setForeground(Color.white);
        image.add(label);

        JLabel valueLabel=new JLabel(value);
        valueLabel.setFont(new Font("Arial",Font.PLAIN,22));
        valueLabel.setBounds(x+200,y,400,30);
        valueLabel.setOpaque(true);
        valueLabel.setBackground(Color.WHITE);
        image.add(valueLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==confirmPaymentButton){
            int response=JOptionPane.showConfirmDialog(fm,"Payment Confirmed!\nTotal: "+guest.getPayment()+" TAKA","Payment Success",JOptionPane.YES_NO_OPTION);
            if(response==JOptionPane.YES_OPTION){

                try{
                    FileWriter writer=new FileWriter("src/Hotel_Management_System/Person/Details/TextFiles/GuestDetails.txt",true);
                    writer.write(guest.getRoom()+","+guest.getType()+","+guest.getName()+","+guest.getAge()+","+guest.getGender()+","+guest.getJob()+","+guest.getContact()
                            +","+(int)guest.getStayingDay()+"Day/s"+","+guest.getPayment()+"\n");
                    writer.close();
                    if(guest.getType().equals("GENERAL/SINGLE") || guest.getType().equals("GENERAL/DOUBLE")){
                        new GeneralRoom(guest.getRoom(),guest.getType()).updateStatusToOccupied(guest.getRoom(),guest.getType());
                        fm.dispose();
                        new Welcome();
                    }
                    else if(guest.getType().equals("PREMIUM/SINGLE") || guest.getType().equals("PREMIUM/DOUBLE")){
                        new PremiumRoom(guest.getRoom(),guest.getType()).updateStatusToOccupied(guest.getRoom(),guest.getType());
                        fm.dispose();
                        new Welcome();
                    }
                    else if(guest.getType().equals("VIP/SINGLE") || guest.getType().equals("VIP/DOUBLE")){
                        new VipRoom(guest.getRoom(),guest.getType()).updateStatusToOccupied(guest.getRoom(),guest.getType());
                        fm.dispose();
                        new Welcome();
                    }
                    JOptionPane.showMessageDialog(fm,"Registration Successful!");
                }catch(IOException io){
                    io.printStackTrace();
                }
            }
        }
        else if(e.getSource()==homeButton){
            int res=JOptionPane.showConfirmDialog(null,"Cancel Payment?","Home",JOptionPane.YES_NO_OPTION);
            if(res==JOptionPane.YES_OPTION){
                fm.dispose();
                new Welcome();
            }
        }
    }
}
