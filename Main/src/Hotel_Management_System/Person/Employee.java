package Hotel_Management_System.Person;

import Hotel_Management_System.GUI.*;
import Hotel_Management_System.Person.Details.*;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;

public class Employee extends JFrame implements ActionListener{
    JTable table;
    JScrollPane scroll;
    JLabel image;
    JLabel nameLabel,ageLabel,genderLabel,jobTitleLabel,salaryLabel,phoneLabel;
    JTextField nameField,ageField,salaryField,phoneField;
    JRadioButton maleRadio,femaleRadio;
    ButtonGroup genderGroup;
    JComboBox<String> jobTitleComboBox;
    JButton submitButton,backButton;
    String[]col={"ID","NAME","AGE","GENDER","JOB TITLE","SALARY","PHONE"};
    String[][]row;
    EmployeeDetails employee;
    public Employee(){
        super.getContentPane().setBackground(Color.WHITE);
        super.setSize(1280, 720);
        super.setLocationRelativeTo(null);
        super.setLayout(null);
        ImageIcon icon=new ImageIcon("src/img/Icon.png");//Icon
        super.setIconImage(icon.getImage());
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setResizable(false);
        super.setTitle("EMPLOYEE");

        // Adding Background Image
        ImageIcon image1=new ImageIcon("src/img/Employee.jpg");
        Image image2=image1.getImage().getScaledInstance(1280,720,Image.SCALE_DEFAULT);
        ImageIcon image3=new ImageIcon(image2);

        image=new JLabel(image3);
        image.setBounds(0,0,1280,720);
        super.add(image);

        //loading row data
        EmployeeData();

        //adding buttons and label for adding new employee
        JLabel addEmployeeLabel = new JLabel("Add Employee");
        addEmployeeLabel.setBounds(50, 100, 200, 50);
        addEmployeeLabel.setFont(new Font("Serif", Font.BOLD, 30));
        image.add(addEmployeeLabel);

        nameLabel = new JLabel("Name: ");
        nameLabel.setBounds(50, 170, 100, 30);
        nameLabel.setFont(new Font("Serif", Font.BOLD, 16));
        image.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 170, 250, 30);
        image.add(nameField);

        ageLabel = new JLabel("Age: ");
        ageLabel.setBounds(50, 210, 100, 30);
        ageLabel.setFont(new Font("Serif",Font.BOLD,16));
        image.add(ageLabel);

        ageField = new JTextField();
        ageField.setBounds(150, 210, 250, 30);
        image.add(ageField);

        genderLabel = new JLabel("Gender: ");
        genderLabel.setBounds(50, 250, 100, 30);
        genderLabel.setFont(new Font("Serif", Font.BOLD, 16));
        image.add(genderLabel);

        maleRadio = new JRadioButton("Male");
        maleRadio.setBounds(150, 250, 70, 30);
        maleRadio.setFocusable(false);
        maleRadio.setBackground(Color.white);
        femaleRadio = new JRadioButton("Female");
        femaleRadio.setBounds(230, 250, 90, 30);
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

        jobTitleComboBox = new JComboBox<>(new String[] {"RECEPTIONIST",
                "MANAGER",
                "CHEF",
                "HR MANAGER",
                "EVENT MANAGER",
                "BARTENDER",
                "ACCOUNTANT",
                "TECHNICIAN",
                "GARDENER",
                "SOFTWARE ENGINEER",
                "IT SUPPORT",
                "SYSTEM ADMINISTRATOR",
                "DATA ANALYST",
                "NETWORK ENGINEER",
                "ELECTRICAL ENGINEER",
                "MECHANICAL ENGINEER",
                "ELECTRONICS ENGINEER",
                "OPERATION MANAGER",
                "FINANCE MANAGER",
                "FRONT DESK ASSISTANT"});
        jobTitleComboBox.setBounds(150, 290, 250, 30);
        jobTitleComboBox.setBackground(Color.WHITE);
        image.add(jobTitleComboBox);

        salaryLabel = new JLabel("Salary: ");
        salaryLabel.setBounds(50, 330, 100, 30);
        salaryLabel.setFont(new Font("Serif", Font.BOLD, 16));
        image.add(salaryLabel);

        salaryField = new JTextField();
        salaryField.setBounds(150, 330, 250, 30);
        image.add(salaryField);

        phoneLabel = new JLabel("Phone: ");
        phoneLabel.setBounds(50, 370, 100, 30);
        phoneLabel.setFont(new Font("Serif", Font.BOLD, 16));
        image.add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(150, 370, 250, 30);
        image.add(phoneField);

        // Submit Button for adding employee
        submitButton = new JButton("Submit");
        submitButton.setBounds(150, 410, 100, 30);
        submitButton.setFocusable(false);
        submitButton.setBackground(Color.WHITE);
        submitButton.setForeground(Color.BLACK);
        submitButton.addActionListener(this);
        image.add(submitButton);

        backButton = new JButton("Back");
        backButton.setBounds(270, 410, 100, 30);
        backButton.setFocusable(false);
        backButton.setBackground(Color.WHITE);
        backButton.setForeground(Color.BLACK);
        backButton.addActionListener(this);
        image.add(backButton);
        super.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==submitButton){
            AddEmployee();
        }
        else if(e.getSource()==backButton){
            super.dispose();
            new AdminDashBoard();
        }
    }

    public void EmployeeData() {
        try {
            File file = new File("src/Hotel_Management_System/Person/Details/TextFiles/EmployeeDetails.txt");
            if (!file.exists()) {
                JOptionPane.showMessageDialog(this, "No employee is registered", "ERROR", JOptionPane.ERROR_MESSAGE);
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
            table.getColumnModel().getColumn(0).setPreferredWidth(50);
            table.getColumnModel().getColumn(1).setPreferredWidth(200);
            table.getColumnModel().getColumn(2).setPreferredWidth(50);
            table.getColumnModel().getColumn(3).setPreferredWidth(80);
            table.getColumnModel().getColumn(4).setPreferredWidth(200);
            table.getColumnModel().getColumn(5).setPreferredWidth(100);
            table.getColumnModel().getColumn(6).setPreferredWidth(102);

            if (scroll != null) {
                scroll.setViewportView(table);
            } else {
                scroll = new JScrollPane(table);
                scroll.setBounds(420, 50, 800, 500);
                image.add(scroll);
            }

            //adding button for update details
            JButton save=new JButton("Save Changes");
            save.setBounds(700,600, 120, 40);
            save.addActionListener(e->{
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    for (int r = 0; r < model.getRowCount(); r++) {
                        writer.write(model.getValueAt(r, 0) + "," +
                                model.getValueAt(r, 1) + "," +
                                model.getValueAt(r, 2) + "," +
                                model.getValueAt(r, 3) + "," +
                                model.getValueAt(r, 4) + "," +
                                model.getValueAt(r, 5) + "," +
                                model.getValueAt(r, 6));
                        writer.newLine();
                    }
                    JOptionPane.showMessageDialog(null, "Employee details updated successfully!");
                }
                catch (IOException x){
                    x.printStackTrace();
                }
            });
            image.add(save);

            JButton deleteButton=new JButton("Delete");
            deleteButton.setBounds(840,600,120,40);
            deleteButton.addActionListener(e->{
                int selectedRow=table.getSelectedRow();
                if(selectedRow==-1){
                    JOptionPane.showMessageDialog(null,"Select a row to delete!","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int confirm=JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this employee member?","Confirm Delete",JOptionPane.YES_NO_OPTION);
                if(confirm==JOptionPane.YES_OPTION){
                    deleteEmployee(selectedRow);
                }
            });
            image.add(deleteButton);

        } catch (IOException ae) {
            ae.printStackTrace();
        }
    }

    public void AddEmployee(){
        String name=nameField.getText().toUpperCase();
        String age=ageField.getText();
        String gender=null;
        String job=(String)jobTitleComboBox.getSelectedItem();
        String salary=salaryField.getText();
        String phone=phoneField.getText();
        if(name.isEmpty()){
            JOptionPane.showMessageDialog(this,"Name is empty!");
            nameField.requestFocus();
            return;
        }
        if(age.isEmpty() || !(age.matches("\\d+"))){
            JOptionPane.showMessageDialog(this,"Age is not valid!");
            ageField.requestFocus();
            return;
        }
        if(salary.isEmpty() || !(salary.matches("\\d+"))){
            JOptionPane.showMessageDialog(this,"Salary is not valid!");
            salaryField.requestFocus();
            return;
        }
        if(phone.length()!=11 || !phone.matches("\\d+")){
            JOptionPane.showMessageDialog(this,"Enter valid Phone");
            phoneField.requestFocus();
            return;
        }
        if(maleRadio.isSelected()){
            gender="MALE";
        }
        else if(femaleRadio.isSelected()){
            gender="FEMALE";
        }
        else{
            JOptionPane.showMessageDialog(this,"Gender not selected!");
            return;
        }
        String id=generateId();
        employee=new EmployeeDetails(id,name,age,gender,job,salary,phone);
        //exception handling and file handling for database
        try{
            FileWriter writer=new FileWriter("src/Hotel_Management_System/Person/Details/TextFiles/EmployeeDetails.txt",true);
            writer.write(employee.getId()+","+employee.getName()+","+employee.getAge()+","+employee.getGender()+
                    ","+employee.getJob()+","+employee.getSalary()+","+employee.getPhone()+"\n");
            writer.close();
            JOptionPane.showMessageDialog(this,"Registered Successfully!");
            EmployeeData();
        }
        catch(IOException ae){
            ae.printStackTrace();
        }
    }

    public String generateId() {
        int lastId = 1000; // Default starting ID
        try (BufferedReader reader = new BufferedReader(new FileReader("src/Hotel_Management_System/Person/Details/TextFiles/EmployeeDetails.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0) {
                    int currentId = Integer.parseInt(parts[0]);
                    if (currentId > lastId) {
                        lastId = currentId; // Track the highest ID
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error reading emoloyee", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Increment the last ID by 1 for the new employee
        return String.valueOf(lastId + 1);
    }

    public void deleteEmployee(int rowIndex){
        File file=new File("src/Hotel_Management_System/Person/Details/TextFiles/EmployeeDetails.txt");
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
            JOptionPane.showMessageDialog(this,"Error deleting employee","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        File originalFile=new File("src/Hotel_Management_System/Person/Details/TextFiles/EmployeeDetails.txt");
        File tempFile=new File("src/Hotel_Management_System/Person/Details/TextFiles/temp.txt");
        if(originalFile.delete()&&tempFile.renameTo(originalFile)){
            JOptionPane.showMessageDialog(this,"Employee deleted successfully!");
            EmployeeData();
        }else{
            JOptionPane.showMessageDialog(this,"Error updating file","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}
