import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class PatientLoginForm <bg> extends JFrame{
    private static JFrame frame = new PatientLoginForm("Patient Login Form");
    JPanel patientPanel;

    private JTextField patientID;
    private JCheckBox yesCheckBox;
    private JButton yesButton;
    private JButton loginButton;
    private JButton forgotPasswordButton;
    private JPasswordField passwordField;
    //private static JFrame frame = new PatientLoginForm();


    public  PatientLoginForm(String title){

        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(patientPanel);
        this.pack();


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql = "SELECT `PatientDetails`.`patient_id`, `PatientDetails`.`password` FROM `SystemDatabase`.`PatientDetails` WHERE `PatientDetails`.`patient_id`= ? AND `PatientDetails`.`password`= ? ";
                try {

                    //  Establishing a connection
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://clinicdatabase.cuepzpvlvpfe.us-east-2.rds.amazonaws.com:3306/SystemDatabase", "admin", "rootroot");
                    PreparedStatement preparedStatement = conn.prepareStatement(sql);
                    preparedStatement.setString(1, patientID.getText());
                    preparedStatement.setString(2, new String (passwordField.getPassword()));


                    ResultSet resultSet = preparedStatement.executeQuery();

                    if (resultSet.next()) {
                        JOptionPane.showMessageDialog(frame, "Welcome back Patient!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Incorrect Username and password", "Error", JOptionPane.ERROR_MESSAGE);
                    }


                } catch (SQLException | ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        });

        forgotPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(frame, "Forgot your password?");
                ForgotPassword forgotPassword = new ForgotPassword ("Forgot Password");
                forgotPassword.setVisible(true);


            }
        });
        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Thank you for coming!");
                NewPatientSignup newPatientSignup = new NewPatientSignup("New Patient Sign up Form");
                newPatientSignup.setVisible(true);
            }
        });
    }


    public static void main(String args[]){
        frame.setSize(800,500);
        frame.setVisible(true);


    }



}


