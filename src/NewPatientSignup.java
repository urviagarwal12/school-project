//import myConnection.MyConnection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.regex.Pattern;


public class NewPatientSignup <bg> extends JFrame {
    private JTextField PatientName;
    private JTextField textFieldDOB;
    private JTextField textFieldEmail;
    private JTextField textFieldAddress;
    private JTextField textFieldContact;
    private JTextField textFieldMedicalHistory;
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
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JButton deleteButton;
    private JTextField textField1;
    private static String s1;
    private static JFrame frame = new NewPatientSignup("New Patient SignUp Form");


    public NewPatientSignup(String title) {

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
        textFieldContact.addActionListener(new ActionListener() {
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



        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = textFieldEmail.getText();
                if (PatientName.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter Patient's Name");
                } else if (textFieldDOB.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter Patient's Date of Birth");
                } else if (textFieldEmail.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter Patient's Email ID");
                } else if (!isEmailValid(email)) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid Email ID");
                } else if (textArea1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter Patient's Address");
                } else if (textFieldContact.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter Patient's Phone Number");
                } else if (textArea2.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter a medical history");
                } else if (yesCheckBox.isSelected() && textFieldAllergy.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter an Allergy");
                } else if (String.valueOf(passwordField.getPassword()).equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter Password");
                } else
                    try {
                        //  SQL Query
                        String sql = "INSERT INTO `SystemDatabase`.`PatientDetails`( `patient_id`,`password`, `patient_name`, `patient_DOB`, `patient_gender`,`patient_email`, `patient_address`, `patient_contact`, `patient_history`, `patient_allergy` ) VALUES (?,?,?,?,?,?,?,?,?,?)";

                        //  Establishing a connection
                        Connection conn = DriverManager.getConnection("jdbc:mysql://clinicdatabase.cuepzpvlvpfe.us-east-2.rds.amazonaws.com:3306/SystemDatabase", "admin", "rootroot");

                        PreparedStatement preparedStatement = conn.prepareStatement(sql);
                        preparedStatement.setString(1, set_PatientID());
                        preparedStatement.setString(2, String.valueOf(passwordField.getPassword()));
                        preparedStatement.setString(3, PatientName.getText());
                        preparedStatement.setString(4, textFieldDOB.getText());
                        preparedStatement.setString(5, comboBoxGender.getSelectedItem().toString());
                        preparedStatement.setString(6, textFieldEmail.getText());
                        preparedStatement.setString(7, textArea1.getText());
                        preparedStatement.setString(8, textFieldContact.getText());
                        preparedStatement.setString(9, textArea2.getText());
                        preparedStatement.setString(10, textFieldAllergy.getText());
                        preparedStatement.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Sign Up successful. Patient ID is " + set_PatientID());
                        PatientLoginForm patientLoginForm = new PatientLoginForm("Patient login Form");
                        patientLoginForm.setVisible(true);
                        conn.close();
                    } catch (SQLException exception) {
                        JOptionPane.showMessageDialog(null, exception);
                    }
                passwordField.setText("");
                PatientName.setText("");
                textFieldDOB.setText("");
                //comboBoxGender.set(true);
                textFieldEmail.setText("");
                textArea1.setText("");
                textFieldContact.setText("");
                textArea2.setText("");
                textFieldAllergy.setText("");
            }

            private boolean isEmailValid(String email) {
                String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";
                Pattern pat = Pattern.compile(emailRegex);
                if (email == null)
                    return false;
                return pat.matcher(email).matches();
            }

            private String set_PatientID() {
                String s1 = null;

                try {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://clinicdatabase.cuepzpvlvpfe.us-east-2.rds.amazonaws.com:3306/SystemDatabase", "admin", "rootroot");
                    Statement s = conn.createStatement();

                    ResultSet rs = s.executeQuery("SELECT patient_id FROM SystemDatabase.PatientDetails");
                    rs.next();

                    rs.getString("patient_id");

                    Statement stmt = conn.createStatement();
                    String query = "select count(*) from SystemDatabase.PatientDetails";
                    ResultSet rs1 = stmt.executeQuery(query);

                    rs1.next();
                    int count = rs1.getInt(1);

                    if (count < 10) {
                        s1 = "P000" + Integer.toString(count);
                    } else {
                        s1 = "P00" + Integer.toString(count);
                    }
                    conn.close();
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(rootPane, exception);
                }
                return s1;
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                 passwordField.setText("");
                 PatientName.setText("");
                 textFieldDOB.setText("");
                 //comboBoxGender.set(true);
                 textFieldEmail.setText("");
                 textArea1.setText("");
                 textFieldContact.setText("");
                 textArea2.setText("");
                 textFieldAllergy.setText("");
          /*      int p = JOptionPane.showConfirmDialog(null,"Are you sure?","Delete",JOptionPane.YES_NO_OPTION);
                if (p==0) {
                    String sql = "delete from PatientDetails where patient_id=?";
                    try {

                        Connection con= null;
                        PreparedStatement pst = con.prepareStatement(sql);
                        pst.setString(1, patientID.getText());
                        pst.execute();
                        JOptionPane.showMessageDialog(null,"Deleted");

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, e);

                    }
                }*/
            }
        });
    }


                public static void main(String args[]){
                    frame.setSize(800,500);
                    frame.setVisible(true);
                }
            }



