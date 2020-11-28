import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DoctorLogin<bg> extends JFrame {
    private JPanel doctorPanel;
    private JTextField textField1;
    private JTextField textField3;
    private JPasswordField passwordField1;
    private JCheckBox yesCheckBox;
    private JButton backButton;
    private JButton submitButton;

    private static JFrame frame = new DoctorLogin("Doctor Login Page");


    public DoctorLogin(String title){

        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(doctorPanel);
        this.pack();

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog( frame,"are you sure?");
            PatientLoginForm patientLoginForm= new PatientLoginForm("Patient login Form");
                patientLoginForm.setVisible(true);}
        });
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //  SQL Query
                String sql = "SELECT `DoctorDetails`.`doctor_id`, `DoctorDetails`.`password` FROM `SystemDatabase`.`DoctorDetails` WHERE `DoctorDetails`.`doctor_id`= ? AND `DoctorDetails`.`password`= ? ";
                try {

                    //  Establishing a connection
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://clinicdatabase.cuepzpvlvpfe.us-east-2.rds.amazonaws.com:3306/SystemDatabase", "admin", "rootroot");
                    PreparedStatement preparedStatement = conn.prepareStatement(sql);
                    preparedStatement.setString(1, textField1.getText());
                    preparedStatement.setString(2, new String (passwordField1.getPassword()));


                    ResultSet resultSet = preparedStatement.executeQuery();

                    if (resultSet.next()) {
                        JOptionPane.showMessageDialog(frame, "Welcome back Doctor!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Incorrect entry", "Error", JOptionPane.ERROR_MESSAGE);
                    }


                } catch (SQLException | ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        });

    }

    public static void main(String args[]){
        frame.setSize(800,500);
        frame.setVisible(true);


    }
}