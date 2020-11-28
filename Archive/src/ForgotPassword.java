import javax.swing.*;

public class ForgotPassword<bg> extends JFrame {
    private JPanel forgotPass;
    private JTextField textField2;
    private JTextField textField1;
    private JButton resetPasswordButton;

    private static JFrame frame = new ForgotPassword("Forgot Password?");

    public ForgotPassword(String title) {

        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(forgotPass);
        this.pack();


    }

    public static void main(String args[]) {
        frame.setSize(800, 500);
        frame.setVisible(true);
    }
}
