package Hotel_Management_System.Person;

import Hotel_Management_System.GUI.*;
import Hotel_Management_System.Person.Details.*;
import Hotel_Management_System.Room.RoomDetails.*;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Guest extends JFrame implements ActionListener {
    JTable table;
    JScrollPane scroll;
    JLabel image,nameLabel, ageLabel, genderLabel, jobTitleLabel, stayingLabel, phoneLabel,roomLabel,roomTypeLabel;
    JTextField nameField, ageField, stayingField, phoneField,roomField;
    JRadioButton maleRadio, femaleRadio;
    ButtonGroup genderGroup;
    JComboBox<String> jobTitleComboBox,roomTypeComboBox;
    JButton submitButton, backButton;
    String[] col = {"ROOM NO.","ROOM TYPE", "NAME", "AGE", "GENDER", "JOB TITLE", "PHONE", "OCCUPIED","PAYMENT"};
    String[][] row;
    GuestDetails guest;

    public Guest() {
        super.getContentPane().setBackground(Color.WHITE);
        super.setSize(1280, 720);
        super.setLocation(150, 50);
        super.setLayout(null);
        ImageIcon icon = new ImageIcon("src/img/Icon.png");//Icon
        super.setIconImage(icon.getImage());
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setResizable(false);
        super.setTitle("Guest Details");

        //adding background
        ImageIcon image1=new ImageIcon("src/img/Employee.jpg");
        Image image2=image1.getImage().getScaledInstance(1280,720,Image.SCALE_DEFAULT);
        ImageIcon image3=new ImageIcon(image2);

        image=new JLabel(image3);
        image.setBounds(0,0,1280,720);
        super.add(image);

        //loading row data
        GuestData();

        //adding buttons and label for adding new employee
        JLabel addEmployeeLabel = new JLabel("Add Guest");
        addEmployeeLabel.setBounds(50, 100, 200, 50);
        addEmployeeLabel.setFont(new Font("Serif", Font.BOLD, 30));
        image.add(addEmployeeLabel);


        nameLabel = new JLabel("Name: ");
        nameLabel.setBounds(50, 170, 100, 30);
        nameLabel.setFont(new Font("Serif", Font.BOLD, 16));
        image.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(170, 170, 250, 30);
        image.add(nameField);

        ageLabel = new JLabel("Age: ");
        ageLabel.setBounds(50, 210, 100, 30);
        ageLabel.setFont(new Font("Serif", Font.BOLD, 16));
        image.add(ageLabel);

        ageField = new JTextField();
        ageField.setBounds(170, 210, 250, 30);
        image.add(ageField);

        genderLabel = new JLabel("Gender: ");
        genderLabel.setBounds(50, 250, 100, 30);
        genderLabel.setFont(new Font("Serif", Font.BOLD, 16));
        image.add(genderLabel);

        maleRadio = new JRadioButton("Male");
        maleRadio.setBounds(170, 250, 70, 30);
        maleRadio.setFocusable(false);
        maleRadio.setBackground(Color.white);
        femaleRadio = new JRadioButton("Female");
        femaleRadio.setBounds(250, 250, 90, 30);
        femaleRadio.setBackground(Color.white);
        femaleRadio.setFocusable(false);

        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);

        image.add(maleRadio);
        image.add(femaleRadio);

        jobTitleLabel = new JLabel("Job Title: ");
        jobTitleLabel.setBounds(50, 290, 100, 30);
        jobTitleLabel.setFont(new Font("Serif", Font.BOLD, 16));
        image.add(jobTitleLabel);

        jobTitleComboBox = new JComboBox<>(new String[]{"DOCTOR", "ENGINEER", "TEACHER", "BANKER", "BUSINESSMAN", "PILOT", "STUDENT"});
        jobTitleComboBox.setBounds(170, 290, 250, 30);
        jobTitleComboBox.setBackground(Color.WHITE);
        image.add(jobTitleComboBox);

        phoneLabel = new JLabel("Phone: ");
        phoneLabel.setBounds(50, 330, 100, 30);
        phoneLabel.setFont(new Font("Serif", Font.BOLD, 16));
        image.add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(170, 330, 250, 30);
        image.add(phoneField);

        stayingLabel = new JLabel("Staying duration: ");
        stayingLabel.setBounds(50, 370, 120, 30);
        stayingLabel.setFont(new Font("Serif", Font.BOLD, 16));
        image.add(stayingLabel);

        stayingField = new JTextField();
        stayingField.setBounds(170, 370, 250, 30);
        image.add(stayingField);

        roomLabel = new JLabel("Room no: ");
        roomLabel.setBounds(50, 410, 100, 30);
        roomLabel.setFont(new Font("Serif", Font.BOLD, 16));
        image.add(roomLabel);

        roomField = new JTextField();
        roomField.setBounds(170, 410, 250, 30);
        image.add(roomField);

        roomTypeLabel = new JLabel("Room Type: ");
        roomTypeLabel.setBounds(50, 450, 100, 30);
        roomTypeLabel.setFont(new Font("Serif", Font.BOLD, 16));
        image.add(roomTypeLabel);

        roomTypeComboBox = new JComboBox<>(new String[]{"VIP/SINGLE", "VIP/DOUBLE", "GENERAL/SINGLE", "GENERAL/DOUBLE", "PREMIUM/SINGLE", "PREMIUM/DOUBLE"});
        roomTypeComboBox.setBounds(170, 450, 250, 30);
        roomTypeComboBox.setBackground(Color.WHITE);
        image.add(roomTypeComboBox);

        // Submit Button for adding employee
        submitButton = new JButton("Submit");
        submitButton.setBounds(170, 490, 100, 30);
        submitButton.setFocusable(false);
        submitButton.setBackground(Color.WHITE);
        submitButton.setForeground(Color.BLACK);
        submitButton.addActionListener(this);
        image.add(submitButton);

        backButton = new JButton("Back");
        backButton.setBounds(290, 490, 100, 30);
        backButton.setFocusable(false);
        backButton.setBackground(Color.WHITE);
        backButton.setForeground(Color.BLACK);
        backButton.addActionListener(this);
        image.add(backButton);
        super.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            AddGuest();
        } else if (e.getSource() == backButton) {
            super.dispose();
            new AdminDashBoard();
        }
    }

    public void AddGuest() {
        String name=nameField.getText().toUpperCase();
        String age=ageField.getText();
        String gender=null;
        String job=((String)jobTitleComboBox.getSelectedItem());
        String contact=phoneField.getText();

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
            phoneField.requestFocus();
            return;
        }

        if(stayingField.getText().isEmpty() || !(stayingField.getText().matches("\\d+"))){
            JOptionPane.showMessageDialog(null,"Enter staying duration");
            stayingField.requestFocus();
            return;
        }
        double staying_day=Double.parseDouble(stayingField.getText());
        double price=0.0;
        String room=roomField.getText();
        String type=(String)roomTypeComboBox.getSelectedItem();
        if(room.isEmpty() || !room.matches("\\d+")){
            JOptionPane.showConfirmDialog(null,"Enter room number");
            roomField.requestFocus();
            return;
        }
        boolean isBooked=false;

        if(type.equals("VIP/DOUBLE")){
            price=8000.0;
            isBooked=new VipRoom(room,type).updateStatusToOccupied(room,type);
            if(!isBooked){
                return;
            }
        }
        else if(type.equals("VIP/SINGLE")){
            price=6000.0;
            isBooked=new VipRoom(room,type).updateStatusToOccupied(room,type);
            if(!isBooked){
                return;
            }
        }
        else if(type.equals("GENERAL/DOUBLE")){
            price=2000.0;
            isBooked=new GeneralRoom(room,type).updateStatusToOccupied(room,type);
            if(!isBooked){
                return;
            }
        }
        else if(type.equals("GENERAL/SINGLE")){
            price=1500.0;
            isBooked=new GeneralRoom(room,type).updateStatusToOccupied(room,type);
            if(!isBooked){
                return;
            }
        }
        else if(type.equals("PREMIUM/DOUBLE")){
            price=5000.0;
            isBooked=new PremiumRoom(room,type).updateStatusToOccupied(room,type);
            if(!isBooked){
                return;
            }
        }
        else if(type.equals("PREMIUM/SINGLE")){
            price=3500.0;
            isBooked=new PremiumRoom(room,type).updateStatusToOccupied(room,type);
            if(!isBooked){
                return;
            }
        }
        double payment=staying_day*price;
        guest = new GuestDetails(room, type, name, age, gender, job, contact, payment, staying_day);
        try {
            FileWriter writer = new FileWriter("src/Hotel_Management_System/Person/Details/TextFiles/GuestDetails.txt", true);
            writer.write(guest.getRoom() + "," + guest.getType() + "," + guest.getName() + "," + guest.getAge() + "," + guest.getGender() + "," + guest.getJob() + "," + guest.getContact()
                    + "," + (int) guest.getStayingDay() + "Day/s" + "," + guest.getPayment() + "\n");
            writer.close();
            JOptionPane.showMessageDialog(this, "Registration Successful!");
            GuestData();
        } catch (IOException io) {
            io.printStackTrace();
        }

    }

    public void GuestData(){
        try {
            File file = new File("src/Hotel_Management_System/Person/Details/TextFiles/GuestDetails.txt");
            if (!file.exists()) {
                JOptionPane.showMessageDialog(this, "No guest is registered", "ERROR", JOptionPane.ERROR_MESSAGE);
                row = new String[0][col.length];
                return;
            }

            int lines = 0;
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while (reader.readLine() != null) {
                lines++;
            }
            reader.close();

            row = new String[lines][col.length];
            reader = new BufferedReader(new FileReader(file));
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == col.length) {
                    row[i] = parts;
                    i++;
                }
            }
            reader.close();

            // Create or update the table with the new data
            DefaultTableModel model=new DefaultTableModel(row,col){
                @Override
                public boolean isCellEditable(int row, int column) {
                    return column>0;
                }
            };

            if (table == null) {
                table = new JTable(model);
            } else {
                table.setModel(model);
            }

            table.setRowHeight(50);
            table.setBackground(Color.WHITE);

            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            for (int j = 0; j < table.getColumnCount(); j++) {
                table.getColumnModel().getColumn(j).setCellRenderer(centerRenderer);
            }
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            table.getColumnModel().getColumn(0).setPreferredWidth(80);
            table.getColumnModel().getColumn(1).setPreferredWidth(110);
            table.getColumnModel().getColumn(2).setPreferredWidth(140);
            table.getColumnModel().getColumn(3).setPreferredWidth(40);
            table.getColumnModel().getColumn(4).setPreferredWidth(70);
            table.getColumnModel().getColumn(5).setPreferredWidth(100);
            table.getColumnModel().getColumn(6).setPreferredWidth(80);
            table.getColumnModel().getColumn(7).setPreferredWidth(80);
            table.getColumnModel().getColumn(8).setPreferredWidth(82);

            if (scroll != null) {
                scroll.setViewportView(table);
            } else {
                scroll = new JScrollPane(table);
                scroll.setBounds(450, 50, 800, 500);
                image.add(scroll);
            }
            //adding button for update details
            JButton save=new JButton("Save Changes");
            save.setBounds(740,600, 120, 40);
            save.addActionListener(e->{
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    for (int r = 0; r < model.getRowCount(); r++) {
                        writer.write(model.getValueAt(r, 0) + "," +
                                model.getValueAt(r, 1) + "," +
                                model.getValueAt(r, 2) + "," +
                                model.getValueAt(r, 3) + "," +
                                model.getValueAt(r, 4) + "," +
                                model.getValueAt(r, 5) + "," +
                                model.getValueAt(r, 6) + "," +
                                model.getValueAt(r, 7) + "," +
                                model.getValueAt(r, 8));
                        writer.newLine();
                    }
                    JOptionPane.showMessageDialog(null, "Guest details updated successfully!");
                }
                catch (IOException x){
                    x.printStackTrace();
                }
            });
            image.add(save);

            //adding a delete option
            JButton deleteButton=new JButton("Delete");
            deleteButton.setBounds(880,600,120,40);
            deleteButton.addActionListener(e->{
                int selectedRow=table.getSelectedRow();
                if(selectedRow==-1){
                    JOptionPane.showMessageDialog(null,"Select a row to delete!","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int confirm=JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this guest member?","Confirm Delete",JOptionPane.YES_NO_OPTION);
                if(confirm==JOptionPane.YES_OPTION){
                    deleteGuest(selectedRow);
                }
            });
            image.add(deleteButton);
        } catch (IOException ae) {
            ae.printStackTrace();
        }
    }

    public void deleteGuest(int rowIndex){
        File file=new File("src/Hotel_Management_System/Person/Details/TextFiles/GuestDetails.txt");
        try(BufferedReader reader=new BufferedReader(new FileReader(file));
            BufferedWriter writer=new BufferedWriter(new FileWriter("src/Hotel_Management_System/Person/Details/TextFiles/temp.txt"))){
            String line;int currentIndex=0;
            while((line=reader.readLine())!=null){
                if(currentIndex!=rowIndex){
                    writer.write(line);
                    writer.newLine();
                }
                currentIndex++;
            }
        }catch(IOException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Error deleting guest","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        File originalFile=new File("src/Hotel_Management_System/Person/Details/TextFiles/GuestDetails.txt");
        File tempFile=new File("src/Hotel_Management_System/Person/Details/TextFiles/temp.txt");
        if(originalFile.delete()&&tempFile.renameTo(originalFile)){
            JOptionPane.showMessageDialog(this,"Guest deleted successfully!");
            GuestData();
        }else{
            JOptionPane.showMessageDialog(this,"Error updating file","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}