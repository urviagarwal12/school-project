import javax.swing.*;

public class Diagnosis <bg> extends JFrame {
    private JTextField textField2;
    private JTextField textField1;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JRadioButton emergencyRadioButton;
    private JRadioButton generalRadioButton;
    private JButton generatePrescriptionButton;
    private JButton printButton;
    private JTextField textField6;
    private JPanel diagnosis;

    private static JFrame frame = new Diagnosis("Diagnosis Form");

    public Diagnosis(String title) {

        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(diagnosis);
        this.pack();


    }

    public static void main(String args[]) {
        frame.setSize(800, 500);
        frame.setVisible(true);
    }
}

