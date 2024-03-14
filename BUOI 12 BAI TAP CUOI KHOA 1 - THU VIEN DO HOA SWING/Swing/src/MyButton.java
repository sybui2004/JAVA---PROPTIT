import java.awt.*;
import javax.swing.*;

public class MyButton extends JButton {
    Font customFont = new Font("Arial", Font.BOLD, 18);
    public MyButton() {
        setText("Update Time");
        setFocusable(false);
        setFont(customFont);
        setBackground(Color.PINK);
    }
}