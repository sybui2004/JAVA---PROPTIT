# **BUỔI 11: CÁC NGUYÊN TẮC THIẾT KẾ, MÔ HÌNH THIẾT KẾ**

## **I. SOLID là gì?**
-  là một phương pháp tiếp cận hướng đối tượng trong thiết kế cấu trúc phần mềm được sử dụng trong Java.
- SOLID là viết tắt chữ cái đầu của 5 nguyên tắc:
    + `Single responsibility principle` : Nguyên tắc một chức năng
    + `Open - closed principle` : Nguyên tắc đóng và mở
    + `Liskov substitution principle` : Nguyên tắc thay thế
    + `Interface segregation principle` : Nguyên tắc chia nhỏ
    + `Dependency inversion principle` : Nguyên tắc đảo ngược phụ thuộc
1. **Single responsibility principle (S)**
`Một class chỉ nên giữ 1 trách nhiệm duy nhất, chỉ có thể sửa đổi class với 1 lý do duy nhất.`
- Theo nguyên lí này, mỗi class chỉ nên có một vai trò duy nhất.
- Có thể để 1 class có rất nhiều chức năng, làm đủ thứ, với nhiều method khác nhau.
- Tuy nhiên việc nhét toàn bộ chức năng vào 1 class khiến code khó bảo trì, khó hiểu hơn, và xử lí một phần nhỏ của cả một class chứa rất nhiều chức năng này có thể làm lỗi toàn bộ các chức năng khác.
- Ví dụ:

```java
public class Player{
    public void getInformation(){}

    public void setPosition(){}

    public void convertToJSON(){}
}
```

- Ở trong class Player có tới 3 chức năng là getInformation, setPosition, convertToJSON. Điều này khiến cho việc xử lí và bảo trì code trở nên khó khăn. Chúng ta có thể chuyển thành như sau:
```java
public class Player{
    public void getInformation(){}
    public void getHealth(){}
    public void setHealth(){}
}

public class convertToJSON{
    public void convert(Player player){}
    public void convert(Monster monster){}
    public void convert(Board board){}

}

public class setPosition{
    public void set(Player player){}
    public void set(Monster monster){}

}

```

- Lúc này mỗi class sẽ độc lập hơn và các luồng hoạt động cũng sẽ rõ ràng hơn, khi có lỗi xảy ra hay cần nâng cấp chức năng, bạn có thể dễ dàng sửa đổi vào các class trong 1 luồng chứ không phải thay đổi hay thêm mọi thứ vào 1 class và khiến chúng phình to hơn nữa.
- Tuy số lượng class nhiều hơn những việc sửa chữa sẽ đơn giản hơn, dễ dàng tái sử dụng hơn, class ngắn hơn nên cũng ít bug hơn.

2. **Open - closed principle (O)**
`Có thể thoải mái mở rộng 1 class, nhưng không được sửa đổi bên trong class đó.`
-  Theo nguyên lý này, chúng ta không được thay đổi hiện trạng của các lớp có sẵn, nếu muốn thêm tính năng mới, thì hãy mở rộng class cũ bằng cách kế thừa để xây dựng class mới. Làm như vậy sẽ tránh được các tình huống làm hỏng tính ổn định của chương trình đang có.
-  Sau khi thiết kế một class với một số chức năng nhất định, cần đảm bảo các chức năng này hoạt động trơn tru trong tương lai, tránh sửa đổi thêm sau này. Như vậy, class luôn “đóng – closed” cho các sửa đổi vào các chức năng đã được thiết kế trước, nhưng lại phải “mở – open” để mở rộng tính năng hơn, để mở thì có 1 số cách phổ biến như:
-  Tạo ra một class kế thừa
- Viết lại chức năng hàm đó từ class cha
- Nâng cấp chức năng/hàm của class cha ở class con

Ví dụ:
```java
public class Monster{
    public String getElement(Monster monster) {
        if (monster instanceof Earth) return "Earth";
        else if (monster instanceof Water) return "Water";
        else if (monster instanceof Fire) return "Fire";
    }
}
```
Với cách thiết kế như trên, khi ta có các class con kế thừa từ class cha Monster, và cần kiểm tra xem class con có hệ là gì, hay ví dụ ta cần tạo thêm nhiều class con khác tương tự, ta lại phải thêm nhiều if else vào class gốc. Thay vào đó, ta nên thiết kế như sau:

```java
public class Monster{
    public String getElement() {
    }
}
public class EarthMonster extends Monster{
    @Override
    public String getElement() {
        return "Earth";
    }
}
public class WaterMonster extends Monster{
    @Override
    public String getElement() {
        return "Water";
    }
}
public class FireMonster extends Monster{
    @Override
    public String getElement() {
        return "Fire";
    }
}
```
- Lúc này, khi cần nâng cấp thêm nhiều hệ mới cho hệ thống, ta chỉ cần tạo các class con và sử dụng chức năng của class chính, không cần thực hiện trực tiếp vào class chính nữa.
- Lợi ích của nguyên lý này là đôi khi chúng ta cần sử dụng các class từ các nguồn thư viện thứ 3, hoặc từ chính các thư viện có sẵn trong Java. Chúng ta có thể dễ dàng extend và tạo các class con mới kế thừa từ class cha để phục vụ cho một mục đích, chức năng mới của dự án, mà không cần quá lo lắng về class cha sẽ bị lỗi do ta đã không sửa đổi chúng.
- Tuy nhiên, việc kế thừa class cha có thể dẫn tới việc chức năng các class con lại quá khác nhau và không có chung ý nghĩa, nên chú ý vào ý nghĩa của các chức năng, tránh tạo ra quá nhiều class dẫn xuất. Mặc dù những sửa đổi nhỏ trong class thường không ảnh hưởng, chúng ta cũng cần phải test cẩn thận. Và đó là lý do chính tại sao chúng ta cần phải viết test case cho các chức năng, để có thể nhận thấy hành vi không mong muốn xảy ra trong code.

3. **Liskov substitution principle (L)**
`Trong kế thừa, các class con, class kế thừa phải luôn có thể thay thế được class cha. Tức là, nếu class A kế thừa từ class B, thì mình luôn có thể sử dụng class A thay cho class B mà các chức năng không bị thay đổi.`

- Ví dụ như hình thang và hình bình hành: Ta có 1 class hình thang và class hình bình hành kế thừa hình thang. Do hình bình hành cũng có thể coi như là hình thang. Tuy nhiên điều này vi phạm quy tắc LSP vì hình bình hành khi kế thừa từ hình thang đã làm thay đổi đặc tính vốn có của hình thang.
- Những vi phạm về nguyên lí LSP:
    + Các lớp dẫn xuất có các phương thức ghi đè phương thức của lớp cha nhưng với chức năng hoàn toàn khác.
    + Các lớp dẫn xuất có phương thức ghi đè phương thức của lớp cha là một phương thức rỗng.
    + Các phương thức bắt buộc kế thừa từ lớp cha ở lớp dẫn xuất nhưng không được sử dụng.
    + Phát sinh ngoại lệ trong phương thức của lớp dẫn xuất.
- Đây là nguyên lý dễ bị vi phạm nhất, nguyên nhân chủ yếu là do sự thiếu kinh nghiệm khi thiết kế class.
- Thông thường, design các class dựa theo đời thật: hình vuông là hình chữ nhật. Tuy nhiên, không thể bê nguyên văn mối quan hệ này vào code. Hãy nhớ 1 điều:

    + Trong thực tế, A là B (hình bình hành là hình thang) không có nghĩa là class A nên kế thừa class B. Chỉ cho class A kế thừa class B khi class A thay thế được cho class B.
    + Nguyên lý này ẩn giấu trong hầu hết mọi đoạn code, giúp cho code linh hoạt và ổn định mà ta không hề hay biết. Ví dụ như trong Java, ta có thể chạy hàm foreach với List, ArrayList, LinkedList bởi vì chúng cùng kế thừa interface Iterable. Các class List, ArrayList, … đã được thiết kế đúng LSP, chúng có thể thay thế cho Iterable mà không làm hỏng tính đúng đắn của chương trình.
    + Theo đó, để sửa vấn đề hình thang – hình bình hành, ta nên để chúng cùng kế thừa một class Shape.
- Việc thiết kế áp dụng theo nguyên tắc LSP giúp chúng ta giảm bớt quá lạm dụng việc kế thừa trong class. Ý nghĩa của các chức năng không được thay đổi để có thể sử dụng ở nhiều phạm vi khác nhau hơn.

## **II. KISS, DRY, YAGNI**
1. **KISS**
- `Keep It Simple, Stupid!` - giữ cho code của bạn thật đơn giản, càng đơn giản, ngắn gọn càng tốt, bạn viết code, người khác vừa đọc đã hiểu bạn đang viết cái gì, code của bạn thực hiện cái gì.

- Ví dụ:
```java
// method 1
public static boolean isEven(int input) {
    return (input & 1) == 0;
}

// method 2
public static boolean isEven(int input) {
    return (input % 2) == 0;
}
```
- Rõ ràng, method 1 nhanh hơn method 2 vì nó thực hiện trực tiếp với bit. Nhưng method 2 lại dễ hiểu hơn, người đọc không cần nhớ lại toán tử ‘&’ thực hiện như nào.

- Ở đây mình chọn method 2 vì nó dễ hiểu, rõ ràng. Còn method 1 có nhanh hơn nhưng tính tổng thể thì nó không nhanh hơn quá nhiều chỉ  tính bằng mini giây.
- Nguyên tắc:
    + Đặt tên hàm, biến, method, class, package, comment rõ nghĩa.
    + Không lạm dụng framework, pattern.
    + Chia vấn task của bạn thành các task nhỏ hơn để code 1 cách rõ ràng.
    + Giới hạn mỗi method chỉ nên từ 30-50 lines, và mỗi method chỉ nên thực hiện 1 chức năng.
    + Hiểu rõ các vấn đề trước khi code.
    + Không nên sử dụng nhiều câu lệnh If trong 1 method, hãy tách nó ra thành các method khác nhau.
- Lợi ích: 
    + Các vấn đề được giải quyết nhanh hơn, tránh được các issue phức tạp
    + Code dễ sử dụng, dễ test
    + Bản thân code đã chính là tài liệu, comment cho chính nó
    + Và dễ dàng bảo trì, sửa lại code khi cần
2. **DRY**

- `Don’t Repeat Yourself` - Đừng bao giờ lặp lại code.
- Đừng lặp lại code ở đây là không lặp lại các đoạn code giống nhau, các method thực hiện chức năng như nhau, cố gắng gom chúng lại 1 cách gọn gàng và có thể dùng lại khi cần.

Ví dụ:
```java
public void print(User user) {
    System.out.println("first name: "+user.getFirstName());
    System.out.println("last name: "+user.getLastName());
    System.out.println("age: "+user.getAge());
    System.out.println("email: "+user.getEmail());
    System.out.println("address: "+user.getAddress());
    System.out.println("gender: "+user.getGender());
    System.out.println("exprience: "+user.getExperience());

    // do something: print user info
}

public void preview(User user) {
    System.out.println("first name: "+user.getFirstName());
    System.out.println("last name: "+user.getLastName());
    System.out.println("age: "+user.getAge());
    System.out.println("email: "+user.getEmail());
    System.out.println("address: "+user.getAddress());
    System.out.println("gender: "+user.getGender());
    System.out.println("exprience: "+user.getExperience());

    // do something: review user
}

```
Thay vào đó:
```java
public void showUser(User user) {
    System.out.println("first name: "+user.getFirstName());
    System.out.println("last name: "+user.getLastName());
    System.out.println("age: "+user.getAge());
    System.out.println("email: "+user.getEmail());
    System.out.println("address: "+user.getAddress());
    System.out.println("gender: "+user.getGender());
    System.out.println("exprience: "+user.getExperience());
}

public void print(User user) {
    showUser(user);
    // do something: print user info
}
public void preview(User user) {
    showUser(user);
    // do something: review user
}
```

- Sau khi tách ra method showUser thì ta có thể dùng lại nó hoặc nếu cần chỉnh sửa, lỗi trong việc in ra thông tin user thì ta chỉ cần sửa method showUser là được.

Hay một ví dụ khác:
```java
public List<User> findByName(String name) {
    if (name == null) {
        return null;
    }
    String sql = "SELECT u FROM User u WHERE u.name like %"+name+"% ";
    // do something
}

public List<User> findByEmail(String email) {
    if (email == null) {
        return null;
    }
    String sql = "SELECT u FROM User u WHERE u.email like %"+email+"% ";
    // do something
}

public List<User> findByNameAndEmail(String name, String email) {
    if (name == null || email == null) {
        return null;
    }
    String sql = "SELECT u FROM User u WHERE u.name like %"+name+"% AND u.email like %"+email+"%";
    // do something
}
```

Thay vào đó:
```java
public List<User> find(String name, String email) {
    if (name == null && email == null) {
        return null;
    }
    String sql = "SELECT u FROM User u WHERE u.name like %"+name+"% AND u.email like %"+email+"%";
    if (name != null && email == null) {
        sql = "SELECT u FROM User u WHERE u.name like %"+name+"% ";
    }
    if (name == null && email != null) {
        sql = "SELECT u FROM User u WHERE u.email like %"+email+"% ";
    }
    // do something
}
```
- vừa có thể search theo name, theo  email và theo cả 2.

3. **YAGNI**
`You Aren’t Gonna Need It` - Bạn không cần nó
- Đôi khi bạn nghĩ rằng cần phải thêm 1 số chức năng mới, bạn nghĩ nó cần thiết, có thể sẽ dùng trong tương lai và bạn làm nó. Stop, hãy dừng lại, như thế là bạn đang phạm phải sai lầm.
- Bạn không nên lãng phí thời gian vì hành động đó, cái chức năng mà bạn thêm mới đó có thể không làm ưng ý khách hàng hoặc cấp trên, thậm chí không bao giờ được dùng tới. Hãy confirm nó trước khi làm, và tập trung vào các task hiện tại thay vì đi làm 1 cái mới mà chưa chắc đã dùng tới rồi lại phải mất thêm công test nó.
## **III. Mô hình MVC**
`Model-View-Controller`
- là một mẫu kiến trúc phần mềm để tạo lập giao diện người dùng trên máy tính.
- chia thành ba phần được kết nối với nhau và mỗi thành phần đều có một nhiệm vụ riêng của nó và độc lập với các thành phần khác.
- được sử dụng rộng rãi trong phát triển web, sự khác biệt được tùy chỉnh liên quan đến sự có mặt của server - client.
![Alt text](https://github.com/sybui2004/JAVA---PROPTIT/blob/main/BU%E1%BB%94I%2011%20C%C3%81C%20NGUY%C3%8AN%20T%E1%BA%AEC%20THI%E1%BA%BET%20K%E1%BA%BE%2C%20M%C3%94%20H%C3%8CNH%20THI%E1%BA%BET%20K%E1%BA%BE/B11-1.png)

- Các thành phần trong MVC:
    + Model : 
        + Có nhiệm vụ thao tác với Database
        + Nó chứa tất cả các hàm, các phương thức truy vấn trực tiếp với dữ liệu
        + Controller sẽ thông qua các hàm, phương thức đó để lấy dữ liệu rồi gửi qua View
    + View :
        + Là giao diện người dùng (User Interface)
        + Chứa các thành phần tương tác với người dùng như menu, button, image, text,...
        + Nơi nhận dữ liệu từ Controller và hiển thị
    + Controller :
        + Là thành phần trung gian giữa Model và View
        + Đảm nhận vai trò tiếp nhận yêu cầu từ người dùng, thông qua Model để lấy dữ liệu sau đó thông qua View để hiển thị cho người dùng
- Luồng xử lý trong MVC:
![Alt text](https://github.com/sybui2004/JAVA---PROPTIT/blob/main/BU%E1%BB%94I%2011%20C%C3%81C%20NGUY%C3%8AN%20T%E1%BA%AEC%20THI%E1%BA%BET%20K%E1%BA%BE%2C%20M%C3%94%20H%C3%8CNH%20THI%E1%BA%BET%20K%E1%BA%BE/B11-2.png)

1. Đầu tiên, client sẽ gửi một request tới server thông qua Controller.
2. Controller tiếp nhận request, và xử lý luồng đi tiếp theo của yêu cầu. Trong trường hợp chỉ chuyển từ trang này sang trang khác mà không yêu cầu gửi và nhận dữ liệu thì lúc này Controller sẽ redirect(chuyển hướng) lại cho browser và kết thúc luồng. Lúc này luồng xử lý sẽ đi theo thứ tự 1-> 6 -> 7 -> 8.
3. Nếu request của người dùng yêu cầu phải xử lý dữ liệu thì Controller gọi xuống Model để lấy dữ liệu. Lúc này Model sẽ tương tác với database để lấy dữ liệu, dữ liệu được Model gửi về Controller, Controller gọi đến View phù hợp với request kèm theo dữ liệu cho View, View sẽ lắp dữ liệu tương ứng vào HTML và gửi lại một HTML cho Controller sau khi thực hiện xong nhiệm vụ của mình. Cuối cùng Controller sẽ trả kết quả về Browser. Lúc này luồng xử lý sẽ đi từ 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8.
4. Nếu request của người dùng chỉ yêu cầu dữ liệu nhưng không chuyển trang thì thay vì Controller sẽ trả dữ liệu về cho View thì Controller sẽ respone lại cho trình duyệt thông qua API, dữ liệu trả về thường sẽ là dạng JSON. Luồng xử lý lúc này sẽ là 1 -> 2 -> 3 -> 4-> 5-> 8.
- Ưu điểm của MVC :
    + Tạo mô hình chuẩn cho dự án, giúp cho việc tiếp cận với ứng dụng dễ dàng hơn.

    + Trình tự xử lý rõ ràng, nhiệm vụ riêng biệt, độc lập với các thành phần khác và các thành phần có thể tương tác được với nhau.

    + Source code được tách bạch rõ ràng nên việc bảo trì code sẽ dễ dàng hơn.
- Nhược điểm :
    + Model sẽ phải xử lý rất nhiều nếu dữ liệu lớn và phức tạp.
    + Đối với cái mô hình ứng dụng lớn và có độ phức tạp cao thì có lẽ MVC không còn khả dụng.

Mô tả lại luồng sự kiện được xử lý :

- User tương tác với View, bằng cách click vào button, user gửi yêu cầu đi.
- Controller nhận và điều hướng chúng đến đúng phương thức xử lý ở Model.
- Model nhận thông tin và thực thi các yêu cầu.
- Khi Model hoàn tất việc xử lý, View sẽ nhận kết quả từ Model thông qua Controller và hiển thị lại cho người dùng. 

Ví dụ mô hình MVC:
