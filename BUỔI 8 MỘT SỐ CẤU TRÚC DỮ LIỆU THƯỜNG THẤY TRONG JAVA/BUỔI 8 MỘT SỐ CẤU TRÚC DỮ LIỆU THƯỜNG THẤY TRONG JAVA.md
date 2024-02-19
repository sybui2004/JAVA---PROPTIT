# **BUỔI 8: MỘT SỐ CẤU TRÚC DỮ LIỆU THƯỜNG THẤY TRONG JAVA**

## **I. Cấu trúc dữ liệu là gì? Sử dụng khi nào?**
- Là một hình thức tổ chức, lưu trữ dữ liệu theo hệ thống và thứ tự để có thể sử dụng tài liệu một cách tối ưu.
- Ta sử dụng cấu trúc dữ liệu khi ta muốn lưu một tập hợp gồm nhiều dữ liệu cũng như có những thao tác xử lý với chúng như thêm, bớt, thay đổi, sắp xếp… Tùy vào nhu cầu mà chọn cấu trúc dữ liệu cho phù hợp.

## **II. Interface Iterable, Collection -> List, Set, Queue**

***1. Iterabtor***
>- **`Iterator`** là 1 object, gọi là **`Iterator<T>`**, nơi T là kiểu dữ liệu của các phần tử trong tập hợp. Iterator cung cấp các phương thức như **`hasNext()`** để kiểm tra xem tập hợp có phần tử tiếp theo không, và **`next()`** để lấy phần tử tiếp theo trong tập hợp, **`remove()`** loại bỏ phần tử trả về bởi next(), **`forEachRemaining()`** thực hiện hành động cụ thể cho từng phần tử còn lại của bộ sưu tập, dùng để duyệt loop trong colletion.

***2. Interface Iterable***

>- Là 1 interface trong gói java.lang, chứa 1 phương thức duy nhất là **`Iterator<T> iterator()`**,nơi mà các lớp triển khai phải cung cấp một trình duyệt (iterator) để duyệt qua các phần tử của tập hợp dữ liệu (collection) như mảng, danh sách liên kết, hoặc tập hợp (Set). Phương thức này trả về một obj Iterator để lặp qua các phần tử trong tập hợp.

>- Cung cấp một cách tiếp cận trừu tượng để truy cập từng phần tử trong tập hợp, mà không cần biết chi tiết cài đặt của tập hợp đó.

>- Cho phép một obj cung cấp một Iterator (một obj dùng để lặp qua tất cả các phần tử của nó) cho một vòng lặp for - each để lặp qua tất cả các phần tử của nó.


 - Khi sử dụng Iterable và Iterator, bạn có thể duyệt qua các phần tử của tập hợp một cách thuận tiện bằng cách sử dụng các cấu trúc lặp như vòng lặp while hoặc vòng lặp for-each (enhanced for loop) mà không cần phải quan tâm đến việc cài đặt cụ thể của tập hợp đó.


Định nghĩa 1 Iterable:

```java
public interface Iterable<T>
{
  Iterator<T>    iterator();
  
  Spliterator<T> spliterator();

  void forEach(Consumer<? super T> action);
}
```

trong đó T là kiểu dữ liệu trả về của Iterator
- Ví dụ sử dụng Iterable và Iterator

```java
    List<String> danhSach = new ArrayList<>();
    danhSach.add("Java");
    danhSach.add("Python");
    danhSach.add("C++");

    // Sử dụng Iterable và Iterator để duyệt qua danh sách liên kết
    Iterable<String> iterable = danhSach;
    Iterator<String> iterator = iterable.iterator();
    while (iterator.hasNext()) {
        String phanTu = iterator.next();
        System.out.println(phanTu);
    }
```
hoặc

```java
    List<String> list = new ArrayList<>(); 
  
    list.add("Java"); 
    list.add("Python"); 
    list.add("C++"); 

    list.forEach( 
        (element) -> { System.out.println(element); }); 
```

hoặc 
```java

    List<String> list = new ArrayList<>(); 
  
    list.add("Java"); 
    list.add("Python"); 
    list.add("C++"); 

    for( String element : list )
          System.out.println(element); 
```
Kết quả:

```java
Java
Python
C++
```

***3. Collection***

>- là một **`tập hợp các class và interface`** dùng để hỗ trợ trong việc thao tác lưu trữ và quản lý nhóm đối tượng dữ liệu trong ứng dụng Java

![Alt text](https://github.com/sybui2004/JAVA---PROPTIT/blob/main/BU%E1%BB%94I%208%20M%E1%BB%98T%20S%E1%BB%90%20C%E1%BA%A4U%20TR%C3%9AC%20D%E1%BB%AE%20LI%E1%BB%86U%20TH%C6%AF%E1%BB%9CNG%20TH%E1%BA%A4Y%20TRONG%20JAVA/B8-2.png)


***`3.1. List`***
>- là dạng tập hợp các phần tử được sắp theo thứ tự (còn được gọi là dãy tuần tự) và trong đó cho phép lặp (hai phần tử giống nhau). Vì List là một interface, nên chúng ta không thể tạo các đối tượng từ nó.

>- Để sử dụng các tính năng của List interface, chúng ta có thể sử dụng các class sau:

- ArrayList
- LinkedList
- Vector
- Stack

>- Khai báo List trong java:

```java
    // ArrayList triển khai List
    List<String> list1 = new ArrayList<>();

    // LinkedList triển khai List
    List<String> list2 = new LinkedList<>();
```
>- Các phương thức khác của List ngoài những phương thức nó kế thừa từ Collection

![Alt text](https://github.com/sybui2004/JAVA---PROPTIT/blob/main/BU%E1%BB%94I%208%20M%E1%BB%98T%20S%E1%BB%90%20C%E1%BA%A4U%20TR%C3%9AC%20D%E1%BB%AE%20LI%E1%BB%86U%20TH%C6%AF%E1%BB%9CNG%20TH%E1%BA%A4Y%20TRONG%20JAVA/B8-1.png)

- VD:
```java
import java.util.ArrayList;
import java.util.List;

public class ListExample {
    public static void main(String args[]) {
        List<String> list = new ArrayList<String>();
        list.add("Java");
        list.add("C++");
        list.add("PHP");
        list.add(1, "Python");
        System.out.println("Phan tu co index = 2 la: " + list.get(2));
        // show list
        for (String s : list) {
            System.out.println(s);
        }
    }
}
```

Kết quả:

```java
Phan tu co index = 2 la: C++
Java
Python
C++
PHP
```

Khai báo list interator:

```java
 ListIterator<String> itr = list.listIterator();
```
***`3.2.Set`***

>- Là một loại Interface Collection
>- Khác với List, các phần tử trong List có thể giống nhau, còn đối với Set, các phần tử trong Set là duy nhất.

>- Để sử dụng các tính năng của Set interface, chúng ta có thể sử dụng các class sau:

- EnumSet
- HashSet
- LinkedHashSet
- TreeSet

>- Khai báo set trong java

```java
Set setA = new HashSet();
Set setB = new LinkedHashSet();
Set setC = new TreeSet();
```

- Phương thức của Set trong java

![Alt text](https://github.com/sybui2004/JAVA---PROPTIT/blob/main/BU%E1%BB%94I%208%20M%E1%BB%98T%20S%E1%BB%90%20C%E1%BA%A4U%20TR%C3%9AC%20D%E1%BB%AE%20LI%E1%BB%86U%20TH%C6%AF%E1%BB%9CNG%20TH%E1%BA%A4Y%20TRONG%20JAVA/B8-3.png)


>- Chúng ta có thể cover một tập hợp Set thành List bằng phương thức addAll()

VD:
```java
Set<String> set = new HashSet<>();
set.add("123");
set.add("456");

List<String> list = new ArrayList<>();
list.addAll(set);

```

***`3.3.Queue`***

![Alt text](https://github.com/sybui2004/JAVA---PROPTIT/blob/main/BU%E1%BB%94I%208%20M%E1%BB%98T%20S%E1%BB%90%20C%E1%BA%A4U%20TR%C3%9AC%20D%E1%BB%AE%20LI%E1%BB%86U%20TH%C6%AF%E1%BB%9CNG%20TH%E1%BA%A4Y%20TRONG%20JAVA/B8-4.png)

>- được sử dụng để lưu trữ các phần tử được xử lý theo thứ tự FIFO (First In First Out).

- Phương thức của Queue trong java

![Alt text](https://github.com/sybui2004/JAVA---PROPTIT/blob/main/BU%E1%BB%94I%208%20M%E1%BB%98T%20S%E1%BB%90%20C%E1%BA%A4U%20TR%C3%9AC%20D%E1%BB%AE%20LI%E1%BB%86U%20TH%C6%AF%E1%BB%9CNG%20TH%E1%BA%A4Y%20TRONG%20JAVA/B8-5.png)

<!-- ```java
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        Queue<Integer> numbers = new PriorityQueue<>();
        numbers.add(5);
        numbers.add(9);
        numbers.add(3);
        numbers.add(7);

        System.out.println("Danh sách ban đầu: ");
        for (Integer i: numbers) {
            System.out.print(i + "\t");
        }

        //Lấy ra phần tử đầu tiên và xóa phần tử đó:
        System.out.println("\nPhần tử đầu tiên: " + numbers.poll());
        System.out.println("Phần tử đầu tiên: " + numbers.poll());

        numbers.offer(1);
        System.out.println("\nDanh sách ban đầu: ");
        for (Integer i: numbers) {
            System.out.print(i + "\t");
        }
    }
}
```

Tại sao kết quả lại như thế này?:

Danh sách ban đầu:
3    7    5    9
Phần tử đầu tiên: 3
Phần tử đầu tiên: 5

Danh sách ban đầu:
1    9    7 -->

## **III. Interface Map, SortedMap -> HashMap, TreeMap**
***1. Interface Map***
![Alt text](https://github.com/sybui2004/JAVA---PROPTIT/blob/main/BU%E1%BB%94I%208%20M%E1%BB%98T%20S%E1%BB%90%20C%E1%BA%A4U%20TR%C3%9AC%20D%E1%BB%AE%20LI%E1%BB%86U%20TH%C6%AF%E1%BB%9CNG%20TH%E1%BA%A4Y%20TRONG%20JAVA/B8-6.png)

>- Trong java, map được sử dụng để lưu trữ và truy xuất dữ liệu theo cặp khóa (key) và giá trị (value). Mỗi cặp key và value được gọi là **`entry`**.

>- Map chỉ chứa các giá trị key duy nhất, không  chứa các key trùng lặp.

>- Các lớp cài đặt (implements) Map interface là HashMap, LinkedHashMap and TreeMap.

- **`HashMap`** không đảm bảo thứ tự các entry được thêm vào.
- **`LinkedHashMap`** đảm bảo thứ tự các entry được thêm vào.
- **`TreeMap`** duy trình thứ tự các phần tử dựa vào bộ so sánh Comparator.

- Sức chứa (compacity) mặc định khi khởi tạo map là 24 = 16. Kích thước này sẽ tự động tăng gấp đôi mỗi khi thêm phần tử vượt quá kích thước của nó.

- Phương thức của Map trong java

![Alt text](https://github.com/sybui2004/JAVA---PROPTIT/blob/main/BU%E1%BB%94I%208%20M%E1%BB%98T%20S%E1%BB%90%20C%E1%BA%A4U%20TR%C3%9AC%20D%E1%BB%AE%20LI%E1%BB%86U%20TH%C6%AF%E1%BB%9CNG%20TH%E1%BA%A4Y%20TRONG%20JAVA/B8-7.png)

- **`Map.Entry Interface`**:

    + Entry là một interface con của Map. Vì vậy, chúng ta được truy cập nó bằng tên Map.Entry. Nó cung cấp các phương pháp để truy xuất các key và value.
    + Define:
    ```java
    public interface Map<K,V> {
        interface Entry<K,V> {
    
        }
    }
    ```
    + Phương thức:
        - Object getKey()	Được dùng để lấy key.
        - Object getValue()	Được sử dụng để lấy value.

>- VD:

```java
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
 
public class MapExample {
    public static void main(String args[]) {
        // init map
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "Basic java");
        map.put(2, "OOP");
        map.put(3, "Collection");
 
        // show map using method keySet()
        for (Integer key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
 
        System.out.println("---");
 
        // show map using method keySet()
        for (Entry<Integer, String> entry : map.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " = " + value);
        }
    }
}
```

Kết quả:

```java
1 = Basic java
2 = OOP
3 = Collection
---
1 = Basic java
2 = OOP
3 = Collection
```
***2. Sorted Map***

>- Là một interface thừa kế từ Map interface có đầy đủ các chức năng mà Map định nghĩa, ngoài ra các phần tử trong SortedMap sẽ được sắp xếp theo thứ tự của key, mà một trong những implementation điển hình của nó là TreeMap.

>- là một interface vì thế chúng ta không thể khởi tạo trực tiếp mà phải thông qua một implementation của nó (TreeMap).

>- Khởi tạo Map:
```java
SortedMap<Integer, String> sm = new TreeMap<Integer, String>(); 

```

VD:

```java
import java.util.Iterator; 
import java.util.Map; 
import java.util.Set; 
import java.util.SortedMap; 
import java.util.TreeMap; 
  
public class SortedMapExample { 
    public static void main(String[] args) 
    { 
        SortedMap<Integer, String> sm = new TreeMap<Integer, String>(); 
        sm.put(new Integer(2), "practice"); 
        sm.put(new Integer(3), "quiz"); 
        sm.put(new Integer(5), "code"); 
        sm.put(new Integer(4), "contribute"); 
        sm.put(new Integer(1), "deftblog"); 
        Set s = sm.entrySet(); 
  
        // Using iterator in SortedMap 
        Iterator i = s.iterator(); 
  
        // Traversing map. Note that the traversal 
        // produced sorted (by keys) output . 
        while (i.hasNext()) { 
            Map.Entry m = (Map.Entry)i.next(); 
  
            int key = (Integer)m.getKey(); 
            String value = (String)m.getValue(); 
  
            System.out.println("Key : " + key + "  value : " + value); 
        } 
    } 
}
```

Kết quả:

```java
Key : 1  value : deftblog
Key : 2  value : practice
Key : 3  value : quiz
Key : 4  value : contribute
Key : 5  value : code
```
***3. HashMap, TreeMap***

- **HashMap**: là một class implements interface Map trong Java. Nó sử dụng bảng băm để lưu trữ dữ liệu, cho phép thao tác nhanh chóng với các phần tử của nó. Cho phép 1 key là null và chứa nhiều giá trị, không hỗ trợ đồng bộ, với đặc điểm đặc trưng là thứ tự lặp (iteration order) không theo một quy tắc nào.
- **TreeMap**: là một class implements interface SortedMap. Nó duy trì thứ tự của các phần tử dựa trên khóa (key) của chúng, nghĩa là các phần tử được sắp xếp theo khóa, chỉ cho phép value là null.

- So sánh: HashMap nhanh hơn tuy nhiên nó tiêu tốn nhiều không gian bộ nhớ hơn, ngoài ra TreeMap hỗ trợ nhiều tính năng nâng cao hơn.
- Độ phức tạp:
    + HashMap : O(1)
    + TreeMap : O(log(N))

## **IV. SỬ DỤNG MỘT SỐ HÀM CỦA CẤU TRÚC DỮ LIỆU NHƯ SORT**

```java
Collections.sort(T)
```
- Interface Comparable<T> cung cấp một phương thức để sắp xếp list object là int compare(T o1, T o2)

```java
public class Student implements Comparator<Student> {
    // Các method và field như ở trên
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getAge() - o2.getAge();
    }
}

```

```java
    List<Student> students = new ArrayList<>();
    students.add(new Student("Jonh", 17));
    students.add(new Student("Peter", 19));
    students.add(new Student("Henry", 18));
    java.util.Collections.sort(students, new Student());
    students.forEach(e -> System.out.println(e));
```

Kết quả:

```java
Student{name='Jonh', age=17}
Student{name='Henry', age=18}
Student{name='Peter', age=19}

```

hoặc

```java
    List<Student> students = new ArrayList<>();
    students.add(new Student("Jonh", 17));
    students.add(new Student("Peter", 19));
    students.add(new Student("Henry", 18));
    Collections.sort(students, new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getAge() - o2.getAge();
        }
    });
    students.forEach(e -> System.out.println(e));
```


