package by.htp.liblary.jsp_bean;

import java.util.ArrayList;

import by.htp.liblary.entity.Abonement;

public class JSPUserBean {
	private ArrayList<Abonement> arr;
	
	public JSPUserBean(ArrayList<Abonement> arr){
		this.arr=arr;
	}
	
	public JSPUserBean(){
		
	}
	public int getSize(){
		return(arr.size());
	}
	public Abonement getElement(int i){
		return arr.get(i);
	}
	

}
