import javax.swing.*;

public class Invoice <bg> extends JFrame {

    private JTextField textField2;
    private JTextField textField1;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton printButton;
    private JButton generateInvoiceButton;
    private JPanel invoicePanel;

    private static JFrame frame = new Invoice("Invoice form");

    public Invoice(String title) {

        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(invoicePanel);
        this.pack();


    }

    public static void main(String args[]) {
        frame.setSize(800, 500);
        frame.setVisible(true);
    }
}
