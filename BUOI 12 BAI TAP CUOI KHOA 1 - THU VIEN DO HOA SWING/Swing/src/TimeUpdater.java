import javax.swing.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUpdater extends JFrame {
    private final JLabel timeLabel;
    private void updateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
        String currentTime = dateFormat.format(new Date());
        timeLabel.setText("Current Time: " + currentTime);
    }
    public TimeUpdater() {
        setTitle("Time Updater");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        JPanel panel = new JPanel();
        MyButton updateButton = new MyButton();
        timeLabel = new JLabel("Current Time: ");

        panel.add(timeLabel);
        panel.add(updateButton);

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateTime();
            }
        });
        panel.setBounds(100, 150, 200, 60);
        this.add(panel);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new TimeUpdater();
    }
}
