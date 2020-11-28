//import myConnection.MyConnection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class NewPatientSignup <bg> extends JFrame{
    private JTextField PatientName;
    private JTextField textFieldDOB;
    private JTextField textFieldEmail;
    private JTextField textFieldAddress;
    private JTextField textFieldContact;
    private JTextField textFieldMedicalHistory;
    private JButton generatePatientIDButton;
    private JRadioButton mRadioButton;
    private JRadioButton otherRadioButton;
    private JRadioButton fRadioButton;
    private JCheckBox noCheckBox;
    private JCheckBox yesCheckBox;
    private JTextField textFieldAllergy;
    private JPanel newPatientPanel;
    private JPasswordField passwordField;
    private JComboBox comboBoxGender;
    private JButton submitButton;
    private JTextField textField1;

    private static JFrame frame = new NewPatientSignup("New Patient SignUp Form");


    public NewPatientSignup (String title) {

        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(newPatientPanel);
        this.pack();


        PatientName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        textFieldDOB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });




        textFieldEmail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        textFieldAddress.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        textFieldContact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        textFieldMedicalHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        noCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        yesCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        textFieldAllergy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        comboBoxGender.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
        });
        generatePatientIDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                private String set_patient_id();
                {
                    String s1 = null;

                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://clinicdatabase.cuepzpvlvpfe.us-east-2.rds.amazonaws.com:3306/SystemDatabase","admin","rootroot");
                        Statement s = conn.createStatement();

                        ResultSet rs = s.executeQuery("select patient_id from PatientDetails");
                        rs.next();

                        rs.getString("patient_id");

                        Statement stmt = conn.createStatement();
                        String query = "select count(*) from PatientDetails";
                        ResultSet rs1 = stmt.executeQuery(query);

                        rs1.next();
                        int count = rs1.getInt(1);

                        if (count < 10){
                            s1 = "P000" + Integer.toString(count);

                        }
                        else
                        {
                            s1= "P00" + Integer.toString(count);
                        }


                    }catch (Exception e){
                        JOptionPane.showMessageDialog(rootPane, e);
                    }
                    return s1;
                }
                //JOptionPane.showMessageDialog(frame, "Thank you for Visiting us!");


    });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fname = PatientName.getText();
                String dateOfBirth = textFieldDOB.getText();
                String email = textFieldEmail.getText();
                String contact = textFieldContact.getText();
                String address = textFieldAddress.getText();
                String mHistory = textFieldMedicalHistory.getText();
                String allergy = textFieldAllergy.getText();
                String password = String.valueOf(passwordField.getPassword());
                String gender = comboBoxGender.getSelectedItem().toString();


//               if (fname.equals("")) {
//                JOptionPane.showMessageDialog(null, "Enter your name");
//                } else if (dateOfBirth.equals("")) {
//                    JOptionPane.showMessageDialog(null, "Enter you Date of Birth");
//                } else if (email.equals("")) {
//                    JOptionPane.showMessageDialog(null, "Enter your Email");
//                } else if (contact.equals("")) {
//                    JOptionPane.showMessageDialog(null, "Enter yourContact Info");
//
//                } else if (address.equals("")) {
//                    JOptionPane.showMessageDialog(null, "Enter your home address");
//                } else if (mHistory.equals("")) {
//                    JOptionPane.showMessageDialog(null, "Enter you relevant medical History");
//
//                } else if (allergy.equals("")) {
//                    JOptionPane.showMessageDialog(null, "Enter your allergies if any");
//
                //  } else {
                //PreparedStatement ps;


                try {
                    //  SQL Query
                    String sql = "INSERT INTO `SystemDatabase`.`PatientDetails`( `patient_id`,`password`, `patient_name`, `patient_DOB`, `patient_gender`,`patient_email`, `patient_address`, `patient_contact`, `patient_history`, `patient_allergy` ) VALUES (?,?,?,?,?,?,?,?,?,?)";

                    //  Establishing a connection
                    Connection conn = DriverManager.getConnection("jdbc:mysql://clinicdatabase.cuepzpvlvpfe.us-east-2.rds.amazonaws.com:3306/SystemDatabase", "admin", "rootroot");

                    PreparedStatement preparedStatement = conn.prepareStatement(sql);
                    preparedStatement.setString(1,"0" );
                    preparedStatement.setString(2,password);
                    preparedStatement.setString(3, fname);
                    preparedStatement.setString(4, dateOfBirth);
                    preparedStatement.setString(5, gender );
                    preparedStatement.setString(6, email);
                    preparedStatement.setString(7, address);
                    preparedStatement.setString(8, contact);
                    preparedStatement.setString(9, mHistory);
                    preparedStatement.setString(10,allergy );


                    JOptionPane.showMessageDialog(null, "Sign Up successful");
                    PatientLoginForm patientLoginForm = new PatientLoginForm("Patient login Form");
                    patientLoginForm.setVisible(true);
                    conn.close();

                } catch (SQLException ex) {
                    Logger.getLogger(NewPatientSignup.class.getName()).log(Level.SEVERE, null, ex);
                }
                // }


            }
        });
    }

               //if(jDateChooser_BDATE.getDate() != null)
                    //{
                    //SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
                    //bdate = dateformat.format(jDateChooser_BDATE.getDate());
                    //}




    // on the register button click


    public static void main(String args[]){
        frame.setSize(800,500);
        frame.setVisible(true);


    }



}