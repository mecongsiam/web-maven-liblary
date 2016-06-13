package by.htp.liblary.jsp_bean;


import java.util.List;

import by.htp.liblary.entity.Book;

public class JSPBookBean {
    private List<Book> arr;

    public JSPBookBean(List<Book> arr) {
        this.arr = arr;
    }

    public JSPBookBean() {

    }

    public int getSize() {
        return (arr.size());
    }

    public Book getElement(int i) {
        return arr.get(i);
    }

}
