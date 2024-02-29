# **BUỔI 10: NHẬP XUẤT FILE, UNIT TEST**

## **I. Xử lí File trong Java (Binary file, Text file)**
1. **File**
- Package java.io có lớp File cho phép bạn làm việc với các file (tệp). Thường để bắt đầu, cần tạo ra một đối tượng File bằng khởi tạo với tham số đường dẫn.
```java
import java.io.File;
...
File file = new File("C:\\data\\input-file.txt");
```
- 1 số phương thức của lớp file:
```java
    + boolean exists() kiểm tra xem file có tồn tại hay không

    + String getName() lấy tên file (input-file.txt)

    + String getParent() lấy đường dẫn thư mục của file

    + String getPath() đường dẫn đầy đủ

    + boolean isDirectory() kiểm tra xem là thư mục hay không

    + boolean isFile() kiểm tra xem là file hay không

    + long length() cỡ file (byte)

    + createNewFile() tạo ra file mới

    + delete() xóa file

    + String list() lấy tên file, thư mục chứa trong đường dẫn

    + mkdir() tạo thư mục

    + renameTo(File dest) đổi tên file
```
- Đọc dữ liệu:

    + [InputStream](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/io/InputStream.html)
    + [Reader](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/io/Reader.html)
- Ghi dữ liệu:
    + [OutputStream](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/io/OutputStream.html)
    + [Writer](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/io/Writer.html)
- ![Alt text](https://github.com/sybui2004/JAVA---PROPTIT/blob/main/BU%E1%BB%94I%2010%20NH%E1%BA%ACP%20XU%E1%BA%A4T%20FILE%2C%20UNIT%20TEST/B10-1.jpg)
- ![Alt text](https://github.com/sybui2004/JAVA---PROPTIT/blob/main/BU%E1%BB%94I%2010%20NH%E1%BA%ACP%20XU%E1%BA%A4T%20FILE%2C%20UNIT%20TEST/B10-2.jpg)

```java
import java.io.File;

public class Main {
  public static void main(String[ ] args) {
    File file = new File("test.txt");

    System.out.println("Tên file: " + file.getName());
    System.out.println("Thư mục: " + file.getParent());
    System.out.println("Thư mục: " + file.getPath());


    if(file.exists()) {
        System.out.println(file.getName() +  "exists!");
    }
    else {
        System.out.println("The file does not exist");
    }
  }
}
```


1. **Binary file**
 - là một loại file chứa dữ liệu không được định dạng theo kiểu văn bản thông thường, mà thay vào đó là dữ liệu được biểu diễn dưới dạng các byte (8-bit). Các binary file thường chứa thông tin như hình ảnh, âm thanh, video, hay bất kỳ dữ liệu nào khác cần được xử lý dưới dạng nhị phân.
 - Trong Java, có thể đọc và ghi dữ liệu từ và vào các binary file bằng cách sử dụng các lớp như FileInputStream và FileOutputStream để thực hiện các thao tác đọc và ghi byte. Ngoài ra, có các lớp và phương thức khác như BufferedInputStream, BufferedOutputStream, DataInputStream, và DataOutputStream giúp bạn thực hiện các thao tác đọc và ghi dữ liệu có cấu trúc hơn.

- Đọc và ghi Binary File
```java
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filePath = "example.bin";

        // Ghi dữ liệu vào binary file
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            byte[] dataToWrite = { 65, 66, 67, 68, 69 }; // Mã ASCII của A, B, C, D, E
            fos.write(dataToWrite);
            System.out.println("Data written to file successfully.");
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Đọc dữ liệu từ binary file
        try (FileInputStream fis = new FileInputStream(filePath)) {
            int byteRead;
            while ((byteRead = fis.read()) != -1) {
                System.out.print((char) byteRead);
            }
            System.out.println("\nData read from file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

```

- Kết quả:
```java
Data written to file successfully.
ABCDE
Data read from file successfully.
```

3. **Text file**
 - là một loại file chứa dữ liệu được biểu diễn dưới dạng văn bản, thường là các ký tự ASCII hoặc Unicode. Text file thường chứa thông tin dưới dạng các dòng văn bản và được sử dụng rộng rãi để lưu trữ và truyền tải dữ liệu dạng văn bản, chẳng hạn như cấu hình, hoặc dữ liệu văn bản thông thường.
 - đọc và ghi dữ liệu từ và vào text file sử dụng các lớp như FileReader, FileWriter, BufferedReader, và BufferedWriter.
```java
import java.io.*;

public class Main {
    public static void main(String[] args) {
        String filePath = "example.txt";

        // Ghi dữ liệu vào text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
    
            writer.write("Hello, this is a text file example.");
            writer.newLine(); // Thêm dòng mới
            writer.write("Second line of text.");

            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

         // Đọc dữ liệu từ text file
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            System.out.println("Data read from file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

```

- Kết quả:
```java
Data written to file successfully.
Hello, this is a text file example.
Second line of text.
Data read from file successfully.
```
Khi cần sử dụng binary file và text file có thể lưu ý một số điểm sau đây:
- Dữ liệu Cấu trúc và Phức tạp: Nếu dữ liệu có cấu trúc phức tạp, chẳng hạn như đối tượng Java hoặc dữ liệu đa chiều, sử dụng binary file có thể là lựa chọn tốt hơn. Binary file cho phép lưu trữ dữ liệu mà không cần chuyển đổi nó thành dạng văn bản, giúp duy trì cấu trúc gốc của dữ liệu.

- Hiệu suất: Binary file thường hiệu quả hơn về mặt hiệu suất so với text file, vì chúng không yêu cầu quá trình chuyển đổi giữa dữ liệu và văn bản. Nếu hiệu suất là một yếu tố quan trọng, sử dụng binary file có thể là lựa chọn tốt hơn.

- Kích thước file: Binary file thường có thể tạo ra file nhỏ hơn so với text file khi lưu trữ cùng một lượng dữ liệu. Điều này do binary file không cần chứa các ký tự và định dạng văn bản mà text file thường có.

- Chỉnh sửa thuận tiện: Khi chỉnh sửa dữ liệu thủ công hoặc muốn dễ đọc và hiểu, text file có thể là lựa chọn tốt hơn. Các text file có thể được mở và chỉnh sửa bằng các trình soạn thảo văn bản thông thường, trong khi việc chỉnh sửa binary file có thể phức tạp hơn và đôi khi đòi hỏi kiến thức chi tiết về định dạng dữ liệu.

- Tương thích và Giao tiếp với các ứng dụng khác: Nếu cần tương thích với các ứng dụng khác, đặc biệt là nếu các ứng dụng đó kỳ vọng hoặc hỗ trợ đọc/ghi dữ liệu dưới dạng text, thì sử dụng text file có thể là lựa chọn tốt hơn.

## **II. Assertions**
- Assertion trong Java trong Java giúp phát hiện lỗi bằng cách kiểm tra mã mà chúng ta cho là đúng. Trong khi thực hiện một xác nhận, ta giả định nó là đúng. Nếu xác nhận không thành công, thì JVM sẽ ném ra lỗi AssertionError và dừng ngay lập tức.
- Cú pháp của nó là:

```java
assert condition; 
```
- Trong đó condition là một biểu thức boolean mà chúng ta giả sử là đúng khi chương trình thực thi.
- Theo mặc định, các xác nhận(assertions) bị tắt và bị bỏ qua trong thời gian chạy.

Để bật assert , chúng ta sử dụng:

``java -ea:arguments``

hoặc

``java -enableassertions:arguments``

**Edit configuration -> Modify options -> VM options -> viết -ea: NameofClass**
- Khi các xác nhận(assert) được kích hoạt và điều kiện là true, chương trình sẽ thực thi bình thường. Nhưng nếu điều kiện được đánh giá là false trong khi các xác nhận(assert) được bật, JVM sẽ ném một dấu AssertionError và chương trình dừng ngay lập tức.

```java
public class Main {
    public static void main(String[] args) {
        String a = "Sy";
        assert a.equals("BTS");
        System.out.println("Dung roi ne!");
    }
}
```

Kết quả:
```java
Dung roi ne!
```
Chúng ta nhận được kết quả ở trên vì chương trình này không có lỗi biên dịch và theo mặc định, các xác nhận(assert) bị vô hiệu hóa.

Sau khi bật xác nhận(assert), chúng ta nhận được kết quả sau:

- ![Alt text](https://github.com/sybui2004/JAVA---PROPTIT/blob/main/BU%E1%BB%94I%2010%20NH%E1%BA%ACP%20XU%E1%BA%A4T%20FILE%2C%20UNIT%20TEST/B10-3.png)

- Dạng khác:
    + assert condition : expression;
- Trong dạng câu lệnh khẳng định này, một biểu thức được chuyển tới hàm tạo của đối tượng AssertionError. Biểu thức này có một giá trị được hiển thị dưới dạng thông báo chi tiết của lỗi nếu điều kiện là false.
- Thông báo chi tiết được sử dụng để nắm bắt và truyền thông tin về lỗi xác nhận để giúp gỡ lỗi vấn đề.

```java
public class Main {
    public static void main(String[] args) {
        String a = "Sy";
        assert a.equals("BTS") : "Phai la BTSZ";
        System.out.println("Dung roi ne!");
    }
}
```
Kết quả:

- ![Alt text](https://github.com/sybui2004/JAVA---PROPTIT/blob/main/BU%E1%BB%94I%2010%20NH%E1%BA%ACP%20XU%E1%BA%A4T%20FILE%2C%20UNIT%20TEST/B10-4.png)

- Để kích hoạt xác nhận(Assertion) cho tất cả các lớp của chương trình Chính của chúng ta
```java
java -ea Main
```
Để bật một lớp,
```java
java -ea: <ClassT> Main
```
Điều này cho phép xác nhận(Assertion) chỉ ClassT trong Main của chương trình.
- Nếu muốn tắt:
```java
java -da arguments 
```
hoặc
```java
java -disableassertions arguments
```

Ưu điểm:
- Kiểm tra điều kiện: assert giúp kiểm tra rằng một điều kiện nhất định là đúng hoặc sai, nếu sai nó sẽ ném ra một AssertionError. Điều này giúp cho việc kiểm tra lỗi trong quá trình phát triển trở nên dễ dàng hơn.
- Tăng tính bảo mật: assert giúp cho việc kiểm tra lỗi trở nên an toàn hơn vì nó chỉ hoạt động khi chế độ -ea hoặc -enableassertions được bật trong JVM, mặc định assert sẽ không hoạt động.
- Giảm thiểu số lượng mã: assert giúp giảm thiểu số lượng mã bằng cách tự động kiểm tra điều kiện mà không cần phải viết thêm mã kiểm tra.
- Tăng tính dễ dàng quản lý: assert giúp cho việc kiểm tra lỗi trở nên dễ dàng hơn vì nó cho phép bạn chỉ định một message lỗi mà không cần phải viết thêm mã xử lý lỗi.

## **III. Unit test**
- là mức độ kiểm thử nhỏ nhất trong quy trình kiểm thử phần mềm. Unit test kiểm thử các đơn vị nhỏ nhất trong mã nguồn như method, class, module… Do đó Unit test nhằm kiểm tra mã nguồn của các chương trình, các chức năng riêng rẽ hoạt động đúng hay không.

1. **JUnit**
- là một framework đơn giản dùng cho việc tạo các unit testing tự động, và chạy các test có thể lặp đi lặp lại. Nó chỉ là một phần của họ kiến trúc xUnit cho việc tạo các unit testing.
- JUnit là một chuẩn trên thực tế cho unit testing trong Java.
- JUnit test framework cung cấp cho chúng ta các gói lớp có sẵn cho phép chúng ta viết các phương thức test một cách dễ dàng.
- TestRunner sẽ chạy các test và trả về kết quả là các Test Results.
- Các lớp của chương trình test chúng ta sẽ được kế thừa các lớp trừu tượng TestCase.
- Khi viết các Test Case chúng ta cần biết và hiểu lớp Assert class.
- Một số định nghĩa trong mô hình tổng quát:
    + Test case : test case định nghĩa môi trường mà nó có thể sử dụng để chạy nhiều test khác nhau
    + TestSuite : testsuite là chạy một tập các test case và nó cũng có thể bao gồm nhiều test suite khác, test suite chính là tổ hợp các test.
  
2. **Cách viết một test case**
- Project -> Maven
- Trong file pom.xml thêm:
```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>5.10.2</version>
    <scope>test</scope>
</dependency>
```
- Tạo 1 class Test trong folder test/java:
    VD:
    ```java
    import org.example.Main;
    import org.junit.jupiter.api.Assertions;
    import org.junit.jupiter.api.Test;

    public class Test1 {
        @Test
        public void Test_1(){
            int a = 2, b = 2;
            int add = 3;
            Main main = new Main();
            Assertions.assertEquals(add, main.add(a, b));
        }
    }
    ```

- Trong class Main:
    ```java
    package org.example;

    public class Main {
        public int add (int a, int b)
        {
            return a + b;
        }

        public static void main(String[] args) {
            System.out.println("Hello world!");
        }
    }
    ```
- Chạy file test
- Chúng ta có thể tạo ra nhiều test giống như cph trong vscode.
 + [Source](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/io/OutputStream.html)
## **IV. Tầm quan trọng của việc viết Unit test**
- Làm giảm tổng số lỗi trong quá trình code.
- Làm cho dòng code của bạn trở lên dễ bảo trì và tái sử dụng hơn.
- Giúp sửa bug sớm trong chu trình phát triển sản phẩm và tiết kiệm chi phí và thời gian
- Có thể xây dựng một bộ kiểm thử bao gồm nhiều các test khác nhau có thể chạy trong bất cứ thời gian nào.
