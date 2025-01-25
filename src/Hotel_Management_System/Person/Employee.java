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
        super.setLocation(150, 50);
        super.setLayout(null);
        ImageIcon icon=new ImageIcon("src/img/Icon.png");//Icon
        super.setIconImage(icon.getImage());
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setResizable(false);
        super.setTitle("EMPLOYEE");

        //loading row data
        EmployeeData();

        //adding buttons and label for adding new employee
        JLabel addEmployeeLabel = new JLabel("Add Employee");
        addEmployeeLabel.setBounds(50, 100, 200, 50);
        addEmployeeLabel.setFont(new Font("Serif", Font.BOLD, 30));
        super.add(addEmployeeLabel);

        nameLabel = new JLabel("Name: ");
        nameLabel.setBounds(50, 170, 100, 30);
        nameLabel.setFont(new Font("Serif", Font.PLAIN, 16));
        super.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 170, 250, 30);
        super.add(nameField);

        ageLabel = new JLabel("Age: ");
        ageLabel.setBounds(50, 210, 100, 30);
        ageLabel.setFont(new Font("Serif",Font.PLAIN,16));
        super.add(ageLabel);

        ageField = new JTextField();
        ageField.setBounds(150, 210, 250, 30);
        super.add(ageField);

        genderLabel = new JLabel("Gender: ");
        genderLabel.setBounds(50, 250, 100, 30);
        genderLabel.setFont(new Font("Serif", Font.PLAIN, 16));
        super.add(genderLabel);

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

        super.add(maleRadio);
        super.add(femaleRadio);

        jobTitleLabel = new JLabel("Job Title: ");
        jobTitleLabel.setBounds(50, 290, 100, 30);
        jobTitleLabel.setFont(new Font("Serif", Font.PLAIN, 16));
        super.add(jobTitleLabel);

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
        super.add(jobTitleComboBox);

        salaryLabel = new JLabel("Salary: ");
        salaryLabel.setBounds(50, 330, 100, 30);
        salaryLabel.setFont(new Font("Serif", Font.PLAIN, 16));
        super.add(salaryLabel);

        salaryField = new JTextField();
        salaryField.setBounds(150, 330, 250, 30);
        super.add(salaryField);

        phoneLabel = new JLabel("Phone: ");
        phoneLabel.setBounds(50, 370, 100, 30);
        phoneLabel.setFont(new Font("Serif", Font.PLAIN, 16));
        super.add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(150, 370, 250, 30);
        super.add(phoneField);

        // Submit Button for adding employee
        submitButton = new JButton("Submit");
        submitButton.setBounds(150, 410, 100, 30);
        submitButton.setFocusable(false);
        submitButton.setBackground(Color.WHITE);
        submitButton.setForeground(Color.BLACK);
        submitButton.addActionListener(this);
        super.add(submitButton);

        backButton = new JButton("Submit");
        backButton.setBounds(150, 410, 100, 30);
        backButton.setFocusable(false);
        backButton.setBackground(Color.WHITE);
        backButton.setForeground(Color.BLACK);
        backButton.addActionListener(this);
        super.add(backButton);
        super.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==submitButton){
            AddEmployee();
        }
        else if(e.getSource()==backButton){
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
            DefaultTableModel model = new DefaultTableModel(row, col);

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
                super.add(scroll);
            }
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
        if(!(salary.matches("\\d+") || salary.isEmpty())){
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
            JOptionPane.showMessageDialog(this, "Error reading Staff", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Increment the last ID by 1 for the new employee
        return String.valueOf(lastId + 1);
    }

    public static void main(String[] args) {
        new Employee();
    }
}
