# **Buổi 5: DEV THÌ KHÔNG CHỈ VIẾT CODE**

## **I. Version Control là gì và tại sao cần dùng nó?**
>- Version Control (hay Source Control) là chương trình quản lý source code cho lập trình viên. Hiện giờ có 2 chương trình thông dụng nhất là git và svn.

>- Version control giúp cho chúng ta dễ dàng quản lý source code hơn, như là:
– Xem lại file code đã thêm/xóa/sửa dòng nào.
– Biết ai đã sửa để quy trách nhiệm.
– Biết được các version phần mềm đã có lịch sử thêm bớt tính năng gì
…

- Lí do sử dụng Version Control:
    + Do lập trình chỉ cần thiếu 1 dấu chấm dấu phẩy là không compile được. Do đó việc sử dụng source control trong lập trình là bắt buộc trong các dự án.
    + Trong dự án có những file chính chứa thông số của cả chương trình. Chỉ cần chúng ta sai 1 chút thôi là tìm lại rất khó khăn, do đó phải dùng để tiết kiệm thời gian. Khi sai chỉ cần `revert` lại là xong, code lại chạy bình thường.
    + Dự án tạm ngưng thời gian đảm bảo chúng ta sẽ quên chính chúng ta code cái gì. Có những dự án để lâu một vài năm mới có yêu cầu sửa đổi, lúc đó `đọc log` sẽ nhớ lại chúng ta làm gì.
    + Và làm việc nhóm thì phải có 1 repository tập trung. Tóm lại, đã code thì phải có source control, bất kể dự án quy mô thế nào
## **II. Khái niệm về git**
>- **`Git`** cũng là 1 dạng source control, trước kia người ta hay dùng Subversion ( SVN) do google hỗ trợ khá là tiện, nhưng trong vòng nhiều năm trở lại đây git đang trở thành 1 xu thế mới, thay thế dần cho SVN, và đang có một cộng đồng người dùng rất lớn.

### Repository

>- **`Repository`** Có thể coi nó là 1 dự án, chứa toàn bộ source code, là nơi sẽ ghi lại trạng thái của thư mục và file từ khi bạn khởi tạo đến hiện tại. Nếu repository được lưu trên máy tính của bạn, nó được gọi là **`local repository`**, còn nếu nó được lưu ở trên các server chuyên cung cấp dịch vụ về git nó được gọi là **`remote repository`**. Hiện nay có một số Git server phổ biến như là Github, GitLab, Bitbucket,…

![Alt text](https://github.com/sybui2004/JAVA---PROPTIT/blob/main/BU%E1%BB%94I%205%20DEV%20TH%C3%8C%20KH%C3%94NG%20CH%E1%BB%88%20VI%E1%BA%BET%20CODE/Repository.png)

### Branch
>- Là cái dùng để phân nhánh và ghi lại luồng của lịch sử phát triển code của dự án. Branch đã phân nhánh sẽ không ảnh hưởng đến các branch khác nên có thể tiến hành nhiều thay đổi đồng thời trong cùng 1 repository.

![Alt text](https://github.com/sybui2004/JAVA---PROPTIT/blob/main/BU%E1%BB%94I%205%20DEV%20TH%C3%8C%20KH%C3%94NG%20CH%E1%BB%88%20VI%E1%BA%BET%20CODE/Branch.png)

### Commit

>- Một repository thì chứa rất nhiều commit, commit đó là những lần bạn sửa code, thêm, xóa file, thay đổi code đều được tính là  commit, những commit đó được lưu vào repository.

![Alt text](https://github.com/sybui2004/JAVA---PROPTIT/blob/main/BU%E1%BB%94I%205%20DEV%20TH%C3%8C%20KH%C3%94NG%20CH%E1%BB%88%20VI%E1%BA%BET%20CODE/Commit.png)

### Merge

>- Git merge được dùng khi ta muốn gộp hai branch lại với nhau, thao tác này thường dùng để merge branch khác vào branch master trước khi push lên remote repository, hoặc merge hai branch thành một để giải quyết chung một task.

Câu lệnh:
```
$ git merge <branch_name>
```

hoặc

```
$ git merge <branch-name> <merged-branch-name>
```


### Pull

>- là một lệnh dùng để tải xuống dữ liệu từ một Remote repository và cập nhật Local repository phù hợp với dữ liệu đó. Nói cách khác, Git Pull là lệnh hợp nhất các thay đổi từ Remote repository vào Local repository.

Câu lệnh:
```
$ git pull origin master
```

### Push
>- là một lệnh được sử dụng để đẩy các commit mới ở Local repository lên Remote repository(server)

```
$ git push origin <name_branch>
```

Ngoài ra, nếu chưa tồn tại remote trên server thì bạn cần phải add mới một remote trước rồi mới push:

```
$ git remote add origin <remote_url>
$ git push origin <name_branch>
```

### Clone

>- là một lệnh trong hệ thống quản lý mã nguồn phân tán Git, được sử dụng để sao chép (clone) một kho lưu trữ Git từ một địa chỉ xa về máy tính của bạn. Lệnh này thường được sử dụng khi bạn muốn bắt đầu làm việc trên một dự án mới hoặc khi bạn muốn sao chép một bản sao của một dự án đã tồn tại từ một kho lưu trữ Git khác.
Git clone: khác với fork; nó là một bản remote local copy của một số kho lưu trữ. Khi bạn sao chép, bạn đang sao chép toàn bộ repo, bao gồm tất cả lịch sử và các nhánh.

```
$ git clone path-git
```

### Fork

>-  là một bản copy của một repository (Kho chứa source code của bạn trên Github). Việc fork một repository cho phép bạn dễ dàng chỉnh sửa, thay đổi source code mà không ảnh hưởng tới source gốc.

## **III. Khi nào cần Pull Request? Cách tạo Pull Request**

>- Pull Request là một tính năng của hệ thống quản lý mã nguồn (source control management) như Git, GitHub, hay GitLab. Nó là một cách để người dùng có thể đề xuất thay đổi vào mã nguồn của một dự án đã được lưu trữ trên hệ thống quản lý mã nguồn đó.

>- Thực tế khi bạn làm việc trong team có nhiều người, mỗi một chức năng bạn hoàn thành code và cần được team review, bạn không thể gọi mọi người đến máy tính của bạn và ngồi đấy review từng dòng code cho bạn. Bạn cũng không thể gửi từng file source code cho người review để họ download về máy và review được - quá tốn thời gian và thật sự không chuyên nghiệp. Và tất nhiên khi khách hàng (đang ở một nơi nào đấy rất rất xa bạn) muốn tham gia review code của bạn thì chuyện này càng khó khăn hơn. Đó là lúc cần dùng đến Pull Request.

>- Khi một pull request được chấp nhận, các thay đổi được hợp nhất vào branch chính của dự án. Quá trình này có thể được tự động hóa bằng các công cụ tích hợp liên kết với hệ thống quản lý mã nguồn. Pull request là một cách linh hoạt và an toàn để đóng góp vào dự án và đảm bảo rằng các thay đổi mới không gây ra tác động tiêu cực đến mã nguồn hiện có.

Vai trò Pull Request:
- Đảm bảo chất lượng mã nguồn
- Giúp đơn giản hóa quy trình kiểm tra code
- Tăng tính minh bạch và sự tham gia của cộng đồng
- Đóng góp vào phát triển dự án

### Cách tạo Pull Request:
- Tạo một branch mới
- Chỉnh sửa mã nguồn trên branch mới
- Commit thay đổi, Mỗi commit sẽ đại diện cho một bản sao của mã nguồn với các thay đổi mới của bạn.
- Tạo Pull Request: Khi các thay đổi của bạn đã được commit vào branch mới, bạn có thể tạo Pull Request để gộp các thay đổi của mình vào nhánh chính của dự án. Trong quá trình tạo Pull Request, bạn sẽ cung cấp thông tin về các thay đổi của mình và mô tả về mục đích của các thay đổi đó.
- Xem xét và thảo luận
- Merge Pull Request

## **IV. UML là gì? Lí do cần vẽ UML**

>- - là ngôn ngữ đồ họa tiêu chuẩn, sử dụng cho nhiều lĩnh vực kỹ thuật trong đó có công nghệ phần mềm
>- - là ngôn ngữ ký hiệu sử dụng trong lập trình hướng đối tượng.
>- - Biểu diễn, quy định cụ thể, xây dựng và tài liệu về hệ thống phần mềm.

Lí do cần vẽ UML:

>- Hiểu rõ yêu cầu:
UML giúp biểu diễn yêu cầu của khách hàng và những chức năng cần thực hiện trong hệ thống.
Cung cấp một phương tiện để diễn đạt yêu cầu một cách rõ ràng và dễ hiểu.

>- Thiết kế hệ thống:
UML hỗ trợ việc thiết kế hệ thống bằng cách mô tả các lớp, đối tượng, mối quan hệ, và các phần tử khác của hệ thống.
Cho phép nhóm phát triển hiểu cấu trúc và quan hệ giữa các thành phần của hệ thống.

>- Tạo mã nguồn:
UML có thể được sử dụng để sinh mã nguồn tự động hoặc hướng dẫn quá trình lập trình, đặc biệt là trong việc tạo ra các lớp và mối quan hệ giữa chúng.

>- Hiểu rõ quy trình làm việc:
UML hỗ trợ mô hình hóa quy trình làm việc thông qua các sơ đồ hoạt động và sơ đồ tuần tự, giúp hiểu rõ luồng công việc trong hệ thống.

>- Tài liệu hóa:
UML tạo ra tài liệu chi tiết và rõ ràng, giúp các thành viên trong nhóm phát triển và bảo trì hệ thống.

>- Giao tiếp:
UML cung cấp một ngôn ngữ chung để giao tiếp giữa các thành viên trong nhóm phát triển, giúp họ hiểu rõ ý tưởng và thiết kế của nhau.

## **V. Mô hình Class Diagram, Activity Diagram**

### Class Diagram
- Mô tả cấu trúc hệ thống: mô tả các Class của hệ thống, thuộc tính của chúng và mối quan hệ giữa các Class.
- Mục đích:
    + Phân tích và thiết kế các view tĩnh của ứng dụng.
    + Thế hiện sự thống nhất giữa các thành phân view tĩnh.
    + Mô tả sự phản hồi của hệ thống.
    + Cơ sở cho các sơ đồ thành phần và triển khai.

Class :
- Đại diện cho Obj
- Có các thuộc tính và func.

Class diagram tốt phải có:
- Tên class, tên diagram nên mô tả được các đối tượng tồn tại trong hệ thống.
- Thành phần, mối qua hệ nên được define rõ ràng.
- Attributes và Methods nên được define rõ ràng.
- Trong mỗi class: Tối thiểu các thuộc tính, những thuộc tính không cần thiết có thể làm sơ đồ phức tạp hơn.
- Dùng ghi chú khi được yêu cầu.

[Class Diagram](https://iviettech.vn/blog/813-classs-diagarm-ban-ve-ve-classlop.html)

### Activity Diagram

- Là sơ đồ quy trình công việc từng bước các hành động với sự hỗ trợ cho sự lựa chọn, lặp đi lặp lại và đồng thời.
- Thế hiện dòng chảy hành động được kiểm soát như thế nào.
- Được tạo tù các shape và kết nối bằng arrow.
Cách xây dựng Activity Diagram:

>- Bước 1: Xác định các nghiệp vụ cần mô tả
Xem xét bản vẽ Use Case  để xác định nghiệp vụ nào bạn cần mô tả.
Bước 2: Xác định trạng thái đầu tiên và trạng thái kết thúc
Bước 3: Xác định các hoạt động tiếp theo
Xuất phát từ điểm bắt đầu, phân tích để xác định các hoạt động tiếp theo cho đến khi gặp điểm kết thúc để hoàn tất bản vẽ này.
Bạn có thể hỏi chuyên gia, học hệ thống tương tự, hỏi khách hàng để nắm rõ về qui trình của hệ thống.

#### Các kí hiệu:
- Nút Start
![Alt text](https://github.com/sybui2004/JAVA---PROPTIT/blob/main/BU%E1%BB%94I%205%20DEV%20TH%C3%8C%20KH%C3%94NG%20CH%E1%BB%88%20VI%E1%BA%BET%20CODE/Start.png)
- Nút End
![Alt text](https://github.com/sybui2004/JAVA---PROPTIT/blob/main/BU%E1%BB%94I%205%20DEV%20TH%C3%8C%20KH%C3%94NG%20CH%E1%BB%88%20VI%E1%BA%BET%20CODE/End.png)
- Activity
![Alt text](https://github.com/sybui2004/JAVA---PROPTIT/blob/main/BU%E1%BB%94I%205%20DEV%20TH%C3%8C%20KH%C3%94NG%20CH%E1%BB%88%20VI%E1%BA%BET%20CODE/Activity.png)
- Branch
![Alt text](https://github.com/sybui2004/JAVA---PROPTIT/blob/main/BU%E1%BB%94I%205%20DEV%20TH%C3%8C%20KH%C3%94NG%20CH%E1%BB%88%20VI%E1%BA%BET%20CODE/Branch1.png)
- Fork
![Alt text](https://github.com/sybui2004/JAVA---PROPTIT/blob/main/BU%E1%BB%94I%205%20DEV%20TH%C3%8C%20KH%C3%94NG%20CH%E1%BB%88%20VI%E1%BA%BET%20CODE/Fork.png)
- Join
![Alt text](https://github.com/sybui2004/JAVA---PROPTIT/blob/main/BU%E1%BB%94I%205%20DEV%20TH%C3%8C%20KH%C3%94NG%20CH%E1%BB%88%20VI%E1%BA%BET%20CODE/Join.png)

[Activity Diagram](https://iviettech.vn/blog/1066-activity-diagram-ban-ve-hoat-dong.html)

