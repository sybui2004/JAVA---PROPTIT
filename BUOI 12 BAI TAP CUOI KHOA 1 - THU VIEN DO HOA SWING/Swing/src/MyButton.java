import java.awt.*;
import javax.swing.*;

public class MyButton extends JButton {
    public MyButton() {
        setText("Here");
        setContentAreaFilled(false); // erase area around button
        setBorder(BorderFactory.createEmptyBorder()); // erase bolder
        setFocusable(false);
        setBounds(50, 100, 100, 50);
    }

    @Override
    public void paintComponent(Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.setColor(Color.PINK);
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 50, 50);
        super.paintComponent(graphics);
    }

}