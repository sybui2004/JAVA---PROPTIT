public class Controller {
    private View view;
    public Controller(View view){
        this.view = view;
    }
    public void login(){
        while(true){
            Model user = view.getUserInfo();
            if (checkLogin(user)){
                view.showMessage("Success!");
                break;
            }else{
                view.showMessage("Wrong username or password");
            }
        }
    }

    public boolean checkLogin(Model user){
        if ((user.getUserName().equals("admin")) && user.getPassword().equals("admin")) return true;
        return false;
    }
    public View getView(){
        return view;
    }
    public void setView(View view){
        this.view = view;
    }
}
