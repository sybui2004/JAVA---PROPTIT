# **BUỔI 9: LUÔN CÓ NGOẠI LỆ, XỬ LÍ NGOẠI LỆ**

## **I. Làm quen với Exception: Checked và Unchecked Exception, Error**

####1. **Exception** (ngoại lệ)
 - Là một tình trạng bất thường, là một sự kiện xảy ra trong quá trình thực thi một chương trình Java, nó làm phá vỡ flow (luồng xử lý) bình thường của một chương trình, thậm chí chết chương trình. Nó là một đối tượng được ném ra tại runtime.

- Các loại Exception:
    + **Checked** : là các lớp extends từ lớp Throwable ngoại trừ RuntimeException và Error. Các Checked Exception được kiểm tra tại compile-time. Loại exception này không thể bỏ qua được trong quá trình compile, bắt buộc ta phải handle nó. Ví dụ: IOException, FileNotFoundException, NoSuchFieldException, ….
    ![Alt text][(https://github.com/sybui2004/JAVA/blob/main/B9-1.png)]
    ![Alt text][(https://github.com/sybui2004/JAVA/blob/main/B9-2.png)]
    + **Unchecked** : Các lớp extends từ RuntimeException được gọi là Unchecked Exception. Các Exception này thường xảy ra khi lỗi đó không lường trước được. Loại exception này xảy ra tại thời điểm thực thi chương trình, nó cũng có thể gọi là runtime exceptions đó là programming bugs, lỗi logic của chương trình… Loại exception này được bỏ qua trong quá trình compile, không bắt buộc ta phải handle nó. Ví dụ: NullPointerException, NumberFormatException, ArrayIndexOutOfBoundsException, DivideByZeroException, …
    ![Alt text][(https://github.com/sybui2004/JAVA/blob/main/B9-3.png)]
    + **Error** : là những vấn đề nghiêm trọng liên quan đến môi trường thực thi của ứng dụng hoặc hệ thống mà lập trình viên không thể kiểm soát. Nó thường làm chết chương trình. Lớp Error định nghĩa các ngoại lệ mà không thể bắt (catch) từ chương trình. Ví dụ: OutOfMemoryError, VirtualMachineError, and StackOverflowError, …
    Ví dụ đệ quy vô tận:
    ![Alt text][(https://github.com/sybui2004/JAVA/blob/main/B9-4.png)]

####2. Một số Exception:
    - Checked Exceptions : 
        + IOException: Ngoại lệ liên quan đến file input / output.
        + SQLException: Ngoại lệ liên quan đến cú pháp SQL.
        + DataAccessException: Ngoại lệ liên quan đến việc truy cập CSDL.
        + ClassNotFoundException: Bị ném khi JVM không thể tìm thấy một lớp mà nó cần, do lỗi dòng lệnh, sự cố đường dẫn hoặc tệp, class bị thiếu…
        + InstantiationException: Ngoại lệ khi cố gắng tạo đối tượng của một abstract class hoặc interface.
    - UnChecked Exceptions
        + NullPointerException: Ngoại lệ bị ném ra khi cố gắng truy cập một đối tượng có biến tham chiếu có giá trị hiện tại là null
        + ArrayIndexOutOfBound: Ngoại lệ khi cố gắng truy cập một phần tử vượt quá độ dài của mảng
        + IllegalArgumentException: Ngoại lệ bị ném ra khi một phương thức nhận được một đối số được định dạng khác với phương thức mong đợi.
        + IllegalStateException: Ngoại lệ bị ném ra khi trạng thái của môi trường không phù hợp với hoạt động cố gắng thực hiện, ví dụ: Sử dụng Scanner đã bị đóng.
        + NumberFormatException: Ngoại lệ bị ném khi một phương thức chuyển đổi một Chuỗi thành số nhưng không thể chuyển đổi.
        + ArithmeticException: Lỗi số học, chẳng hạn như chia cho 0.

## **II. Bắt Exception với try-catch**
Cú pháp :
```java
try {
    // code có thể ném ra ngoại lệ
} catch(Exception_class_Name ex) {
    // code xử lý ngoại lệ
}
```

VD: xử lí ArithmeticException
```java
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            int zero = 0;
            int average = 10 / zero;
            System.out.println("Average = " + average);
        } catch (ArithmeticException ex) {
            System.out.println(ex);
        }
    }
}
```
Sử dụng try-catch lồng nhau:
```java
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            try {
                int zero = 0;
                int average = 10 / zero;
                System.out.println("Average = " + average);
            } catch (ArithmeticException ex) {
                System.out.println(ex);
            }

            System.out.println("Continue...");
            int arr[] = new int[5];
            arr[5] = 4;
            System.out.println("arr[5] = " + arr[5]);

        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println(ex);
        }
    }
}
```

Sử dụng nhiều khối lệnh catch:
```java
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            int arr[] = new int[5];
            arr[5] = 4;
            System.out.println("arr[5] = " + arr[5]);

            int zero = 0;
            int average = 10 / zero;
            System.out.println("Average = " + average);

            String obj = null;
            System.out.println(obj.length());
        } catch (NullPointerException | ArithmeticException | ArrayIndexOutOfBoundsException ex) {
            System.out.println(ex);
        }
    }
}
```
## **III. Sử dụng finally**
- Khối lệnh finally trong java được sử dụng để thực thi các lệnh quan trọng như đóng kết nối, đóng cả stream,…
- Khối lệnh finally trong java luôn được thực thi cho dù có ngoại lệ xảy ra hay không hoặc gặp lệnh return trong khối try.
- Quy tắc:
    + Đối với mỗi khối try, có thể có không hoặc nhiều khối catch, nhưng chỉ có một khối finally.
    + Khối finally sẽ không được thực thi nếu chương trình bị thoát bằng cách gọi System.exit() hoặc xảy ra một lỗi không thể tránh khiến chương trình bị chết.

Ví dụ:
```java
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            int arr[] = new int[5];
            arr[5] = 4;
            System.out.println("arr[5] = " + arr[5]);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println(ex);
        } finally {
            System.out.println("Khối lệnh finally luôn được thực thi");
        }
    }
}
```

Kết quả:
```java
java.lang.ArrayIndexOutOfBoundsException: 5
Khối lệnh finally luôn được thực thi
```

```java
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            int arr[] = new int[5];
            arr[5] = 4;
            System.out.println("arr[5] = " + arr[5]);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println(ex);
            System.exit(0);
        } finally {
            System.out.println("Khối lệnh finally luôn được thực thi");
        }
    }
}
```

Kết quả:
```java
java.lang.ArrayIndexOutOfBoundsException: 5
```

## **IV. Cây phân cấp Exception, phân biệt throw và throws**
####1. Cây phân cấp Exception

![Alt text][(https://github.com/sybui2004/JAVA/blob/main/B9-5.png)]

####2. Phân biệt throw và throws

- **Throw**:
  + Nằm bên trong hàm/phương thức.

  + Từ khóa throw trong java được sử dụng để ném ra một ngoại lệ rõ ràng.

  + Ngoại lệ checked không được truyền ra nếu chỉ sử dụng từ khóa throw.

  + Sau throw là một instance.

  + Throw được sử dụng trong phương thức có thể quăng ra Exception ở bất kỳ dòng nào trong phương thức (sau đó dùng try-catch để bắt hoặc throws cho thằng khác sử lý)

  + Từ khóa throw chủ yếu được sử dụng để ném ngoại lệ tùy chỉnh (ngoại lệ do người dùng tự định nghĩa).

  + Không thể throw nhiều exceptions.
- **Throws**:
  + Nằm ngay sau phần khai báo tên hàm/phương thức.

  + Từ khóa throws trong java được sử dụng để khai báo một ngoại lệ.

  + Ngoại lệ checked được truyền ra ngay cả khi chỉ sử dụng từ khóa throws.

  + Throws được khai báo ngay sau dấu đóng ngoặc đơn của phương thức. Khi một phương thức có throw bên trong mà không bắt lại (try – catch) thì phải ném đi (throws) cho thằng khác xử lý.

  + Theo sau throws có thể là một hoặc nhiều lớp(class).

  + 	Có thể khai báo nhiều exceptions, Ví dụ:
  ```java
  public void method() throws IOException, SQLException { }
  ```

## **V. Tạo ra Exception của riêng mình**

- Khi bạn phát triển một ứng dụng Java phức tạp, có thể bạn muốn xử lý các tình huống đặc biệt mà các lớp ngoại lệ có sẵn trong Java không đáp ứng. Trong trường hợp này chúng ta cần custom exception.
- Chúng ta có thể khai báo 1 class mới và extends Exception để trở thành 1 ngoại lệ **checked**

```java
//File : CustomException.java
public class CustomException extends Exception {
    CustomException (String s) {
        super(s);
    }
}

//File : Main.java
public class Main {
    static void validAge(int age) throws CustomException {
        if (age < 18)
            throw new CustomException("Tuổi không hợp lệ");
        else
            System.out.println("Chào mừng bạn đã đủ tuổi");
    }

    public static void main(String args[]) {
        try {
            validAge(13);
        } catch (CustomException e) {
            System.out.println("Xảy ra ngoại lệ: " + e.getMessage());
        }
    }
}

```
Kết quả:

```java
Xảy ra ngoại lệ: Tuổi không hợp lệ
```

- Chúng ta có thể khai báo 1 class mới và extends RuntimeException để trở thành 1 ngoại lệ **unchecked**

```java
//File : CustomException.java
public class CustomException extends RuntimeException {
    CustomException (String s) {
        super(s);
    }
}

//File : Main.java
public class Main {
    static void validAge(int age) {
        if (age < 18)
            throw new CustomException("Tuổi không hợp lệ");
        else
            System.out.println("Chào mừng bạn đã đủ tuổi");
    }

    public static void main(String args[]) {
        try {
            validAge(13);
        } catch (CustomException e) {
            System.out.println("Xảy ra ngoại lệ: " + e.getMessage());
        }
    }
}

```

Kết quả : 
```java
Xảy ra ngoại lệ: Tuổi không hợp lệ
```
