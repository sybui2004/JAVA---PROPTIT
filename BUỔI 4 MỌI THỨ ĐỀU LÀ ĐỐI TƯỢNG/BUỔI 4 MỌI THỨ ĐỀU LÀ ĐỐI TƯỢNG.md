# **Buổi 4: MỌI THỨ ĐỀU LÀ ĐỐI TƯỢNG**

## **I. Trả lời câu hỏi về bài tập buổi trước**
## **II. Tính đóng gói trong Java**
>- Là kỹ thuật ẩn giấu thông tin không liên quan và hiện thị ra thông liên quan. Mục đích chính của đóng gói trong java là giảm thiểu mức độ phức tạp phát triển phần mềm.

>-  Là một tiến trình đóng gói code và dữ liệu lại với nhau vào trong một đơn vị unit đơn. Chúng ta có thể tạo một lớp được bao đóng hoàn toàn trong Java bằng việc tạo tất cả thành viên dữ liệu của lớp là private. Chúng ta sử dụng phương thức public setter và getter để thiết lập và lấy dữ liệu trong nó.

>- Để đạt được đóng gói trong Java chúng ta cần:
    - Khai báo các biến của một lớp là private.
    - Cung cấp phương thức setter và getter là public để có thể sửa đổi và xem các giá trị biến.

VD: 
```java
public class Student {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
```

>- Quy ước đặt tên phương thức getter và setter như sau:
Getter: bắt đầu bằng chữ get + viết hoa chữ đầu tiên tất cả các từ (viết hoa chữ đầu tiên của tên biến).
Setter: bắt đầu bằng chữ set + viết hoa chữ đầu tiên tất cả các từ (viết hoa chữ đầu tiên của tên biến).

### Lợi ích của đóng gói trong java:
Tất cả các trường (field) của lớp có chế độ chỉ đọc (read-only) hoặc chỉ ghi (write-only), tức là chỉ có hàm getter hoặc setter.
Một lớp có thể có toàn bộ điều khiển thông qua những gì được lưu giữ trong các trường (field) của nó.
Người sử dụng của class không biết cách các class lưu trữ dữ liệu. Một class có thể thay đổi kiểu dữ liệu của một trường và người dùng class không cần sự thay đổi trong code.

## **III. Tính kế thừa trong Java**

>- Kế thừa là sự liên quan giữa hai class với nhau, trong đó có class cha (superclass) và class con (subclass). Khi kế thừa class con được hưởng tất cả các phương thức và thuộc tính của class cha. Tuy nhiên, nó chỉ được truy cập các thành viên public và protected của class cha. Nó không được phép truy cập đến thành viên private của class cha.

>- Tư tưởng của kế thừa trong java là có thể tạo ra một class mới được xây dựng trên các lớp đang tồn tại. Khi kế thừa từ một lớp đang tồn tại bạn có sử dụng lại các phương thức và thuộc tính của lớp cha, đồng thời có thể khai báo thêm các phương thức và thuộc tính khác.

Cú pháp:
```java
class Super {

}
class Sub extends Super {

}
```
VD:
```java
public class Moto {
 
    protected price = 1000;
 
}
 
public class Bike extends Moto {
    int bonus = 10000;
    public static void main(String args[]) {
        Bike p = new Bike();
        System.out.println("Price of Moto is:" + p.price);
        System.out.println("Bonus of Bike is:" + p.bonus);
    }
 
}
```
>- Trong ví dụ trên, class Bike là con của class Moto, nên nó được phép truy cập đến field price của class Moto.

### Các kiểu kế thừa trong Java

>- Có 3 kiểu kế thừa trong java: đơn kế thừa (single), kế thừa nhiều cấp (multilevel), kế thừa thứ bậc (hierarchical).
>- Khi một class được kế thừa từ nhiều class đươc gọi là đa kế thừa.

>- Trong java, một class không được phép thừa kế từ nhiều class, có thể cài đặt (implement) nhiều interface. Tuy nhiên, một interface có thể thừa kế nhiều interface.
Hay nói cách khác class trong Java không có tính đa kế thừa


![Alt text](https://github.com/sybui2004/JAVA---PROPTIT/blob/main/BU%E1%BB%94I%204%20M%E1%BB%8CI%20TH%E1%BB%A8%20%C4%90%E1%BB%80U%20L%C3%80%20%C4%90%E1%BB%90I%20T%C6%AF%E1%BB%A2NG/B4-1.png)

- VD Đơn kế thừa :

```java
public class Animal {
    public void eat() {
        System.out.println("eating...");
    }
}
public class Dog extends Animal {
    public void bark() {
        System.out.println("barking...");
    }
}
public class TestInheritance {
    public static void main(String args[]) {
        Dog d = new Dog();
        d.bark();
        d.eat();
    }
}
```
Kết quả
`barking...`
`eating...`

VD Kế thừa nhiều cấp :
```java
public class Animal {
    public void eat() {
        System.out.println("eating...");
    }
}
public class Dog extends Animal {
    public void bark() {
        System.out.println("barking...");
    }
}
public class BabyDog extends Dog {
    public void weep() {
        System.out.println("weeping...");
    }
}
public class TestInheritance2 {
    public static void main(String args[]) {
        BabyDog d = new BabyDog();
        d.weep();
        d.bark();
        d.eat();
    }
}
```
Kết quả:
`weeping...`
`barking...`
`eating..`

VD Kế thừa thứ bậc:
```java
class Animal {
    public void eat() {
        System.out.println("eating...");
    }
}
class Dog extends Animal {
    public void bark() {
        System.out.println("barking...");
    }
}
public class Cat extends Animal {
    public void meow() {
        System.out.println("meowing...");
    }
}
public class TestInheritance3 {
    public static void main(String args[]) {
        Cat c = new Cat();
        c.meow();
        c.eat();
    }
}
```
Kết quả:
`meowing...`
`eating...`

### Lợi ích của kế thừa trong Java
>- Để ghi đè phương thức (Method Overriding), do đó có thể thu được tính đa hình tại runtime.
>- Để làm tăng tính tái sử dụng của code.

### Tại sao đa kế thừa không được support trong Java

>- Để giảm thiểu sự phức tạp và đơn giản hóa ngôn ngữ, đa kế thừa không được support trong java.
Hãy suy xét kịch bản sau: Có 3 lớp A, B, C. Trong đó lớp C kế thừa từ các lớp A và B. Nếu các lớp A và B có phương thức giống nhau và bạn gọi nó từ đối tượng của lớp con, như vậy khó có thể xác đinh được việc gọi phương thức của lớp A hay B.
Java sẽ print ra lỗi “compile time error” nếu bạn cố tình kế thừa 2 class.

```java
public class Printable {
    void print() {
        System.out.println("Printable");
    }
}  
public class Showable {  
    void print() {
        System.out.println("Showable");
    }
}  
// Không thể thực hiện đa thừa kế với class
public class MultiHeritanceExample extends Printable, Showable {  
    public static void main(String args[]) {  
        MultiHeritanceExample obj = new MultiHeritanceExample();  
        obj.print();  // Không thể xác định được gọi phương thức print() của class nào
    }  
}  
```
## **III. Tính đa hình trong Java**

>- Là khả năng một đối tượng có thể thực hiện một tác vụ theo nhiều cách khác nhau.

>-  Được thể hiện rõ nhất qua việc gọi phương thức của đối tượng. Các phương thức hoàn toàn có thể giống nhau, nhưng việc xử lý luồng có thể khác nhau. Nói cách khác: Tính đa hình cung cấp khả năng cho phép người lập trình ***gọi trước một phương thức của đối tượng***, tuy chưa xác định đối tượng có phương thức muốn gọi hay không. Đến khi thực hiện (run-time), chương trình mới xác định được đối tượng và gọi phương thức tương ứng của đối tượng đó.

>- Trong Java, chúng ta sử dụng nạp chồng phương thức (method overloading) và ghi đè phương thức (method overriding) để có tính đa hình.
Nạp chồng (Overloading): Đây là khả năng cho phép một lớp có nhiều thuộc tính, phương thức cùng tên nhưng với các tham số khác nhau về loại cũng như về số lượng. Khi được gọi, dựa vào tham số truyền vào, phương thức tương ứng sẽ được thực hiện.
Ghi đè (Overriding): là hai phương thức cùng tên, cùng tham số, cùng kiểu trả về nhưng thằng con viết lại và dùng theo cách của nó, và xuất hiện ở lớp cha và tiếp tục xuất hiện ở lớp con. Khi dùng override, lúc thực thi, nếu lớp Con không có phương thức riêng, phương thức của lớp Cha sẽ được gọi, ngược lại nếu có, phương thức của lớp Con được gọi.

VD Overloading:
```java
class Program{
    public static double tinhTong(double a, double b) 
        return a+b;
    public static int tinhTong(int a, int b)
        return a+b;
}
```
VD Overriding:
```java
public class Book {
    private String title, author, type, dateOfPublish;
    private int id;
    @Override
    public String toString() {
        return String.format("|%-3d|%-13s|%-15s|%-12s|%-16s|", id, title, author, type, dateOfPublish);
    }
}
```
>- run time: là thời điểm chương trình đang chạy
compile time: là thời điểm source code đang được compile
Thông thường run time và compile time được nhắc tới khi nói tới lỗi. Lỗi run time tức là lỗi khi chạy mới thấy, tức lỗi logic. Lỗi compile time là lỗi compile là thấy ngay, tức là lỗi cú pháp.

Khác nhau giữa Overloading và Overriding

![Alt text](https://github.com/sybui2004/JAVA---PROPTIT/blob/main/BU%E1%BB%94I%204%20M%E1%BB%8CI%20TH%E1%BB%A8%20%C4%90%E1%BB%80U%20L%C3%80%20%C4%90%E1%BB%90I%20T%C6%AF%E1%BB%A2NG/B4-2.png)
