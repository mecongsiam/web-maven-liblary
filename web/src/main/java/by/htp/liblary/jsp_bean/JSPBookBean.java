package by.htp.liblary.jsp_bean;

import java.util.ArrayList;

import by.htp.liblary.entity.Book;

public class JSPBookBean {
private ArrayList<Book> arr;
	
	public JSPBookBean(ArrayList<Book> arr){
		this.arr=arr;
	}
	
	public JSPBookBean(){
		
	}
	public int getSize(){
		return(arr.size());
	}
	public Book getElement(int i){
		return arr.get(i);
	}

}
