package by.htp.liblary.jsp_bean;


import java.util.List;


import by.htp.liblary.entity.User;

public class JSPUserBean {
    private List<User> arr;

    public JSPUserBean(List<User> arr) {
        this.arr = arr;
    }

    public JSPUserBean() {

    }

    public int getSize() {
        return (arr.size());
    }

    public User getElement(int i) {
        return arr.get(i);
    }


}
