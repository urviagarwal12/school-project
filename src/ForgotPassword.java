import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ForgotPassword<bg> extends JFrame {
    private JPanel forgotPass;
    private JTextField textField2;
    private JTextField EmailTextField1;
    private JButton resetPasswordButton;
    JPasswordField NewpasswordField1;
    JPasswordField confirmPasswordField;
    private JLabel EmailLabel;

    private static JFrame frame = new ForgotPassword("Forgot Password?");

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public ForgotPassword(String title) {

        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(forgotPass);
        this.pack();


                resetPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                String Newpass = String.valueOf(NewpasswordField1.getText());
                String ConfPass = String.valueOf(confirmPasswordField.getText());
                String patient_id = String.valueOf(textField2.getText());
                String email = String.valueOf(EmailTextField1.getText());

                if (Newpass.equals("")) {

                    JOptionPane.showMessageDialog(ForgotPassword.this, "Please enter a new password");
                    return;

                } else if (ConfPass.equals("")) {

                    JOptionPane.showMessageDialog(ForgotPassword.this, "Please enter a confirmed password");
                    return;
                } else if (email.equals("")) {

                    JOptionPane.showMessageDialog(ForgotPassword.this, "Please enter a Valid Email ID");
                    return;
                } else if (patient_id.equals("")) {

                    JOptionPane.showMessageDialog(ForgotPassword.this, "Please enter a Valid Patient ID");
                    return;
                }
                con = DriverManager.getConnection("jdbc:mysql://clinicdatabase.cuepzpvlvpfe.us-east-2.rds.amazonaws.com:3306/SystemDatabase","admin","rootroot");
                String sql = "select patient_id from SystemDatabase.PatientDetails where patient_id='" + textField2.getText() +"'";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    String pName = rs.getString("patient_id").trim();
                    //String passwd = rs.getString("password").trim();
                    if (pName.equals(patient_id)) {
                        con = DriverManager.getConnection("jdbc:mysql://clinicdatabase.cuepzpvlvpfe.us-east-2.rds.amazonaws.com:3306/SystemDatabase","admin","rootroot");
                        String sql1 = "update PatientDetails set password= '" + Newpass + "' where patient_id = '" + patient_id  + "'";
                        Statement stmt = con.createStatement();
                        stmt.execute(sql1.toString());
                        stmt.close();
                        JOptionPane.showMessageDialog(ForgotPassword.this, "Password Successfully Changed");

                        return;
                    } else {
                        JOptionPane.showMessageDialog(ForgotPassword.this, "invalid Patient ID");
                        textField2.setText("");
                        NewpasswordField1.setText("");
                        confirmPasswordField.setText("");
                        EmailTextField1.setText("");
                        return;
                    }
                }
            } catch (SQLException | HeadlessException ex) {
                        JOptionPane.showMessageDialog(ForgotPassword.this, ex);
                    }
                }

        });
    }

    public static void main(String args[]) {
        frame.setSize(800, 500);
        frame.setVisible(true);
    }
}

