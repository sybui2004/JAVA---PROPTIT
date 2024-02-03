# **Buổi 3: CÁCH JAVA LƯU TRỮ DỮ LIỆU**

## **I. CÁCH JAVA LƯU TRỮ DỮ LIỆU**
Khi một chương trình Java được thực thi, nó sẽ yêu cầu hệ điều hành cấp phát một ***không gian trên bộ nhớ*** để lưu trữ toàn bộ dữ liệu và thông tin của nó.

Sau đó, nó sẽ chia vùng không gian đó thành 4 vùng nhớ (`memory segment`) để lưu trữ.

![Alt text](https://github.com/sybui2004/JAVA/blob/main/B3-1.png)
>- `Vùng nhớ code` (code segment), tất cả mã chương trình (machine code) được lưu ở đây khi chương trình được thực thi.

>- `Vùng nhớ data` (data segment), lưu trữ những dữ liệu chung của chương trình như các biến static, constant,… những biến dữ liệu mà được sinh ra khi chương trình bắt đầu thực thi và chỉ được giải phóng khi chương trình kết thúc.

>- `Vùng nhớ stack` (stack segment), đây sẽ là nơi lưu trữ các biến thuộc nhóm kiểu dữ liệu cơ sở (primitive data type như là boolean, int, char,…) và địa chỉ của ô nhớ (memory address).
Dữ liệu ở đây chia theo các nhóm gọi là ***stack frame***, và mỗi ***stack frame*** sẽ được lưu vào vùng nhớ stack theo cơ chế vào sau ra trước như một stack.
***Stack Frame*** lưu trữ các biến cục bộ (local variable) của hàm, đối số (argument) và giá trị trả về (return value). Một stack frame được thêm vào ngăn xếp stack mỗi khi một hàm mới được gọi và loại bỏ khi hàm đó được thoát / trả về (return). Một ngăn xếp bao gồm một tập hợp các stack frame được quản lý theo cơ chế vào trước ra sau. ` Mỗi phương thức được thực thi sẽ tạo ra một stack frame.` Ta có thể minh họa ***stack segment*** qua ví dụ sau: 
```java
public class Test {
    public static void call2(){
        int a = 1;
        System.out.print(a + " ");
    }
    public static void call1(){
        int b = 2;
        System.out.print(b + " ");
        call2(); 
    }
    public static void main(String[] args){
        int c = 3;
        System.out.print(c + " ");
        call1();
    }
}
```
Kết quả cho ra như sau :
>3
2
1

Khi chương trình này thực thi, nó sẽ tạo ra 3 ***Stack Frame*** và push vào vùng nhớ stack theo thứ tự nó được gọi: main, call1, call2.
Với phương thức main() ta có biến c = 3 nên giá trị 3 này sẽ được lưu trữ ở ***Stack Frame main***, và biến c này cũng sẽ có phạm vi sử dụng trong phương thức main() mà thôi.

Tương tự với các phương thức call1() và call2(), ta cũng sẽ có các biến b và a tương ứng. Biến b sẽ được lưu trữ ở ***Stack Frame call1*** và chỉ có phạm vi sử dụng ở đó, tương tự cho biến a cũng sẽ được lưu trữ ở ***Stack Frame call2*** và chỉ có phạm vi sử dụng ở đây thôi.

Khi call2() thực thi xong, ***Stack Frame call2*** sẽ được pop ra khỏi vùng nhớ stack, biến a (với giá trị là 1) đồng thời cũng được giải phóng. Sau đó ***Stack Frame call1*** sẽ được pop, biến b được giải phóng và cuối cùng là tới ***Stack Frame main*** và biến c.
>- `Vùng nhớ heap` (heap segment), đây là nơi lưu trữ tất cả các object được sinh ra trong thời gian thực thi chương trình. Heap được tạo ra khi JVM start up và có thể tăng hoặc giảm kích thước khi các ứng dụng chạy. Khi heap trở nên đầy, quá trình thu gom rác (GC) sẽ chạy, lúc này các đối tượng không còn được sử dụng sẽ bị xóa đi, tạo ra khoảng trống cho các đối tượng mới trên heap. 

`Với vùng nhớ Code và Data, khi chương trình thực thi sẽ cấp phát một không gian có kích thước không đổi. Còn đối với vùng nhớ Stack và Heap, kích thước của nó sẽ thay đổi (mở rộng khi tạo thêm biến hoặc đối tượng, thu hẹp khi một biến hoặc đối tượng được giải phóng) `


### **1. Đối với kiểu dữ liệu nguyên thủy**
- Kiểu dữ liệu nguyên thủy là các kiểu dữ liệu đơn giản, không phải là đối tượng, và chỉ chứa một giá trị duy nhất. Các kiểu dữ liệu nguyên thủy trong Java bao gồm: boolean, char, byte, short, int, long, float, và double.
- Tất cả các biến thuộc kiểu dữ liệu nguyên thủy đều được lưu trữ trên vùng nhớ stack.
- Mỗi kiểu dữ liệu nguyên thủy có một kích thước bộ nhớ cố định, ví dụ: byte là 1 byte, int là 4 byte, long là 8 byte, v.v.
- Khi thực hiện các phép toán hoặc gán giá trị cho các biến kiểu dữ liệu nguyên thủy, Java sẽ sao chép giá trị của biến nguồn sang biến đích, không có sự tham chiếu hay liên kết nào giữa hai biến.
- Ex: int a = 10 cấp phát 1 ô nhớ 4 byte, int b = a thì b = 10. Sau đó gán a = 20 thì b vẫn = 10.

> ***Điều này có nghĩa là khi thay đổi giá trị của một biến, giá trị của biến khác không bị ảnh hưởng.***

### **2. Đối với kiểu dữ liệu object**
- Kiểu dữ liệu object là các kiểu dữ liệu phức tạp, là đối tượng, và có thể chứa nhiều giá trị khác nhau. Các kiểu dữ liệu object trong Java bao gồm: Array, class, interface, enum,..
- Interface : [Interface](https://gpcoder.com/2295-abstract-class-va-interface-trong-java/)
- Enum : [Enum](https://viblo.asia/p/java-enum-Az45bN2w5xY)
- Java lưu trữ dữ liệu bằng kiểu dữ liệu object trong một vùng nhớ riêng biệt gọi là heap, không phải trong chính bản thân biến.
- Biến chỉ lưu trữ địa chỉ của vùng nhớ đó, tức là biến chỉ là một tham chiếu (reference) đến object. Mỗi object có một định danh duy nhất (identity) và có thể được truy cập bằng nhiều biến khác nhau.
>***Khi thực hiện các phép toán hoặc gán giá trị cho các biến kiểu dữ liệu object, Java sẽ sao chép địa chỉ của object từ biến nguồn sang biến đích, có sự tham chiếu hay liên kết giữa hai biến. Điều này có nghĩa là khi thay đổi giá trị của một object, giá trị của tất cả các biến tham chiếu đến object đó cũng bị ảnh hưởng.***
- Ex: 
```java
public class Test {
    public static void main(String[] args){
        StringBuilder a = new StringBuilder("Sy");
        StringBuilder b = a.reverse();
        System.out.println(a + " " + b);
    }
}
```
Kết quả cho ra như sau : 
> yS yS

### **3. ClassObject**
- ClassObject là `lớp cha của tất cả các lớp trong java`. Nói cách khác nó là một lớp cao nhất trong java.
- Nó dùng để tham chiếu bất kỳ đối tượng nào mà bạn chưa biết kiểu dữ liệu của đối tượng đó.
```java
    Object obj = getObject();
    // chúng ta không biết đối tượng gì được trả về từ phương thức này.

```
- Lớp Object cung cấp một vài cách xử lý chung cho tất cả các đối tượng như đối tượng có thể được so sánh, đối tượng có thể được `cloned`, đối tượng có thể được `notified`...
### **4. Wrapper**
- Wrapper là một lớp đặc biệt cung cấp cơ chế để chuyển đổi các kiểu dữ liệu nguyên thủy (primitive types) thành các đối tượng (objects) và ngược lại.
- Trong java, có 8 lớp Wrapper chúng được thiết kế trong gói java.lang.
![Alt text](https://github.com/sybui2004/JAVA/blob/main/B3-2.png)

- Tạo ra đối tượng từ Wrapper class trong Java

```java
    WrapperClass nameobj = WrapperClass.valueOf(value);
```


```java

    public class Main {
        public static void main(String[] args) {
            Integer myInt = 5;
            Double myDouble = 5.99;
            Character myChar = 'A';
            System.out.println(myInt);
            System.out.println(myDouble);
            System.out.println(myChar);
        }
    }

```

Để lấy giá trị ta sử dụng phương thức `Primitive Data Type + Value()` : `intValue(), byteValue(), shortValue(), longValue(), floatValue(), doubleValue(), charValue(), booleanValue().`

```java

    public class Main {
        public static void main(String[] args) {
            Integer myInt = 5;
            Double myDouble = 5.99;
            Character myChar = 'A';
            System.out.println(myInt.intValue());
            System.out.println(myDouble.doubleValue());
            System.out.println(myChar.charValue());
        }
    }

```
- Các lớp Wrapper trong Java sử dụng để:
  - Tạo ra các đối tượng từ các giá trị nguyên thủy.
  - Chuyển đổi các đối tượng thành các giá trị nguyên thủy.
  - Thực hiện các phép toán và so sánh trên các đối tượng bằng cách sử dụng các phương thức compare(), compareTo(), equals(), hashCode(), toString(), và các phương thức khác của các lớp Wrapper.
  - Sử dụng các đối tượng trong các Collection objects như mảng (Array), danh sách (List), tập hợp (Set), bản đồ (Map), v.v. Các Collection objects này chỉ chấp nhận các đối tượng, không chấp nhận các kiểu nguyên thủy.
  ```java
        ArrayList<int> myNumbers = new ArrayList<int>(); // Invalid
        ArrayList<Integer> myNumbers = new ArrayList<Integer>(); // Valid
  ```
  - Tận dụng tính năng autoboxing và unboxing của Java, tức là chuyển đổi tự động giữa các kiểu nguyên thủy và các lớp Wrapper khi cần thiết.
### **5. Boxing và Unboxing**
- `Boxing` là một quá trình tự động chuyển đổi một giá trị của kiểu dữ liệu nguyên thủy (primitive type) thành một đối tượng tương ứng của kiểu dữ liệu đối tượng (object type) tương tự.
```java
int primitiveInt = 42;
Integer boxedInt = new Integer(primitiveInt); // Boxing: chuyển đổi từ int thành Integer

```
- `Autoboxing` là quá trình mà trong đó trình biên dịch Java sẽ tự động chuyển đổi các kiểu dữ liệu căn bản thành các đối tượng lớp Wrapper tương ứng của chúng hay nói cách khác nó tự động thực hiện boxing khi bên trái dấu bằng là kiểu dữ liệu đối tượng còn bên phải là nguyên thủy. Autoboxing có một lợi thế lớn khi làm việc với các tập hợp trong Java.
```java
int primitiveInt = 42;
Integer boxedInt = primitiveInt; // Autoboxing: chuyển đổi từ int thành Integer

```
- Ngược lại với boxing, `Unboxing` dùng để chuyển kiểu dữ liệu đối tượng về kiểu dữ liệu nguyên thủy.
```java
    Integer primitiveInt = 42;
    int boxedInt = primitiveInt; // Unboxing: chuyển đổi từ Integer thành int

```
## **II. CÁC PHƯƠNG THỨC KHỞi TẠO TRONG JAVA**
> `Khởi tạo bằng constructor`
```java
    Bike bike1 = new Bike("123", "Cong", "cong@gmail.com", 22);
    Bike bike1 = new Bike();//constructor không đối số
```
- Khi khởi tạo constructor không đối số thì các field bằng null hoặc 0.

> `Khởi tạo bằng setter`
- Ta có thể khởi tạo bằng 1 constructor không đối số rồi dùng setter để truyền feild cho đối tượng.
```java
    Bike bike1 = new Bike();
    bike1.setId(value);
    bike1.setName(value);
```

- Các phương thức khởi tạo phải có cùng tên với tên lớp của chúng.
- Các phương thức khởi tạo không có kiểu trả về, kể cả void.
- Các phương thức khởi tạo được gọi tự động khi một đối tượng được tạo ra bằng toán tử new.
- Các phương thức khởi tạo có thể được nạp chồng, tức là có nhiều phương thức khởi tạo khác nhau trong một lớp, với các tham số khác nhau.
- Các phương thức khởi tạo có thể gọi đến các phương thức khởi tạo khác trong cùng một lớp bằng từ khoá this, hoặc gọi đến các phương thức khởi tạo của lớp cha bằng từ khoá super.
- 
>***Mục đích chính của các phương thức khởi tạo là để khởi tạo các giá trị ban đầu cho các thuộc tính của đối tượng, hoặc thực hiện các công việc khác liên quan đến đối tượng. Các phương thức khởi tạo giúp đảm bảo tính toàn vẹn và an toàn của đối tượng.***

>`Từ khóa this`
- Từ khóa this trong java là một biến tham chiếu được sử dụng để tham chiếu tới đối tượng của lớp hiện tại.
- Trong java, Từ khóa this có 6 cách sử dụng như sau:
  - Từ khóa this có thể được dùng để tham chiếu tới biến instance của lớp hiện tại.
  ```java
  public class Student{
        int id;
        String name;
        Student(int id, String name) {
            this.id = id;
            this.name = name;
        }
        public static void main(String args[]) {
            Student11 s1 = new Student11(1, "sy");
        }
    }
  ```
  - this() có thể được dùng để gọi Constructor của lớp hiện tại.
    ```java
    public class Student {
        int id;
        String name;
        String city;
        Student(int id, String name) {
            this.id = id;
            this.name = name;
        }
    
        Student(int id, String name, String city){
            this(id, name);
            this.city = city;
        }
        void display() {
            System.out.print(id + " " + name + " " + city+" ");
        }
        public static void main(String args[]) {
            Student14 e1 = new Student14(1, "Sy");
            Student14 e2 = new Student14(2, "Cong", "Ha Noi");
            e1.display();
            e2.display();
        }
    }
    ```
- Kết quả: 
>1 Sy null 2 Cong Ha Noi

  - Từ khóa this có thể được dùng để gọi phương thức của lớp hiện tại.
    ```java
    public class Example{
        void m() {
            System.out.println("abs");
        }
        void n() {
            this.m();
        }
        void p() {
            n();// trình biên dịch sẽ thêm this để gọi phương thức n() như this.n()
        }
        public static void main(String args[]) {
            Example e1 = new Example();
            e1.p();
        }
    }
    ```
  - Từ khóa this có thể được truyền như một tham số trong phương thức.
    ```java
    public class Example {
        void m(Example obj) {
            System.out.println("Hello Java");
        }
        void p() {
            m(this);
        }
        public static void main(String args[]) {
            Example o1 = new Example();
            o1.p();
        }
    }
    ```
  - Từ khóa this có thể được truyền như một tham số trong Constructor.
    ```java
    public class Bike {  
        Moto obj;  
        Bike(Moto obj){  
            this.obj = obj;  
        }  
        void display() {  
            System.out.println(obj.data);// sử dụng biến thành viên cửa lớp Moto
        }  
    }  
    public class Moto {  
        int data = 10;  
        Moto(){  
            Bike bike = new Bike(this);  
            b.display();  
        }  
        public static void main(String args[]) {  
            Moto a = new Moto();  
        }  
    }  
    ```
    - Kết quả
>10


  - Từ khóa this có thể được dùng để trả về instance của lớp hiện tại.

    ```java
        class A {  
            A getA() {  
                return this;  
            }  
            void display() {
                System.out.println("Hello Java");
            }  
        }  
    
        class Test {  
            public static void main(String args[]) {  
                new A().getA().display();  
            }  
        }  
    ```
    - Kết quả:
>Hello Java
>`Từ khóa super`
- Từ khóa super trong Java là một biến tham chiếu, được sử dụng để tham chiếu trực tiếp đến đối tượng của lớp cha gần nhất.
- Trong java, super có 3 cách sử dụng chính:
- Sử dụng từ khóa super để tham chiếu trực tiếp đến biến instance của lớp cha gần nhất.
  ```java
  // Tạo class cha Parent
    class Parent {
        public String name = "Cha";
        public Parent() {} //Hàm tạo hay Constructor
    }
    // Tạo class con kế thừa class Parent
    class Child extends Parent{
        public String name = "Con";
        public Child() {} //Hàm tạo hay Constructor
        public void display() {
            // Sử dụng từ khóa super
            System.out.println("Sử dụng super gọi biến name: " + super.name);
            // Không sử dụng từ khóa super
            System.out.println("Không sử dụng super: " + name);
        }
    }

    public class SuperInJava {
        public static void main(String[] args) {
            Child child = new Child();
            child.display();
        }
    }
  ```
  - Kết quả:
>Sử dụng super gọi biến name: Cha

>Không sử dụng super: Con

`Với phương thức display(), đầu tiên in ra màn hình sử dụng super.name vì vậy nó sẽ gọi đến biến name của lớp cha gần nhất (ở đây là lớp Parent). Tương tự in ra màn hình chỉ sử dụng name thì nó sẽ gọi đến biến name của lớp Child.`

  - Sử dụng từ khóa super để gọi đến method của lớp cha gần nhất.
  ```java
    class Parent {
        public Parent(){}
        public void printInfo() {
            System.out.println("Đây là lớp cha");
        }
    }
    class Child extends Parent{
        public Child() {}

        public void printInfo() {
            System.out.println("Đây là lớp con");
        }
        public void displayUseSuper() {
            // Sử dụng từ khóa super
            super.printInfo();
        }
        public void displayNotUseSuper() {
            // Không sử dụng từ khóa super
            printInfo();
        }
    }

    public class SuperInJava{
        public static void main(String[] args) {
            Child child = new Child();
            child.displayUseSuper();
            child.displayNotUseSuper();
        }
    }
  ```
  - Kết quả:
>Đây là lớp cha

>Đây là lớp con

`Trong lớp Child, phương thức displayUseSuper() sử dụng từ khóa super.printInfo(), vì vậy trình biên dịch sẽ hiểu là cần phải gọi đến hàm printInfo trong lớp Parent.`
  - Sử dụng super() để gọi trực tiếp constructor của lớp cha gần nhất.
  ```java
    class Parent {
        public Parent() {
            System.out.println("Tạo constructor");
        }
    }

    class Child extends Parent{
        public Child() {
            super();
        }
    }

    public class SuperInJava {
        public static void main(String[] args) {
            Child child = new Child();
            }
    }
  ```
  - Kết quả:
>Tạo constructor

## **III. Garbage Collector trong Java**
- Là một bộ thu gom rác. Trong JVM là quá trình xác định và loại bỏ các Object không được sử dụng khỏi bộ nhớ Heap. Không gian trống này sẽ được cấp phát cho những Object mới.
- Với Java thì việc giải phóng bộ nhớ được thực hiện một cách tự động.
- Garbage collector cũng đảm bảo rằng mọi đối tượng có tham chiếu trực tiếp sẽ không bị xóa khỏi bộ nhớ. 
-  Garbage Collector sử dụng các phương thức mark and sweep để xác định và loại bỏ các đối tượng không còn được tham chiếu.
-  Phương thức mark sẽ duyệt qua các đối tượng trong heap và đánh dấu những đối tượng nào còn được tham chiếu. Phương thức sweep sẽ xóa bỏ những đối tượng không được đánh dấu và nén lại bộ nhớ heap bằng cách đưa các object lại gần nhau.
- Garbage Collector: [Garbage Collector](https://viblo.asia/p/garbage-collector-1Je5EJ61KnL)
## **IV. Pass by Value trong Java**
- `Tên gọi khác là Truyền tham trị`
- Truyền tham trị là việc ta tạo ra một bản sao (tạo ra một giá trị mới bằng cách copy giá trị gốc) và thao tác với giá trị của bản sao đó và không làm thay đổi giá trị của bản gốc.
- Hiểu đơn giản là khi truyền dữ liệu vào hàm và tương tác thì dữ liệu chỉ thay đổi trong hàm đó, mà không làm thay đổi giá trị gốc ban đầu ngoài hàm.
```java
public class Main {
    public static void passByValue(int a) {
        a = 10;
        System.out.println(a);
    }
    public static void main(String[] args) {
        int a = 1;
        System.out.println(a);
        passByValue(a);
        System.out.println(a);
    }
}
```
- Kết quả:
>1

>10

>1

- Ngoài ra còn có một khái niệm nữa là Truyền tham chiếu khi ta truyền vào địa chỉ và làm thay đổi giá trị của bản gốc khi truyền vào(pass-by-reference)

`Có hai kiểu truyền tham số phổ biến là pass-by-value và pass-by-reference. Mỗi ngôn ngữ sẽ vận dụng chúng theo mỗi cách khác, ví dụ trong C/C++ sẽ cho phép bạn tuỳ biến theo ý muốn etc. Trong java luôn luôn là pass-by-value.`
