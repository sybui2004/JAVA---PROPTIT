import java.util.Scanner;

public class View {
    public static Scanner sc = new Scanner(System.in);
    public void showMessage(String msg){
        System.out.println(msg);
    }
    public Model getUserInfo() {
        Model user = new Model();
        System.out.print("Username: ");
        user.setUserName(sc.next());
        System.out.print("Password: ");
        user.setPassword(sc.next());
        return user;
    }
}
