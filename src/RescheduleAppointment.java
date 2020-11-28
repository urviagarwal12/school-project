import javax.swing.*;

public class RescheduleAppointment <bg> extends JFrame  {
    private JTextField textField2;
    private JTextField textField1;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JButton rescheduleAppointmentButton;
    private JCheckBox notifyViaEmailOrCheckBox;
    private JTextField textField8;
    private JPanel missedAppointmentPanel;

    private static JFrame frame = new RescheduleAppointment ("Missed Appointment?");

    public RescheduleAppointment (String title) {

        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(missedAppointmentPanel);
        this.pack();


    }

    public static void main(String args[]) {
        frame.setSize(800, 500);
        frame.setVisible(true);
    }
}


