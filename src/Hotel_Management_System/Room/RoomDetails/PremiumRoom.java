package Hotel_Management_System.Room.RoomDetails;
import Hotel_Management_System.Person.*;
import Hotel_Management_System.Room.*;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.io.*;

public class GeneralRoom {
    public GeneralRoom(){
        Admin_Frame();
    }
    public GeneralRoom(JFrame x){
        Guest_Frame("General",x);
    }
    public GeneralRoom(String room,String type){
    }

    public boolean updateStatusToOccupied(String room,String Type){
        File file=new File("src/Hotel_Management_System/Room/RoomDetails/RoomTextFiles/GeneralRoom.txt");
        String[][]data;

        //counting lines
        int countLine=0;
        try(BufferedReader reader=new BufferedReader(new FileReader(file))){
            while(reader.readLine()!=null){
                countLine++;
            }
        }
        catch (IOException e){
            e.printStackTrace();
            return false;
        }
        data=new String[countLine][4];
        boolean found=false;
        try(BufferedReader reader=new BufferedReader(new FileReader(file))){
            String lines;
            int i=0;
            while((lines=reader.readLine())!=null){
                String[] parts= lines.split(",");
                if(parts.length==4){
                    if(parts[0].equals(room) && parts[1].equals(Type) && parts[3].equals("AVAILABLE")){
                        System.out.println("Room found and updating: " + parts[0]); // Debug log
                        parts[3]="OCCUPIED";
                        found=true;
                    }
                    data[i]=parts;
                    i++;
                }
            }
        } catch (IOException ae){
            ae.printStackTrace();
        }

        //now it will update the data into the text file
        if(found){
            try(BufferedWriter writer=new BufferedWriter(new FileWriter(file))){
                for(int i=0;i<countLine;i++){
                    writer.write(data[i][0] + "," + data[i][1] + "," + data[i][2] + "," + data[i][3]);
                    writer.newLine();
                }
                System.out.println("File updated successfully.");
                return true;
            }
            catch (IOException a){
                a.printStackTrace();
                return false;
            }
        }else {
            JOptionPane.showMessageDialog(null,"Failed");
            return false;
        }
    }

    public void Admin_Frame(){
        JFrame fm = new JFrame("General Room Details");
        fm.getContentPane().setBackground(Color.WHITE);
        fm.setSize(720, 580);
        fm.setLocationRelativeTo(null);
        fm.setLayout(null);
        ImageIcon icon = new ImageIcon("src/img/Icon.png"); // Icon
        fm.setIconImage(icon.getImage());
        fm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fm.setResizable(false);

        // Adding Background Image
        ImageIcon image1=new ImageIcon("src/img/GeneralRoom.jpg");
        Image image2=image1.getImage().getScaledInstance(720,580,Image.SCALE_DEFAULT);
        ImageIcon image3=new ImageIcon(image2);

        JLabel image=new JLabel(image3);
        image.setBounds(0,0,720,580);
        fm.add(image);

        //adding table
        String[]col={"Room No.","Type","Cleaning Status","Availability"};
        String[][]row;
        try{
            File file = new File("src/Hotel_Management_System/Room/RoomDetails/RoomTextFiles/GeneralRoom.txt");
            if (!file.exists()) {
                JOptionPane.showMessageDialog(null, "Rooms not added yet", "Error", JOptionPane.ERROR_MESSAGE);
                row = new String[0][col.length];
            }
            int availableRooms=0;
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == col.length){
                    availableRooms++;
                }
            }
            reader.close();
            row = new String[availableRooms][col.length];
            reader = new BufferedReader(new FileReader(file));
            int i = 0;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == col.length) {
                    row[i] = parts;
                    i++;
                }
            }
            reader.close();
            //creating table
            DefaultTableModel model=new DefaultTableModel(row,col){
                @Override
                public boolean isCellEditable(int row, int column) {
                    return column>0;
                }
            };
            JTable table = new JTable(model);
            table.setRowHeight(50);
            table.setBackground(Color.WHITE);

            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            for (int j = 0; j < table.getColumnCount(); j++) {
                table.getColumnModel().getColumn(j).setCellRenderer(centerRenderer);
            }

            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            table.getColumnModel().getColumn(0).setPreferredWidth(100);
            table.getColumnModel().getColumn(1).setPreferredWidth(140);
            table.getColumnModel().getColumn(2).setPreferredWidth(100);
            table.getColumnModel().getColumn(3).setPreferredWidth(140);

            //adding table to Scroll
            JScrollPane scroll = new JScrollPane(table);
            scroll.setBounds(180, 50, 500, 400);
            image.add(scroll);
            //adding a save change button
            JButton save=new JButton("Save Changes");
            save.setBounds(30, 200, 120, 40);
            save.addActionListener(e->{
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    for (int r = 0; r < model.getRowCount(); r++) {
                        writer.write(model.getValueAt(r, 0) + "," +
                                model.getValueAt(r, 1) + "," +
                                model.getValueAt(r, 2) + "," +
                                model.getValueAt(r, 3));
                        writer.newLine();
                    }
                    JOptionPane.showMessageDialog(null, "Room details updated successfully!");
                }
                catch (IOException x){
                    x.printStackTrace();
                }
            });
            JButton back=new JButton("Back");
            back.setBounds(30, 260, 120, 40);
            back.addActionListener(e->{
                fm.dispose();
                new Room();
            });
            image.add(back);
            image.add(save);
            fm.setVisible(true);
        }
        catch(IOException ae){
            ae.printStackTrace();
        }
    }

    public JScrollPane Guest_Frame(String roomType,JFrame fm) {
        String[] col = {"Room No.","Type","Cleaning Status","Availability"};
        String[][] row;
        try {
            File file = new File("src/Hotel_Management_System/Room/RoomDetails/RoomTextFiles/GeneralRoom.txt");
            if (!file.exists()) {
                JOptionPane.showMessageDialog(null, "Rooms not added yet", "Error", JOptionPane.ERROR_MESSAGE);
                row = new String[0][col.length];
            }
            int availableRooms=0;
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == col.length && parts[2].equals("CLEANED") && parts[3].equals("AVAILABLE")){
                    availableRooms++;
                }
            }
            reader.close();
            row = new String[availableRooms][col.length];
            reader = new BufferedReader(new FileReader(file));
            int i = 0;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == col.length && parts[2].equals("CLEANED") && parts[3].equals("AVAILABLE")) {
                    row[i] = parts;
                    i++;
                }
            }
            reader.close();
            //creating table
            JTable table = new JTable(new DefaultTableModel(row, col));
            table.setRowHeight(50);
            table.setBackground(Color.WHITE);

            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            for (int j = 0; j < table.getColumnCount(); j++) {
                table.getColumnModel().getColumn(j).setCellRenderer(centerRenderer);
            }

            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            table.getColumnModel().getColumn(0).setPreferredWidth(100);
            table.getColumnModel().getColumn(1).setPreferredWidth(200);
            table.getColumnModel().getColumn(2).setPreferredWidth(100);
            table.getColumnModel().getColumn(3).setPreferredWidth(180);

            //adding a table listener to assume data from user
            table.getSelectionModel().addListSelectionListener(e -> {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow >= 0) {
                        String roomNo = (String) table.getValueAt(selectedRow, 0);
                        String type = (String) table.getValueAt(selectedRow, 1);
                        String cleaningStatus = (String) table.getValueAt(selectedRow, 2);
                        String bookingStatus = (String) table.getValueAt(selectedRow, 3);

                        int response=JOptionPane.showConfirmDialog(fm,
                                "Selected Room: " + roomNo + "\nType: " + type + "\nCleaning: " + cleaningStatus + "\nBooking: " + bookingStatus + "\nConfirm?",
                                "Room Details", JOptionPane.YES_NO_OPTION);
                        if(response==JOptionPane.YES_OPTION){
                            if(type.equals("GENERAL/SINGLE")){
                                fm.dispose();
                                new GuestRegistration(roomNo,"GENERAL/SINGLE",1500.0);
                            }
                            else if(type.equals("GENERAL/DOUBLE")){
                                fm.dispose();
                                new GuestRegistration(roomNo,"GENERAL/DOUBLE",2000.0);
                            }
                        }
                    }
                }
            });
            JScrollPane scroll = new JScrollPane(table);
            scroll.setBounds(600, 100, 600, 500);
            return scroll;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
