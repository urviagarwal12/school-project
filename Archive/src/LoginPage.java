import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class LoginPage<bg> extends JFrame {

    private static JFrame frame = new LoginPage("Clinic Management System");
    JPanel mainpanel;
    private JRadioButton doctorRadioButton;
    private JButton loginButton1;
    private JRadioButton patientRadioButton;
    private JButton loginButton2;
    private JButton signUpButton;
    ButtonGroup bg;
//private void jButtonActionPerformed (java.awt.event.ActionEvent evt);
//String sql String loginQuery = "SELECT * FROM UserDetails WHERE username = ? AND password = ?";
//try{
    //try {
    //Class.forName("com.mysql.cj.jdbc.Driver");
    // DbConnection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/eventcreator","root","password");
    //} //catch (ClassNotFoundException e) {
    //e.printStackTrace();
    //}
//         }


    public LoginPage(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainpanel);
        this.pack();
        bg = new ButtonGroup();
        bg.add(doctorRadioButton);
        bg.add(patientRadioButton);

        doctorRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Hide current frame
                //second.setVisible(true);
            }
        });
        loginButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(frame, "Welcome Doctor!");
                DoctorLogin doctorLogin = new DoctorLogin("Doctor Login Form");
                doctorLogin.setVisible(true);

            }
        });
        patientRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        loginButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Welcome back patient!");
                PatientLoginForm patientLoginForm = new PatientLoginForm("Patient login Form");
                patientLoginForm.setVisible(true);
            }
        });
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Welcome new patient!");
                NewPatientSignup newPatientSignup = new NewPatientSignup("New Patient SignUp Form");
                newPatientSignup.setVisible(true);
            }
        });
    }


    public static void main(String args[]) {
        frame.setSize(800, 500);
        frame.setVisible(true);
    }
}

