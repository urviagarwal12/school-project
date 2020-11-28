/*
package Trial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrialForm {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton submitButton;

    private static JFrame frame = new JFrame("Trial Form");


    public TrialForm(String title) {

        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(newPatientPanel);
        this.pack();

        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        textField2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        textField3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                @Override
                public void actionPerformed(ActionEvent e); {
                    String DeptID = TextField.getText();
                    String address = t.getText();
                    String contact = textFieldContact.getText();


                {


//


                        try {
                            //  SQL Query
                            String sql = "INSERT INTO `TrialTable`.`DeptTable`( `Dept_ID`,`Dept_Name`, `Dept_status`) VALUES (?,?,?)";

                            //  Establishing a connection
                            Connection conn = DriverManager.getConnection("jdbc:mysql://clinicdatabase.cuepzpvlvpfe.us-east-2.rds.amazonaws.com:3306/SystemDatabase", "admin", "rootroot");

                            PreparedStatement preparedStatement = conn.prepareStatement(sql);
                            preparedStatement.setString(1, set__Dept_ID);
                            preparedStatement.setString(2, name );
                            preparedStatement.setString(3, );



                            JOptionPane.showMessageDialog(null, "Sign Up successful");
                            TrialForm trialForm = new TrialForm("Trial Form);
                            trialForm.setVisible(true);
                            conn.close();

                        } catch (SQLException ex) {
                            Logger.getLogger(TrialForm.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });

            }








            public void main(String args[]) {
                frame.setSize(800, 500);
                frame.setVisible(true);


            }
        }

    private void pack() {
    }


}
*/
       // });