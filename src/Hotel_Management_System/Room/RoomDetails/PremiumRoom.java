package Hotel_Management_System.Room.RoomDetails;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.io.*;

public class PremiumRoom {
    public PremiumRoom(JFrame x){
            Guest_Frame("Premium",x);
    }
    public void Guest_Frame(String roomType,JFrame fm) {
        String[] col = {"Room No.","Type","Cleaning Status","Availability"};
        String[][] row;
        try {
            File file = new File("src/Hotel_Management_System/Room/RoomDetails/RoomTextFiles/PremiumRoom.txt");
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
            table.getColumnModel().getColumn(1).setPreferredWidth(100);
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
                            fm.dispose();
                            //add next frame with roomnumber parameter
                        }
                    }
                }
            });
            JScrollPane scroll = new JScrollPane(table);
            scroll.setBounds(700, 50, 500, 500);
            fm.add(scroll);
            fm.setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFrame fm = new JFrame();
        fm.getContentPane().setBackground(Color.WHITE);
        fm.setSize(1280, 720);
        fm.setLocation(150, 50);
        fm.setLayout(null);
        ImageIcon icon = new ImageIcon("src/img/Icon.png"); // Icon
        fm.setIconImage(icon.getImage());
        fm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fm.setResizable(false);
        new PremiumRoom(fm);
    }
}
