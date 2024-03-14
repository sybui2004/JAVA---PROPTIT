import javax.swing.*;

public class MyFrame extends JFrame {
    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
        this.setSize(400, 400); // set size of frame
        this.setLayout(null);
        ImageIcon icon = new ImageIcon("icon.png");
        JButton jButton = new JButton();
        jButton.setIcon(icon);
        jButton.setBounds(50, 50, 100, 100);
        this.add(jButton);
        this.setVisible(true); // make frame visible
    }
}
