package x1.Action;


import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class test extends ActionSupport {

    public String userName;// 此处要用public 不然index.jsp 传入的数据无法set进来
    
    public String execute() throws Exception {
        System.out.print(userName);
        if(userName == null || "".equals(userName)){
            return ERROR;
        }else{
            return SUCCESS;
        }
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}