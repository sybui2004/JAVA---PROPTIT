# **Buổi 7: INTERFACE VÀ TRỪU TƯỢNG**

## **I. Interface là gì?**
>- **Interface** trong Java là một bản thiết kế của một lớp
>- Có thể hiểu là :
 - **Trong thế giới thực, chúng ta có vật (đồ vật, con vật…) và các hành vi của nó. Interface được sinh là để định nghĩa các hành vi của một nhóm vật.**
- VD:

    ```java
        interface Behaviors {
            void run(int speed);

            void walk(int step);

            void jump(int meter);
        }
        class Human implements Behaviors {

            private string name;

            // Define cách chạy
            void run(int speed){
            ...
            }

            // Define cách bước
            void walk(int step){
            ...
            }

            // Define cách ngủ
            void jump(int meter){
            ...
            }
        }
    ```
<!-- >- Nó chỉ có các phương thức trừu tượng
>- Interface là một kỹ thuật để thu được tính trừu tượng hoàn toàn và đa kế thừa trong Java
>- Một Interface trong Java là một tập hợp các phương thức trừu tượng (abstract) -->


## **II. Interface và Abstract Class**
### **`1. Interface`**
- Đặc điểm của **Interface** trong Java:
    + Các method của nó đều là method trừu tượng, nghĩa là không có thân hàm, và đều có modifier là: **`public abstract`**, cho dù bạn có khai báo hay không.
    + là một kỹ thuật để thu được tính trừu tượng hoàn toàn và đa kế thừa trong Java.
    +  luôn luôn có modifier là: **`public interface`**, cho dù bạn có khai báo rõ hay không.
    +  Nếu có các trường (**`field`**) thì chúng đều là: **`public static final`**, cho dù bạn có khai báo rõ hay không.
    +  không có hàm khởi tạo (**`constructor`**).
    +  Một interface **`không phải là một class`**. Viết một interface **`giống như viết một class`**, nhưng chúng có 2 định nghĩa khác nhau. Một clas mô tả các thuộc tính và hành vi của một đối tượng. Một interface **`chứa các hành vi mà một class triển khai`**.
    +  Trừ khi một class triển khai interface là abstract class, còn lại tất cả các phương thức của interface cần được định nghĩa trong class.

>- **`Java Compiler`** thêm từ khóa **`public abstract`** trước method của interface và các từ khóa **`public static final`** trước các field.

- So sánh Interface và Class:

![Alt text](https://github.com/sybui2004/JAVA/blob/main/B7-1.png)

- VD sử dụng interface:
>- Shape.java
```java
    public interface Shape {
     
        String color = "red";
        
        void draw();
        
    }
```
>- Circle.java

```java
    public class Circle implements Shape {
 
        @Override
        public void draw() {
            System.out.println("Draw " + color + " circle");
        }
        
    }
```

>- Square.java
```java
    public class Square implements Shape {
 
        @Override
        public void draw() {
            System.out.println("Draw " + color + " square");
        }
        
    }
```

>- ShapeApp.java
```java
    public class ShapeApp {
        public static void main(String[] args) {
            Shape sqr = new Square();
            rect.draw();
            System.out.println("---");
            Shape cir = new Circle();
            circle.draw();      
        }
    }
```

- Kết quả:
```java
    Draw red square
    ---
    Draw red circle
```
<span style="color:red">

- Khi triển khai interface, có vài quy tắc sau:

</span>

>- Một class có thể triển khai một hoặc nhiều interface tại một thời điểm.
>- Một class chỉ có thể kế thừa một class khác, nhưng được triển khai nhiều interface.
>- Một interface có thể kế thừa từ một interface khác, tương tự cách một class có thể kế thừa class khác.


## **`2.Abstract Class`**

- Đặc điểm của **Abstract class** trong java:
    + Một class được khai báo với từ khóa abstract là lớp trừu tượng (abstract class).
    + Lớp trừu tượng có thể có các phương thức abstract hoặc non-abtract.
    + Lớp trừu tượng có thể khai báo 0, 1 hoặc nhiều method trừu tượng bên trong.
    + Không thể khởi tạo 1 đối tượng trực tiếp từ một class trừu tượng.
    + Một lớp kế thừa từ lớp trừu tượng (subclass – lớp con) không cần phải implement non-abstract methods, nhưng những method nào có abstract thì bắt buộc phải override. Trừ khi subclass cũng là abstract.
- Cú pháp:

```java
    <PhamViTruyCap> abstract class <TenLop> {
        
    }
```
- Abstract method:
    + Một phương thức được khai báo là abstract và không có trình triển khai thì đó là phương thức trừu tượng (abstract method).
    + Nếu bạn muốn một lớp chứa một phương thức cụ thể nhưng bạn muốn triển khai thực sự phương thức đó để được quyết định bởi các lớp con, thì bạn có thể khai báo phương thức đó trong lớp cha ở dạng abstract.
    + Từ khóa abstract được sử dụng để khai báo một phương thức dạng abstract. Phương thức abstract sẽ không có định nghĩa, được theo sau bởi dấu chấm phẩy, không có dấu ngoặc nhọn theo sau.

- Cú pháp:
```java
	
<PhamViTruyCap> abstract void <TenPhuongThuc>();

```
- vD:

>- Shape.java
```java
    public abstract class Shape {
     
        private String color = "red";
        public Shape() {

        }
        public abstract void draw();
     
        public String getColor() {
            return color;
        }
    }
```
>- Circle.java

```java
    public class Circle extends Shape {
 
         @Override
        public void draw() {
            System.out.println("Draw " + super.getColor() + "circle");
        } 
    }
```

>- Square.java
```java
    public class Square implements Shape {
 
        @Override
        public void draw() {
            System.out.println("Draw " + super.getColor() + " square");
        }
        
    }
```

>- ShapeApp.java
```java
    public class ShapeApp {
        public static void main(String[] args) {
            Shape sqr = new Square();
            rect.draw();
            System.out.println("---");
            Shape cir = new Circle();
            circle.draw();      
        }
    }
```

- Kết quả:
```java
    Draw red square
    ---
    Draw red circle
```

<span style="color:red">

- Một vài lưu ý:

</span>

>- Lớp con bắt buộc phải cài đặt (implement) tất cả các phương thức trừu tượng của lớp cha
>- Không thể khởi tạo trực tiếp một lớp trừu tượng

## **`3. So sánh Interface và Abstract Class`**

![Alt text](https://github.com/sybui2004/JAVA/blob/main/B7-2.png)
![Alt text](https://github.com/sybui2004/JAVA/blob/main/B7-3.png)


<span style="color:red">

- Khi một class extend một class/ abtract class thì có nghĩa là ta đang thể hiện mối quan hệ is-a (là), còn khi implement một interface, thì ta đang thể hiện mối quan hệ has-a (có, hay thực hiện).

</span>

- VD :
```java
    // Programmer là Person, thực hiện việc Programming, Debugging
 
    class Programmer extends Person implements Programming, Debugging {}
    
    // Square là Shape, có Width, Height
    
    class Square extends Shape implements Width, Height {}
```

## **III. Tính trừu tượng**

- Tính trừu tượng là một tiến trình **`ẩn các chi tiết trình triển khai và chỉ hiển thị tính năng tới người dùng`**
- Tính trừu tượng cho phép ta loại bỏ tính chất phức tạp của đối tượng bằng cách **`chỉ đưa ra các thuộc tính và phương thức`** cần thiết của đối tượng trong lập trình.
- Tính trừu tượng giúp ta tập trung vào những cốt lõi cần thiết của đối tượng thay vì quan tâm đến cách nó thực hiện.
- Trong Java, chúng là sử dụng **`abstract class`** và **`abstract interface`** để có tính trừu tượng.

## **IV. Khi nào dùng interface, khi nào dùng abstract class?**

- Khi một nhóm đối tượng có cùng bản chất kế thừa từ một class thì sử dụng **`abstract class`**.
- Khi một nhóm đối tượng không có cùng bản chất nhưng chúng có hành động giống nhau thì sử dụng **`interface`**.


