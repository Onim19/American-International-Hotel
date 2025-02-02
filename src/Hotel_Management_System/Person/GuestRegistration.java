package Hotel_Management_System.Person;

import Hotel_Management_System.GUI.*;
import Hotel_Management_System.Person.Details.GuestDetails;
import Hotel_Management_System.Service.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class GuestRegistration extends JFrame implements ActionListener {
    JLabel image,nameLabel, ageLabel, genderLabel, professionLabel, contactLabel, stayingDurationLabel;
    JTextField nameField, ageField, contactField,stayingDurationField;
    JRadioButton maleRadio, femaleRadio;
    ButtonGroup genderGroup;
    JComboBox<String> professionComboBox;
    JButton submitButton, backButton;
    GuestDetails guest;
    String room;
    double price;
    String type;

    Font font = new Font("Sherif", Font.PLAIN, 20);

    public GuestRegistration(String room, String type, double price) {

        // Initializing parameters
        this.room = room;
        this.price = price;
        this.type = type;

        // Frame adjustments
        this.getContentPane().setBackground(Color.decode("#5ce1e6"));
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        ImageIcon icon = new ImageIcon("src/img/Icon.png");
        this.setIconImage(icon.getImage());
        this.setTitle("Guest Registration");

        // Background Image
        ImageIcon image1 = new ImageIcon("src/img/Guest.jpg");
        Image image2 = image1.getImage().getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);

        image = new JLabel(image3);
        image.setBounds(0, 0, 1280, 720);
        super.add(image);

        JLabel addGuestLabel = new JLabel("Guest Registration");
        addGuestLabel.setBounds(420, 50, 607, 80);
        addGuestLabel.setFont(new Font("Sherif", Font.BOLD, 50));
        image.add(addGuestLabel);

        int centerX = 500; // Adjusting alignment towards the center
        int labelX = centerX - 180;
        int fieldX = centerX + 50;

        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(labelX, 180, 150, 30);
        nameLabel.setFont(new Font("Sherif", Font.BOLD, 22));
        image.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(fieldX, 180, 290, 30);
        image.add(nameField);

        ageLabel = new JLabel("Age:");
        ageLabel.setBounds(labelX, 230, 150, 30);
        ageLabel.setFont(new Font("Sherif", Font.BOLD, 22));
        image.add(ageLabel);

        ageField = new JTextField();
        ageField.setBounds(fieldX, 230, 290, 30);
        image.add(ageField);

        genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(labelX, 280, 150, 30);
        genderLabel.setFont(new Font("Sherif", Font.BOLD, 22));
        image.add(genderLabel);

        maleRadio = new JRadioButton("Male");
        maleRadio.setBounds(fieldX, 280, 80, 30);
        maleRadio.setFocusable(false);
        maleRadio.setBackground(Color.WHITE);
        maleRadio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        image.add(maleRadio);

        femaleRadio = new JRadioButton("Female");
        femaleRadio.setBounds(fieldX + 100, 280, 100, 30);
        femaleRadio.setFocusable(false);
        femaleRadio.setBackground(Color.WHITE);
        femaleRadio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        image.add(femaleRadio);

        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);

        professionLabel = new JLabel("Profession:");
        professionLabel.setBounds(labelX, 330, 150, 30);
        professionLabel.setFont(new Font("Sherif", Font.BOLD, 22));
        image.add(professionLabel);

        professionComboBox = new JComboBox<>(new String[]{"Doctor", "Engineer", "Teacher", "Banker", "Businessman", "Pilot", "Student"});
        professionComboBox.setBounds(fieldX, 330, 290, 30);
        professionComboBox.setBackground(Color.WHITE);
        professionComboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        image.add(professionComboBox);

        contactLabel = new JLabel("Contact:");
        contactLabel.setBounds(labelX, 380, 150, 30);
        contactLabel.setFont(new Font("Sherif", Font.BOLD, 22));
        image.add(contactLabel);

        contactField = new JTextField();
        contactField.setBounds(fieldX, 380, 290, 30);
        image.add(contactField);

        stayingDurationLabel = new JLabel("Staying Duration:");
        stayingDurationLabel.setBounds(labelX, 430, 200, 30);
        stayingDurationLabel.setFont(new Font("Sherif", Font.BOLD, 22));
        image.add(stayingDurationLabel);

        stayingDurationField = new JTextField();
        stayingDurationField.setBounds(fieldX, 430, 290, 30);
        image.add(stayingDurationField);

        // Centering Buttons
        int buttonX = centerX - 80;
        submitButton = new JButton("Submit");
        submitButton.setBounds(buttonX, 500, 120, 40);
        submitButton.setFocusable(false);
        submitButton.setBackground(Color.GREEN);
        submitButton.setForeground(Color.WHITE);
        submitButton.addActionListener(this);
        submitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        image.add(submitButton);

        backButton = new JButton("Back");
        backButton.setBounds(buttonX + 150, 500, 120, 40);
        backButton.setFocusable(false);
        backButton.setBackground(Color.RED);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        image.add(backButton);

        this.setVisible(true);
    }

    public void Register(String r,String t,double price) {
        String room=r;
        String type=t;
        String name=nameField.getText().toUpperCase();
        String age=ageField.getText();
        String gender=null;
        String job=((String)professionComboBox.getSelectedItem()).toUpperCase();
        String contact=contactField.getText();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name is empty!");
            nameField.requestFocus();
            return;
        }
        if(age.isEmpty() || !age.matches("\\d+")){
            JOptionPane.showMessageDialog(null,"Enter valid age");
            ageField.requestFocus();
            return;
        }
        if (maleRadio.isSelected()) {
            gender="MALE";
        } else if (femaleRadio.isSelected()) {
            gender="FEMALE";
        } else {
            JOptionPane.showMessageDialog(this, "Gender not selected!");
            return;
        }
        if (contact.length() != 11 || !contact.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Enter valid Phone");
            contactField.requestFocus();
            return;
        }

        if(stayingDurationField.getText().isEmpty() || !(stayingDurationField.getText().matches("\\d+"))){
            JOptionPane.showMessageDialog(null,"Enter staying duration");
            stayingDurationField.requestFocus();
            return;
        }
        double staying_day=Double.parseDouble(stayingDurationField.getText());
        double payment=staying_day*price;
        guest=new GuestDetails(room,type,name,age,gender,job,contact,payment,staying_day);
        int extra=JOptionPane.showConfirmDialog(this,"Want extra services?","Extra servies",JOptionPane.YES_NO_OPTION);
        if(extra==JOptionPane.YES_OPTION){
            this.dispose();
            new Service(guest,price);
        }
        else if(extra==JOptionPane.NO_OPTION){
            new Payment(guest,price,0.0);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            this.dispose();
            Register(room,type,price);
        } else if (e.getSource() == backButton) {
            this.dispose();
            new Welcome();
        }
    }
}