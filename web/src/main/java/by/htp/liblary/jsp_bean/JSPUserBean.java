package by.htp.liblary.jsp_bean;


import java.util.List;


import by.htp.liblary.entity.User;

public class JSPUserBean {
    private List<User> arr;
    private int countAllUsers;
    private int interval;
    private int position;

    public JSPUserBean(List<User> arr,int countAllUsers,int interval,int position) {
        this.arr = arr;
        this.countAllUsers=countAllUsers;
        this.interval=interval;
        this.position=position;
    }

    public JSPUserBean() {

    }

    public int getSize() {
        return (arr.size());
    }

    public User getElement(int i) {
        return arr.get(i);
    }


    public int getCountAllUsers() {
        return countAllUsers;
    }

    public void setCountAllUsers(int countAllUsers) {
        this.countAllUsers = countAllUsers;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
