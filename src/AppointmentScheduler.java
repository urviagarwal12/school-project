import javax.swing.*;

public class AppointmentScheduler <bg> extends JFrame {
    private JTextField textField3;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField4;
    private JButton scheduleButton1;
    private JButton missedAppointmentButton;
    private JRadioButton urgentRadioButton;
    private JRadioButton generalChekupRadioButton;
    private JPanel appointmentPanel;

    private static JFrame frame = new AppointmentScheduler("Appointment Scheduler");


    public AppointmentScheduler (String title){

        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(appointmentPanel);
        this.pack();

    }
    public static void main(String args[]){
        frame.setSize(800,500);
        frame.setVisible(true);


    }
}
