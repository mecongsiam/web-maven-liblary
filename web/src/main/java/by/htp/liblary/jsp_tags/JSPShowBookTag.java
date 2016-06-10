package by.htp.liblary.jsp_tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import by.htp.liblary.entity.Book;
import by.htp.liblary.jsp_bean.JSPBookBean;

public class JSPShowBookTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4614863814305782002L;
	
	private JSPBookBean jspBookBean;

	public JSPBookBean getJspBookBean() {
		return jspBookBean;
	}

	public void setJspBookBean(JSPBookBean jspBookBean) {
		this.jspBookBean = jspBookBean;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int doStartTag() throws JspException {
		int size = new Integer(jspBookBean.getSize());

		try {
			JspWriter out = pageContext.getOut();
			out.write("Book Information");
			out.write("<table border=\"1\">");

			for (int i = 0; i < size; i++) {
				Book book = jspBookBean.getElement(i);
				out.write("<tr><td>");
				out.write(book.getName());
				out.write("</td><td>");
				out.write("avtor");
				out.write("</td><td>");
				out.write(Integer.toString(book.getYear()));
				
				out.write("</td></tr>");

			}
			out.write("</table>");
		} catch (IOException e) {
			throw new JspException(e.getMessage());
		}
		return SKIP_BODY;

	}

}
