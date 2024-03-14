# **BUỔI 12 (FINAL) - THƯ VIỆN ĐỒ HOẠ SWING**

## **I. Thư viện đồ hoạ Swing cơ bản**

- Java Swing là một phần của Java Foundation Classes (JFC) được sử dụng để tạo các ứng dụng Window-Based. Nó được xây dựng ở trên cùng của AWT (Abstract Windowing Toolkit) API, cung cấp các thành phần giao diện người dùng như nút, trường văn bản, bảng và cửa sổ cho phép nhà phát triển tạo ra giao diện đồ họa cho các ứng dụng Java.
- Swing được thiết kế để cung cấp các tính năng tốt hơn so với Abstract Window Toolkit (AWT), thư viện giao diện người dùng gốc của Java. Swing hỗ trợ các thành phần giao diện mạnh mẽ hơn, phong cách đẹp hơn và tương thích đa nền tảng.

> [!NOTE]
> **API** là các phương thức, giao thức kết nối với các thư viện và ứng dụng khác. Nó là viết tắt của Application Programming Interface – giao diện lập trình ứng dụng. API cung cấp khả năng truy xuất đến một tập các hàm hay dùng. Và từ đó có thể trao đổi dữ liệu giữa các ứng dụng.

![Alt text](https://github.com/sybui2004/JAVA---PROPTIT/blob/main/BUOI%2012%20BAI%20TAP%20CUOI%20KHOA%201%20-%20THU%20VIEN%20DO%20HOA%20SWING/B12-1.png)

- Các phương thức phổ biến:

![Alt text](https://github.com/sybui2004/JAVA---PROPTIT/blob/main/BUOI%2012%20BAI%20TAP%20CUOI%20KHOA%201%20-%20THU%20VIEN%20DO%20HOA%20SWING/B12-2.png)

## **II. JFrame, JButton, JLabel, JTextField, JTable, JList**

1. **JFrame**
- Là một cửa sổ đồ họa có chứa các thành phần giao diện khác.

```java
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args){
        JFrame frame = new JFrame("Test"); // create a frame with title "Test"
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
//        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // close frame without close program
//        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // can't close frame
        frame.setResizable(false); // prevent frame being resized
        frame.setSize(400,400); // set the x - dimension, y - dimension of frame
        frame.setTitle("My Frame"); // set title of frame
        frame.getContentPane().setBackground((new Color(123, 50, 100)));
        frame.setVisible(true); // make frame visible
    }
}
```
![Alt text](https://github.com/sybui2004/JAVA---PROPTIT/blob/main/BUOI%2012%20BAI%20TAP%20CUOI%20KHOA%201%20-%20THU%20VIEN%20DO%20HOA%20SWING/B12-3.png)

2. **JButton**
- Được dùng để tạo ra một nút (button) có tên.
- Việc sử dụng ActionListener sẽ dẫn đến một số hành động khi nút được nhấn.
- Kế thừa lớp AbstractButton và độc lập với nền tảng.

```java
//Main.java

public class Main {
    public static void main(String[] args){
        new MyFrame();
    }
}

//MyFrame.java

import javax.swing.*;
import java.awt.*;
public class MyFrame extends JFrame {
    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
        this.setSize(400, 400); // set size of frame
        JButton button = new JButton("Here"); // create a button
        button.setBounds(100, 200, 85, 20); // set position and size of button
        this.add(button); // add button on frame
        this.setVisible(true); // make frame visible
    }
}

```

![Alt text](https://github.com/sybui2004/JAVA---PROPTIT/blob/main/BUOI%2012%20BAI%20TAP%20CUOI%20KHOA%201%20-%20THU%20VIEN%20DO%20HOA%20SWING/B12-4.png)


```java
//Main.java

public class Main {
    public static void main(String[] args){
        new MyFrame();
    }
}

//MyFrame.java

import javax.swing.*;
import java.awt.*;
public class MyFrame extends JFrame {
    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
        this.setSize(400, 400); // set size of frame
        JButton button = new JButton("Here"); // create a button
        button.addActionListener(e -> System.out.println("Hey~")); // add a ActionListener
        button.setBounds(100,200,85,20); // set position and size of button
        this.add(button); // add button on frame
        this.setVisible(true); // make frame visible
    }
}
```
![Alt text](https://github.com/sybui2004/JAVA---PROPTIT/blob/main/BUOI%2012%20BAI%20TAP%20CUOI%20KHOA%201%20-%20THU%20VIEN%20DO%20HOA%20SWING/B12-5.png)

3. **JLabel**
- là 1 GUI hiển thị 1 chuỗi văn bản hoặc 1 hình ảnh hoặc cả 2.

```java
//Main.java

public class Main {
    public static void main(String[] args){
        new MyFrame();
    }
}

//MyFrame.java

import javax.swing.*;
import java.awt.*;
public class MyFrame extends JFrame {
    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
        this.setSize(400, 400); // set size of frame
        JLabel label =  new JLabel(); // create a label
        label.setText("Hello World"); // set text of label
        this.add(label); // add label on frame
        this.setVisible(true); // make frame visible
    }
}
```

![Alt text](https://github.com/sybui2004/JAVA---PROPTIT/blob/main/BUOI%2012%20BAI%20TAP%20CUOI%20KHOA%201%20-%20THU%20VIEN%20DO%20HOA%20SWING/B12-6.png)

```java
//Main.java

public class Main {
    public static void main(String[] args){
        new MyFrame();
    }
}

//MyFrame.java

import javax.swing.*;
import java.awt.*;
public class MyFrame extends JFrame {
    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
        this.setSize(400, 400); // set size of frame
        JLabel label =  new JLabel(); // create a label
        ImageIcon imageIcon = new ImageIcon("icon.png"); // create a imageIcon
        label.setText("Hello World"); // set text of label
        label.setIcon(imageIcon); // set icon of label
        this.add(label);
        this.setVisible(true); // make frame visible
    }
}
```

![Alt text](https://github.com/sybui2004/JAVA---PROPTIT/blob/main/BUOI%2012%20BAI%20TAP%20CUOI%20KHOA%201%20-%20THU%20VIEN%20DO%20HOA%20SWING/B12-7.png)

4. **JTextField**
- 1 GUI textbox có thể dùng để add, set hoặc get 1 text

```java
//Main.java

public class Main {
    public static void main(String[] args){
        new MyFrame();
    }
}

//MyFrame.java

import javax.swing.*;
import java.awt.*;
public class MyFrame extends JFrame {
    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
        this.setSize(400, 400); // set size of frame

        JTextField jTextField = new JTextField(); // create a TextField
        jTextField.setPreferredSize(new Dimension(250, 40)); // set size of text field
        this.add(jTextField); // add text file on frame
        this.setVisible(true); // make frame visible
    }
}
```

![Alt text](https://github.com/sybui2004/JAVA---PROPTIT/blob/main/BUOI%2012%20BAI%20TAP%20CUOI%20KHOA%201%20-%20THU%20VIEN%20DO%20HOA%20SWING/B12-8.png)

5. **JTable**

- Được sử dụng để hiển thị và chỉnh sửa mảng 2 chiều.
```java
//Main.java

public class Main {
    public static void main(String[] args){
        new MyFrame();
    }
}

//MyFrame.java

import javax.swing.*;
import java.awt.*;
public class MyFrame extends JFrame {
    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
        this.setSize(400, 400); // set size of frame
        // Data to be displayed in the JTable
        String[][] data = {
                { "Bui Thai Sy", "B22DCCN702", "D22CQCN06-B" },
                { "BTS", "B22DCCN702", "D22CQCN06-B" }
        };
        // Column Names
        String[] columnNames = { "Name", "Student ID", "Class" };
        // Initializing the JTable
        JTable jTable = new JTable(data, columnNames); // create a table with data and column name
        jTable.setBounds(30, 40, 200, 300); // set position and size of table

        // adding it to JScrollPane
        JScrollPane jScrollPane = new JScrollPane(jTable);
        this.add(jScrollPane);
        this.setVisible(true); // make frame visible
    }
}
```

> [!NOTE]
> JScrollPane được sử dụng để cung cấp cơ chế cuộn cho một component. Khi kích thước màn hình bị giới hạn chúng ta có thể sử dụng JScrollPane để hiển thị một component có kích thước lớn hoặc có thể thay đổi linh hoạt.

![Alt text](https://github.com/sybui2004/JAVA---PROPTIT/blob/main/BUOI%2012%20BAI%20TAP%20CUOI%20KHOA%201%20-%20THU%20VIEN%20DO%20HOA%20SWING/B12-9.png)

6. **JList**

- Hiển thị một tập hợp các phần tử và cho phép người dùng có thể chọn một hoặc nhiều phần tử trong số chúng. 

```java
//Main.java

public class Main {
    public static void main(String[] args){
        new MyFrame();
    }
}

//MyFrame.java

import javax.swing.*;
import java.awt.*;
public class MyFrame extends JFrame {
    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
        this.setSize(400, 400); // set size of frame
        JPanel jPanel = new JPanel();
        String[] week = {"Monday", "Tuesday", "Wednesday",
                "Thursday", "Friday", "Saturday", "Sunday"}; //String array to store weekdays
        JList jList = new JList(week); //create list
        jList.setSelectionBackground(Color.RED); // set color background list
        jPanel.add(jList); // add list on panel
        this.add(jPanel); // add panel on frame
        this.setVisible(true); // make frame visible
    }
}
```

![Alt text](https://github.com/sybui2004/JAVA---PROPTIT/blob/main/BUOI%2012%20BAI%20TAP%20CUOI%20KHOA%201%20-%20THU%20VIEN%20DO%20HOA%20SWING/B12-10.png)

> [!NOTE]
> JPanel là lớp container nhẹ đơn giản nhất, là một phần của gói java.swing. Nó có thể nhóm hoặc lưu trữ một tập hợp các thành phần lại với nhau.

## **III. BorderLayout, FlowLayout, GridLayout**

- Sử dụng để sắp xếp các thành phần trong container
- Nếu setLayout cho container là null, có thể điều chỉnh position và size của thành phần bằng method setBounds.

1. **BorderLayout**

- là Layout đặt các component vào 5 khu vực: NORTH, SOUTH, WEST, EAST, CENTER
- khi add 1 component thì sẽ được đặt ở CENTER

```java
//Main.java

public class Main {
    public static void main(String[] args){
        new MyFrame();
    }
}

//MyFrame.java

import javax.swing.*;
import java.awt.*;
public class MyFrame extends JFrame {
    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
        this.setSize(400, 400); // set size of frame
        this.setLayout(new BorderLayout());
        JButton jButton1 = new JButton("NORTH");
        JButton jButton2 = new JButton("SOUTH");
        JButton jButton3 = new JButton("WEST");
        JButton jButton4 = new JButton("EAST");
        JButton jButton5 = new JButton("CENTER");

        jButton1.setBackground(Color.RED);
        jButton2.setBackground(Color.GREEN);
        jButton3.setBackground(Color.BLUE);
        jButton4.setBackground(Color.CYAN);
        jButton5.setBackground(Color.LIGHT_GRAY);
        jButton1.setPreferredSize(new Dimension(100, 100));
        jButton2.setPreferredSize(new Dimension(100, 100));
        jButton3.setPreferredSize(new Dimension(100, 100));
        jButton4.setPreferredSize(new Dimension(100, 100));
        jButton5.setPreferredSize(new Dimension(100, 100));
        this.add(jButton1, BorderLayout.NORTH);
        this.add(jButton2, BorderLayout.SOUTH);
        this.add(jButton3, BorderLayout.WEST);
        this.add(jButton4, BorderLayout.EAST);
        this.add(jButton5, BorderLayout.CENTER);

        this.setVisible(true); // make frame visible
    }
}
```

![Alt text](https://github.com/sybui2004/JAVA---PROPTIT/blob/main/BUOI%2012%20BAI%20TAP%20CUOI%20KHOA%201%20-%20THU%20VIEN%20DO%20HOA%20SWING/B12-11.png)

2. **FlowLayout**

- Đặt các component thành hàng, nếu không đủ chỗ thì sẽ đặt ở hàng tiếp theo

```java
//Main.java

public class Main {
    public static void main(String[] args){
        new MyFrame();
    }
}

//MyFrame.java

import javax.swing.*;
import java.awt.*;
public class MyFrame extends JFrame {
    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
        this.setSize(400, 400); // set size of frame
        this.setLayout(new FlowLayout());
        JButton jButton1 = new JButton("1");
        JButton jButton2 = new JButton("2");
        JButton jButton3 = new JButton("3");
        JButton jButton4 = new JButton("4");
        JButton jButton5 = new JButton("5");

        jButton1.setBackground(Color.RED);
        jButton2.setBackground(Color.GREEN);
        jButton3.setBackground(Color.BLUE);
        jButton4.setBackground(Color.CYAN);
        jButton5.setBackground(Color.LIGHT_GRAY);
        jButton1.setPreferredSize(new Dimension(100, 100));
        jButton2.setPreferredSize(new Dimension(100, 100));
        jButton3.setPreferredSize(new Dimension(100, 100));
        jButton4.setPreferredSize(new Dimension(100, 100));
        jButton5.setPreferredSize(new Dimension(100, 100));
        this.add(jButton1);
        this.add(jButton2);
        this.add(jButton3);
        this.add(jButton4);
        this.add(jButton5);
        this.setVisible(true); // make frame visible
    }
}
```

![Alt text](https://github.com/sybui2004/JAVA---PROPTIT/blob/main/BUOI%2012%20BAI%20TAP%20CUOI%20KHOA%201%20-%20THU%20VIEN%20DO%20HOA%20SWING/B12-12.pngg)

3. **GridLayout**

- Đặt các component vào 1 lưới các ô, mỗi component nhận tất cả khoảng trống có thể của ô đó, mỗi ô có kích thước bằng nhau.

```java
//Main.java

public class Main {
    public static void main(String[] args){
        new MyFrame();
    }
}

//MyFrame.java

import javax.swing.*;
import java.awt.*;
public class MyFrame extends JFrame {
    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
        this.setSize(400, 400); // set size of frame
        this.setLayout(new GridLayout(4, 4, 10, 10));
        JButton jButton1 = new JButton("1");
        JButton jButton2 = new JButton("2");
        JButton jButton3 = new JButton("3");
        JButton jButton4 = new JButton("4");
        JButton jButton5 = new JButton("5");

        jButton1.setBackground(Color.RED);
        jButton2.setBackground(Color.GREEN);
        jButton3.setBackground(Color.BLUE);
        jButton4.setBackground(Color.CYAN);
        jButton5.setBackground(Color.LIGHT_GRAY);
        jButton1.setPreferredSize(new Dimension(100, 100));
        jButton2.setPreferredSize(new Dimension(100, 100));
        jButton3.setPreferredSize(new Dimension(100, 100));
        jButton4.setPreferredSize(new Dimension(100, 100));
        jButton5.setPreferredSize(new Dimension(100, 100));
        this.add(jButton1);
        this.add(jButton2);
        this.add(jButton3);
        this.add(jButton4);
        this.add(jButton5);
        this.setVisible(true); // make frame visible
    }
}
```

![Alt text](https://github.com/sybui2004/JAVA---PROPTIT/blob/main/BUOI%2012%20BAI%20TAP%20CUOI%20KHOA%201%20-%20THU%20VIEN%20DO%20HOA%20SWING/B12-13.png)

> [!NOTE]
> GridLayout(int rows, int cols, int hgap, int vgap): hgap là khoảng cách các cột, vgap là khoảng cách các hàng.

## **IV. Graphics2D, Image**

1. **Graphics2D**

- abstract class kế thừa từ class Graphics, hỗ trợ nhiều công cụ để vẽ và xuất ra hình ảnh, văn bản… định dạng 2 chiều.

```java
//Main.java

public class Main {
    public static void main(String[] args){
        new MyFrame();
    }
}

//MyButton.java

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

//MyFrame.java

import javax.swing.*;

public class MyFrame extends JFrame {
    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
        this.setSize(400, 400); // set size of frame
        this.setLayout(null);
        this.add(new MyButton());
        this.setVisible(true); // make frame visible
    }
}

```

![Alt text](https://github.com/sybui2004/JAVA---PROPTIT/blob/main/BUOI%2012%20BAI%20TAP%20CUOI%20KHOA%201%20-%20THU%20VIEN%20DO%20HOA%20SWING/B12-14.png)


2. **Image**

- Lớp Image trong Java Swing là một phần của gói java.awt và được sử dụng để đại diện cho một hình ảnh.
- Image là một lớp abstract (trừu tượng), nghĩa là bạn không thể tạo một đối tượng Image trực tiếp mà thay vào đó bạn sẽ sử dụng các phương thức tĩnh (static methods) như Toolkit.getImage() hoặc ImageIO.read() để tạo một đối tượng Image từ một tệp hình ảnh hoặc một URL.

```java
import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {
    private Image image;

    public ImagePanel(Image image) {
        this.image = image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, this);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Image Panel Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Image image = Toolkit.getDefaultToolkit().getImage("icon.png");
        ImagePanel panel = new ImagePanel(image);
        
        frame.getContentPane().add(panel);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}

```

![Alt text](https://github.com/sybui2004/JAVA---PROPTIT/blob/main/BUOI%2012%20BAI%20TAP%20CUOI%20KHOA%201%20-%20THU%20VIEN%20DO%20HOA%20SWING/B12-15.png)

> [!NOTE]
> ImageIcon trong Java Swing là một lớp được sử dụng để hiển thị và quản lý hình ảnh trong các thành phần giao diện người dùng Swing. ImageIcon thường được sử dụng để hiển thị hình ảnh trong các thành phần như JLabel, JButton, và JMenuItem.

```java
//ImageIconExample.java
public class ImageIconExample{
    public static void main(String[] args) {
        new MyFrame();
    }
}

//MyFrame.java

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


```

![Alt text](https://github.com/sybui2004/JAVA---PROPTIT/blob/main/BUOI%2012%20BAI%20TAP%20CUOI%20KHOA%201%20-%20THU%20VIEN%20DO%20HOA%20SWING/B12-16.png)
=======
![Alt text](https://github.com/sybui2004/JAVA---PROPTIT/blob/main/BUOI%2012%20BAI%20TAP%20CUOI%20KHOA%201%20-%20THU%20VIEN%20DO%20HOA%20SWING/B12-16.png)
